import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Instruction {
  public static final String SEPARATOR_CODE = ":";

   static public Instruction fromString(String instruction) {
     Pattern patternInsctructionWithSugar = Pattern.compile("...");
     Matcher matcherDrinkWithSugar = patternInsctructionWithSugar.matcher(instruction);
     matcherDrinkWithSugar.find();

     if (matcherDrinkWithSugar.group(1)) {

     }

     if (instruction.startsWith("C")) {
       return new DrinkCoffeeInstruction();
     }

     if (instruction.startsWith("H")) {
       return new DrinkHotChocolateInstruction();
     }

     if (instruction.startsWith("T")) {
       return new DrinkTeaInstruction();
     }

     return null;
   }

  abstract String make();

  public String toString() {
    return make();
  }
}
