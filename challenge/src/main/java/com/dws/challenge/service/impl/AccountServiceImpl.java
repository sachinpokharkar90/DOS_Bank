package com.dws.challenge.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dws.challenge.domain.Account;
import com.dws.challenge.dto.TransferRequest;
import com.dws.challenge.repositories.AccountRepository;
import com.dws.challenge.service.AccountService;
import com.dws.challenge.service.NotificationService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accRepo;
	
	@Autowired
	NotificationService notificationService;

	@Override
	public void transfer(TransferRequest request) {

		if (request.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
			throw new IllegalArgumentException("Transfer amount must be positive");
		}

		Account from = accRepo.findById(request.getAccFrom())
				.orElseThrow(() -> new RuntimeException("Sender account not found"));
		Account to = accRepo.findById(request.getAccTo())
				.orElseThrow(() -> new RuntimeException("Receiver account not found"));

		if (from.getBalance().compareTo(request.getAmount()) < 0) {
			throw new IllegalStateException("Insufficient funds in sender account");
		}
		
		from.setBalance(from.getBalance().subtract(request.getAmount()));
        to.setBalance(to.getBalance().add(request.getAmount()));

        accRepo.save(from);
        accRepo.save(to);
        
        notificationService.sendNotification(from.getId(), "Your account has been debited by " + request.getAmount() + " for the transfer.");
        notificationService.sendNotification(to.getId(), "Your account has been credited with " + request.getAmount() + " from the transfer.");

	}

	@Override
	public Account addAccount(String owner, BigDecimal balance) {
		Account account = new Account();
		account.setOwner(owner);
		account.setBalance(balance);
		return accRepo.save(account);
	}

	public Account getAccount(Long id) {
		return accRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Account not found"));
	}

	@Override
	public List<Account> getAllAccount() {
		return accRepo.findAll();
	}

}
