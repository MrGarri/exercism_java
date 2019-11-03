import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class ListOps {

    static <T> List<T> append(List<T> list1, List<T> list2) {
        List<T> result = new ArrayList<>(list1);
        result.addAll(list2);
        return result;
    }

    static <T> List<T> concat(List<List<T>> listOfLists) {
        return listOfLists.stream().flatMap(Collection::stream).collect(Collectors.toList());
    }

    static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>(list);
        return result.stream().filter(predicate).collect(Collectors.toList());
    }

    static <T> int size(List<T> list) {
        List<T> result = new ArrayList<>(list);
        return result.size();
    }

    static <T, U> List<U> map(List<T> list, Function<T, U> transform) {
        List<T> result = new ArrayList<>(list);
        return result.stream().map(transform).collect(Collectors.toList());
    }

    static <T> List<T> reverse(List<T> list) {
        List<T> result = new ArrayList<>(list);
        Collections.reverse(result);
        return result;
    }

    static <T, U> U foldLeft(List<T> list, U initial, BiFunction<U, T, U> f) {
        U result = initial;

        for (T element : list) {
            result = f.apply(result, element);
        }

        return result;
    }

    static <T, U> U foldRight(List<T> list, U initial, BiFunction<T, U, U> f) {
        List<T> reverse = reverse(list);
        U result = initial;

        for (T element : reverse)
            result = f.apply(element, result);

        return result;
    }

    private ListOps() {
        // No instances.
    }

}