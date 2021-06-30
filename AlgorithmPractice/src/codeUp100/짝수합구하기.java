package codeUp100;

import java.util.Scanner;

public class 짝수합구하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		for(int i = 2 ; i<=n;i+=2) {
			sum += i;
		}
		System.out.println(sum);
	}

}
