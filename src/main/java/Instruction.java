abstract class Instruction {
  public static final String SEPARATOR_CODE = ":";

   static public Instruction fromString(String instruction) {
     if (instruction.startsWith("C")) {
       
     }
   }

  abstract String make();

  public String toString() {
    return make();
  }
}
