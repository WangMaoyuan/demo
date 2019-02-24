package com.example.demo.Model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MemberAccount {
  private int id;
  private String email;
  private String cellphone;
  private String password;
  private String address;

  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  public String getCellphone() {
    return cellphone;
  }
  public void setCellphone(String cellphone) {
    this.cellphone = cellphone;
  }

  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }

  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }

  public Map<String, String> payloadify() {
    Map<String, String> payload = new HashMap<String, String>();
    payload.put("id", Integer.toString(id));
    payload.put("email", email);
    payload.put("cellphone", cellphone);
    payload.put("address", address);
    return payload;
  }
}