package com.bankaccount;

public class BankAccountTest {

	public static void main(String[] args) {

		User shannon = new User("Shannon");
		User george = new User("George");

		shannon.depositMoney(500.00, "checking");
		shannon.depositMoney(1000.00, "savings");
		shannon.withdrawMoney(725.00, "savings");
		george.depositMoney(250.00, "savings");
		george.withdrawMoney(500.00, "ira");
		george.withdrawMoney(500.00, "savings");
		george.viewAccountBalances();
		shannon.viewAccountBalances();
		BankAccount.getTotalBalance();
	}

}
