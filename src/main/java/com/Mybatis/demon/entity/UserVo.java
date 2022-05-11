package com.Mybatis.demon.entity;

/**
 * Created：Jeffrey
 * date   ：2020/7/7 21:41
 */
public class UserVo {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserVo(User user) {
        this.user = user;
    }
}
