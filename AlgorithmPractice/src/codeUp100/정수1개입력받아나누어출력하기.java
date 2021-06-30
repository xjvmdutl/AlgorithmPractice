package codeUp100;

import java.util.Scanner;

public class 정수1개입력받아나누어출력하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int len = 10000;
		while(n>0){
			System.out.println((n/len) * len);
			n -= (n/len) * len;
			len/=10;
		}
	}

}
