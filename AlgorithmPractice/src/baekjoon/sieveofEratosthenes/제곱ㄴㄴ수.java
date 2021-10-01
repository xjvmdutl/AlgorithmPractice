package baekjoon.sieveofEratosthenes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Á¦°ö¤¤¤¤¼ö {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		long min = Long.parseLong(tokens.nextToken());
		long max = Long.parseLong(tokens.nextToken());
		
		System.out.println(solution(min,max));
	}

	private static int solution(long min, long max) {
		int answer = 0;
		int size = (int) (max - min + 1);
		int sqrt = ((int) Math.sqrt(max));
		boolean[] checks = new boolean[size];
		long[] num = new long[size];
		for(long i = 2; i <= sqrt; i++) { 
			long squared = i * i;
			long start = min % squared == 0 ? min / squared : (min / squared) + 1;
			for(long j = start; j * squared <= max; j ++) {	
				checks[(int) ( (j * squared) - min)] = true;
			}
		}
		int count = 0;
		for(int i = 0; i < size; i++) {
			if(!checks[i])
				count++;
		}
		
		return count;
	}


}
