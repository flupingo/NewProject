package com.springXml.demon.Service;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created：Jeffrey
 * date   ：2020/7/1 16:52
 */
public class IOCComplexUserServiceImpl {
    String[] arr;
    List<String> list;
    Set<String> set;
    Map<String,Object> map;
    Properties properties;

    public void setArr(String[] arr) {
        this.arr = arr;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String[] getArr() {
        return arr;
    }

    public List<String> getList() {
        return list;
    }

    public Set<String> getSet() {
        return set;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public Properties getProperties() {
        return properties;
    }
}
