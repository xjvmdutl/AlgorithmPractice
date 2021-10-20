package baekjoon.problems.samsungSwTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
class FireBall{
	int x;
	int y;
	int m;
	int speed;
	int dir;
	public FireBall(int x,int y,int m,int speed,int dir) {
		this.dir = dir;
		this.m = m;
		this.x = x;
		this.y = y;
		this.speed =speed;
	}
}
public class 마법사상어와파이어볼 {
	public static int[] dx = {0,1,1,1,0,-1,-1,-1};
	public static int[] dy = {-1,-1,0,1,1,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		List<FireBall>[][] map = new ArrayList[n][n];
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				map[i][j] = new ArrayList<>();
			}
		}
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int r = Integer.parseInt(tokens.nextToken())-1;
			int c = Integer.parseInt(tokens.nextToken())-1;
			int mi = Integer.parseInt(tokens.nextToken());
			int s = Integer.parseInt(tokens.nextToken());
			int d = Integer.parseInt(tokens.nextToken());
			map[r][c].add(new FireBall(r, c, mi, s, d));
		}
		System.out.println(solution(map,n,k));
	}
	private static int solution(List<FireBall>[][] map, int n, int k) {
		int answer = 0;
		
		while(k-- > 0) {
			map = spread(map,n);
			map = contain(map,n);
		}
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(map[i][j].size() > 0) {
					for(FireBall fb : map[i][j])
						answer += fb.m;
				}
			}	
		}
		return answer;
	}
	private static List<FireBall>[][] spread(List<FireBall>[][] map, int n) {
		List<FireBall>[][] tmp = new ArrayList[n][n];
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				tmp[i][j] = new ArrayList<FireBall>();
			}
		}
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(map[i][j].size() > 0) {
					for(FireBall fb : map[i][j]) {
						int nx = fb.x + dx[fb.dir]*fb.speed;
						int ny = fb.y + dy[fb.dir]*fb.speed;
						if(isRange(nx,ny,n)) {
							tmp[ny][nx].add(new FireBall(nx, ny, fb.m, fb.speed, fb.dir));
						}
					}
				}
			}	
		}
		return tmp;
	}
	private static boolean isRange(int nx, int ny, int n) {
		return 0<=nx&&nx<n&&0<=ny&&ny<n;
	}
	private static List<FireBall>[][] contain(List<FireBall>[][] map, int n) {
		List<FireBall>[][] tmp = new ArrayList[n][n]; 
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				tmp[i][j] = new ArrayList<FireBall>();
			}
		}
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(map[i][j].size() > 1) {
					int sumM = 0;
					int sumS = 0;
					boolean flag = true;
					int number = map[i][j].get(0).dir%2;
					for(FireBall fb : map[i][j]) {
						sumM += fb.m;
						sumS += fb.speed;
						if(fb.dir % 2 != number) {
							flag = false;
						}
					}
					int m = sumM/5;
					int speed = sumS/map[i][j].size();
					map[i][j].clear();
					if(m == 0) {
						continue;
					}
					for(int k=0;k<7;k+=2) {
						if(!flag) {
							if(i == 0 || i==2 || i==4 || i== 6)
								continue;
						}else {
							if(i == 1 || i==3 || i==5 || i== 7)
								continue;
						}
						int nx = j + dx[k];
						int ny = i + dy[k];
						if(isRange(nx, ny, n)) {
							map[ny][nx].add(new FireBall(nx, ny, m, speed, i));
						}
					}
				}else if(map[i][j].size() == 1) {
					tmp[i][j].add(map[i][j].get(0));
				}
			}	
		}
		return tmp;
	}

}
