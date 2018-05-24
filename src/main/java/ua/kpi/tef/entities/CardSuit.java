package ua.kpi.tef.entities;

public enum CardSuit {
    HEARTS("H"),
    DIAMONDS("D"),
    CLUBS("C"),
    SPADES("S");

    String shortForm;

    CardSuit(String shortForm) {
        this.shortForm = shortForm;
    }

    @Override
    public String toString() {
        return shortForm;
    }
}
