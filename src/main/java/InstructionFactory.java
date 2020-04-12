class InstructionFactory {

  static private boolean isDrinkOrder(String order) {
    return isTea(order) || isHotChocolate(order) || isCoffee(order);
  }

  static boolean isCoffee(String order) {
    return order.startsWith("coffee");
  }

  static boolean isHotChocolate(String order) {
    return order.startsWith("chocolate");
  }

  static boolean isTea(String order) {
    return order.startsWith("tea");
  }

  public static Instruction create(String order) {
       if (isDrinkOrder(order)) {
           return new DrinkInstruction(order);
       }
        return new MessageInstruction(order);
  }
}
