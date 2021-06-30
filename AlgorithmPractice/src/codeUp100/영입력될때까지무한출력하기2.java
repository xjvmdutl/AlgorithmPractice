package codeUp100;

import java.util.Scanner;

public class 영입력될때까지무한출력하기2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt();
			if(n == 0) {
				break;
			}
			System.out.println(n);
		}
	}

}
