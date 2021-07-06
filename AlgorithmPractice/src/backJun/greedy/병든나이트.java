package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 병든나이트 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] str = reader.readLine().split(" ");
		long n = Long.parseLong(str[0]);
		long m = Long.parseLong(str[1]);
		System.out.println(solution(n,m));
		
	}

	private static long solution(long n, long m) {
		if(n==1) return 1;
        if(n==2) return Math.min(4, (m+1)/2);
        if(m<7) return Math.min(4, m);
        return m-2;
	}

}
