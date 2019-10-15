package coding.ctci.structures.mutable;

import java.util.Optional;

public class CustomArrayList<T> {
    public interface FindItem<T> {
        boolean isItem(T item);
    }

    public interface Mapper<T, T1> {
        T1 apply(T item);
    }

    private final int DEFAULT_SIZE = 1;
    private final int INCREMENT_FACTOR = 2;

    protected Object[] underlyingArray;
    protected int currIdx;

    public CustomArrayList() {
        this.underlyingArray = new Object[DEFAULT_SIZE];
        this.currIdx = 0;
    }

    public CustomArrayList(T item) {
        this.underlyingArray = new Object[DEFAULT_SIZE];

        insert(item);
    }

    @SafeVarargs
    public CustomArrayList(T... items) {
        this.underlyingArray = new Object[items.length * INCREMENT_FACTOR];

        insert(items);
    }

    //O(1)
    public Optional<T> get(int pos) {
        if (currIdx <= 0 || pos >= currIdx) {
            return Optional.empty();
        } else {
            return Optional.ofNullable((T) underlyingArray[pos]);
        }
    }

    //O(1)
    @SafeVarargs
    public final void insert(T... items) {
        insert(currIdx, items);
    }

    @SafeVarargs
    public final void insert(Integer pos, T... items) {
        assert(pos <= currIdx && items.length < Integer.MAX_VALUE);

        resizeIfNecessary(items.length);

        if (pos != currIdx) {
            for (int i = currIdx + items.length; i > pos; --i) {
                int originalPosition = i - items.length;

                underlyingArray[i] = underlyingArray[originalPosition];
            }

            currIdx = currIdx + items.length;

            for (int x = 0, y = pos; x < items.length; ++x, ++y) {
                underlyingArray[y] = items[x];
            }
        } else {
            for (int i = 0; i < items.length; ++i) {
                underlyingArray[currIdx] = items[i];
                ++currIdx;
            }
        }
    }

    //O(N)
    public Optional<T> remove(int pos) {
        Optional<T> item = Optional.empty();

        if (currIdx <= 0 || pos >= currIdx) {
            return Optional.empty();
        } else {
            item = Optional.ofNullable((T) underlyingArray[pos]);

            if (pos == currIdx - 1) {
                underlyingArray[pos] = null;
            } else {
                for (int i = pos; i < currIdx; ++i) {
                    if (i == currIdx - 1) {
                        underlyingArray[i] = null;
                    } else {
                        underlyingArray[i] = underlyingArray[i + 1];
                    }
                }
            }

            --currIdx;
            return item;
        }
    }

    //O(N)
    public Optional<T> findFirst(FindItem<T> findItem) {
        for (int i = 0; i < currIdx; ++i) {
            T item = (T) underlyingArray[i];

            if (findItem.isItem(item)) {
                return Optional.ofNullable(item);
            }
        }

        return Optional.empty();
    }

    //O(N)
    public boolean contains(T item1) {
        return exists(item2 -> item1 == item2);
    }

    //O(N)
    public boolean exists(FindItem<T> findItem) {
        for (int i = 0; i < currIdx; ++i) {
            T item = (T) underlyingArray[i];

            if (findItem.isItem(item)) {
                return true;
            }
        }

        return false;
    }

    //O(N)
    public boolean forAll(FindItem<T> findItem) {
        for (int i = 0; i < currIdx; ++i) {
            T item = (T) underlyingArray[i];

            if (!findItem.isItem(item)) {
                return false;
            }
        }

        return true;
    }

    //O(N)
    public <TT> CustomArrayList<TT> map(Mapper<T, TT> mapper) {
        Object[] tmp = new Object[this.size() * INCREMENT_FACTOR];

        for (int i = 0; i < currIdx; ++i) {
            tmp[i] = mapper.apply((T) underlyingArray[i]);
        }

        return new CustomArrayList(tmp);
    }

    //O(N)
    public String mkString() {
        return mkString("");
    }

    //O(N)
    public String mkString(String sep) {
        String tmp = "";

        for (int i = 0; i < currIdx; ++i) {
            Optional<T> itemOpt = Optional.ofNullable((T) underlyingArray[i]);

            if (itemOpt.isPresent())
                tmp = String.format("%s%s%s", tmp, sep, itemOpt.get().toString());
        }

        return tmp;
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

    protected void resizeIfNecessary(int items) {
        assert(currIdx + items < Integer.MAX_VALUE);

        if (underlyingArray.length - (currIdx + items) <= 0) {
            resize();
            resizeIfNecessary(items);
        }
    }

    protected void resize() {
        assert(this.underlyingArray.length * INCREMENT_FACTOR < Integer.MAX_VALUE);
        Object [] newUnderlyingArray = new Object[this.underlyingArray.length * INCREMENT_FACTOR];

        for (int i = 0; i < this.underlyingArray.length; ++i) {
            newUnderlyingArray[i] = underlyingArray[i];
        }

        this.underlyingArray = newUnderlyingArray;
    }

    @Override
    public String toString() {
        return mkString();
    }
}
