package baekjoon.problems.samsungSwTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
class School{
	int x;
	int y;
	int blankCount = 0;
	public School(int x,int y,int blankCount) {
		this.x = x;
		this.blankCount =blankCount;
		this.y = y;
	}
}
public class 상어초등학교 {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] map = new int[n][n];
		int[][] arr = new int[n*n][5];
		for(int i=0;i<n*n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<5;++j)
				arr[i][j] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(map,arr,n));
	}

	private static int solution(int[][] map, int[][] arr, int n) {
		int sum = 0;
		for(int i=0;i<arr.length;++i) {
			dfs(map,arr[i],n);
		}
		
		Arrays.sort(arr,(o1,o2)->o1[0]-o2[0]);
		for(int i=0;i<arr.length;++i) {
			sum += couting(map,arr[i],n);
		}
		return sum;
	}

	private static void dfs(int[][] map, int[] arr, int n) {
		List<Integer>[][] love = new ArrayList[n][n];
		int max = 0;
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				love[i][j] = new ArrayList<>();
				if(map[i][j] == 0) {
					find(map,love,arr,i,j,n);
					max = Math.max(max, love[i][j].size());
				}
			}	
		}
		List<School> list = new ArrayList<School>();
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(max == love[i][j].size() && map[i][j] == 0) {
					list.add(new School(j, i,0));
				}
			}	
		}
		if(list.size() <= 1) {
			map[list.get(0).y][list.get(0).x] = arr[0];
			return;
		}
		Queue<School> blank = new PriorityQueue<>((o1,o2)->{
			if(o2.blankCount == o1.blankCount) {
				if(o1.y == o2.y)
					return o1.x - o2.x;
				return o1.y - o2.y;
			}
			return o2.blankCount - o1.blankCount;
		});
		for(School s : list) {
			int count = 0;
			for(int i=0;i<4;++i) {
				int nx = s.x + dx[i];
				int ny = s.y + dy[i];
				if(isRange(nx, ny, n) && map[ny][nx] == 0) {
					count++;
				}
			}
			blank.offer(new School(s.x,s.y,count));
		}
		School school = blank.poll();
		map[school.y][school.x] = arr[0];
		
	}

	private static void find(int[][] map, List<Integer>[][] love, int[] arr, int y, int x, int n) {
		for(int i=0;i<4;++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(isRange(nx, ny, n)) {
				for(int j=0;j<4;++j) {
					if(arr[j+1] == map[ny][nx]) {
						love[y][x].add(1);
						break;
					}
				}
			}
		}
	}

	private static int couting(int[][] map, int[] arr, int n) {
		int x = 0;
		int y = 0;
		for(int i=0;i<n;++i) {
			boolean flag = true;
			for(int j=0;j<n;++j) {
				if(arr[0] == map[i][j]) {
					x = j;
					y = i;
					flag = false;
					break;
				}
			}
			if(!flag)
				break;
		}
		int count = 0;
		for(int i=0;i<4;++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(isRange(nx,ny,n)) {
				for(int j=1;j<5;++j) {
					if(arr[j] == map[ny][nx]) {
						count++;
						break;
					}
				}
			}
		}
		if(count > 0) {
			return (int) Math.pow(10, count-1);
		}
		return count;
	}

	private static boolean isRange(int nx, int ny, int n) {
		return 0 <= nx && nx < n && 0 <= ny && ny < n;
	}


}
