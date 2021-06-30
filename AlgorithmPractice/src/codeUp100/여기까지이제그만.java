package codeUp100;

import java.util.Scanner;

public class 여기까지이제그만 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int idx =0;
		int sum = 0;
		while(sum<n) {
			idx++;
			sum+=idx;
			
		}
		System.out.println(sum);
	}

}
