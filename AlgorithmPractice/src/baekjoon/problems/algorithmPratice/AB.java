package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AB {
	public static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		long a = Long.parseLong(tokens.nextToken());
		long b = Long.parseLong(tokens.nextToken());
		System.out.println(solution(a,b));
	}

	private static int solution(long a, long b) {
		int count = 0;
		long min = a;
		long max = b;
		if(a>b)
			return -1;
		while(min<max) {
			if(max%10 == 1) {
				max/=10;
			}else if(max%2 == 0) {
				max/=2;
			}else {
				return -1;
			}
			count++;
		}
		if(max < min)
			count = -2;
		return count+1;
	}

	private static void bfs(long a, long b) {
		// TODO Auto-generated method stub
		
	}

}
