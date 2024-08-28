package infjava;

public class Generic<T> {
    private T value;

    public void set (T value) {
        this.value = value;
    }

    public T get () {
        return this.value;
    }


    public <A> A returninput (A ele) {
        return ele;
    }
}
