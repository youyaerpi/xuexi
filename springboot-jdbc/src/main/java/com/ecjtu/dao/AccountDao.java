package com.ecjtu.dao;

import com.ecjtu.entity.Account;

import java.util.List;

/**
 * dao接口
 */
public interface AccountDao {

      int add(Account account);

      int update(Account account);

      int delete(int id);

      Account findAccountById(int id);

      List<Account> findAllAccount();
}
