package javaBar;

import java.util.Scanner;

public class Tax {
	private static Scanner scan;

	public static void main(String[] args) {
		int income = 0;              //记录保存收入
		char incomeRange = 'a';     //标志收入水平
		double tax;
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入一个收入：");
		while (scan.hasNextInt()) {
			income = scan.nextInt();
			//判断收入水平
			if (income <= 1500) {
				incomeRange = 'a';
			} else if (income <= 4500) {
				incomeRange = 'b';
			} else if (income <= 9000) {
				incomeRange = 'c';
			} else if (income <= 35000) {
				incomeRange = 'd';
			} else if (income <= 55000) {
				incomeRange = 'e';
			} else if (income <= 80000) {
				incomeRange = 'f';
			} else {
				incomeRange = 'g';
			}
			break;
		}
		
		
//		我觉得你准备加while 意图是为了防止恶意输出   改成这样应该会比较容易理解吧， 也能稍微处理一些异常输入
//		while(true){
//			try{
//				income = Integer.parseInt(scan.next());
//				//判断收入水平
//				if (income <= 1500) {
//					incomeRange = 'a';
//				} else if (income <= 4500) {
//					incomeRange = 'b';
//				} else if (income <= 9000) {
//					incomeRange = 'c';
//				} else if (income <= 35000) {
//					incomeRange = 'd';
//				} else if (income <= 55000) {
//					incomeRange = 'e';
//				} else if (income <= 80000) {
//					incomeRange = 'f';
//				} else {
//					incomeRange = 'g';
//				}
//				break;
//			}catch(Exception e){
//				System.out.println("请采用正确输入");
//			}
//		}
		
		
		switch (incomeRange) {
		case 'a': {
			tax = income * 0.03;
			System.out.println("应纳税额" + "为" + tax);
			break;
		}
		case 'b': {
			tax = (income - 1500) * 0.1 + 105;
			System.out.println("应纳税额" + "为" + tax);
			break;
		}
		case 'c': {
			tax = (income - 4500) * 0.2 + 555;
			System.out.println("应纳税额" + "为" + tax);
			break;
		}
		case 'd': {
			tax = (income - 9000) * 0.25 + 1005;
			System.out.println("应纳税额" + "为" + tax);
			break;
		}
		case 'e': {
			tax = (income - 35000) * 0.3 + 2755;
			System.out.println("应纳税额" + "为" + tax);
			break;
		}
		case 'f': {
			tax = (income - 55000) * 0.35 + 5505;
			System.out.println("应纳税额" + "为" + tax);
			break;
		}

		case 'g': {
			tax = (income - 80000) * 0.45 + 13505;
			System.out.println("应纳税额" + "为" + tax);
			break;
		}
		default: {
			System.out.println("请输入一个收入：");
		}
		}
	}
}