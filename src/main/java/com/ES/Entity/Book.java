package com.ES.Entity;

/**
 * Created：Jeffrey
 * date   ：2020/11/24 14:31
 */
public class Book {
    String name;
    String age;
    String describe;
    String price;

    public Book(String name, String age, String describe, String price) {
        this.name = name;
        this.age = age;
        this.describe = describe;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
