package codeUp100;

import java.util.Scanner;

public class 이상한출석번호부르기3 {

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
