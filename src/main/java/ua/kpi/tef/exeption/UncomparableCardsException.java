package ua.kpi.tef.exeption;

public class UncomparableCardsException  extends RuntimeException  {
    public UncomparableCardsException() {
        super("imposible to compare this cards");
    }
}

