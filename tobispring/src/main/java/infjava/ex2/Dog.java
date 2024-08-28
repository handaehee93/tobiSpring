package infjava.ex2;

public class Dog extends Animal{
    public Dog(String name, int size) {
        super(name, size);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getSize() {
        return super.getSize();
    }

    @Override
    public void sound() {
        super.sound();
    }
}
