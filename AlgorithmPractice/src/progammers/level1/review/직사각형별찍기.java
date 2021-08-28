package progammers.level1.review;

import java.util.Scanner;

public class 직사각형별찍기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        //	5 3 
        System.out.println(solution(a,b));
        /*
	        *****
	        *****
	        *****
        */
	}

	private static String solution(int a, int b) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<b;++i) {
			for(int j=0;j<a;++j) {
				sb.append("*");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

}
