package axysis.controller;

import axysis.aonnotation.DoneTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring
 * @description: 测试controller
 * @author: shaw
 * @create: 2020-07-15 14:53
 **/
@RestController
public class IndexController {

    @GetMapping("/index")
    @DoneTime(param = "IndexController")
    public String index(){
        System.out.println("方法执行");
        return "hello this is aspect method";
    }

    @GetMapping("/index2")
    public String index2(){
        System.out.println("方法2执行");
        return "hello this is aspect method";
    }
}

