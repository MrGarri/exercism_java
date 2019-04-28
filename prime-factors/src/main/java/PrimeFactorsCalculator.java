import java.util.ArrayList;
import java.util.List;

public class PrimeFactorsCalculator {

    List<Long> calculatePrimeFactorsOf(long num) {

        List<Long> result = new ArrayList<>();

        for (long i = 2; i <= num; i++) {
            while (num % i == 0) {
                result.add(i);
                num /= i;
            }
        }

        return result;

    }

}
