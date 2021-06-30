package codeUp100;

import java.util.Scanner;

public class 실수1개입력받아부분별로출력하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(str.split("\\.")[0]);
		System.out.println(str.split("\\.")[1]);
	}

}
