package net.bhp.phase10;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Game {
    private Hand hand;
    private Deck deck;

    public Game() {
        deck = new Deck();
        hand = new Hand();
        hand.getNewHand(deck);

        System.out.println("Welcome to Phase 10!");
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Map<String, Boolean> phaseCheck() {
        return Phase.hasPhases(hand);
    }
}
