package net.bhp.phase10;

import java.util.*;
import java.util.stream.Collectors;

public class Hand {
    public static Integer SIZE = 10;
    private Set<Card> hand;

    public Hand() {
        hand = new HashSet<>(SIZE);
    }

    public Hand(Collection<Card> newHand) {
        hand = new HashSet<>(SIZE);
        if (newHand.size() != SIZE) {
            // Error - need 10 cards
        }
    }

    public Integer size() {
        return hand.size();
    }

    private Boolean hasCard(Card card) {
        return hand.contains(card);
    }

    public void addCard(Card card) {
        if (this.size() < SIZE && !hasCard(card)) {
            hand.add(card);
        }
    }

    public Collection<Card> getCards() {
        return hand;
    }

    public List<Integer> getValueList() {
        return new ArrayList<>(hand.stream().map(c -> c.getValue()).collect(Collectors.toList()));
    }

    public void printHand() {
        Util.printCards(hand, false);
    }

    public void getNewHand(Deck deck) {
        hand.clear();
        while (size() < Hand.SIZE) {
            this.addCard(Util.random(deck.getCards()));
        }
    }
}
