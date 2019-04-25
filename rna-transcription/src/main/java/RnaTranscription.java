import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class RnaTranscription {

    private static final Map<Character, Character> transcriptions = new HashMap<Character, Character>() {{
        put('G', 'C');
        put('C', 'G');
        put('T', 'A');
        put('A', 'U');
    }};

    String transcribe(String dnaStrand) {
        return IntStream.range(0, dnaStrand.length())
                .mapToObj(dnaStrand::charAt)
                .map(transcriptions::get)
                .map(String::valueOf)
                .collect(Collectors.joining(""));
    }

}
