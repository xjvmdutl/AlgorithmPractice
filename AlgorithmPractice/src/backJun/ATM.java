package backJun;

import java.util.Arrays;
import java.util.Scanner;

public class ATM {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] p = new int[n];
		for(int i = 0 ;i<n;++i)
			p[i] = sc.nextInt();
		System.out.println(solution(n,p));
	}

	private static int solution(int n, int[] p) {
		Arrays.sort(p);
		int sum = 0;
		for(int i=0;i<p.length;++i) {
			int cnt = 0;
			for(int j=0;j<=i;++j) {
				cnt+=p[j];
			}
			sum += cnt;
		}
		return sum;
	}

	
	
}
