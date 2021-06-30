package codeUp100;

import java.util.Scanner;

public class 주민번호입력받아형태바꿔출력하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(str.replace("-",""));
	}

}
