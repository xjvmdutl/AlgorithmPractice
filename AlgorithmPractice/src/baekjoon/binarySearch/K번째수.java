package baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class K¹øÂ°¼ö {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		long k = Long.parseLong(reader.readLine());
		System.out.println(solution(n,k));
	}

	private static long solution(int n, long k) {
		long start = 1;
		long end = k;
		long answer = 0;
		while(start <= end) {
			long mid = (start+end)/2;
			long count = 0;	
			for(int i=1;i<=n;++i) {
				count += Math.min(mid/i, n);
			}
			if(count < k) {
				start = mid + 1;
			}else {
				answer = mid;
				end = mid - 1;
			}
		}
		return answer;
	}

}
