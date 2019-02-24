package com.example.demo.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.example.demo.Model.MemberAccount;

@Repository
public class MemberDao {
  @Autowired
  private JdbcTemplate jdbc;

  public void addMember(MemberAccount memberAccount) {
    System.out.println("excute insert");
    String sql = "insert into member_account (password, email, address, cellphone, create_date) values (?, ?, ?, ?, NOW())";
    jdbc.update(sql, memberAccount.getPassword(), memberAccount.getEmail(), memberAccount.getAddress(), memberAccount.getCellphone());
  }

  public List<MemberAccount> getMember(int id) {
    String sql = "select * from member_account where id = ?";
    RowMapper<MemberAccount> rowMapper = new BeanPropertyRowMapper<MemberAccount>(MemberAccount.class);
    List<MemberAccount> accounts = jdbc.query(sql, rowMapper, id);
    return accounts;
  }

  public List<MemberAccount> getMembers() {
    String sql = "select * from member_account";
    RowMapper<MemberAccount> rowMapper = new BeanPropertyRowMapper<MemberAccount>(MemberAccount.class);
    List<MemberAccount> accounts = jdbc.query(sql, rowMapper);
    return accounts;
  }
}