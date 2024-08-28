package infjava.collectionFrameWork.ArrayList;

import java.util.Arrays;

public class MyArrayListV1<T> {

    // DEFAULT_CAPACITY는 배열의 전체 크기를 의미한다.
    private static final int DEFAULT_CAPACITY = 5;
    // 모든 타입을 담을 수 있게 Object 타입으로 배열을 생성한다.
    private Object[] elementData;
    // size는 배열의 담겨있는 요소의 갯수를 의미한다.
    private int size = 0;


    // MyArrayList를 그냥 생성하면 기본 크기가 DEFAULT_CAPACITY인 배열이 생성된다.
    public MyArrayListV1 () {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    // MyArrayList에 인자를 전달하여 생성하면 전달한 인자만큼의 크기를 가지는 배열이 생성된다.
    public MyArrayListV1 (int initialCapacity) {
        elementData = new Object[initialCapacity];
    }

    // size 메서드는 현재 요소의 갯수를 리턴한다.
    public int size () {
        return size;
    }

    // 배열에 요소를 추가하면 size가 증가되게 하여 배열의 요소들이 순서대로 추가된다.
    public void add (int index, T e) {

        if (size == elementData.length){
            grow();
        }
        shiftRightData(index);
        elementData[index] = e;
        size++;
    }

    public void shiftRightData (int index) {
        // 값이 있는 데이터중 가장 오른쪽에 있는 것 부터 인덱스까지 한칸씩 오른쪽으로 이동
        for (int i = size; i > index; i --) {
            elementData[i] = elementData[i -1];
          }
    }

    public Object remove(int index) {
        Object preValue = get(index);
        shiftLeftData (index);

        size--;
        // 값을 복사해서 왼쪽으로 보내는 것이기 때문에 마지막 요소의 값은 그대로 있다.따라서 NULL을 넣어준 것.
        elementData[size] = null;

        return preValue;
    }

    public void shiftLeftData (int index) {
        for(int i = index; i < size; i++) {
            elementData[i] = elementData[i + 1];
        }
    }

    public void grow () {
        int prevCapacity = elementData.length;
        int newCapacity = prevCapacity * 2;
        // copyOf를 사용하면 두번째 인자 만큼의 크기르 가지는 배열을 생성 후 첫번째 인자를 복사한다.
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    // 요소 조회
    public T get (int index) {
        return (T)elementData[index];
    }

    // 특정 인덱스 위치에 요소 추가
    public T set (int index, T element) {
        T oldValue = get(index);
        elementData[index] = element;
        return oldValue;
    }

    // 특정 요소의 인덱스 반환
    public int indexOf(Object e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    // toString 구현
    public String toString () {
        // [1,2,3,null,null] 이면 null이 아닌 값들만 출력되도록 한다.
        // copyOf를 사용하면 지정한 크기만큼 배열을 생성 후 요소를 복사할 수 있다.
        return Arrays.toString(Arrays.copyOf(elementData, size)) + ", size = " + size + ", capacity = " + elementData.length;
    }
}
