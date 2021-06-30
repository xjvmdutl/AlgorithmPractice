package codeUp100;

import java.util.Scanner;

public class 팔진정수1개입력받아10진수로출력하기 {

	public static void main(String[] args) {
		Scanner sc=  new Scanner(System.in);
		String s =sc.next();
		System.out.println(Integer.parseInt(s,8));
		
	}

}
