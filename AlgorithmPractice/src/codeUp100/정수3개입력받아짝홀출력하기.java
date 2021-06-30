package codeUp100;

import java.util.Scanner;

public class 정수3개입력받아짝홀출력하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int n3 = sc.nextInt();
		if(n1%2==0)
			System.out.println("even");
		else System.out.println("odd");
		if(n2%2==0)
			System.out.println("even");
		else System.out.println("odd");
		if(n3%2==0)
			System.out.println("even");
		else System.out.println("odd");
	}

}
