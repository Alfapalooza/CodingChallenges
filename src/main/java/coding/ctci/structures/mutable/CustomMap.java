package coding.ctci.structures.mutable;

import java.util.Optional;

public class CustomMap<K, V> {
    public class Node<T, TT> {
        private T key;
        private TT value;

        public Node(T key, TT value) {
            this.key = key;
            this.value = value;
        }

        public T getKey() {
            return key;
        }

        public TT getValue() {
            return value;
        }
    }

    private final int INCREMENT_FACTOR = 2;

    protected CustomLinkedList<V>[] underlyingArray;
    protected int currIdx;

    public CustomMap() {
        int DEFAULT_SIZE = 1;
        this.underlyingArray = new CustomLinkedList[DEFAULT_SIZE];
        this.currIdx = 0;
    }

    public CustomMap(Node<K, V>... items) {
        underlyingArray = new CustomLinkedList[items.length * INCREMENT_FACTOR];

        put(items);
    }

    public void put(Node<K, V>... items) {
        assert(items.length < Integer.MAX_VALUE);

        for (int i = 0; i < items.length; ++i) {
            int hash = hashCode(items[i].getKey());
            V value = items[i].getValue();

            resizeIfNecessary(hash);

            if (underlyingArray[hash] == null) {
                underlyingArray[hash] = new CustomLinkedList<V>();
            }

            underlyingArray[hash].insert(value);
            ++currIdx;
        }
    }

    public Optional<V> remove(K key) {
        int hash = hashCode(key);

        if (hash > underlyingArray.length || underlyingArray[hash] == null) {
            return Optional.empty();
        } else {
            V item = (V) underlyingArray[hash];
            underlyingArray[hash] = null;
            return Optional.of(item);
        }
    }

    public Optional<V> get(K key) {
        int hash = hashCode(key);

        if (hash > underlyingArray.length || underlyingArray[hash] == null) {
            return Optional.empty();
        } else {
            return Optional.of((V) underlyingArray[hash]);
        }
    }

    public int size() {
        return currIdx;
    }

    public boolean isEmpty() {
        return currIdx - 1 < 0;
    }

    public boolean isNonEmpty() {
        return !isEmpty();
    }

    protected int hashCode(K key) {
        return Math.abs(key.hashCode());
    }


    protected void resizeIfNecessary(int pos) {
        assert(pos > 0 && pos < Integer.MAX_VALUE);

        if (underlyingArray.length < pos) {
            resize();
            resizeIfNecessary(pos);
        }
    }

    protected void resize() {
        assert(this.underlyingArray.length * INCREMENT_FACTOR < Integer.MAX_VALUE);
        CustomLinkedList [] newUnderlyingArray = new CustomLinkedList[this.underlyingArray.length * INCREMENT_FACTOR];

        for (int i = 0; i < this.underlyingArray.length; ++i) {
            newUnderlyingArray[i] = this.underlyingArray[i];
        }

        this.underlyingArray = newUnderlyingArray;
    }
}
