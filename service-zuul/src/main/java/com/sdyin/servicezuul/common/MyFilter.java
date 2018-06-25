package com.sdyin.servicezuul.common;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author: liuye
 * @Date: 2018/6/25 12:29
 */
@Component
public class MyFilter extends ZuulFilter {

  private static Logger log = LoggerFactory.getLogger(MyFilter.class);

  @Override
  public String filterType() {
    return "pre";
  }

  @Override
  public int filterOrder() {
    return 0;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() throws ZuulException {
    RequestContext ctx = RequestContext.getCurrentContext();
    HttpServletRequest request = ctx.getRequest();
    log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
    String accessToken = request.getParameter("token");
    if(accessToken == null){
      log.warn("token is null");
      ctx.setSendZuulResponse(false);
      ctx.setResponseStatusCode(401);
      try {
        ctx.getResponse().getWriter().write("token is Empty");
      } catch (IOException e) {
        log.error("异常:" + e );
        return null;
      }
    }
    log.info("ok");
    return null;
  }
}
