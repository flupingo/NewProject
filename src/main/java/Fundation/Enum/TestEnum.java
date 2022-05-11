package Fundation.Enum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created：Jeffrey
 * date   ：2021/6/28 15:02
 */
public class TestEnum {
    public static void main(String[] args) {
        String name = Enum001.Little.getName();
        System.out.println(name);
        String age = Enum001.getAgeByName("zhang");
        System.out.println(age);

        Map<String, Object> map = new HashMap();
        map.put("11", "211");
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey()+entry.getValue());
        }

    }
}
