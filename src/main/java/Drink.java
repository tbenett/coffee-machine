import java.util.Objects;

public class Drink {
    private final String name;

    protected Drink(String name) {
        this.name = name;
    }

    public static Drink from(String name) {
        return new Drink(name);
    }

    public String name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drink drink = (Drink) o;
        return Objects.equals(name, drink.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
