package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A¿¡¼­B {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] str = reader.readLine().split(" ");
		long a = Long.parseLong(str[0]);
		long b = Long.parseLong(str[1]);
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

}
