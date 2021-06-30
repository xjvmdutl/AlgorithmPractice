package codeUp100;

import java.util.Scanner;

public class 영문자1개입력받아10진수로출력하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println((int)s.charAt(0));
	}

}
