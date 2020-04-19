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

  @ParameterizedTest
  @CsvSource({
          "tea with 1 sugar, 10, M:Not enough money missing 30 cents",
          "tea with 1 sugar, 20, M:Not enough money missing 20 cents",
          "tea with 1 sugar, 30, M:Not enough money missing 10 cents",
  })
  void give_a_message_not_enough_money(String drink, int cents, String instruction) {
    assertThat(foo(drink, cents)).isEqualTo(instruction);
  }

  @Test
  void name() {

  }

  String foo(String order, int cents) {
    var missing = 40 - cents;
    if (missing > 0) {
      return InstructionFactory.create(String.format("Not enough money missing %d cents", missing)).toString();
    }
    return InstructionFactory.create(order).toString();
  }
}
