import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NucleotideCounter {

    private String sequence;

    public NucleotideCounter(String sequence) {
        if (Pattern.compile("[^acgt]", Pattern.CASE_INSENSITIVE).matcher(sequence).find())
            throw new IllegalArgumentException("Invalid nucleotide sequence.");

        this.sequence = sequence;
    }

    Map<Character, Integer> nucleotideCounts() {
        Map<Character, Integer> nucleotideCount = IntStream.range(0, sequence.length())
                .mapToObj(i -> sequence.charAt(i))
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.reducing(0, e -> 1, Integer::sum)));

        return complete(nucleotideCount);
    }

    private Map<Character, Integer> complete(Map<Character, Integer> nucleotideCount) {
        nucleotideCount.putIfAbsent('A', 0);
        nucleotideCount.putIfAbsent('C', 0);
        nucleotideCount.putIfAbsent('G', 0);
        nucleotideCount.putIfAbsent('T', 0);
        return nucleotideCount;
    }

}
