package coding.ctci.structures.mutable;

import java.util.Optional;

public class CustomLinkedList<T> {
    interface FindItem<T> {
        public boolean isItem(T item);
    }

    public class Node<TT> {
        private TT value;
        private Optional<Node<TT>> previous;
        private Optional<Node<TT>> next;

        public Node(TT item) {
            this(item, Optional.empty(), Optional.empty());
        }

        public Node(TT item, Optional<Node<TT>> previous, Optional<Node<TT>> next) {
            this.value = item;
            this.previous = previous;
            this.next = next;
        }

        public TT getValue() {
            return value;
        }

        public Optional<Node<TT>> getPrevious() {
            return previous;
        }

        public Optional<Node<TT>> getNext() {
           return next;
        }

        public void setNext(Optional<Node<TT>> next) {
            this.next = next;
        }

        public void setPrevious(Optional<Node<TT>> previous) {
            this.previous = previous;
        }
    }

    protected Optional<Node<T>> head;
    protected Optional<Node<T>> tail;
    protected int currIdx;

    public CustomLinkedList() {
        this.head = Optional.empty();
        this.tail = Optional.empty();
        this.currIdx = 0;
    }

    public CustomLinkedList(T... items) {
        insert(items);
    }

    //O(1)
    public void insert(T... items) {
        for (int i = 0; i < items.length; ++i) {
            if (!head.isPresent()) {
                tail = Optional.of(new Node(items[i]));
                head = Optional.of(new Node(items[i], Optional.empty(), tail));
                head.get().setPrevious(tail);
            } else {
                Node<T> node = new Node(items[i], tail, Optional.empty());
                tail = Optional.of(node);
            }

            ++currIdx;
        }
    }

    //O(N)
    public Optional<T> remove(T item) {
        return remove(head, item);
    }

    //O(N)
    private Optional<T> remove(Optional<Node<T>> currNode, T item) {
        return Optional.empty();
    }

    //O(N)
    public Optional<T> findFirst(FindItem<T> findItem) {
        return Optional.empty();
    }

    private Optional<T> findFirst(Optional<Node<T>> currNode, FindItem<T> findItem) {
        return Optional.empty();
    }

    public Optional<Node<T>> getHead() {
        return head;
    }

    public Optional<Node<T>> getTail() {
        return tail;
    }
}
