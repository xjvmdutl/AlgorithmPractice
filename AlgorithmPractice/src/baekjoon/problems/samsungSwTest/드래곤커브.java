package baekjoon.problems.samsungSwTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class µå·¡°ïÄ¿ºê {
	public static int[] dx = {1,0,-1,0};
	public static int[] dy = {0,-1,0,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] map = new int[101][101];
		int[][] arr = new int[n][4];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
			arr[i][2] = Integer.parseInt(tokens.nextToken());
			arr[i][3] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(map,arr,n));
	}

	private static int solution(int[][] map, int[][] arr, int n) {
		
		for(int i = 0;i<n;++i) {
			List<Integer> list = findDir(arr[i][2],arr[i][3]);
			draw(map,list,arr[i][1],arr[i][0]);
		}
		int answer = check(map);
		return answer;
	}

	private static int check(int[][] map) {
		int sum = 0;
		for(int i=0;i<100;++i) {
			for(int j=0;j<100;++j) {
				if(map[i][j] == 1 
					&& map[i+1][j] == 1
					&& map[i][j+1] == 1
					&& map[i+1][j+1] == 1) {
					sum++;
				}
			}
		}
		return sum;
	}

	private static void draw(int[][] map, List<Integer> list, int y, int x) {
		map[y][x] = 1;
		for(int dir : list) {
			x = x + dx[dir];
			y = y + dy[dir];
			map[y][x] = 1;
		}
	}

	private static List<Integer> findDir(int dir, int g) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(dir);
		while(g-- > 0) {
			int n = list.size();
			for(int i=n-1;i>=0;--i) {
				int d = (list.get(i)+1)%4;
				list.add(d);
			}
		}
		return list;
	}

	

}
