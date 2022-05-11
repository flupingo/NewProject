package Fundation.DataStructure;

/**
 * Created：Jeffrey
 * date   ：2021/7/16 10:08
 */
public class TestQueue001 implements Cloneable{ //队列
    Node first;
    Node last;

    public static void main(String[] args) {
        TestQueue001 testQueue001 = new TestQueue001();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.pre = null;
        node1.next = node2;
        node2.pre = node1;
        node2.next = node3;
        node3.pre = node2;
        node3.next = null;
        testQueue001.first = node1;
        testQueue001.last = node3;



    }

    static class Node {
        Object element;
        Node pre;
        Node next;

        public Node(Object element) {
            this.element = element;
        }
    }
}
