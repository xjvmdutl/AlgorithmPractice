package baekjoon.workbook.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class ½Ã°¢ {
	private static int solution(int n, int k) {
		int answer = 0;
		int finishTime = 59 + (60 * 59) + (60 * 60 * n);
		for(int i=0;i<=finishTime;++i) {
			String time = convert(i);
			if(time.contains(String.valueOf(k))) {
				answer++;
			}
		}
		return answer;
	}
	private static String convert(int time) {
		StringBuilder answer = new StringBuilder();
		int hour = time / (60 * 60);
		time %= (60 * 60);
		int minute = time / 60;
		int second = time % 60;
		if(hour < 10) {
			answer.append("0" + hour);
		}else {
			answer.append(hour);
		}
		if(minute < 10) {
			answer.append("0" + minute);
		}else {
			answer.append(minute);
		}
		if(second < 10) {
			answer.append("0" + second);
		}else {
			answer.append(second);
		}
		return answer.toString();
	}
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(n, k));
	}

	
}
