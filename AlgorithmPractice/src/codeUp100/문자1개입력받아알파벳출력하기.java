package codeUp100;

import java.util.Scanner;

public class 문자1개입력받아알파벳출력하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char c = sc.next().charAt(0);
		for(char i = 'a' ; i<=c;++i) {
			System.out.println(i);
		}
	}

}
