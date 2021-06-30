package codeUp100;

import java.util.Scanner;

public class 언제까지더해야할까 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		int i;
		for( i =1;sum<n;++i) {
			sum +=i;
		}
		System.out.println(i-1);
		
		
	}

}
