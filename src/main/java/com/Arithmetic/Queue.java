package com.Arithmetic;

/**
 * Created：Jeffrey
 * date   ：2021/7/25 20:21
 */
public class Queue {
    Node head;  //头节点

    //遍历
    void list() {
        Node node = head.next;
        while (true) {
            if (node == null) {
                break;
            }
            node = node.next;
            System.out.println(node);
        }
    }

    //添加
    void add(Node node) {
        Node node1 = head.next;
        while (true) {
            if (node1 == null) { //找到最后一个
                break;
            }
            node1 = node1.next;
            System.out.println(node);
        }
        node1.next = node;
    }

    public Queue(Node head) {
        this.head = head;
    }

    static class Node {
        Object obj;
        Node next;

        public Node(Object obj) {
            this.obj = obj;
        }
    }
}
