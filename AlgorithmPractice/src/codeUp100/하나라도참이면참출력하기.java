package codeUp100;

import java.util.Scanner;

public class 하나라도참이면참출력하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean n1 = sc.nextBoolean();
		boolean n2 = sc.nextBoolean();
		System.out.println(n1 || n2);
	}

}
