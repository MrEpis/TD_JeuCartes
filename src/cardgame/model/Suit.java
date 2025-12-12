package cardgame.model;

public enum Suit {
    SPADES(4),
    HEARTS(3),
    CLUBS(2),
    DIAMONDS(1);

    public final int value;

    Suit(int value) {
        this.value = value;
    }

    public static Suit getSuitFromValue(int value) {
        for (Suit suit : Suit.values()) {
            if (suit.value == value) {
                return suit;
            }
        }
        throw new IllegalArgumentException("No suit attributed to this value: " + value);
    }
}
