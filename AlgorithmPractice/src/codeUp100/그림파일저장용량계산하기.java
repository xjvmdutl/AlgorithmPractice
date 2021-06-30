package codeUp100;

import java.util.Scanner;

public class 그림파일저장용량계산하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int h = sc.nextInt();
		int b = sc.nextInt();
		long l = w * h * b;
		double d = l / Math.pow(2, 23);
		System.out.printf("%.2f MB",d);
	}

}
