import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DrinkInstruction {
  final String drinkOrder;

  public static final String SEPARATOR_CODE = ":";
  public static final String WITHOUT_SUGAR_CODE = "";
  public static final String WITH_STICK = "0";
  public static final String WITHOUT_STICK = "";

  DrinkInstruction(String drinkOrder) {
      this.drinkOrder = drinkOrder;
    }

   String make() {
    return
      makeDrinkCode() + SEPARATOR_CODE
        + makeSugarQuantityCode() + SEPARATOR_CODE
        + makeStickCode();
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

  private String makeSugarQuantityCode() {
    return hasSugar() ? extractQuantitySugar() : WITHOUT_SUGAR_CODE;
  }

    private String makeStickCode() {
    return hasSugar() ? WITH_STICK : WITHOUT_STICK;
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

  @Override
  public String toString() {
    return make();
  }
}
