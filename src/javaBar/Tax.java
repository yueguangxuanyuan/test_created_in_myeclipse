package javaBar;

import java.util.Scanner;

public class Tax {
	private static Scanner scan;

	public static void main(String[] args) {
		int income = 0;              //��¼��������
		char incomeRange = 'a';     //��־����ˮƽ
		double tax;
		Scanner scan = new Scanner(System.in);
		System.out.print("������һ�����룺");
		while (scan.hasNextInt()) {
			income = scan.nextInt();
			//�ж�����ˮƽ
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
		
		
//		�Ҿ�����׼����while ��ͼ��Ϊ�˷�ֹ�������   �ĳ�����Ӧ�û�Ƚ��������ɣ� Ҳ����΢����һЩ�쳣����
//		while(true){
//			try{
//				income = Integer.parseInt(scan.next());
//				//�ж�����ˮƽ
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
//				System.out.println("�������ȷ����");
//			}
//		}
		
		
		switch (incomeRange) {
		case 'a': {
			tax = income * 0.03;
			System.out.println("Ӧ��˰��" + "Ϊ" + tax);
			break;
		}
		case 'b': {
			tax = (income - 1500) * 0.1 + 105;
			System.out.println("Ӧ��˰��" + "Ϊ" + tax);
			break;
		}
		case 'c': {
			tax = (income - 4500) * 0.2 + 555;
			System.out.println("Ӧ��˰��" + "Ϊ" + tax);
			break;
		}
		case 'd': {
			tax = (income - 9000) * 0.25 + 1005;
			System.out.println("Ӧ��˰��" + "Ϊ" + tax);
			break;
		}
		case 'e': {
			tax = (income - 35000) * 0.3 + 2755;
			System.out.println("Ӧ��˰��" + "Ϊ" + tax);
			break;
		}
		case 'f': {
			tax = (income - 55000) * 0.35 + 5505;
			System.out.println("Ӧ��˰��" + "Ϊ" + tax);
			break;
		}

		case 'g': {
			tax = (income - 80000) * 0.45 + 13505;
			System.out.println("Ӧ��˰��" + "Ϊ" + tax);
			break;
		}
		default: {
			System.out.println("������һ�����룺");
		}
		}
	}
}