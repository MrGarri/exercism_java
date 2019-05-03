import java.util.*;

public class SimpleLinkedList<T> {

    private static class Node<T> {
        private T element;
        private Node next;

        Node(T element, Node next) {
            this.element = element;
            this.next = next;
        }
    }

    private int size = 0;
    private Node first = null;

    public SimpleLinkedList() {}

    public SimpleLinkedList(T[] values) {
        addAll(values);
    }

    public void push(T element) {
        if (this.isEmpty()) {
            first = new Node<>(element, null);
        } else {
            first = new Node<>(element, first);
        }
        size++;
    }

    public T pop() {
        if (this.isEmpty())
            throw new NoSuchElementException();

        Node<T> currFirst = first;
        first = currFirst.next;
        size--;
        return currFirst.element;
    }

    public int size() { return size; }

    public T[] asArray(Class<T> tClass) {
        List<T> result = new ArrayList<>();

        while (!this.isEmpty())
            result.add(this.pop());

        return (T[]) result.toArray();
    }

    public void reverse() {
        List<T> elements = new ArrayList<>();
        while (!this.isEmpty())
            elements.add(this.pop());
        Collections.reverse(elements);
        this.addAll((T[]) elements.toArray());
    }

    private void addAll(T[] values) {
        List<T> asList = Arrays.asList(values);
        Collections.reverse(asList);
        asList.forEach(this::push);
    }

    private boolean isEmpty() { return size == 0; }

}


