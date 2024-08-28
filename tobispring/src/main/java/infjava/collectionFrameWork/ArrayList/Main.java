package infjava.collectionFrameWork.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyArrayListV1<String> list1 = new MyArrayListV1<>();
        list1.add(0, "a");
        // int타입은 값을 넣을 수 없다.
        list1.add(1,"1");

        List<String> list  = new ArrayList<>();
        // add 메서드를 사용하여 값 삽입
        // 그냥 값을 넣으면 순차적으로 들어가고, 인덱스를 지정하여 값을 넣을 수도 있다.
        list.add("a");
        list.add("b");
        list.add(2,"c");
        list.add(null);
        System.out.println("add = " + list);

        // get 메서드를 사용하여 값 조회
        // 인덱스를 전달하여 값을 조회한다.
        System.out.println("get = " + list.get(0));

        // indexOf 메서드를 사용하여 요소의 인덱스를 반환한다.
        System.out.println("indexOf = " + list.indexOf("b"));

        // lastIndexOf 메서드를 사용하여 특정 요소의 인덱스를 반환한다.
        System.out.println("lastIndexOf = " + list.lastIndexOf("c"));

        // isEmpty 메서드를 사용하여 리스트가 비어있는지 확인한다.
        System.out.println("isEmpty = " + list.isEmpty());

        // set 메서드를 사용하여 값을 변경할 수 있다.
        // 인덱스와 값을 전달하여 해당 인덱스의 값을 변경한다.
        list.set(0,"A");
        System.out.println("set = " + list);

        // size 메서드를 사용하여 요소의 갯수를 반환한다.
        System.out.println("size = " + list.size());

        // remove 메서드를 사용하여 값 삭제
        // 인덱스를 전달하여 값을 삭제할 수도 있고, 삭제할 값을 전달하여 삭제할 수 도 있다.
        list.remove("a");
        list.remove(1);
        System.out.println("remove = " + list);



    }
}
