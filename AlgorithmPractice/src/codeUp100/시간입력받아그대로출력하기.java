package codeUp100;

import java.util.Scanner;

public class 시간입력받아그대로출력하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		System.out.println(h+":"+m);
	}

}
