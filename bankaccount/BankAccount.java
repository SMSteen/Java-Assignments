package com.bankaccount;

import java.util.Random;

public class BankAccount {
	private String accountNumber;
	private Double checkingBalance = 0.00; // initialized account balance to $0.00
	private Double savingsBalance = 0.00; // initialized account balance to $0.00

	private static int numAccts; // auto initializes at 0
	private static Double totalMoney = 0.00;

	public BankAccount() {
		this.setAccountNumber(createAccountNumber());
		numAccts++;
	}

	public static Integer getNumAccts() {
		return numAccts;
	}

	public static void getTotalBalance() {
		System.out.println(
				String.format("The bank has a total of $%,.2f deposited across %d accounts.", totalMoney, numAccts));
	}

	public Double getSavingsBalance() {
		return savingsBalance;
	}

	public void setSavingsBalance(Double amt, String method) {
		if (method.equals("deposit")) {
			this.savingsBalance += amt;
			totalMoney += amt;
		} else {
			this.savingsBalance -= amt;
			totalMoney -= amt;
		}
	}

	public Double getCheckingBalance() {
		return checkingBalance;
	}

	public void setCheckingBalance(Double amt, String method) {
		if (method.equals("deposit")) {
			this.checkingBalance += amt;
			totalMoney += amt;
		} else {
			this.checkingBalance -= amt;
			totalMoney -= amt;
		}
	}

	private String createAccountNumber() {
		Random r = new Random();
		// using _ for readability; adding 1_000_000_000 to ensure result is positive
		int acctNumber = r.nextInt(1_000_000_000) + 1_000_000_000;
		// System.out.println(acctNumber);
		return String.valueOf(acctNumber);
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	private void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

}
