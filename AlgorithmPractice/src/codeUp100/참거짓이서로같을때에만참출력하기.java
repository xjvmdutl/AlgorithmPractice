package codeUp100;

import java.util.Scanner;

public class 참거짓이서로같을때에만참출력하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean n1 = sc.nextBoolean();
		boolean n2 = sc.nextBoolean();
		System.out.println((n1&&n2) || (!n1 && !n2));
	}

}
