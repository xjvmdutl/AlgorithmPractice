package codeUp100;

import java.util.Scanner;

public class �̻����⼮��ȣ�θ���3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;++i) {
			int randN = sc.nextInt();
			arr[i] = randN;
		}
		int min = Integer.MAX_VALUE;
		for(int i : arr) {
			min = Math.min(i, min);
		}
		System.out.println(min);
	}
}
