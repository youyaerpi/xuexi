package com.ecjtu.service.impl;

import com.ecjtu.dao.AccountDao;
import com.ecjtu.entity.Account;
import com.ecjtu.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program springboot-jdbc
 * @description:
 * @author: xiexiang
 * @create: 2018/10/12 16:12
 */
@Service
public class AccountServiceImpl implements AccountService {

      @Autowired
      private AccountDao accountDao;

      @Override
      public int add(Account account) {
            return accountDao.add(account);
      }

      @Override
      public int update(Account account) {
            return accountDao.update(account);
      }

      @Override
      public int deldete(int id) {
            return accountDao.delete(id);
      }

      @Override
      public Account findAccountById(int id) {
            return accountDao.findAccountById(id);
      }

      @Override
      public List<Account> findAllAccount() {
            return accountDao.findAllAccount();
      }
}
