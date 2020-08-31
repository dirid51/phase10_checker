package net.bhp.phase10;

import java.util.Comparator;

public class CardValueComparator implements Comparator<Card> {
    @Override
    public int compare(Card card1, Card card2) {
        return card1.getValue().compareTo(card2.getValue());
    }
}
