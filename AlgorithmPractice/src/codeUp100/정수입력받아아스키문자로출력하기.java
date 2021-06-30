package codeUp100;

import java.util.Scanner;

public class 정수입력받아아스키문자로출력하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		System.out.println(Character.toChars(c));
	}

}
