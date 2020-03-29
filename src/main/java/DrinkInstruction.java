import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DrinkInstruction {
  final static String SEPARATOR_CODE = ":";
  final String drinkOrder;
  public static final String WITHOUT_SUGAR_CODE = "";

  DrinkInstruction(String drinkOrder) {
      this.drinkOrder = drinkOrder;
    }

   String make() {
    return
      makeDrinkCode() + SEPARATOR_CODE
        + makeSugarQuantityCode() + SEPARATOR_CODE
        + makeStickCode();
   }

  private String makeStickCode() {
    final var WITHOUT_STICK = "";
    final var WITH_STICK = "0";

    return hasSugar() ? WITH_STICK : WITHOUT_STICK;
  }

  private String makeSugarQuantityCode() {

    return hasSugar() ? extractQuantitySugar() : WITHOUT_SUGAR_CODE;
  }

  private boolean hasSugar() {
    Pattern patternDrinkWithSugar = Pattern.compile(".*sugar[s]?");
    Matcher matcherDrinkWithSugar = patternDrinkWithSugar.matcher(drinkOrder);

    return matcherDrinkWithSugar.find();
  }

  private String extractQuantitySugar() {
    Pattern patternDrinkWithSugar = Pattern.compile(".*(1|2) sugar[s]?");
    Matcher matcherDrinkWithSugar = patternDrinkWithSugar.matcher(drinkOrder);
    matcherDrinkWithSugar.find();

    return matcherDrinkWithSugar.group(1);
  }

  private String makeDrinkCode() {
    if (drinkOrder.startsWith("tea")) {
      return "T";
    }
    if (drinkOrder.startsWith("coffee")) {
      return "C";
    }
    if (drinkOrder.startsWith("chocolate")) {
      return "H";
    }
    return "";
  }
}
