package com.sdyin.serviceribbon.controller;

import com.sdyin.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: liuye
 * @Date: 2018/6/23 15:56
 */
@RestController
public class HelloController {

  @Autowired
  HelloService helloService;

  @RequestMapping(value = "/hi")
  public String hi(@RequestParam String name){
    return helloService.hiService(name);
  }

}
