import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordCount {

    public Map<String, Integer> phrase(String phrase) {

        String[] words = phrase.split("[\n:, ]");

        return Arrays.stream(words)
                .filter(word -> !word.isEmpty())
                .map(word -> {
                    word = word.toLowerCase();
                    word = word.replaceAll("[^a-z0-9']", "");
                    word = word.replaceAll("^'|'$", "");
                    return word;
                })
                .collect(Collectors.toMap(Function.identity(), word -> 1, Integer::sum));

    }

}
