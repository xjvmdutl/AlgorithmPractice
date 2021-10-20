package baekjoon.problems.samsungSwTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Shark01{
	int x;
	int y;
	int speed;
	int dir;
	int z;
	public Shark01(int x,int y,int speed,int dir,int z) {
		this.dir = dir;
		this.x = x;
		this.y = y;
		this.z = z;
		this.speed = speed;
	}
}
public class ³¬½Ã¿Õ {
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {-1,1,0,0};
	public static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int r = Integer.parseInt(tokens.nextToken());
		int c = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		Shark01[][] map = new Shark01[r][c];
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int y = Integer.parseInt(tokens.nextToken())-1;
			int x = Integer.parseInt(tokens.nextToken())-1;
			int s = Integer.parseInt(tokens.nextToken());
			int d = Integer.parseInt(tokens.nextToken())-1;
			int z = Integer.parseInt(tokens.nextToken());
			map[y][x] = new Shark01(x, y, s, d, z);
		}
		System.out.println(solution(map,r,c));
	}

	private static int solution(Shark01[][] map, int r, int c) {
		answer = 0;
		for(int i=0;i<c;++i) {
			map = bfs(map,r,c,i);
		}
		
		return answer;
	}

	private static Shark01[][] bfs(Shark01[][] map, int r, int c, int now) {
		int weight = 0;
		for(int i=0;i<r;++i) {
			if(map[i][now] != null) {
				weight = map[i][now].z;
				map[i][now] = null;
				
				break;
			}
		}
		Shark01[][] tmp = new Shark01[r][c];
		for(int i=0;i<r;++i) {
			for(int j=0;j<c;++j) {
				if(map[i][j] != null) {
					go(map,i,j,r,c,tmp);
				}
			}
		}
		
		answer += weight;
		return tmp;
	}

	private static void go(Shark01[][] map, int y, int x, int r, int c,Shark01[][] tmp) {
		Shark01 s = map[y][x];
		int speed = s.speed;
		while(speed-- > 0) {
			int nx = s.x + dx[s.dir];
			int ny = s.y + dy[s.dir];
			if(!isRange(nx,ny,r,c)) {
				if(s.dir == 0)
					s.dir = 1;
				else if(s.dir == 1)
					s.dir = 0;
				else if(s.dir == 2)
					s.dir = 3;
				else if(s.dir == 3)
					s.dir = 2;
				nx = s.x + dx[s.dir];
				ny = s.y + dy[s.dir];
			}
			s.x = nx;
			s.y = ny;
		}
		
		if(tmp[s.y][s.x] != null ) {
			if(s.z > tmp[s.y][s.x].z) {
				tmp[s.y][s.x] = s; 
			}
		}else {
			tmp[s.y][s.x] = s;
			
		}
	}

	private static boolean isRange(int nx, int ny, int r, int c) {
		return 0 <= nx && nx < c && ny < r && 0 <= ny;
	}
}
