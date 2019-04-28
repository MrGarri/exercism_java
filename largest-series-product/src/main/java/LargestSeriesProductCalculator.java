import java.util.OptionalLong;
import java.util.stream.IntStream;

class LargestSeriesProductCalculator {
    private final String inputNumber;

    LargestSeriesProductCalculator(String inputNumber) {
        if (!inputNumber.matches("\\d*"))
            throw new IllegalArgumentException("String to search may only contain digits.");
        this.inputNumber = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        if (numberOfDigits > inputNumber.length())
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        if (numberOfDigits < 0)
            throw new IllegalArgumentException("Series length must be non-negative.");

        OptionalLong max = IntStream.rangeClosed(0, inputNumber.length() - numberOfDigits)
                .mapToObj(i -> inputNumber.substring(i, numberOfDigits + i))
                .mapToLong(this::mulChars)
                .max();

        return max.orElse(1);

    }

     private long mulChars(String chars) {
        int result = IntStream.range(0, chars.length())
                .map(chars::charAt)
                .map(Character::getNumericValue)
                .reduce(1, Math::multiplyExact);

        return (long) result;
    }
}
