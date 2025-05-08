package com.dws.challenge.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dws.challenge.domain.Account;
import com.dws.challenge.dto.TransferRequest;

@Service
public interface AccountService {

	void transfer(TransferRequest request);

	Account addAccount(String owner, BigDecimal balance);

	Account getAccount(Long id);

	List<Account> getAllAccount();

}
