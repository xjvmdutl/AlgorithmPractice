package codeUp100;

import java.util.Scanner;

public class ������Է¹޾����Ĺٲ�����ϱ� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] days = str.split("\\.");
		System.out.println(days[2] + "-" + days[1] + "-" + days[0]);
	}
}
