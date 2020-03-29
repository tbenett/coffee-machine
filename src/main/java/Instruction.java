class Instruction {
  final static String SEPARATOR_CODE = ":";

  static String make(String order) {

    if (isDrinkOrder(order)) {
      return new DrinkInstruction(order).make();
    }

    return makeMessageInstruction(order);
  }

  private static String makeMessageInstruction(String messageOrder) {
    final var MESSAGE_CODE = "M";

    return MESSAGE_CODE + SEPARATOR_CODE + messageOrder;
  }

  private static boolean isDrinkOrder(String order) {
    return order.startsWith("tea") || order.startsWith("chocolate") || order.startsWith("coffee");
  }
}
