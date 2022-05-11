package com.SpringBoot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created：Jeffrey
 * date   ：2020/8/2 23:13
 */
@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String sayHello() {
        return "Hello SpringBoot!";
    }


}
