package com.sdyin.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Author: liuye
 * @Date: 2018/6/25 17:57
 */
@RestController("/controller")
public class ServiceHiController {

  private static final Logger LOG = Logger.getLogger(ServiceHiController.class.getName());

  @Autowired
  private RestTemplate restTemplate;

  @Bean
  public RestTemplate getRestTemplate(){
    return new RestTemplate();
  }

  @RequestMapping("/hi")
  public String callHome(){
    LOG.log(Level.INFO, "calling trace service-hi  ");
    return restTemplate.getForObject("http://localhost:8763/controller/miya", String.class);
  }
  @RequestMapping("/info")
  public String info(){
    LOG.log(Level.INFO, "calling trace service-hi ");

    return "i'm service-hi";

  }


}
