package com.ecjtu.controller;

import com.ecjtu.entity.Account;
import com.ecjtu.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program springboot-jdbc
 * @description:
 * @author: xiexiang
 * @create: 2018/10/12 16:15
 */
@RestController
@RequestMapping("/account/")
public class AccountController {
      @Autowired
      private AccountService accountService;

      @PostMapping("list")
      public List<Account> getAccounts() {
            return accountService.findAllAccount();
      }

      @RequestMapping(value = "/{id}", method = RequestMethod.GET)
      public Account getAccountById(@PathVariable("id") int id) {
            return accountService.findAccountById(id);
      }

      @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
      public String updateAccount(int id, String name, double money) {
            Account account = new Account();
            account.setMoney(money);
            account.setName(name);
            account.setId(id);
            int t = accountService.update(account);
            if (t == 1) {
                  return account.toString();
            } else {
                  return "更新失败";
            }
      }

      @PostMapping("add")
      public String addAccount(String name, double money) {

            Account account = new Account();
            account.setName(name);
            account.setMoney(money);
            int t = accountService.add(account);

            return null;
      }

      @PostMapping("deldete")
      public String deleteById(int id) {
            int t = accountService.deldete(id);
            if (t == 1) {
                  return "success";

            } else {
                  return "fail";
            }
      }

      @RequestMapping("do")
      public String hello() {
            return "hello";
      }
}
