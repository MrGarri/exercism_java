import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Flattener {

    List<Object> flatten(List<Object> input) {

        List<Object> result = new ArrayList<>();

        input.forEach(o -> {
            if (o instanceof List)
                result.addAll(flatten((List<Object>) o));
            else if (Objects.nonNull(o))
                result.add(o);
        });

        return result;

    }

}
