import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Sieve {

    private final int maxPrime;

    Sieve(int maxPrime) {
        this.maxPrime = maxPrime;
    }

    List<Integer> getPrimes() {
        return IntStream.rangeClosed(2, maxPrime)
                .filter(Sieve::isPrime)
                .boxed()
                .collect(Collectors.toList());
    }

    private static boolean isPrime(int num) {
        return IntStream.rangeClosed(2, (int) Math.sqrt(num))
                .allMatch(value -> num % value != 0);
    }

}
