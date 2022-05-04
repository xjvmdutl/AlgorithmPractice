package baekjoon.workbook.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ºø¹° {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int h = Integer.parseInt(tokens.nextToken());
		int w = Integer.parseInt(tokens.nextToken());
		int[] map = new int[w];
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<w;++i) {
			map[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(map, h, w));
	}

	private static int solution(int[] map, int h, int w) {
		int answer = 0;
		for(int i=1;i<w-1;++i) {
			int maxLeft = getMaxLeft(map, i, w);
			int maxRight = getMaxRight(map, i, 0);
			int min = Math.min(maxLeft, maxRight);
			if(isNowOver(map[i], min)) {
				answer += min - map[i];
			}
		}
		return answer;
	}

	private static boolean isNowOver(int now, int compare) {
		return now < compare;
	}

	private static int getMaxLeft(int[] map, int now, int w) {
		int answer = 0;
		int current = map[now];
		for(int i=now+1;i<w;++i) {
			if(current < map[i]) {
				answer = Math.max(answer, map[i]);
			}
		}
		return answer;
	}

	private static int getMaxRight(int[] map, int now, int end) {
		int answer = 0;
		int current = map[now];
		for(int i=now-1;i>=end;--i) {
			if(current < map[i]) {
				answer = Math.max(answer, map[i]);
			}
		}
		return answer;
	}

}
