package codeUp100;

import java.util.Scanner;

public class 연월일입력받아그대로출력하기 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int year = sc.nextInt();
		int month = sc.nextInt();
		int day = sc.nextInt();
		System.out.println(year + "."+month+"."+day);
		
	}

}
