import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class InstructionShould {

  @ParameterizedTest
  @CsvSource({"coffee, C::" , "chocolate, H::", "tea, T::"})
  void make_drink_instruction_without_sugar(String drink, String instruction) {
    assertThat(InstructionFactory.create(drink).toString()).isEqualTo(instruction) ;
  }

  @ParameterizedTest
  @CsvSource({
    "coffee with 1 sugar, C:1:0",
    "coffee with 2 sugars, C:2:0",
    "tea with 1 sugar, T:1:0",
    "chocolate with 1 sugar, H:1:0"
  })
  void make_drink_instruction_with_sugar_and_stick(String drink, String instruction) {
    assertThat(InstructionFactory.create(drink).toString()).isEqualTo(instruction);
  }

  @Test
  void make_an_instruction_message() {
    String message = "hello";

    assertThat(InstructionFactory.create(message).toString()).isEqualTo("M:" + message);
  }

  @Test
  void test_x() {
    assertThat(foo("tea with 1 sugar", 40)).isEqualTo("T:1:0");
  }

  @Test
  void test_xx() {
    assertThat(foo("chocolate with 1 sugar", 50)).isEqualTo("H:1:0");
  }

  // tea is 0.4
  // chocolate is 0.5
  // coffee is 0.6
  @ParameterizedTest
  @CsvSource({
          "tea with 1 sugar, 20",
          "chocolate with 1 sugar, 41",
          "coffee, 59",
  })
  void give_a_message_not_enough_money(String drink, int cents) {
    assertThat(foo(drink, cents)).startsWith("M:Not enough money");
  }

  // TODO 3/2: abstraction on Order & Drink
  // TODO 1/2: inject drinks prices
  @ParameterizedTest
  @CsvSource({
          "tea with 1 sugar, 10, 30",
          "tea with 1 sugar, 20, 20",
          "tea with 1 sugar, 30, 10",
          "tea with 1 sugar, 39, 1",
          "coffee with 1 sugar, 59, 1",
          "chocolate, 41, 9",
          "chocolate, 49, 1",
  })
  void give_a_message_not_enough_money_with_missing_amount(String drink, int amount, int missingAmount) {
    final var expectedInstruction = String.format("M:Not enough money missing %d cents", missingAmount);

    assertThat(foo(drink, amount)).isEqualTo(expectedInstruction);
  }

  String foo(String order, int cents) {
    final var missingAmount = missingAmount(order, cents);

    if (missingAmount > 0) {
      return InstructionFactory.create(String.format("Not enough money missing %d cents", missingAmount)).toString();
    }

    return InstructionFactory.create(order).toString();
  }

  // TODO 2/2: generalize check drink and return prices
  private int missingAmount(String order, int cents) {
    return minimalPriceForDrink(order) - cents;
  }

  private int minimalPriceForDrink(String order) {
    if (InstructionFactory.isTea(order)) {
      return DrinkPrices.TEA.amount();
    }

    if (InstructionFactory.isHotChocolate(order)) {
      return DrinkPrices.HOT_CHOCOLATE.amount();
    }

    if (InstructionFactory.isCoffee(order)) {
      return DrinkPrices.COFFEE.amount();
    }

    return 0;
  }
}
