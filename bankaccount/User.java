package com.bankaccount;

public class User {
	public String name;
	public BankAccount acct;

	public User(String name) {
		this.name = name;
		acct = new BankAccount();
	}

	public void depositMoney(Double amt, String type) {
		if (!type.toLowerCase().equals("checking") && !type.toLowerCase().equals("savings")) {
			System.out.println(String
					.format("Hello %s. Which account you'd like to deposit funds to? Checking or Savings?", this.name));
		} else {
			Double newBalance = 0.00;
			if (type.toLowerCase().equals("checking")) {
				this.acct.setCheckingBalance(amt, "deposit");
				newBalance = this.acct.getCheckingBalance();
			} else {
				this.acct.setSavingsBalance(amt, "deposit");
				newBalance = this.acct.getSavingsBalance();
			}
			System.out.println(String.format(
					"Your transaction is now complete. Your new %s account balance is $%,.2f. Thank you for your business, %s.",
					type.toLowerCase(), newBalance, this.name));
		}

	}

	public void withdrawMoney(Double amt, String type) {
		if (!type.toLowerCase().equals("checking") && !type.toLowerCase().equals("savings")) {
			System.out.println(String.format(
					"Hello %s. Which account would you like to withdraw funds from? Checking or Savings?", this.name));
		} else {
			Boolean hasMoney = checkBalance(amt, type);
			if (hasMoney == true) {
				Double newBalance = 0.00;
				if (type.toLowerCase().equals("checking")) {
					this.acct.setCheckingBalance(amt, "withdraw");
					newBalance = this.acct.getCheckingBalance();
				} else if (type.toLowerCase().equals("savings")) {
					this.acct.setSavingsBalance(amt, "withdraw");
					newBalance = this.acct.getCheckingBalance();
				}
				System.out.println(String.format(
						"Your transaction is now complete. Your new %s account balance is $%,.2f. Thank you for your business, %s.",
						type.toLowerCase(), newBalance, this.name));
			} else {
				System.out.println(String.format(
						"We're sorry %s, but you do not have enough money in your account for this transaction.",
						this.name));
			}
		}
	}

	public boolean checkBalance(Double amt, String type) {
		Boolean haveFunds = false;
		Double balance = 0.00;
		if (type.toLowerCase().equals("checking")) {
			balance = this.acct.getCheckingBalance();
		} else {
			balance = this.acct.getSavingsBalance();
		}
		if (balance >= amt) {
			haveFunds = true;
		}
		return haveFunds;
	}

	public void viewAccountBalances() {
		System.out.println(
				String.format("%s, your checking account balance is $%,.2f and your savings account balance is $%,.2f.",
						this.name, this.acct.getCheckingBalance(), this.acct.getSavingsBalance()));
	}
}
