import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class School {

    private Map<Integer, Set<String>> students = new TreeMap<>();

    void add(String name, int grade) {
        students.merge(grade, new TreeSet<>(Collections.singletonList(name)),
                (o1, o2) -> new TreeSet<>(Stream.concat(o1.stream(), o2.stream()).collect(Collectors.toList())));
    }

    List<String> roster() {
        return students.values()
                .stream()
                .flatMap(Set::stream)
                .collect(Collectors.toList());
    }

    List<String> grade(int grade) {
        return new ArrayList<>(students.getOrDefault(grade, new TreeSet<>()));
    }

}
