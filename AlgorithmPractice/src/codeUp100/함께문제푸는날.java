package codeUp100;

import java.util.Scanner;

public class 함께문제푸는날 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int n3 = sc.nextInt();
		int n = gcd(n1,n2);
		n = gcd(n,n3);
		
		System.out.println((n1*n2*n3)/n);
		
	}
	public static int gcd(int x,int y) {
		if(y == 0) {
			return x;
		}else {
			return gcd(x,x%y);
		}
	}

}
