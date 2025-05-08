package com.dws.challenge.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class TransferRequest {

	private Long accFrom;
	private Long accTo;
	private BigDecimal amount;
	
	

}
