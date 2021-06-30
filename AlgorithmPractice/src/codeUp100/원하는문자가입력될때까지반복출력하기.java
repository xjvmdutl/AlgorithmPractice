package codeUp100;

import java.util.Scanner;

public class 원하는문자가입력될때까지반복출력하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			char c = sc.next().charAt(0);
			System.out.println(c);
			if(c == 'q')
				break;
			
		}
	}

}
