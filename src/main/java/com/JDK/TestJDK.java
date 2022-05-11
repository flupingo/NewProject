package com.JDK;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.redisson.misc.Hash;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created：Jeffrey
 * date   ：2022/2/28 20:20
 */
public class TestJDK {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User("zhang", 2));
        list.add(new User("zhang", 20));
        list.add(new User("wang", 3));
        List<Integer> list1 = list.stream().filter(item -> item.name == "zhang")
                .map(item -> item.age)
                .collect(Collectors.toList());

        System.out.println(list1);
        Integer[]integers=new Integer[]{1,2};
//        Arrays.stream(integers).filter(null).;
//        list.forEach();


      List list2=  list.stream().filter(null).collect(Collectors.toList());

      new ArrayList<>().stream().filter(null).map(null).forEach(null);


    }

    @Data
    @AllArgsConstructor
    public static class User {
        String name;
        Integer age;
    }

}
