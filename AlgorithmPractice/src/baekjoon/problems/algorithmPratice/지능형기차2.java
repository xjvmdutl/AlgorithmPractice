package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 지능형기차2 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[10][2];
		for(int i=0;i<map.length;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			map[i][0] = Integer.parseInt(tokens.nextToken());
			map[i][1] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(map));	
	}

	private static int solution(int[][] map) {
		int answer = 0;
		int people = 0;
		for(int i=0;i<map.length;++i) {
			people -= map[i][0];
			people += map[i][1];
			answer = Math.max(answer, people);
		}
		return answer;
	}

}
