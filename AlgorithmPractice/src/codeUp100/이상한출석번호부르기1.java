package codeUp100;

import java.util.Arrays;
import java.util.Scanner;

public class �̻����⼮��ȣ�θ���1 {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[23];
		for(int i=0;i<n;++i) {
			int randN = sc.nextInt();
			arr[randN-1]++;
		}
		for(int i : arr)
			System.out.print(i + " ");
	}

}
