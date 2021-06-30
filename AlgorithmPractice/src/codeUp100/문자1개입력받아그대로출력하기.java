package codeUp100;

import java.util.Scanner;

public class 문자1개입력받아그대로출력하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char c = sc.next().charAt(0);
		System.out.println(c);
	}

}
