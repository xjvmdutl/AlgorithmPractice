package codeUp100;

import java.util.Scanner;

public class 두정수입력받아큰수출력하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		System.out.println(n1>n2?n1:n2);
	}

}
