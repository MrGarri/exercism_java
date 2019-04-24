import java.util.Arrays;
import java.util.stream.IntStream;

class SumOfMultiples {

    private final int number;
    private final int[] set;

    SumOfMultiples(int number, int[] set) {
        this.number = number;
        this.set = set;
    }

    int getSum() {
        return IntStream.range(0, number)
                .filter(this::isDivisorOfAnySetElement)
                .sum();
    }

    private boolean isDivisorOfAnySetElement(int divisor) {
        return Arrays.stream(set)
                .filter(value -> value != 0)
                .anyMatch(value -> divisor % value == 0);
    }

}
