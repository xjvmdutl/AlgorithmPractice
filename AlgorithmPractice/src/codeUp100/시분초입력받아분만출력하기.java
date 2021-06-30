package codeUp100;

import java.util.Scanner;

public class 시분초입력받아분만출력하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str =sc.nextLine();
		String[] times = str.split(":");
		System.out.println(times[1]);
	}

}
