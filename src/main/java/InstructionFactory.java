class InstructionFactory {

   static String make(String order) {
    if (isDrinkOrder(order)) {
      return new DrinkInstruction(order).make();
    }

    return new MessageInstruction(order).make();
  }

  static MessageInstruction makeInstruction(String message) {
     return new MessageInstruction(message);
  }

  static private boolean isDrinkOrder(String order) {
    return order.startsWith("tea") || order.startsWith("chocolate") || order.startsWith("coffee");
  }

  public static DrinkInstruction create(String order) {
       if (isDrinkOrder(order)) {
           return new DrinkInstruction(order);
       }
        return new MessageInstruction(order);
  }
}
