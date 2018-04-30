package ua.kpi.tef;

import ua.kpi.tef.entities.Card;
import ua.kpi.tef.entities.CardDeck;
import ua.kpi.tef.entities.CardRating;
import ua.kpi.tef.entities.CardSuit;
import ua.kpi.tef.utils.CardUtils;

public class Main {
    public static void main(String[] args) {
        CardDeck deck = new CardDeck();
        deck.setTrump();
        System.out.println(deck.getTrumpCard());
        for (int i = 0; i <36 ; i++) {
            System.out.println(deck.getAmountOfCardsInDeck());
            System.out.println(deck.pull());
        }
        System.out.println(deck.getAmountOfCardsInDeck());
        Card card1 = Card.builder().rating(CardRating.SIX).suit(CardSuit.SPADES).build();
        Card card2 = Card.builder().rating(CardRating.ACE).suit(CardSuit.SPADES).build();
        System.out.println(CardUtils.compareCardWithTrump(card1, card2, CardSuit.CLUBS));

    }


}
