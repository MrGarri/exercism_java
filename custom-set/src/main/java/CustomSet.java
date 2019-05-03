import java.util.*;

public class CustomSet<T> {

    private Map<T, Object> elements = new HashMap<>();
    private final static Object DUMMY = new Object();

    private CustomSet() {}
    CustomSet(List<T> initialElements) {
        addAll(initialElements);
    }

    public boolean isEmpty() { return elements.isEmpty(); }
    public boolean contains(T element) { return elements.containsKey(element); }
    public void add(T element) { elements.put(element, DUMMY); }

    public boolean isSubset(CustomSet<T> set) {
        Iterator<T> iterator = set.iterator();

        while (iterator.hasNext()) {
            T next = iterator.next();
            if (!this.contains(next))
                return false;
        }

        return true;
    }

    public boolean isDisjoint(CustomSet<T> set) {
        Iterator<T> iterator = set.iterator();

        while (iterator.hasNext()) {
            T next = iterator.next();
            if (this.contains(next))
                return false;
        }

        return true;
    }

    public CustomSet<T> getIntersection(CustomSet<T> set) {
        CustomSet<T> result = new CustomSet<>();

        set.iterator().forEachRemaining(element -> {
            if (this.contains(element))
                result.add(element);
        });

        return result;
    }

    public CustomSet<T> getDifference(CustomSet<T> set) {
        CustomSet<T> result = new CustomSet<>();

        this.iterator().forEachRemaining(element -> {
            if (!set.contains(element))
                result.add(element);
        });

        return result;
    }

    public CustomSet<T> getUnion(CustomSet<T> set) {
        set.iterator().forEachRemaining(this::add);
        return this;
    }

    public boolean equals(CustomSet<T> set) {
        return this.isSubset(set) && set.isSubset(this);
    }

    private void addAll(List<T> initialElements) {
        initialElements.forEach(element -> elements.put(element, DUMMY));
    }

    private Iterator<T> iterator() { return elements.keySet().iterator(); }

}
