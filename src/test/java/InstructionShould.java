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
    assertThat(foo("tea with 1 sugar", 4)).isEqualTo("T:1:0");
    /* assertThat(foo("tea with 1 sugar", 3)).isEqualTo("M:Not enough money missing 10 cents"); */
  }

  String foo(String order, int amount) {
    
  }

}
