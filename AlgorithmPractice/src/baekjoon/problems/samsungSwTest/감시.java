package baekjoon.problems.samsungSwTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
class CCTV{
	int x;
	int y;
	int number;
	int dir;
	public CCTV(int x,int y,int number,int dir){
		this.x = x;
		this.y = y;
		this.number = number;
		this.dir = dir;
	}
}
public class °¨½Ã {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static int answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[n][m];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<m;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		System.out.println(solution(map,n,m));
	}

	private static int solution(int[][] map, int n, int m) {
		answer = Integer.MAX_VALUE;
		int cctvCount = 0;
		List<CCTV> list = new ArrayList<>();
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				if(0 < map[i][j] && map[i][j] < 6) {
					list.add(new CCTV(j, i, map[i][j],0));
					cctvCount++;
				}
			}
		}
		combine(map,list,0,cctvCount,n,m);
		
		
		return answer;
	}

	private static void combine(int[][] map, List<CCTV> list, int index, int cctvCount,int n,int m) {
		if(index == cctvCount) {
			
			check(map,list,n,m);
			return;
		}
		CCTV cctv = list.get(index);
		if(cctv.number == 1) {
			list.get(index).dir = 0;
			combine(map,list, index+1, cctvCount,n,m);
			list.get(index).dir = 1;
			combine(map,list, index+1, cctvCount,n,m);
			list.get(index).dir = 2;
			combine(map,list, index+1, cctvCount,n,m);
			list.get(index).dir = 3;
			combine(map,list, index+1, cctvCount,n,m);
		}else if(cctv.number == 2) {
			list.get(index).dir = 0;
			combine(map,list, index+1, cctvCount,n,m);
			list.get(index).dir = 2;
			combine(map,list, index+1, cctvCount,n,m);
		}else if(cctv.number == 3) {
			list.get(index).dir = 0;
			combine(map,list, index+1, cctvCount,n,m);
			list.get(index).dir = 1;
			combine(map,list, index+1, cctvCount,n,m);
			list.get(index).dir = 2;
			combine(map,list, index+1, cctvCount,n,m);
			list.get(index).dir = 3;
			combine(map,list, index+1, cctvCount,n,m);
		}else if(cctv.number == 4) {
			list.get(index).dir = 0;
			combine(map,list, index+1, cctvCount,n,m);
			list.get(index).dir = 1;
			combine(map,list, index+1, cctvCount,n,m);
			list.get(index).dir = 2;
			combine(map,list, index+1, cctvCount,n,m);
			list.get(index).dir = 3;
			combine(map,list, index+1, cctvCount,n,m);
		}else if(cctv.number == 5) {
			list.get(index).dir = 0;
			combine(map,list, index+1, cctvCount,n,m);
		}
		
	}

	private static void check(int[][] map, List<CCTV> list, int n, int m) {
		boolean[][] visit = new boolean[n][m];
		for(int i=0;i<list.size();++i) {
			CCTV cctv = list.get(i);
			if(cctv.number == 1) {
				int x = cctv.x;
				int y = cctv.y;
				int dir = cctv.dir;
				go(x,y,dir,visit,n,m,map);
			}else if(cctv.number == 2) {
				int x = cctv.x;
				int y = cctv.y;
				int dir = cctv.dir;
				go(x,y,dir,visit,n,m,map);
				x = cctv.x;
				y = cctv.y;
				dir = cctv.dir+1;
				go(x,y,dir,visit,n,m,map);
			}else if(cctv.number == 3) {
				int x = cctv.x;
				int y = cctv.y;
				int org = cctv.dir;
				int[] tmp = new int[2];
				switch (org) {
				case 0: 
					tmp[0] = 0;
					tmp[1] = 2;
					break;
				case 1:
					tmp[0] = 1;
					tmp[1] = 2;
					break;
				case 2: 
					tmp[0] = 1;
					tmp[1] = 3;
					break;
				case 3:
					tmp[0] = 0;
					tmp[1] = 3;
					break;
				};
				for(int j=0;j<2;++j) {
					go(x,y,tmp[j],visit,n,m,map);
				}
			}else if(cctv.number == 4) {
				int x = cctv.x;
				int y = cctv.y;
				int org = cctv.dir;
				int[] tmp = new int[3];
				switch (org) {
				case 0: 
					tmp[0] = 0;
					tmp[1] = 1;
					tmp[2] = 2;
					break;
				case 1:
					tmp[0] = 1;
					tmp[1] = 2;
					tmp[2] = 3;
					break;
				case 2: 
					tmp[0] = 0;
					tmp[1] = 1;
					tmp[2] = 3;
					break;
				case 3:
					tmp[0] = 0;
					tmp[1] = 2;
					tmp[2] = 3;
					break;
				};
				for(int j=0;j<3;++j) {
					go(x,y,tmp[j],visit,n,m,map);
				}
			}else {
				for(int j=0;j<4;++j) {
					int x = cctv.x;
					int y = cctv.y;
					while(isRange(x,y,n,m) && map[y][x] != 6) {
						visit[y][x] = true;
						x = x + dx[j];
						y = y + dy[j];
					}
				}
			}
		}
		counting(map,visit,n,m);
	}

	private static void go(int x, int y, int dir, boolean[][] visit, int n, int m, int[][] map) {
		while(isRange(x,y,n,m) && map[y][x] != 6) {
			visit[y][x] = true;
			x = x + dx[dir];
			y = y + dy[dir];
		}
	}
	
	private static void counting(int[][] map, boolean[][] visit, int n, int m) {
		int sum = 0;
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				if(!visit[i][j] && map[i][j] != 6) {
					sum++;
				}
			}
		}
		answer = Math.min(answer, sum);
	}

	private static boolean isRange(int x, int y, int n, int m) {
		return 0 <= x && x < m && 0 <= y && y < n;
	}

}
