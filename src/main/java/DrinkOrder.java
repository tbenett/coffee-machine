import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DrinkOrder {
  final static String SEPARATOR_CODE = ":";

   String makeDrinkInstruction(String drinkOrder) {
    return
      makeDrinkCode(drinkOrder) + SEPARATOR_CODE
        + makeSugarQuantityCode(drinkOrder) + SEPARATOR_CODE
        + makeStickCode(drinkOrder);
   }

  private String makeStickCode(String drinkOrder) {
    final var WITHOUT_STICK = "";
    final var WITH_STICK = "0";

    String stickCode = WITHOUT_STICK;
    if (hasSugar(drinkOrder)) {
      stickCode = WITH_STICK;
    }
    return stickCode;
  }

  private String makeSugarQuantityCode(String drinkOrder) {
    String WITHOUT_SUGAR = "";
    String quantitySugarCode = WITHOUT_SUGAR;

    if (hasSugar(drinkOrder)) {
      quantitySugarCode = extractQuantitySugar(drinkOrder);

    }
    return quantitySugarCode;
  }

  private boolean hasSugar(String drinkOrder) {
    Pattern patternDrinkWithSugar = Pattern.compile(".*sugar[s]?");
    Matcher matcherDrinkWithSugar = patternDrinkWithSugar.matcher(drinkOrder);

    return matcherDrinkWithSugar.find();
  }

  private String extractQuantitySugar(String drinkOrder) {
    Pattern patternDrinkWithSugar = Pattern.compile(".*(1|2) sugar[s]?");
    Matcher matcherDrinkWithSugar = patternDrinkWithSugar.matcher(drinkOrder);
    matcherDrinkWithSugar.find();

    return matcherDrinkWithSugar.group(1);
  }

  private String makeDrinkCode(String drinkOrder) {
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
