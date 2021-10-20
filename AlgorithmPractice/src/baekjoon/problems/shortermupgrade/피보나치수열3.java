package baekjoon.problems.shortermupgrade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class �Ǻ���ġ����3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(reader.readLine());
		//�ǻ�� �ֱ� : �Ǻ���ġ ������ ���� ������ ������� ���� �ֱⰡ �����.
		//10^6 ���� ���������� �Ǻ���ġ �ֱ� = 15 * 10^5
		System.out.println(solution(n));
	}

	private static int solution(long n) {
		int[] dp = new int[1500001];
		dp[0] = 0;
		dp[1] = 1;
		for(int i=2;i<=1500000;++i) {
			dp[i] = (dp[i-2] + dp[i-1])%1000000;
		}
		return dp[(int) (n%1500000)];
	}

}
