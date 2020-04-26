enum DrinkPrices {
  TEA(40),
  HOT_CHOCOLATE(50),
  COFFEE(60),
  ;

  private final int amount;

  DrinkPrices(int amount) {
    this.amount = amount;
  }

  public int amount() {
    return amount;
  }
}
