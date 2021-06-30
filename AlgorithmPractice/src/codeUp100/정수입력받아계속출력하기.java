package codeUp100;

import java.util.Scanner;

public class 정수입력받아계속출력하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i =0;i<n;++i) {
			System.out.println(sc.nextInt());
		}
		
	}

}
