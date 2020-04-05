import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Instruction {

  public static final String SEPARATOR_CODE = ":";
  public static final String WITHOUT_SUGAR_CODE = "";
  public static final String WITH_STICK = "0";
  public static final String WITHOUT_STICK = "";

  static String make(String order) {

    if (isDrinkOrder(order)) {
      DrinkInstruction drinkInstruction = new DrinkInstruction(order);
      return
        new Instruction().makeDrinkCode(drinkInstruction.drinkOrder) + SEPARATOR_CODE
          + makeSugarQuantityCode(drinkInstruction) + SEPARATOR_CODE
          + makeStickCode(drinkInstruction);
    }

    return new Message(order).make();
  }

  private static boolean isDrinkOrder(String order) {
    return order.startsWith("tea") || order.startsWith("chocolate") || order.startsWith("coffee");
  }

  static String makeSugarQuantityCode(DrinkInstruction drinkInstruction) {
    return hasSugar(drinkInstruction.drinkOrder) ? extractQuantitySugar(drinkInstruction.drinkOrder) : WITHOUT_SUGAR_CODE;
  }

  static String makeStickCode(DrinkInstruction drinkInstruction) {
    return hasSugar(drinkInstruction.drinkOrder) ? WITH_STICK : WITHOUT_STICK;
  }

  static String extractQuantitySugar(String drinkOrder) {
    Pattern patternDrinkWithSugar = Pattern.compile(".*(1|2) sugar[s]?");
    Matcher matcherDrinkWithSugar = patternDrinkWithSugar.matcher(drinkOrder);
    matcherDrinkWithSugar.find();

    return matcherDrinkWithSugar.group(1);
  }

  static boolean hasSugar(String drinkOrder) {
    Pattern patternDrinkWithSugar = Pattern.compile(".*sugar[s]?");
    Matcher matcherDrinkWithSugar = patternDrinkWithSugar.matcher(drinkOrder);

    return matcherDrinkWithSugar.find();
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
}
