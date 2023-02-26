package com.braindata.bankmanagement.client;

import java.util.Scanner;

import com.braindata.bankmanagement.service.Rbi;
import com.braindata.bankmanagement.serviceImpl.Sbi;

public class BankMain {
	static {
		System.out.println("--------Welcome User--------");
	}

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Rbi bank = new Sbi();

		while (true) {
			System.out.println("1.Create Account" + "\n2.Display Account Details" + "\n3.Deposite Money"
					+ "\n4.Withdrawal Money" + "\n5.Check Balance" + "\n6.Exit" + "\n7.Update");

			switch (sc.nextInt()) {
			case 1:
				bank.createAccount();
				break;
			case 2:
				bank.displayAllDetails();
				break;
			case 3:
				bank.depositMoney();
				break;
			case 4:
				bank.withdrawal();
				break;
			case 5:
				bank.balanceCheck();
				break;
			case 6:
				System.out.println("Thank You!!!");
				sc.close();
				System.exit(0);
//			case 7:
//				updateInfo();
//				break;

			default:
				System.out.println("Incorrect Choice!!!");
				break;
			}
		}

	}

//	public static void updateInfo()  {
//		
//		try (Scanner sc = new Scanner(System.in)) {
//			boolean flag = true;
//			while (flag) {
//				System.out.println("1.Update Account no" + "\n2.Update name" + "\n3.Update Age" + "\n4.Update gender"
//						+ "\n5.Update mobno" + "\n6.Update adharno" + "\n7.Exit" + "\n8.Create Table"
//								+ "\n9.Delete Record");
//				System.out.println("Enter choice");
//				switch (sc.nextInt()) {
//				case 1:
//					// update.updateAccountNo();
//					break;
//				case 2:
//					update.updateName();
//					break;
//				case 3:
//					update.updateAge();
//					break;
//				case 4:
//					update.updateGender();
//					break;
//				case 5:
//					update.updateMobileNo();
//					break;
//				case 6:
//					update.updateAdhaarNo();
//					break;
//				case 7:
//					flag = false;
//					break;
//				case 8:
//					try {
//						update.createTable();
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					break;
//				case 9:update.deleteRecord();
//				break;
//				default:
//					System.out.println("Incorrect choice!!!");
//					break;
//				}
//			}
//		}
//	}
}
