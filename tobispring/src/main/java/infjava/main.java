package infjava;

public class main {
    public static void main(String[] args) {

        Generic<String> generic = new Generic<>();
        generic.set("String타입");
        String value = generic.get();
        System.out.println(value);

        Generic<Integer> generic2 = new Generic<>();
        generic2.set(10);
        Integer value2 = generic2.get();
        System.out.println(value2);

        Generic<String> generic3 = new Generic<>();
        generic3.set("test");
        String value3 = generic3.get();
    }


}
