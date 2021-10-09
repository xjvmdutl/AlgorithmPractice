package baekjoon.problems.samsungSwTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 나무재테크 {
	public static int[] dx = {-1,0,1,-1,1,-1,0,1};
	public static int[] dy = {-1,-1,-1,0,0,1,1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[n][n];
		List<Integer>[][] list = new ArrayList[n][n];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<n;++j) {
				map[i][j]=Integer.parseInt(tokens.nextToken());
				list[i][j] = new ArrayList<>();
			}	
		}
		
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int x = Integer.parseInt(tokens.nextToken())-1;
			int y = Integer.parseInt(tokens.nextToken())-1;
			int z = Integer.parseInt(tokens.nextToken());
			list[x][y].add(z);
		}
		System.out.println(solution(map,list,n,m,k));
	}

	private static int solution(int[][] start, List<Integer>[][] list, int n, int m, int k) {
		
		int[][] map = new int[n][n];
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				map[i][j] = 5;
			}	
		}
		while(k-- > 0) {
			springAndSummer(map,list,n);
			fall(map,list,n);
			winter(map,start,n);
		}
		int answer = find(list,n);
		return answer;
	}

	private static int find(List<Integer>[][] list, int n) {
		int sum = 0;
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				sum += list[i][j].size();
			}	
		}
		return sum;
	}

	private static void fall(int[][] map, List<Integer>[][] list, int n) {
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(list[i][j].size() > 0) {
					for(int number : list[i][j]) {
						if(number % 5 == 0) {
							for(int k =0;k<8;++k) {
								int nx = j + dx[k];
								int ny = i + dy[k];
								if(isRange(nx,ny,n)) {
									list[ny][nx].add(1);
								}
							}
						}
					}
				}
			}	
		}
	}

	private static boolean isRange(int nx, int ny, int n) {
		return 0 <= nx && nx < n && 0 <= ny && ny < n;
	}

	private static void winter(int[][] map, int[][] start, int n) {
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				map[i][j] += start[i][j];
			}	
		}
	}

	private static void springAndSummer(int[][] map, List<Integer>[][] list, int n) {
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(list[i][j].size() > 0) {
					eat(list,map,i,j);
				}
			}	
		}
	}

	private static void eat(List<Integer>[][] list, int[][] map, int y, int x) {
		int now = map[y][x];
		Collections.sort(list[y][x]);
		int idx = 0;
		for(;idx<list[y][x].size();++idx) {
			if(now >= list[y][x].get(idx)) {
				now -= list[y][x].get(idx);
				list[y][x].set(idx,list[y][x].get(idx)+1);
			}else {
				break;
			}
		}
		for(;idx<list[y][x].size();) {
			now += list[y][x].remove(idx)/2;
		}
		map[y][x] = now;
	}

}
