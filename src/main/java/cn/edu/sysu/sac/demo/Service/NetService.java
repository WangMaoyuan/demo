package cn.edu.sysu.sac.demo.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.edu.sysu.sac.demo.Bean.ResBody;

@Repository
public class NetService {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  ResBody resBody;

  @Autowired
  ObjectMapper objectMapper;

  public ResBody resSuccess() {
    ResBody resBody = new ResBody();
    resBody.setCode(200);
    return resBody;
  }
  public ResBody resSuccess(Object payload) {
    ResBody resBody = new ResBody();
    resBody.setCode(200);
    // BeanInfo info = Introspector.getBeanInfo(payload.getClass());
    Map<String, String> m = new HashMap<String, String>();
    m.put("0", payload.toString());
    resBody.setPayload(Arrays.asList(m));
    return resBody;
  }
  public ResBody resSuccess(Map<String, String> payload) {
    ResBody resBody = new ResBody();
    resBody.setCode(200);
    resBody.setPayload(Arrays.asList(payload));
    return resBody;
  }
  public ResBody resSuccess(List<Map<String, String>> payload) {
    ResBody resBody = new ResBody();
    resBody.setCode(200);
    resBody.setPayload(payload);
    return resBody;
  }

  public ResBody resFail (String error) {
    ResBody resBody = new ResBody();
    resBody.setCode(400);
    resBody.setError(error);
    logger.warn(error);
    return resBody;
  }

  public ResBody resError (String error) {
    ResBody resBody = new ResBody();
    resBody.setError(error);
    logger.error(error);
    return resBody;
  }
}