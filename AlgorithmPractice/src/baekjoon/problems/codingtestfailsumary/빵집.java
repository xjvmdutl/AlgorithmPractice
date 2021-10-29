package baekjoon.problems.codingtestfailsumary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class »§Áý {
	public static int answer;
	public static boolean find;
	public static int[] dx = {1,1,1};
    public static int[] dy = {-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int r = Integer.parseInt(tokens.nextToken());
		int c = Integer.parseInt(tokens.nextToken());
		char[][] map = new char[r][c];
		for(int i=0;i<r;++i) {
			String str = reader.readLine();
			for(int j=0;j<c;++j) {
				map[i][j] = str.charAt(j);
			}
		}
		System.out.println(solution(map,r,c));
	}

	private static int solution(char[][] map, int r, int c) {
		answer = 0;
		for(int i=0;i<r;++i) {
			find = false;
			dfs(map,0,i,r,c);
		}
		return answer;
	}

	private static void dfs(char[][] map, int x, int y, int r, int c) {
		if(x == c - 1) {
			answer++;
			find = true;
			return;
		}
		for(int i=0;i<3;++i) {
			int nx = x + dx[i];
            int ny = y + dy[i];
			if(isRange(nx,ny,r,c) && map[ny][nx] == '.') {
				map[y][x] = 'x';
				dfs(map, nx, ny, r, c);
				if(find) {
					return;
				}
			}
		}
	}

	private static boolean isRange(int nx, int ny, int r, int c) {
		return 0 <= nx && nx < c && 0 <= ny && ny < r;
	}

}
