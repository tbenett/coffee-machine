class InstructionFactory {

  static String make(String order) {
    if (isDrinkOrder(order)) {
      return new DrinkInstruction(order).make();
    }

    return new MessageInstruction(order).make();
  }

  private static boolean isDrinkOrder(String order) {
    return order.startsWith("tea") || order.startsWith("chocolate") || order.startsWith("coffee");
  }
}
