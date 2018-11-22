package com.cvt.rest1.springbootrest1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello-world")
    public String gethelloWorld(){
        return "Hello World";
    }

    @GetMapping(path ="/hello-world-bean")
    public HelloWorldBean getHelloWorldBean(){
        return new HelloWorldBean("Hello World Bean");
    }

    @GetMapping(path ="/hello-world/path-variable/{name}")
    public HelloWorldBean getHelloWorldBean(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World Bean, %s",name));
    }

}
