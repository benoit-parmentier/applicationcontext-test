package com.benoitparmentier.service;

public class CustomerService {

    private AccountService accountService;

    public CustomerService(AccountService accountService){
        this.accountService = accountService;
    }

    public void test(){
        System.out.println("accountService#ID : " + accountService);
    }
}
