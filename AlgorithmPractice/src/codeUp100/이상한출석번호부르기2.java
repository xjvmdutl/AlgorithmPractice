package codeUp100;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class 이상한출석번호부르기2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Integer[] arr = new Integer[n];
		for(int i=0;i<n;++i) {
			Integer randN = sc.nextInt();
			arr[i] = randN;
		}
		
		for(int i = arr.length-1;i>=0;--i)
			System.out.print(arr[i] + " ");
	}
}
