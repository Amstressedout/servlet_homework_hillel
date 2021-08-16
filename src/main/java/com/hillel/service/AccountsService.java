package com.hillel.service;

import com.hillel.dto.AccountsDto;
import com.hillel.dao.AccountsDao;
import com.hillel.entity.Accounts;

import java.util.ArrayList;
import java.util.List;

public class AccountsService {
    private final AccountsDao accountDao;

    public AccountsService() {
        accountDao = new AccountsDao();
    }


    public List<AccountsDto> findAllAccounts() {
        List<Accounts> accounts = accountDao.findAllAccounts();
        List<AccountsDto> result = new ArrayList<>();

        for (Accounts account : accounts) {
            AccountsDto dto = new AccountsDto();
            dto.setId(account.getId());
            dto.setClientId(account.getClientId());
            dto.setNumber(account.getNumber());
            dto.setValue(account.getValue());
            result.add(dto);
        }
        return result;
    }
}