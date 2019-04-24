public class DoublyLinkedList<T> {

    private static class Node<T> {
        private Node previous;
        private Node next;
        T value;

        Node(T value, Node previous, Node next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }

    private Node<T> first = null;
    private Node<T> last = null;

    public void push(T element) {
        if (isEmpty()) {
            addWhenEmpty(element);
        } else {
            Node<T> currLast = this.last;
            last = new Node<>(element, currLast, currLast.next);
            currLast.next = last;
        }
    }

    public T pop() {
        Node<T> currLast = this.last;
        last = currLast.previous;
        return currLast.value;
    }

    public T shift() {
        Node<T> currFirst = this.first;
        first = currFirst.next;
        return currFirst.value;
    }

    public void unshift(T element) {
        if (isEmpty()) {
            addWhenEmpty(element);
        } else {
            Node<T> currFirst = this.first;
            first = new Node<>(element, currFirst.previous, currFirst);
            currFirst.previous = first;
        }
    }

    private boolean isEmpty() { return first == null; }

    private void addWhenEmpty(T element) {
        Node<T> node = new Node<>(element, null, null);
        first = node;
        last = node;
    }

}
