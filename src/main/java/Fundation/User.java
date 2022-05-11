package Fundation;

import java.io.Serializable;

/**
 * Created：Jeffrey
 * date   ：2020/6/24 10:39
 */
public class User implements Serializable, Cloneable {
    String name;
    int age;

    public User(String name) {
        this.name = name;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    void add() {

    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
