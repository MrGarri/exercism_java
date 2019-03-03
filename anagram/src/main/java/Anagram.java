import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagram {

    private String word;

    public Anagram(String word) {
        this.word = word;
    }

    public List<String> match(List<String> input) {

        List<String> result = new ArrayList<>();
        String wordSorted = (word.matches("[A-Z]+")) ? sortString(word) : sortString(word.toLowerCase());

        input.stream().forEach(s -> {
            String aux = sortString(s.toLowerCase());
            if(aux.equals(wordSorted))
                result.add(s);
        });

        return result;

    }

    private String sortString(String s) {

        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);

    }

}
