package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ²É±æ {
	public static boolean[][] visit;
	public static int answer;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static int[][] per;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] map = new int[n][n];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<n;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}	
		}
		System.out.println(solution(map, n));
	}

	private static int solution(int[][] map, int n) {
		answer = Integer.MAX_VALUE;
		visit = new boolean[n][n];
		per = new int[3][2];
		permutation(map, n, 0, 3);
		return answer;
	}

	private static void permutation(int[][] map, int n, int count, int length) {
		if(count == length) {
			boolean[][] mp = new boolean[n][n];
			boolean isOkay = true;
			int sum = 0;
			OUTER:for(int i=0;i<3;++i) {
				sum += map[per[i][1]][per[i][0]];
				mp[per[i][1]][per[i][0]] = true;
				for(int j=0;j<4;++j) {
					int nx = dx[j] + per[i][0];
					int ny = dy[j] + per[i][1];
					if(!isRange(nx, ny, n) || mp[ny][nx]) {
						isOkay =  false;
						break OUTER;
					}
					mp[ny][nx] = true;
					sum += map[ny][nx];
				}
			}
			if(isOkay) {
				answer = Math.min(answer, sum);
			}
			return;
			
		}
		
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(!visit[i][j]) {
					per[count][0] = j;
					per[count][1] = i;
					visit[i][j] = true;
					permutation(map, n, count+1, length);
					visit[i][j] = false;
				}
			}	
		}
	}

	private static boolean isRange(int nx, int ny, int n) {
		return 0 <= nx && nx < n && 0 <= ny && ny < n;
	}

}
