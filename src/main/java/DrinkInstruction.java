import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DrinkInstruction extends Instruction {
  public static final String TEA_CODE = "T";
  public static final String COFFEE_CODE = "C";
  public static final String HOT_CHOCOLATE_CODE = "H";
  public static final String WITHOUT_SUGAR_CODE = "";
  public static final String WITH_STICK = "0";
  public static final String WITHOUT_STICK = "";

  final String drinkOrder;

  DrinkInstruction(String drinkOrder) {
    this.drinkOrder = drinkOrder;
  }

  DrinkInstruction(Drink drink) {
    this.drinkOrder = drink.name();
  }

  @Override
  String make() {
    return
      makeDrinkCode() + SEPARATOR_CODE
        + makeSugarQuantityCode() + SEPARATOR_CODE
        + makeStickCode();
  }

  private String makeDrinkCode() {
    if (InstructionFactory.isTea(drinkOrder)) {
      return TEA_CODE;
    }
    if (InstructionFactory.isCoffee(drinkOrder)) {
      return COFFEE_CODE;
    }
    if (InstructionFactory.isHotChocolate(drinkOrder)) {
      return HOT_CHOCOLATE_CODE;
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
}
