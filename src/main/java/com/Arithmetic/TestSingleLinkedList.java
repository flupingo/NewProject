package com.Arithmetic;

/**
 * Created：Jeffrey
 * date   ：2021/8/4 15:30
 */
public class TestSingleLinkedList {
    public static void main(String[] args) {
        int len = testLength();
        System.out.println("链表的节点个数为：" + len + "！！！");
    }

    //查看节点数量
    static int testLength() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addNode(new Node(1, "1", "1"));
        singleLinkedList.addNode(new Node(2, "2", "2"));
        singleLinkedList.list();
        Node head = singleLinkedList.getHead();

        int len = 0;
        if (head != null) {
            Node node = head.next;
            while (node != null) {
                node = node.next;
                len++;
            }
            return len + 1;
        }
        return len;
    }



}
