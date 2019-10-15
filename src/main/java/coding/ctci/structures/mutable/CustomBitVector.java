package coding.ctci.structures.mutable;

public class CustomBitVector {
    private int underlyingVector;

    public CustomBitVector() {
        underlyingVector = 0;
    }

    public void setFlag(int pos) {
        underlyingVector |= (1 << pos);
    }

    public boolean isFlagSet(int pos) {
        return (underlyingVector & (1 << pos)) > 0;
    }
}
