package infjava.collectionFrameWork.LinkedList;

public class Main {
    public static void main(String[] args) {
        // 각각의 노드를 생성한다.
        Node firstNode = new Node("A");
        firstNode.next = new Node("B");
        firstNode.next.next = new Node("C");

        System.out.println(firstNode);


    }

    // 전체 노드 조회하기
    private static void printAll(Node node){
        Node x = node;
        while ( x != null ) {
            System.out.println(x.item);
            x = x.next;
        }
    }
    // 마지막 노드 조회하기
    private static Node getLastNode(Node node) {
        Node x = node;
        while (x.next != null) {
            x = x.next;
        }

        return x;
    }

    private static Node getNode(Node node, int index) {
        Node x = node;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }

        return x;
    }

    // 데이터 추가 하기
    private static void add(Node node, String param) {
        Node lastNode = getLastNode(node);
        lastNode.next = new Node(param);
    }
}

