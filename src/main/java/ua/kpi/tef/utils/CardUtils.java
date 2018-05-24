package ua.kpi.tef.utils;

import ua.kpi.tef.entities.Card;
import ua.kpi.tef.entities.CardDeck;
import ua.kpi.tef.entities.CardSuit;
import ua.kpi.tef.entities.Player;
import ua.kpi.tef.exeption.UncomparableCardsException;

public class CardUtils {
    public static final int AMOUNT_OF_CARDS_ON_FIRS_DISTRIBUTION = 6;

    public static int compareCardWithTrump(Card card1, Card card2, CardSuit trump) {
        if (card1.getSuit() != card2.getSuit() && card1.getSuit() != trump && card2.getSuit() != trump) {
            throw new UncomparableCardsException();
        }
        if (card1.getSuit() == card2.getSuit()) {
            return card1.getRating().compareTo(card2.getRating());
        }
        if (card1.getSuit() == trump) {
            return 1;
        }
        if (card2.getSuit() == trump) {
            return -1;
        }
        return 0;
    }

    public static void giveOut(Player player1, Player player2, CardDeck deck) {
        for (int i = 0; i < AMOUNT_OF_CARDS_ON_FIRS_DISTRIBUTION; i++) {
            player1.addCard(deck.pull());
            player2.addCard(deck.pull());
        }
        deck.setTrump();
    }
}
