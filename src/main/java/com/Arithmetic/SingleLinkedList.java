package com.Arithmetic;

/** 单向链表
 * Created：Jeffrey
 * date   ：2021/8/6 14:06
 */
public class SingleLinkedList {
    //初始化头节点
    private Node head = new Node(0, "0", "0");

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    //添加：往节点的后一个
    void addNode(Node node) {
        Node temp = head; //指针指向头节点位置
        while (true) {
            if (temp.next == null) { //找到尾部，加到最后
                temp.next = node;
                break;
            }
            temp = temp.next; //指针后移
        }
    }

    void addByOrder(Node node) {
        Node temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) { //最后
                break;
            } else if (temp.next.no == node.no) { //已经存在
                flag = true;
                break;
            } else if (temp.next.no > node.no) { //找到中间位置
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("节点已经存在");
        } else {
            //插到中间位置
            temp.next = node;
            node.next = temp.next;
        }
    }


    //遍历
    void list() {
        Node temp = head;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }

    //修改
    void updateNode(Node node) {
        Node temp = head;
        while (true) {
            if (temp == null) {
                break;
            } else if (temp.no == node.no) {
                temp.name = node.name;
                temp.value = node.value;
                break;
            }
            temp = temp.next;
        }
    }

    //删除
    void delNodeByNo(int no) {
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            } else if (temp.next.no == no) {
                temp.next = temp.next.next;  //当前指向往后第二个
                break;
            }
            temp = temp.next;
        }
    }


    //=====约瑟夫问题=====
    //创建长度为n的环
    void createCircle(int n) {
        Node head = null;  //1
        Node temp = null; //2

        for (int i = 1; i <= n; i++) {
            Node node = new Node(i, "", "");
            if (i == 1) { //只有一个头结点的环
                head = node;
                head.next = head;
            } else {
                //node插在尾部，
                temp.next = node;
                node.next = head;
            }
            temp = node; //3
        }
    }

    void showCircle() {
        Node temp = head;
        while (true) {
            if (temp.next == head) {
                break;
            }
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }

    void count(int start, int k, int m) {


    }


}
