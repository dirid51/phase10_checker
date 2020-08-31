package net.bhp.phase10;

import java.util.*;
import java.util.stream.Collectors;

public class Util {

    public static <T> T random(Collection<T> coll) {
        int num = (int) (Math.random() * coll.size());
        for(T t: coll) if (--num < 0) return t;
        throw new AssertionError();
    }

    public static void printPhaseResults(Map<String, Boolean> phaseResults) {
        System.out.println();
        System.out.println("Phase\t\tSuccessful");
        List<String> keys = (new ArrayList<>(phaseResults.keySet())).stream().sorted().collect(Collectors.toList());
        for (String key : keys) {
            //if (phaseResults.get(key).booleanValue()) {
                System.out.println(key + "\t\t" + phaseResults.get(key));
            //}
        }
    }

    public static void printCards(Collection<Card> cards, Boolean isDeck) {
        List<Card> cardList = new ArrayList<>(cards);
        Collections.sort(cardList, isDeck ? new CardIdComparator() : new CardValueComparator());
        System.out.println("The " + (isDeck ? "deck" : "hand") + " contains the following cards:");
        int cardCount = 0;
        for (Card c : cardList) {
            System.out.print("Card " + c.getId() + ": " + c.getValue() + "\t\t");
            if (isDeck) {
                cardCount++;
                if (cardCount % 6 == 0) {
                    System.out.println();
                }
            } else {
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void printPossibleRuns(List<Integer> runList, Integer runSize) {
        if (runList.size() > 0) {
            System.out.println("Possible Runs of size " + runSize + " found:");
            for (Integer runStarter : runList) {
                for (int i = 0; i < runSize - 1; i++) {
                    System.out.print((runStarter + i) + ", ");
                }
                System.out.println(runStarter + (runSize - 1));
            }
        } else {
            System.out.println("\tNo " + runSize + " member runs found.");
        }
    }

    public static void printPossibleSets(List<Integer> setList, Integer setSize) {
        if (setList.size() > 0) {
            System.out.println("Sets of size " + setSize + " found:");
            for (Integer setValue : setList) {
                System.out.println(setValue);
            }
        } else {
            System.out.println("\tNo " + setSize + " member sets found.");
        }
    }

    public static List<Integer> hasRunOfN(Hand hand, Integer n) {
        List<Integer> runStart = new ArrayList<>();
        if (n > 0 && n <= Hand.SIZE) {
            List<Integer> valuesList = (new ArrayList<>(hand.getValueList())).stream().distinct().sorted().collect(Collectors.toList());
            Integer[] values = new Integer[valuesList.size()];
            valuesList.toArray(values);
            if (n <= valuesList.size()) {
                for (int i = 0; i < values.length - n + 1; i++) {
                    boolean isConsecutive = true;
                    for (int j = 0; j < n; j++) {
                        if (values[i + j] != values[i] + j) {
                            isConsecutive = false;
                            break;
                        }
                    }
                    if (isConsecutive) {
                        runStart.add(values[i]);
                    }
                }
                printPossibleRuns(runStart, n);
            }
        }
        return runStart;
    }

    public static List<Integer> hasSetOfN(Hand hand, Integer n) {
        List<Integer> setList = new ArrayList<>();
        if (n < hand.size()) {
            List<Integer> valuesList = (new ArrayList<>(hand.getValueList())).stream().distinct().sorted().collect(Collectors.toList());
            Integer[] values = new Integer[valuesList.size()];
            valuesList.toArray(values);
            for (int i = 0; i < values.length; i++) {
                if (values[i] == values[i] + (n - 1)) {
                    setList.add(values[i]);
                    i = values[i] + (n - 1);
                }
            }
            printPossibleSets(setList, n);
        }
        return setList;
    }
}
