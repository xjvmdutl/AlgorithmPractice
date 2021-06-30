package codeUp100;

import java.util.Scanner;

public class 정수1개입력받아분석하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		System.out.println(n1>0? "plus" : "minus");
		System.out.println(n1%2==0? "even" : "odd");
	}

}
