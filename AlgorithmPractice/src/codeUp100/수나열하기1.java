package codeUp100;

import java.util.Scanner;

public class 수나열하기1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int d = sc.nextInt();
		int n = sc.nextInt();
		for(int i =1;i<n;++i) {
			a+=d;
		}
		System.out.println(a);
	}

}
