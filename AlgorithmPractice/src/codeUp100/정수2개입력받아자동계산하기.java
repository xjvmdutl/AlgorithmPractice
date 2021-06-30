package codeUp100;

import java.util.Scanner;

public class 정수2개입력받아자동계산하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		System.out.println(n1+n2);
		System.out.println(n1-n2);
		System.out.println(n1*n2);
		System.out.println(n1/n2);
		System.out.println(n1%n2);
		System.out.printf("%.2f",(double)n1/n2);
	}

}
