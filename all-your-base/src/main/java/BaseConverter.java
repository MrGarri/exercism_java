import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseConverter {

    private int base;
    private int[] digits;

    BaseConverter(int base, int[] digits) {
        if (base < 2)
            throw new IllegalArgumentException("Bases must be at least 2.");
        if (Arrays.stream(digits).anyMatch(digit -> digit < 0))
            throw new IllegalArgumentException("Digits may not be negative.");
        if (Arrays.stream(digits).anyMatch(digit -> digit >= base))
            throw new IllegalArgumentException("All digits must be strictly less than the base.");

        this.base = base;
        this.digits = digits;
    }

    public int[] convertToBase(int targetBase) {
        if (targetBase < 2)
            throw new IllegalArgumentException("Bases must be at least 2.");
        if (Arrays.stream(digits).allMatch(digit -> digit == 0))
            return new int[]{0};

        if (this.base == targetBase)
            return this.digits;
        else if (targetBase == 10)
            return convertToBase10();
        else if (this.base == 10)
            return convertFromBase10ToAnyBase(targetBase);
        else {
            this.digits = convertToBase10();
            return convertFromBase10ToAnyBase(targetBase);
        }
    }

    private int[] convertToBase10() {

        List<Integer> result = new ArrayList<>();
        int power = digits.length - 1;

        for (int digit : digits) {
            double value = Math.pow(base, power) * digit;
            result.add((int) value);
            power--;
        }

        String sum = String.valueOf(result.stream().reduce(0, Integer::sum));
        return sum.chars().map(Character::getNumericValue).toArray();

    }

    private int[] convertFromBase10ToAnyBase(int targetBase) {

        List<Integer> resultDigits = new ArrayList<>();

        StringBuilder tmpNum = Arrays.stream(digits).collect(
                StringBuilder::new,
                StringBuilder::append,
                StringBuilder::append
        );
        int number = Integer.valueOf(tmpNum.toString());

        while (number > 0) {
                resultDigits.add(0, number % targetBase);
                number /= targetBase;
        }

        int[] result = new int[resultDigits.size()];
        for (int i = 0; i < resultDigits.size(); i++)
            result[i] = resultDigits.get(i);
        return result;

    }

}
