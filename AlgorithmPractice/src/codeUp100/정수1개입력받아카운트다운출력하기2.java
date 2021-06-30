package codeUp100;

import java.util.Scanner;

public class 정수1개입력받아카운트다운출력하기2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=n;i>0;--i){
			System.out.println(i);
		}
	}

}
