abstract class Instruction {
  public static final String SEPARATOR_CODE = ":";

  abstract String make();

  public String toString() {
    return make();
  }
}
