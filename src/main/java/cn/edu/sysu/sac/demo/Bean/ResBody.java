package cn.edu.sysu.sac.demo.Bean;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class ResBody {
  public int code;
  public String error;
  public List<Map<String, String>> payload;

  public int getCode() {
    return code;
  }
  public void setCode(int code) {
    this.code = code;
  }

  public String getDescription() {
    return error;
  }
  public void setError(String error) {
    this.error = error;
  }

  public List<Map<String, String>> getPayload() {
    return payload;
  }
  public void setPayload(List<Map<String, String>> payload) {
    this.payload = payload;
  }

}