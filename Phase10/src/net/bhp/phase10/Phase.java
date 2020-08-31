package net.bhp.phase10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phase {

    public static Map<String, Boolean> hasPhases(Hand hand) {
        Map<String, Boolean> meetsPhaseReqs = new HashMap<>();
        meetsPhaseReqs.put("Phase 1", hasPhase1(hand));
        meetsPhaseReqs.put("Phase 2", hasPhase2(hand));
        meetsPhaseReqs.put("Phase 3", hasPhase3(hand));
        meetsPhaseReqs.put("Phase 4", hasPhase4(hand));
        meetsPhaseReqs.put("Phase 5", hasPhase5(hand));
        meetsPhaseReqs.put("Phase 6", hasPhase6(hand));
        meetsPhaseReqs.put("Phase 7", hasPhase7(hand));
        meetsPhaseReqs.put("Phase 9", hasPhase9(hand));
        meetsPhaseReqs.put("Phase 10", hasPhase10(hand));
        return meetsPhaseReqs;
    }

    private static Boolean hasPhase1(Hand hand) {
        // 2 sets of 3
        System.out.println("Checking Phase 1...");
        List<Integer> sets = Util.hasSetOfN(hand, 3);
        return sets.size() >= 2;
    }

    private static Boolean hasPhase2(Hand hand) {
        // 1 set of 3, 1 run of 4
        System.out.println("Checking Phase 2...");
        List<Integer> sets = Util.hasSetOfN(hand, 3);
        List<Integer> runs = Util.hasRunOfN(hand, 4);
        return sets.size() >= 1 && runs.size() >= 1;
    }

    private static Boolean hasPhase3(Hand hand) {
        // 1 set of 4, 1 run of 4
        System.out.println("Checking Phase 3...");
        List<Integer> sets = Util.hasSetOfN(hand, 4);
        List<Integer> runs = Util.hasRunOfN(hand, 4);
        return sets.size() >= 1 && runs.size() >= 1;
    }

    private static Boolean hasPhase4(Hand hand) {
        // 1 run of 7
        System.out.println("Checking Phase 4...");
        List<Integer> runs = Util.hasRunOfN(hand, 7);
        return runs.size() >= 1;
    }

    private static Boolean hasPhase5(Hand hand) {
        // 1 run of 8
        System.out.println("Checking Phase 5...");
        List<Integer> runs = Util.hasRunOfN(hand, 8);
        return runs.size() >= 1;
    }

    private static Boolean hasPhase6(Hand hand) {
        // 1 run of 9
        System.out.println("Checking Phase 6...");
        List<Integer> runs = Util.hasRunOfN(hand, 9);
        return runs.size() >= 1;
    }

    private static Boolean hasPhase7(Hand hand) {
        // 2 sets of 4
        System.out.println("Checking Phase 7...");
        List<Integer> sets = Util.hasSetOfN(hand, 4);
        return sets.size() >= 2;
    }

    private static Boolean hasPhase9(Hand hand) {
        // 1 set of 5, 1 set of 2
        System.out.println("Checking Phase 9...");
        List<Integer> sets1 = Util.hasSetOfN(hand, 5);
        List<Integer> sets2 = Util.hasSetOfN(hand, 2);
        return sets1.size() >= 1 && sets2.size() >= 1;
    }

    private static Boolean hasPhase10(Hand hand) {
        // 1 set of 5, 1 set of 3
        System.out.println("Checking Phase 10...");
        List<Integer> sets1 = Util.hasSetOfN(hand, 5);
        List<Integer> sets2 = Util.hasSetOfN(hand, 3);
        return sets1.size() >= 1 && sets2.size() >= 1;
    }
}
