package codeUp100;

import java.util.Scanner;

public class 정수1개입력받아평가출력하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		if(n>=90) {
			sb.append("A");
		}else if(n>=70) {
			sb.append("B");
		}else if(n>=40) {
			sb.append("C");
		}else {
			sb.append("D");
		}
		System.out.println(sb.toString());
	}

}
