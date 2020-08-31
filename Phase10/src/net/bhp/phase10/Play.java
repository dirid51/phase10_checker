package net.bhp.phase10;

public class Play {
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println();
        game.getDeck().printDeck();
        game.getHand().printHand();
        Util.printPhaseResults(game.phaseCheck());
    }
}
