package ua.kpi.tef.entities;

import static ua.kpi.tef.entities.CardRating.*;
import static ua.kpi.tef.entities.CardSuit.*;

public class CardDeck {
    private Card[] cards = {
            Card.builder().rating(SIX).suit(SPADES).build(),
            Card.builder().rating(SEVEN).suit(SPADES).build(),
            Card.builder().rating(EIGHT).suit(SPADES).build(),
            Card.builder().rating(NINE).suit(SPADES).build(),
            Card.builder().rating(TEN).suit(SPADES).build(),
            Card.builder().rating(JACK).suit(SPADES).build(),
            Card.builder().rating(QUINE).suit(SPADES).build(),
            Card.builder().rating(KING).suit(SPADES).build(),

            Card.builder().rating(SIX).suit(CLUBS).build(),
            Card.builder().rating(SEVEN).suit(CLUBS).build(),
            Card.builder().rating(EIGHT).suit(CLUBS).build(),
            Card.builder().rating(NINE).suit(CLUBS).build(),
            Card.builder().rating(TEN).suit(CLUBS).build(),
            Card.builder().rating(JACK).suit(CLUBS).build(),
            Card.builder().rating(QUINE).suit(CLUBS).build(),
            Card.builder().rating(KING).suit(CLUBS).build(),

            Card.builder().rating(SIX).suit(DIAMONDS).build(),
            Card.builder().rating(SEVEN).suit(DIAMONDS).build(),
            Card.builder().rating(EIGHT).suit(DIAMONDS).build(),
            Card.builder().rating(NINE).suit(DIAMONDS).build(),
            Card.builder().rating(TEN).suit(DIAMONDS).build(),
            Card.builder().rating(JACK).suit(DIAMONDS).build(),
            Card.builder().rating(QUINE).suit(DIAMONDS).build(),
            Card.builder().rating(KING).suit(DIAMONDS).build(),

            Card.builder().rating(SIX).suit(DIAMONDS).build(),
            Card.builder().rating(SEVEN).suit(DIAMONDS).build(),
            Card.builder().rating(EIGHT).suit(DIAMONDS).build(),
            Card.builder().rating(NINE).suit(DIAMONDS).build(),
            Card.builder().rating(TEN).suit(DIAMONDS).build(),
            Card.builder().rating(JACK).suit(DIAMONDS).build(),
            Card.builder().rating(QUINE).suit(DIAMONDS).build(),
            Card.builder().rating(KING).suit(DIAMONDS).build(),

    };
}
