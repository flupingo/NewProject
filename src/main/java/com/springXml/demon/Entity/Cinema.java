package com.springXml.demon.Entity;

import java.io.Serializable;

/**
 * Created：Jeffrey
 * date   ：2020/6/30 22:26
 */
public class Cinema implements Serializable {
    String cid;
    String name;
    String address;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
