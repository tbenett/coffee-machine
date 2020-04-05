import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DrinkInstruction {
  final String drinkOrder;

  DrinkInstruction(String drinkOrder) {
      this.drinkOrder = drinkOrder;
    }


  String makeSugarQuantityCode() {
    return hasSugar() ? extractQuantitySugar() : Instruction.WITHOUT_SUGAR_CODE;
  }

    String makeStickCode() {
    return hasSugar() ? Instruction.WITH_STICK : Instruction.WITHOUT_STICK;
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
