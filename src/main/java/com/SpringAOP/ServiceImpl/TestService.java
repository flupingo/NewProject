package com.SpringAOP.ServiceImpl;

import org.springframework.stereotype.Service;

/**
 * Created：Jeffrey
 * date   ：2021/6/6 15:42
 */
@Service
public class TestService {
    public void start() {
        System.out.println("start");
    }

    public void action() {
        System.out.println("action");
    }
}
