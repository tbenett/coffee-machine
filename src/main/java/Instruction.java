import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Instruction {

  public static final String SEPARATOR_CODE = ":";
  public static final String WITHOUT_SUGAR_CODE = "";
  public static final String WITH_STICK = "0";
  public static final String WITHOUT_STICK = "";
  public static final String MESSAGE_CODE = "M";


  private boolean isDrinkOrder(String order) {
    return order.startsWith("tea") || order.startsWith("chocolate") || order.startsWith("coffee");
  }


  String makeDrinkCode(String drinkOrder) {
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

  String makeStickCode(String drinkOrder) {
    return new Instruction().hasSugar(drinkOrder) ? WITH_STICK : WITHOUT_STICK;
  }

  boolean hasSugar(String drinkOrder) {
    Pattern patternDrinkWithSugar = Pattern.compile(".*sugar[s]?");
    Matcher matcherDrinkWithSugar = patternDrinkWithSugar.matcher(drinkOrder);

    return matcherDrinkWithSugar.find();
  }

  String extractQuantitySugar(String drinkOrder) {
    Pattern patternDrinkWithSugar = Pattern.compile(".*(1|2) sugar[s]?");
    Matcher matcherDrinkWithSugar = patternDrinkWithSugar.matcher(drinkOrder);
    matcherDrinkWithSugar.find();

    return matcherDrinkWithSugar.group(1);
  }

  String makeSugarQuantityCode(String drinkOrder) {
    return hasSugar(drinkOrder) ? extractQuantitySugar(drinkOrder) : WITHOUT_SUGAR_CODE;
  }

  String makeMessage(String message) {
    return MESSAGE_CODE + SEPARATOR_CODE + message;
 }

  String make(String order) {

    if (isDrinkOrder(order)) {
      return
        makeDrinkCode(order) + SEPARATOR_CODE
          + makeSugarQuantityCode(order) + SEPARATOR_CODE
          + makeStickCode(order);
    }

    return makeMessage(order);
  }
}
