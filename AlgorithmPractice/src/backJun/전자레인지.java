package backJun;

import java.util.Scanner;

public class 전자레인지 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		System.out.println(solution(t));
	}

	private static String solution(int t) {
		int a = 60*5;
		int b = 60;
		int c = 10;
		StringBuilder sb = new StringBuilder();
		sb.append(t/a + " ");
		t %= a;
		sb.append(t/b + " ");
		t %= b;
		sb.append(t/c);
		t %= c;
		if(t != 0)
			return "-1";
		return sb.toString();
	}

}
