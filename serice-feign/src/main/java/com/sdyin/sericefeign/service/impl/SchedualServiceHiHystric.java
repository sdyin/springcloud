package com.sdyin.sericefeign.service.impl;

import com.sdyin.sericefeign.service.SchedualServiceHi;
import org.springframework.stereotype.Component;

/**
 * @Author: liuye
 * @Date: 2018/6/25 10:52
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {

  @Override
  public String sayHiFromClientOne(String name) {
    return "sorry "+name;
  }
}
