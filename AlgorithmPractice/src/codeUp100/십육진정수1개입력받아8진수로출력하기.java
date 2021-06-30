package codeUp100;

import java.util.Scanner;

public class 십육진정수1개입력받아8진수로출력하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=  new Scanner(System.in);
		String s =sc.next();
		System.out.printf("%X",Integer.parseInt(s,8));
	}

}
