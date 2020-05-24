abstract class Instruction {
  public static final String SEPARATOR_CODE = ":";

   static public Instruction fromString(String instruction) {
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
