package com.kob.backend.Controller.pk;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pk/")  //指定父目录
public class IndexController {

    @RequestMapping("index/")
    public String index()
    {
        return "pk/index.html";
    }
}
