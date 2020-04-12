class InstructionFactory {

  static private boolean isDrinkOrder(String order) {
    return order.startsWith("tea") || order.startsWith("chocolate") || order.startsWith("coffee");
  }

  public static Instruction create(String order) {
       if (isDrinkOrder(order)) {
           return new DrinkInstruction(order);
       }
        return new MessageInstruction(order);
  }
}
