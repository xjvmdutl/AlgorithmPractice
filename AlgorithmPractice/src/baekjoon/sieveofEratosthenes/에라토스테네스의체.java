package baekjoon.sieveofEratosthenes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 에라토스테네스의체 {
	public static int[] sosu; 
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(n,k));
	}

	private static int solution(int n, int k) {
		sosu = new int[n+1];
		int idx = 0;
		int answer = 0;
		Arrays.fill(sosu, Integer.MAX_VALUE);
		for(int i=2;i<=n;++i) {
			if(sosu[i] == 0) {
				continue;
			}
			boolean flag = true;
			for(int j=i;j<=n;j+=i) {
				if(sosu[j] == 0) {
					continue;
				}
				idx++;
				sosu[j]=0;
				if(idx == k) {
					answer = j;
					flag = false;
					break;
				}
			}
			if(!flag)
				break;
		}
		return answer;
	}

}
