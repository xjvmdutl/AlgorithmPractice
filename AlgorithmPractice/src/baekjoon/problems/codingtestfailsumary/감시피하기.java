package baekjoon.problems.codingtestfailsumary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
class Teacher{
	int x;
	int y;
	public Teacher(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
public class 감시피하기 {
	public static boolean[][] visit;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static List<Teacher> list;
	public static String answer;
	public static boolean flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		char[][] map = new char[n][n];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<n;++j)
				map[i][j] = tokens.nextToken().charAt(0);
		}
		System.out.println(solution(map,n));
	}

	private static String solution(char[][] map, int n) {
		answer = "NO";
		flag = false;
		list = new ArrayList<>();
		visit = new boolean[n][n];
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(map[i][j] == 'T') {
					list.add(new Teacher(j,i));
				}
			}	
		}
		dfs(map,n,0);
		return answer;
	}

	private static void dfs(char[][] map, int n, int depth) {
		if(depth == 3) {
			for(Teacher t : list) {
				for(int i=0;i<4;++i) {
					int nx = t.x;
					int ny = t.y;
					for(int j=0;j<n;++j) {
						nx += dx[i];
						ny += dy[i];
						if(isRange(nx,ny,n)) { 
							if(map[ny][nx] == 'O')
								break;
							else if(map[ny][nx] == 'S')
								return;
						}else {
							break;
						}
					}
				}
			}
			flag = true;
			answer = "YES";
			return;
		}
		
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(!visit[i][j] && map[i][j] == 'X' && !flag) {
					visit[i][j] = true;
					map[i][j] = 'O';
					dfs(map, n, depth+1);
					visit[i][j] = false;
					map[i][j] = 'X';
				}
			}	
		}
		
	}

	private static boolean isRange(int nx, int ny, int n) {
		return 0 <= nx && nx < n && 0 <= ny && ny < n;
	}

}
