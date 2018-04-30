package ua.kpi.tef.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Card {
    private CardSuit suit;
    private CardRating rating;
}
