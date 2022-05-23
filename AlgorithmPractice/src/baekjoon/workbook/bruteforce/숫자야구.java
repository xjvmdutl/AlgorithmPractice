package baekjoon.workbook.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자야구 {
	private static int solution(int[][] map, int n) {
		int answer = 0;
		OUTER:for(int i=123;i<=987;++i) {
			if(!isNotContainsZeroAndNotDuplicate(i)) {
				continue;
			}
			for(int j=0;j<n;++j) {
				String value1 = String.valueOf(i);
				String value2 = String.valueOf(map[j][0]);
				int strike = getStrike(value1, value2);
				int ball = getBall(value1, value2);
				if(strike != map[j][1] || ball != map[j][2]) {
					continue OUTER;
				}
			}
			answer++;
		}
		return answer;
	}
	private static int getBall(String value1, String value2) {
		int ball = 0;
		if(value1.charAt(0) == value2.charAt(1) || value1.charAt(0) == value2.charAt(2)) {
			ball++;
		}
		if(value1.charAt(1) == value2.charAt(0) || value1.charAt(1) == value2.charAt(2)) {
			ball++;
		}
		if(value1.charAt(2) == value2.charAt(0) || value1.charAt(2) == value2.charAt(1)) {
			ball++;
		}
		return ball;
	}
	private static int getStrike(String value1, String value2) {
		int strike = 0;
		for(int i=0;i<3;++i) {
			if(value1.charAt(i) == value2.charAt(i)) {
				strike++;
			}
		}
		return strike;
	}
	private static boolean isNotContainsZeroAndNotDuplicate(int num) {
		String str = String.valueOf(num);
		if(str.charAt(0) == str.charAt(1) || str.charAt(0) == str.charAt(2) || str.charAt(1) == str.charAt(2)) {
			return false;
		}
		if(str.charAt(0) == '0' || str.charAt(1) == '0' || str.charAt(2) == '0') {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] map = new int[n][3];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int num = Integer.parseInt(tokens.nextToken());
			int strike = Integer.parseInt(tokens.nextToken());
			int ball = Integer.parseInt(tokens.nextToken());
			map[i][0] = num;
			map[i][1] = strike;
			map[i][2] = ball;
		}
		System.out.println(solution(map, n));
	}



}
