package com.dws.challenge.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dws.challenge.domain.Account;
import com.dws.challenge.dto.TransferRequest;
import com.dws.challenge.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	private final AccountService accountService;

	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	@PostMapping("/transfer")
	public ResponseEntity<String> transfer(@RequestBody TransferRequest request) {
		accountService.transfer(request);
		return ResponseEntity.ok("Transfer successful");
	}

	@PostMapping("/save")
	public ResponseEntity<Account> createAccount(@RequestParam("owner") String owner,
			@RequestParam("balance") BigDecimal balance) {
		return ResponseEntity.ok(accountService.addAccount(owner, balance));
	}

	@GetMapping("/getAccount/{id}")
	public ResponseEntity<Account> getAccount(@PathVariable("id") Long id) {
		return ResponseEntity.ok(accountService.getAccount(id));
	}

	@GetMapping("/getAllAccount")
	public ResponseEntity<List<Account>> getAllAccount() {
		return ResponseEntity.ok(accountService.getAllAccount());
	}

}
