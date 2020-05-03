class InstructionFactory {

  static final Drink TEA = Drink.from("tea");
  static final Drink HOT_CHOCOLATE = Drink.from("chocolate");
  static final Drink COFFEE = Drink.from("coffee");


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

    public static Instruction create(Drink drink) {
      if (drink.equals(TEA)) {
        return new DrinkTeaInstruction();
      }

      if (drink.equals(HOT_CHOCOLATE)) {
        return new DrinkHotChocolateInstruction();
      }

      if (drink.equals(COFFEE)) {
        return new DrinkCoffeeInstruction();
      }

      throw new UnsupportedOperationException();
  }

}
