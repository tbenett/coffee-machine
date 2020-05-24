class DrinkCoffeeInstruction extends DrinkInstruction {
  private final int sugarQuantity;

  DrinkCoffeeInstruction() {
    super("");
  }

  DrinkCoffeeInstruction(int sugarQuantity) {
    this.sugarQuantity = sugarQuantity;
    super("");
  }


  @Override
  public String toString() {
    return "C::";
  }
}
