package com.benoitparmentier.factory;

import com.benoitparmentier.service.AccountService;
import org.springframework.beans.factory.FactoryBean;

public class AccountServiceFactoryBean implements FactoryBean<AccountService> {
    @Override
    public AccountService getObject() throws Exception {
        // Conditional logic – for example: selecting the right
        //  implementation or sub-class of AccountService to create
        return new AccountService();
    }

    @Override
    public Class<?> getObjectType() { return AccountService.class; }

    //  isSingleton defaults to returning true since Spring V5

    @Override
    public boolean isSingleton() {
        return false;
    }
}
