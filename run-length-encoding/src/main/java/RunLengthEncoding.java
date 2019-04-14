import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RunLengthEncoding {

    String encode(String input) {

        if (input.isEmpty()) return "";

        StringBuilder result = new StringBuilder();
        char current = input.charAt(0);
        int counter = 0;

        for (char c : input.toCharArray()) {
            if (c != current) {
                result.append(merge(current, counter));
                current = c;
                counter = 0;
            }
            counter++;
        }

        result.append(merge(current, counter));

        return result.toString();

    }

    private String merge(char c, int count) {
        return count == 1 ? String.valueOf(c) : String.valueOf(count) + c;
    }

    String decode(String input) {

        final StringBuilder num = new StringBuilder();
        List<String> numbers = new ArrayList<>();
        List<String> letters = new ArrayList<>();

        StringBuilder result = new StringBuilder();

        input.chars().forEach(c -> {
            if (Character.isDigit(c)) {
                num.append(Character.toChars(c));
            } else {
                letters.add(new String(Character.toChars(c)));
                if (num.length() == 0)
                    numbers.add("1");
                else
                    numbers.add(num.toString());
                num.setLength(0);
            }
        });

        IntStream.range(0, numbers.size())
                .forEach(i -> repeatLetter(Integer.valueOf(numbers.get(i)), letters.get(i), result));

        return result.toString();

    }

    private void repeatLetter(int times, String letter, StringBuilder sb) {
        for (int i = 0; i < times; i++)
            sb.append(letter);
    }

}
