import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PangramChecker {

    private static final Integer NUM_OF_LETTERS = 26;

    public boolean isPangram(String input) {

        String sanitizedInput = input.toLowerCase().replaceAll("[^a-z]", "");

        Set<Character> lettersUsed = IntStream.range(0, sanitizedInput.length())
                .mapToObj(sanitizedInput::charAt)
                .collect(Collectors.toSet());

        return lettersUsed.size() == NUM_OF_LETTERS;

    }

}
