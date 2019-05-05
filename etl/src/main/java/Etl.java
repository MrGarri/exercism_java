import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Etl {
    Map<String, Integer> transform(Map<Integer, List<String>> old) {

        return old.entrySet()
                .stream()
                .flatMap(entry -> entry.getValue()
                        .stream()
                        .map(s -> new AbstractMap.SimpleEntry<>(s.toLowerCase(), entry.getKey())))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }
}
