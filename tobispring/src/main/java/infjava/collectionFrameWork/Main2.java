package infjava.collectionFrameWork;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int listSize = list.size();
        boolean listIsEmpty = list.isEmpty();
        int listElement = list.get(1);
        boolean listContains = list.contains(1);

        list.set(1,111);
        list.add(1,11);


        list.remove(3);
        list.remove((Integer)111);



    }
}
