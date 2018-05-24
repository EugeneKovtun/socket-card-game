package ua.kpi.tef.entities;

public enum CardRating {
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("J"),
    QUINE("Q"),
    KING("K"),
    ACE("A");
    String shortForm;

    CardRating(String shortForm) {
        this.shortForm = shortForm;
    }

    @Override
    public String toString() {
        return shortForm;

    }
}
