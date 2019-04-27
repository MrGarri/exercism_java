import java.util.Arrays;
import java.util.Map;
import java.util.PrimitiveIterator;
import java.util.function.Function;
import java.util.stream.Collectors;

class Yacht {

    private final int[] dice;
    private final YachtCategory yachtCategory;

    Yacht(int[] dice, YachtCategory yachtCategory) {
        this.dice = dice;
        this.yachtCategory = yachtCategory;
    }

    int score() {
        switch (yachtCategory) {
            case YACHT:
                return calculateYacht();
            case ONES:
                return calculateNs(1);
            case TWOS:
                return calculateNs(2);
            case THREES:
                return calculateNs(3);
            case FOURS:
                return calculateNs(4);
            case FIVES:
                return calculateNs(5);
            case SIXES:
                return calculateNs(6);
            case FULL_HOUSE:
                return calculateFullHouse();
            case FOUR_OF_A_KIND:
                return fourOfAKind();
            case LITTLE_STRAIGHT:
                return calculateStraight(false);
            case BIG_STRAIGHT:
                return calculateStraight(true);
            case CHOICE:
                return calculateChoice();
            default:
                return 0;
        }
    }

    private int calculateChoice() {
        return Arrays.stream(dice).sum();
    }

    private int calculateStraight(boolean big) {
        int start = big ? 2 : 1;

        PrimitiveIterator.OfInt iterator = Arrays.stream(dice).sorted().iterator();
        int previous = iterator.nextInt();
        if (previous != start)
            return 0;

        while (iterator.hasNext()) {
            int current = iterator.nextInt();
            if (previous + 1 == current)
                previous = current;
            else
                return 0;
        }

        return 30;
    }

    private int fourOfAKind() {
        Map<Integer, Integer> collect = Arrays.stream(dice)
                .boxed()
                .collect(Collectors.toMap(Function.identity(), a -> 1, Integer::sum));

        for (Map.Entry<Integer, Integer> entry : collect.entrySet()) {
            if (entry.getValue() >= 4)
                return 4 * entry.getKey();
        }

        return 0;
    }

    private int calculateFullHouse() {
        Map<Integer, Integer> collect = Arrays.stream(dice)
                .boxed()
                .collect(Collectors.toMap(Function.identity(), a -> 1, Integer::sum));

        if (collect.values().contains(3) && collect.values().contains(2)) {
            return Arrays.stream(dice).sum();
        } else
            return 0;
    }

    private int calculateNs(int category) {
        return Arrays.stream(dice).filter(roll -> roll == category).sum();
    }

    private int calculateYacht() {
        return Arrays.stream(dice).distinct().count() == 1 ? 50 : 0;
    }

}
