package net.bhp.phase10;

import java.util.Comparator;

public class CardIdComparator implements Comparator<Card> {
    @Override
    public int compare(Card card1, Card card2) {
        return card1.getId().compareTo(card2.getId());
    }
}