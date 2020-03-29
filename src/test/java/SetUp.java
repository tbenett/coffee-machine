import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SetUp {

  @ParameterizedTest
  @CsvSource({"coffee, C::" , "chocolate, H::", "tea, T::"})
  void makes(String customerOrder, String instruction) {
    assertThat(Instruction.make(customerOrder)).isEqualTo(instruction) ;
  }

  @ParameterizedTest
  @CsvSource({
    "coffee with 1 sugar, C:1:0",
    "coffee with 2 sugars, C:2:0",
    "tea with 1 sugar, T:1:0",
    "chocolate with 1 sugar, H:1:0"
  })
  void name___(String drink, String instruction) {
    assertThat(Instruction.make(drink)).isEqualTo(instruction);
  }

  @Test
  void name() {
    String message = "hello";

    assertThat(Instruction.make(message)).isEqualTo("M:" + message);
  }
}
