package com.Arithmetic;

/**
 * Created：Jeffrey
 * date   ：2021/8/19 7:31
 */
public class TestBinary {
    Node head;

    public TestBinary(Node head) {
        this.head = head;
    }

    public static void main(String[] args) {
        TestBinary testBinary = new TestBinary(new Node(1));


    }


    void list(Node t0) {
        Node temp = null;
        if (t0 == null) {
            temp = head;
        }
        if (temp.left != null) {
            System.out.println(temp.left);
            t0 = temp.left;
            list(t0);
        }


    }

    static class Node {
        Node left;
        Node right;
        Object value;

        public Node(Object value) {
            this.value = value;
        }
    }
}
