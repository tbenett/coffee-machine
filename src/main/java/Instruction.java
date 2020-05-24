import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Instruction {
  public static final String SEPARATOR_CODE = ":";

   static public Instruction fromString(String instruction) {

     if (instruction.startsWith("C")) {
       Pattern patternInsctructionWithSugar = Pattern.compile("C:(1|2)+:.*");
       Matcher matcherDrinkWithSugar = patternInsctructionWithSugar.matcher(instruction);
       if (matcherDrinkWithSugar.find()) {
         String quantity = matcherDrinkWithSugar.group(1);
         return new DrinkCoffeeInstruction(Integer.parseInt(quantity));
       }
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
