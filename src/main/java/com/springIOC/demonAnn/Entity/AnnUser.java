package com.springIOC.demonAnn.Entity;

import org.springframework.stereotype.Component;

/**
 * Created：Jeffrey
 * date   ：2020/7/1 17:28
 */

@Component
public class AnnUser {
    private String name;

    public AnnUser() {
    }

    public AnnUser(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
