class Instruction {

  public static final String SEPARATOR_CODE = ":";
  public static final String WITHOUT_SUGAR_CODE = "";
  public static final String WITH_STICK = "0";
  public static final String WITHOUT_STICK = "";

  static String make(String order) {

    if (isDrinkOrder(order)) {
      DrinkInstruction drinkInstruction = new DrinkInstruction(order);
      return
        makeDrinkCode(drinkInstruction.drinkOrder) + SEPARATOR_CODE
          + drinkInstruction.makeSugarQuantityCode() + SEPARATOR_CODE
          + drinkInstruction.makeStickCode();
    }

    return new Message(order).make();
  }

  private static boolean isDrinkOrder(String order) {
    return order.startsWith("tea") || order.startsWith("chocolate") || order.startsWith("coffee");
  }

  static String makeDrinkCode(String drinkOrder) {
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
