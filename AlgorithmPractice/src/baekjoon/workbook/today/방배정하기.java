package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 방배정하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int a = Integer.parseInt(tokens.nextToken());
		int b = Integer.parseInt(tokens.nextToken());
		int c = Integer.parseInt(tokens.nextToken());
		int n = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(a,b,c,n));
	}

	private static int solution(int a, int b, int c, int n) {
		for(int i=0;i<=n/a;++i) {
			for(int j=0;j<=(n-(i*a))/b;++j) {
				for(int k=0;k<=(n-(i*a)-(j*b))/c;++k) {
					if((a*i) + (b*j) + (c*k) ==  n)
						return 1;
				}	
			}	
		}
		return 0;
	}

}
