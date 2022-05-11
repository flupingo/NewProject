package com.Arithmetic;

/**
 * Created：Jeffrey
 * date   ：2021/8/6 14:06
 */
public class Node {
    Node pre;
    Node next;
    int no;
    String name;
    Object value;

    public Node(int no, String name, Object value) {
        this.no = no;
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
