import java.util.stream.IntStream;

class PrimeCalculator {

    int nth(int nth) {
        if (nth < 1)
            throw new IllegalArgumentException();

        return IntStream.iterate(2, i -> ++i)
                .filter(PrimeCalculator::isPrime)
                .limit(nth)
                .reduce((first, second) -> second)
                .orElse(0);

    }

    private static boolean isPrime(int num) {
        return IntStream.rangeClosed(2, (int) Math.sqrt(num))
                .allMatch(value -> num % value != 0);
    }

}
