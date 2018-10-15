package com.ecjtu.dao.impl;

import com.ecjtu.dao.AccountDao;
import com.ecjtu.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program springboot-jdbc
 * @description:
 * @author: xiexiang
 * @create: 2018/10/12 15:52
 */
@Repository
public class AccountDaoImpl implements AccountDao {
      @Autowired
      private JdbcTemplate jdbcTemplate;

      @Override
      public int add(Account account) {
            return jdbcTemplate.update("insert into Account(name,money) values (?,?)", account.getName(), account.getMoney());
      }

      @Override
      public int update(Account account) {
            return jdbcTemplate.update("update Account set name =?,monney=? where id=?", account.getName(), account.getMoney());
      }

      @Override
      public int delete(int id) {
            return jdbcTemplate.update("delete from account where id=?", id);
      }

      @Override
      public Account findAccountById(int id) {
            List<Account> list = jdbcTemplate.query("select * from Account where id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Account.class));
            if (list != null && list.size() > 0) {
                  Account account = list.get(0);
                  return account;

            } else {
                  return null;
            }

      }

      @Override
      public List<Account> findAllAccount() {
            List<Account> list = jdbcTemplate.query("select *from Account", new Object[]{}, new BeanPropertyRowMapper<>(Account.class));
            if (list != null && list.size() > 0) {

                  return list;
            } else {

                  return null;
            }
      }
}
