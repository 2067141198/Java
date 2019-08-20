package Poke;

public class PokeCard {
    int value;
    String color;

    public PokeCard(int value, String color) {
        this.value = value;
        this.color = color;
    }

    @Override
    public String toString() {
        return "[" +
                 + value + ","
                + color +
                ']';
    }

    public boolean equals(Object o) {
        if(o == null) {
            return false;
        }

        if(!(o instanceof PokeCard)) {
            return false;
        }

        PokeCard other = (PokeCard)o;
        return this.value == other.value && this.color.equals(other.color);
    }
}
