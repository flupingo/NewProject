package com.Arithmetic;

/** 双向链表
 * Created：Jeffrey
 * date   ：2021/8/8 11:03
 */
public class DoubleLinkedList {
    Node head = new Node(0, "0", "0"); //头节点不为null

    //添加：往节点的后一个
    void addNode(Node node) {
        Node temp = head; //指针指向头节点位置
        while (true) {
            if (temp.next == null) { //找到尾部
                //互相指向：和单向的区别
                temp.next = node;
                node.pre = temp;
                break;
            }
            temp = temp.next; //指针后移
        }
    }


    void delNodeByNo(int no) {
        Node temp = head;
        if (temp.next == null) {
            System.out.println("空链表");
        }

        while (true) {
            if (temp.next == null) { //尾部节点
                if (temp.no == no) {
                    temp.pre.next = null;
                    break;
                } else {
                    break;
                }
            }
            if (temp.no == no) {
                temp.pre.next = temp.next;
                temp.next.pre = temp.pre;
                break;
            }
            temp = temp.next;
        }


    }


}
