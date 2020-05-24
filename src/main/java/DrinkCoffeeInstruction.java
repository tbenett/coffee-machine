import java.util.Objects;

class DrinkCoffeeInstruction extends DrinkInstruction {
  private final int sugarQuantity;

  DrinkCoffeeInstruction() {
    super("");
    this.sugarQuantity = 0;
  }

  DrinkCoffeeInstruction(int sugarQuantity) {
    super("");
    this.sugarQuantity = sugarQuantity;
  }

  @Override
  public String toString() {
    return String.format("C:%d:%s", sugarQuantity, sugarQuantity > 0 ? "0" : "");
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    DrinkCoffeeInstruction that = (DrinkCoffeeInstruction) o;
    return sugarQuantity == that.sugarQuantity;
  }

  @Override
  public int hashCode() {
    return Objects.hash(sugarQuantity);
  }
}
