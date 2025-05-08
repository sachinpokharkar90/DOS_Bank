package com.dws.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dws.challenge.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
