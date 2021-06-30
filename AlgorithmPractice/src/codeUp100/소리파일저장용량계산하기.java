package codeUp100;

import java.util.Scanner;

public class 소리파일저장용량계산하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int s = sc.nextInt();
		long l = h * b * c * s;
		double d = l/Math.pow(2, 23);
		System.out.printf("%.2fMB",d);
	}

}
