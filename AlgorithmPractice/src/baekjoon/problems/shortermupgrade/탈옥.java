package baekjoon.problems.shortermupgrade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
class Merder implements Comparable<Merder>{
	int x;
	int y;
	int openDoor;
	public Merder(int x,int y,int openDoor) {
		this.x = x;
		this.y = y;
		this.openDoor = openDoor;
	}
	@Override
	public int compareTo(Merder o) {
		return this.openDoor - o.openDoor;
	}
}
public class Å»¿Á {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		while(t-- > 0) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int h = Integer.parseInt(tokens.nextToken());
			int w = Integer.parseInt(tokens.nextToken());
			char[][] map = new char[h+2][w+2];
			for(int i=1;i<=h;++i) {
				String str = reader.readLine();
				for(int j=1;j<=w;++j) {
					map[i][j] = str.charAt(j-1);
				}	
			}
			System.out.println(solution(map,h,w));
		}
	}

	private static int solution(char[][] map, int h, int w) {
		int[][] prisonerOne, prisonerTwo,sanggeun;
		Merder m1 = null;
		Merder m2 = null;
		for(int i=0;i<=h;++i) {
			for(int j=0;j<=w;++j) {
				if(map[i][j] == '$') {
					if(m1 != null) {
						m2 = new Merder(j, i,0);
					}else {
						m1 = new Merder(j, i,0);
					}
				}
			}
		}
		prisonerOne = bfs(map,h, w, m1);
		prisonerTwo = bfs(map,h,w, m2);
		sanggeun = bfs(map, h, w, new Merder(0, 0, 0));
		int answer = getMinimumSum(prisonerOne, prisonerTwo, sanggeun, map);
		return answer;
	}


	private static int getMinimumSum(int[][] prisonerOne, int[][] prisonerTwo, int[][] sanggeun, char[][] map) {
		int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < prisonerOne.length; i++){
            for (int j = 0; j < prisonerOne[i].length; j++){
                if (map[i][j] == '*')
                    continue;
                int sum = prisonerOne[i][j] + prisonerTwo[i][j] + sanggeun[i][j];
                if (map[i][j] == '#'){
                    sum -= 2;
                }
                minSum = Math.min(sum, minSum);
            }
        }


        return minSum;
	}

	private static int[][] bfs(char[][] map, int h, int w, Merder m) {
		boolean[][] visit = new boolean[h+2][w+2];
		Queue<Merder> que = new PriorityQueue<>();
		que.offer(new Merder(m.x, m.y, m.openDoor));
		int[][] doorHistory = new int[h+2][w+2];
		visit[m.y][m.x] = true;
		
		while(!que.isEmpty()) {
			Merder merder = que.poll();
			doorHistory[merder.y][merder.x] = merder.openDoor;
			for(int i=0;i<4;++i) {
				int nx = merder.x + dx[i];
				int ny = merder.y + dy[i];
				if(isRange(nx,ny,h,w) && !visit[ny][nx] && map[ny][nx] != '*') {
					visit[ny][nx] = true;
					que.offer(new Merder(nx, ny, map[ny][nx] == '#' ?  merder.openDoor+1 : merder.openDoor));
				}
			}
		}
		return doorHistory;
	}

	private static boolean isRange(int x, int y, int h, int w) {
		return 0 <= x && x < w+2 && 0 <= y && y < h+2;
	}

}
