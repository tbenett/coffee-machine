import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SetUp {

  @ParameterizedTest
  @CsvSource({"coffee, C::" , "chocolate, H::", "tea, T::"})
  void makes(String customerOrder, String instruction) {
    assertThat(makeInstruction(customerOrder)).isEqualTo(instruction) ;
  }

  @ParameterizedTest
  @CsvSource({
    "coffee with 1 sugar, C:1:0",
    "coffee with 2 sugars, C:2:0",
    "tea with 1 sugar, T:1:0",
    "chocolate with 1 sugar, H:1:0"
  })
  void name___(String drink, String instruction) {
    assertThat(makeInstruction(drink)).isEqualTo(instruction);
  }

  @Test
  void name() {
    String message = "hello";

    assertThat(makeInstruction(message)).isEqualTo("M:" + message);
  }

  final static String SEPARATOR_CODE = ":";

  private String makeInstruction(String order) {

    if (isDrinkOrder(order)) {
      return new DrinkOrder().makeDrinkInstruction(order);
    }

    return makeMessageInstruction(order);
  }

  private String makeMessageInstruction(String messageOrder) {
    final var MESSAGE_CODE = "M";

    return MESSAGE_CODE + SEPARATOR_CODE + messageOrder;
  }

  private static boolean isDrinkOrder(String order) {
    return order.startsWith("tea") || order.startsWith("chocolate") || order.startsWith("coffee");
  }


}
