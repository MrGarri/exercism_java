import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Proverb {

    private String[] words;
    private final String SKELETON = "For want of a %s the %s was lost.\n";
    private final String FINAL_SENTENCE = "And all for the want of a %s.";

    Proverb(String[] words) {
        this.words = words;
    }

    String recite() {
        if (words.length == 0) return "";

        return IntStream.range(0, words.length - 1)
                .mapToObj(i -> String.format(SKELETON, words[i], words[i+1]))
                .collect(Collectors.joining(""))
                .concat(String.format(FINAL_SENTENCE, words[0]));
    }

}
