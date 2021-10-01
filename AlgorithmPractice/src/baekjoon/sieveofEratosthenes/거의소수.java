package baekjoon.sieveofEratosthenes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 거의소수 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		long a = Long.parseLong(tokens.nextToken());
		long b = Long.parseLong(tokens.nextToken());
		System.out.println(solution(a,b));
	}

	private static int solution(long a, long b) {
		int answer = 0;
		boolean[] sosu = new boolean[(int)Math.sqrt(b)+1];
		sosu[1] = true;
		for(int i=2;i<=(int)Math.sqrt(b);++i) {
			if(sosu[i] )
				continue;
			for(int j=i+i;j<=(int)Math.sqrt(b);j+=i) {
				sosu[j] = true;
			}
		}
		Set<Long> set = new HashSet<>();
		for(int i=2;i<=(int)Math.sqrt(b);++i) {
			if(!sosu[i]) {
				int idx = 2;
				long num = (long)Math.pow(i, idx);
				while(num <= b) {
					if(num >= a) {
						set.add(num);
					}
					num = (long) Math.pow(i, ++idx);
				}
			}
		}
		return set.size();
	}

}
