package net.bhp.phase10;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Deck {

    private Set<Card> deck;
    private static Integer SIZE = 96;

    public Deck() {
        deck = new HashSet<>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            deck.add(new Card(i + 1, (i % 12) + 1));
        }
    }

    public Collection<Card> getCards() {
        return deck;
    }

    public void printDeck() {
        Util.printCards(deck, true);
    }
}
