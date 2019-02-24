package com.example.demo.Controller;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.MemberService;
import com.example.demo.Service.NetService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.example.demo.Bean.DataException;
import com.example.demo.Bean.ResBody;
import com.example.demo.Model.MemberAccount;

@RestController
@RequestMapping("/api/member")
public class MemberController{
  // private Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  NetService netService;
  @Autowired
  MemberService memberService;

  // Before Login
  @RequestMapping(value = "/add", method = RequestMethod.GET)
  public ResBody add() {
    MemberAccount memberAccount = new MemberAccount();
    memberAccount.setPassword("12345678");
    memberAccount.setEmail("test@mail2.sysu.edu.cn");
    memberAccount.setCellphone("15360042103");
    memberAccount.setAddress("广州市");
    memberService.addMember(memberAccount);
    return netService.resSuccess();
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public ResBody login(@RequestParam(value = "id", required = true) int id,
      @RequestParam(value = "password", required = true) String password, HttpSession session) {
    if (session.getAttribute("uid") != null) return netService.resFail("DUP_LOGIN");
    else {
      try {
        Boolean checkAuth = memberService.checkAuth(id, password);
        if (checkAuth) {
          session.setAttribute("uid", id);
          return netService.resSuccess();
        } else {
          return netService.resFail("WRONG_PASS");
        }
      } catch (DataException e) {
        return netService.resFail(e.getMessage());
      }
    }
  }
  
  // After Login
  @RequestMapping(value = "/account", method = RequestMethod.GET)
  public ResBody getListById(@RequestParam(value="id", required=true) int id, HttpSession session) {
    MemberAccount account;
    try {
      account = memberService.checkMemberById(id);
    } catch (DataException e) {
      return netService.resFail(e.getMessage());
    }
    return netService.resSuccess(account.payloadify());
  }

  @RequestMapping(value = "/accountList", method = RequestMethod.GET)
  public ResBody getList() {
    List<MemberAccount> accounts = memberService.checkMemberAccounts();
    List<Map<String, String>> payload = new ArrayList<Map<String, String>>();
    for (int i = 0; i < accounts.size(); i ++) {
      payload.add(accounts.get(i).payloadify());
    }
    return netService.resSuccess(payload);
  }
}