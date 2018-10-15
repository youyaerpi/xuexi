package com.ecjtu.service;

import com.ecjtu.entity.Account;

import java.util.List;

/**
 * @program springboot-jdbc
 * @description:
 * @author: xiexiang
 * @create: 2018/10/12 16:08
 */
public interface AccountService {
      /**
       * @param account
       * @return
       */
      int add(Account account);

      /**
       * @param account
       * @return
       */
      int update(Account account);

      /**
       * @param id
       * @return
       */
      int deldete(int id);

      /**
       * @param id
       * @return
       */
      Account findAccountById(int id);

      /**
       * @return
       */
      List<Account> findAllAccount();

}
