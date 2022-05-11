package com.Redis.Thread;

import com.Redis.Service.Business;

/**
 * Created：Jeffrey
 * date   ：2020/7/18 17:32
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        Business business=new Business();
        while (true){
            business.print();
        }
    }
}
