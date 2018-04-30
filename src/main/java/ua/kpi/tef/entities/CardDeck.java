package ua.kpi.tef.entities;

import java.util.Random;

import static ua.kpi.tef.entities.CardRating.*;
import static ua.kpi.tef.entities.CardSuit.*;

/**
 * @author y.kovtun
 * stack based card deck
 */
public class CardDeck {

    private Card trump = null;

    private Card[] cards = {
            Card.builder().rating(SIX).suit(SPADES).build(),
            Card.builder().rating(SEVEN).suit(SPADES).build(),
            Card.builder().rating(EIGHT).suit(SPADES).build(),
            Card.builder().rating(NINE).suit(SPADES).build(),
            Card.builder().rating(TEN).suit(SPADES).build(),
            Card.builder().rating(JACK).suit(SPADES).build(),
            Card.builder().rating(QUINE).suit(SPADES).build(),
            Card.builder().rating(KING).suit(SPADES).build(),
            Card.builder().rating(ACE).suit(SPADES).build(),


            Card.builder().rating(SIX).suit(CLUBS).build(),
            Card.builder().rating(SEVEN).suit(CLUBS).build(),
            Card.builder().rating(EIGHT).suit(CLUBS).build(),
            Card.builder().rating(NINE).suit(CLUBS).build(),
            Card.builder().rating(TEN).suit(CLUBS).build(),
            Card.builder().rating(JACK).suit(CLUBS).build(),
            Card.builder().rating(QUINE).suit(CLUBS).build(),
            Card.builder().rating(KING).suit(CLUBS).build(),
            Card.builder().rating(ACE).suit(CLUBS).build(),


            Card.builder().rating(SIX).suit(DIAMONDS).build(),
            Card.builder().rating(SEVEN).suit(DIAMONDS).build(),
            Card.builder().rating(EIGHT).suit(DIAMONDS).build(),
            Card.builder().rating(NINE).suit(DIAMONDS).build(),
            Card.builder().rating(TEN).suit(DIAMONDS).build(),
            Card.builder().rating(JACK).suit(DIAMONDS).build(),
            Card.builder().rating(QUINE).suit(DIAMONDS).build(),
            Card.builder().rating(KING).suit(DIAMONDS).build(),
            Card.builder().rating(ACE).suit(DIAMONDS).build(),


            Card.builder().rating(SIX).suit(HEARTS).build(),
            Card.builder().rating(SEVEN).suit(HEARTS).build(),
            Card.builder().rating(EIGHT).suit(HEARTS).build(),
            Card.builder().rating(NINE).suit(HEARTS).build(),
            Card.builder().rating(TEN).suit(HEARTS).build(),
            Card.builder().rating(JACK).suit(HEARTS).build(),
            Card.builder().rating(QUINE).suit(HEARTS).build(),
            Card.builder().rating(KING).suit(HEARTS).build(),
            Card.builder().rating(ACE).suit(HEARTS).build(),
    };

    private int position = cards.length - 1;

    public Card pull() {
        if (position >= 0) {
            return cards[position--];
        } else {
            throw new ArrayIndexOutOfBoundsException("Deck is empty");
        }
    }

    public void setTrump() {
        if (trump == null) {
            trump = cards[position];
            System.arraycopy(cards, 0, cards, 1, position);
            cards[0]= trump;
        } else {
            throw new UnsupportedOperationException("Trump card has already been setted");
        }
    }

    public Card getTrumpCard() {
        return trump;
    }

    public int getAmountOfCardsInDeck() {
        return position + 1;
    }

    public void shuffle() {
        Random random = new Random();
        for (int i = 0; i < cards.length; i++) {
            int randomIndex = random.nextInt(cards.length);
            Card temp = cards[i];
            cards[i] = cards[randomIndex];
            cards[randomIndex] = temp;
        }
    }
}
