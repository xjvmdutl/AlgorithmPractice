package baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ∞‘¿” {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		long x = Long.parseLong(tokens.nextToken());
		long y = Long.parseLong(tokens.nextToken());
		System.out.println(solution(x,y));
	}

	private static long solution(long x, long y) {
		long answer = -1;
		long start = 0;
		long end = 1000000000;
		int z = getPercent(x,y);
		while(start <= end) {
			long mid = (start + end)/2;
			if(getPercent(x+mid,y+mid) != z) {
				answer = mid;
				end = mid -1;
			}else {
				start = mid +1;
			}
		} 
		return answer;
	}

	private static int getPercent(long x, long y) {
		return (int)(y*100 / x);
	}

}
