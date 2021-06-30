package codeUp100;

import java.util.Scanner;

public class 정수3개입력받아가장작은수출력하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int n3 = sc.nextInt();
		System.out.println((n1 > n2? n2:n1) < n3 ?(n1 > n2? n2:n1) :n3);
	}

}
