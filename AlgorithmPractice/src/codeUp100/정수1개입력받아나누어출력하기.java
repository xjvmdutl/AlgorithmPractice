package codeUp100;

import java.util.Scanner;

public class ����1���Է¹޾Ƴ���������ϱ� {

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
