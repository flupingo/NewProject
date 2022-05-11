package Fundation.JSON;

import Fundation.User;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;

import java.util.List;
import java.util.UUID;

/**
 * Created：Jeffrey
 * date   ：2021/5/21 21:21
 */
public class TestJSON {
    public static void main(String[] args) {
        //随机ID生成
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();

        //JSON
        testJson();
    }

    static void testJson() {
        //=====value可以是Json对象 /String /基本数据 /bool等=====

        //1.JSON   {key:value}
        String obj = "{\n" +
                "\t\t\t\t\t\t\t\"term\": {\n" +
                "\t\t\t\t\t\t\t\t\"dept_mid_cd\": \"10\"\n" +
                "\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t}";
        JSONObject jsonObject = JSONObject.parseObject(obj);

        jsonObject.put("key", "valule");
        System.out.println(jsonObject.get("key"));
        System.out.println(jsonObject.get("term"));


        User user=new User();
        user.setAge(20);
        user.setName("zhang");
        String string = JSONObject.toJSONString(null);
        System.out.println(string);

        //2.JSON数组格式的字符串！！！   [value,value,value]
        String array = "[{\n" +
                "\t\t\t\t\t\t\t\"term\": {\n" +
                "\t\t\t\t\t\t\t\t\"dept_mid_cd\": \"10\"\n" +
                "\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\"term\": {\n" +
                "\t\t\t\t\t\t\t\t\"statis_date\": \"201807\"\n" +
                "\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t},\"123\"]";

        JSONArray jsonArray = JSONArray.parseArray(array);
        for (int i = 0; i < jsonArray.size(); i++) {
            if (jsonArray.get(i) instanceof JSONObject) {

                //确定是JSON类型value时使用！！！
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                System.out.println(jsonObject1.getString("term")); //根据key获取value
            } else {
                System.out.println(jsonArray.getString(i));
            }
        }

        //JSONArray转成指定数据类型List

        String list01 = "[{\n" +
                "\t\t\t\t\t\t\t\"term\": {\n" +
                "\t\t\t\t\t\t\t\t\"dept_mid_cd\": \"10\"\n" +
                "\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\"term\": {\n" +
                "\t\t\t\t\t\t\t\t\"statis_date\": \"201807\"\n" +
                "\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t}]";

        //2.1 转成JSONObject组成的List
        List<JSONObject> list = JSONArray.parseArray(list01, JSONObject.class);
        System.out.println(list);



        //            JSONArray jsonArray = new JSONArray();
//            jsonArray.add("1");
////            jsonArray.add(jsonObject);
//            List list = new ArrayList<>();
//            list.add(1);
//            list.add(2);
//            String list1 = list.toString();
//            JSONArray jsonArray1 = JSONArray.parseArray(list1); //字符串数组转成jsonArray
//
//            Map map = new HashMap();
//            map.put(1, 2);
//            map.put(2, 3);
//            String map1 = map.toString();
//
//
//            JSONObject jsonObject1 = JSONObject.parseObject("{}");
    }


}
