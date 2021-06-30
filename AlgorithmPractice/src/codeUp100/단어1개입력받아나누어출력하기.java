package codeUp100;

import java.util.Scanner;

public class 단어1개입력받아나누어출력하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		for(char c : str.toCharArray()) {
			System.out.println("\'" + c + "\'");
		}
	}
}
