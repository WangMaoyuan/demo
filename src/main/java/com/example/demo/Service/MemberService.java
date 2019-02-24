package com.example.demo.Service;

import java.util.List;

import com.example.demo.Bean.DataException;
import com.example.demo.Dao.MemberDao;
import com.example.demo.Model.MemberAccount;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
  // private Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  MemberDao memberDao;

  public void addMember(MemberAccount memberAccount) {
    memberDao.addMember(memberAccount);
  }

  public MemberAccount checkMemberById(int id) throws DataException {
    List<MemberAccount> accounts = memberDao.getMember(id);
    if(accounts.isEmpty()) throw new DataException("NO_DATA");
    else return accounts.get(0);
  }

  public List<MemberAccount> checkMemberAccounts() {
    List<MemberAccount> accounts = memberDao.getMembers();
    return accounts;
  }

  public Boolean checkAuth(int id, String pass) throws DataException {
    List<MemberAccount> accounts = memberDao.getMember(id);
    if (accounts.isEmpty()) throw new DataException("NO_USER");
    else if (accounts.get(0).getPassword().equals(pass)) return true;
    else return false;
  }
}