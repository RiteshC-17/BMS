package com.braindata.bankmanagement.serviceImpl;

import java.util.Scanner;

import com.braindata.bankmanagement.model.Account;
import com.braindata.bankmanagement.service.Rbi;

public class Sbi implements Rbi {
	Scanner sc = new Scanner(System.in);

	Account ac = new Account();
	long m;
	static long mno;
	boolean flag = true;

	@Override
	public void createAccount() {
		// TODO Auto-generated method stub

		// Account no
		flag = true;
		while (flag) {
			System.out.println("Enter account no");
			long accno = sc.nextLong();
			long temp = accno;
			int count = 0;
			while (temp > 0) {
				temp = (temp / 10);
				count++;
			}
			if (count == 12) {
				ac.setAdharNo(accno);
				flag = false;
			} else
				System.out.println("Account no is invalid : " + accno);

			ac.setAccNo(accno);
		}
		// name
		System.out.println("Enter name");
		String name = sc.next() + sc.nextLine();
		ac.setName(name);

		// mobile operation

		flag = true;
		while (flag) {
			String mobno = null;
			try {
				System.out.println("Enter mobile no");
				mobno = sc.next();
				mno = Long.parseLong(mobno);
				int count = 0;
				long temp = mno;
				while (temp > 0) {
					temp = (temp / 10);
					if (temp == 7 || temp == 8 || temp == 9)
						m = temp;
					count++;
				}

				if (m == 7 || m == 8 || m == 9 && count == 10) {
					ac.setMobNo(mno);
					flag = false;
					break;
				} else {
					System.out.println("mobile no is not valid :" + mno);
				}
			} catch (NumberFormatException e) {
				System.out.println("cant use alphabets : " + mobno);
			}

			// System.out.println("mno"+mno);

		}
		// Adhaar
		flag = true;
		while (flag) {
			System.out.println("Enter adhar no");
			long adharno = sc.nextLong();
			long temp = adharno;
			int count1 = 0;
			while (temp > 0) {
				temp = (temp / 10);
				count1++;
			}
			if (count1 == 12) {
				ac.setAdharNo(adharno);
				flag = false;
			} else
				System.out.println("Adhar no is invalid : " + adharno);
		}

		// Gender
		flag = true;
		while (flag) {
			System.out.println("Enter gender");
			String gender = sc.next();
			if (gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female")) {
				ac.setGender(gender);
				flag = false;
			} else
				System.out.println("Your input is wrong...");
		}

		// Age

		flag = true;
		while (flag) {
			System.out.println("Enter age");
			int age = sc.nextInt();
			if (age >= 18 && age < 99) {
				ac.setAge(age);
				flag = false;
			} else
				System.out.println("Sorry!!! You can't create account,Beacause you are below 18");
		}
		// balance min 1000 operation
		flag = true;
		while (flag) {
			System.out.println("Enter balance");
			double balance = sc.nextDouble();
			if (balance >= 1000) {
				ac.setBalance(balance);
				flag = false;
			}

			else {
				System.out.println("You have to keep minimum 1000 Rupees in your account");
			}
		}
	}

	@Override
	public void displayAllDetails() {

		if (ac.getAccNo() == 0) {
			System.out.println("Please create account first!!!");
		} else {
			System.out.println("Account no : " + ac.getAccNo());
			System.out.println("Name : " + ac.getName());
			System.out.println("Mobile no : " + ac.getMobNo());
			System.out.println("Adhar no : " + ac.getAdharNo());
			System.out.println("Gender : " + ac.getGender());
			System.out.println("Age : " + ac.getAge());
			System.out.println("Balance : " + ac.getBalance());
		}
	}

	public static double deposit;

	@Override
	public void depositMoney() {
		// TODO Auto-generated method stub
		// deposit money
		flag = true;
		while (flag) {
			System.out.println("How much money you want to deposit?");
			int bal = sc.nextInt();
			if (bal >= 500) {
				deposit = ac.getBalance() + bal;
				ac.setBalance(deposit);
				flag = false;
			} else {
				System.out.println("You can deposit at leaste 500 rupees or more");
			}
		}
	}

	@Override
	public void withdrawal() {
		// TODO Auto-generated method stub
		// Withdraw operation
		boolean flag = true;
		while (flag) {
			System.out.println("How much money you want to withdraw?");
			double withdraw = sc.nextDouble();
			if (withdraw <= (ac.getBalance() - 1000) && withdraw >= 500) {
				deposit = ac.getBalance() - withdraw;
				ac.setBalance(deposit);
				flag = false;
			} else if (withdraw < 500) {
				System.out.println("You have to withdraw at-least RS500...");
			} else {
				flag = true;
				while (flag) {
					System.out.println("Sorry!!!You don't have enough balance...");
					System.out.println("Press 1 for continue or Press 2 for back");
					int s = sc.nextInt();
					switch (s) {
					case 1:
						flag = false;
						break;
					case 2:
						return;
					default:
						System.out.println("Incorrect choice!!!");
					}
				}
				flag = true;
			}
		}
	}

	@Override
	public void balanceCheck() {
		// TODO Auto-generated method stub
		ac.getBalance();
	}
}