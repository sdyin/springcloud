package com.sdyin.eurekaserver.demo;

import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: liuye
 * @Date: 2018/6/7 21:22
 */
public class DemoStringUtils {
  public static void main(String[] args) {
    String str = "a,b,c,d";
    //转成String数组
    String[] strings = StringUtils.commaDelimitedListToStringArray(str);
    //转成List
    List<String> lists = Arrays.asList(strings);
    System.out.println(lists);
  }
}
