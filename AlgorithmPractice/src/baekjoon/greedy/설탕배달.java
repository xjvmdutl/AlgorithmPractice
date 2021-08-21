package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class º≥≈¡πË¥ﬁ {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		System.out.println(solution(n));
	}

	
	
	private static int solution(int n) {
		int cnt = -1;
		for(int i=0;i<=n/5;++i) {
			int tmp = permulate(n - 5*i, 0);
			if(tmp != -1)
				cnt = tmp+i;
		}
		return cnt;
	}
	private static int permulate(int num,int cnt) {
		if(num % 3 != 0)
			return -1;
		return num/3;
	}

}
