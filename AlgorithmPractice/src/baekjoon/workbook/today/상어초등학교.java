package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
class Student implements Comparable<Student>{
	int x;
	int y;
	int loveCount;
	int blankCount;
	public Student(int x,int y, int loveCount, int blankCount) {
		this.x = x;
		this.y = y;
		this.loveCount = loveCount;
		this.blankCount = blankCount;
	}
	@Override
	public int compareTo(Student o) {
		if(o.loveCount == this.loveCount) {
			if(o.blankCount == this.blankCount) {
				if(o.y == this.y) {
					return this.x - o.x;
				}
				return this.y - o.y;
			}
			return o.blankCount - this.blankCount;
		}
		return o.loveCount - this.loveCount;
	}
}
public class 상어초등학교 {
	public static boolean[][] visit;
	public static Queue<Student> pq;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static Map<Integer, HashSet<Integer>> m;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n*n][5];
		
		for(int i=0;i<arr.length;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<5;++j) {
				arr[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		System.out.println(solution(arr, n));
	}

	private static int solution(int[][] arr, int n) {
		int answer = 0;
		int[][] map = new int[n][n];
		m = new HashMap<>();
		visit = new boolean[n][n];
		for(int i=0;i<arr.length;++i) {
			int now = arr[i][0];
			pq = new PriorityQueue<>();
			find(map,arr[i], n);
			Student s = pq.poll();
			map[s.y][s.x] = now;
			visit[s.y][s.x] = true; 
		}
		answer = sumAll(map,arr, n);
		
		return answer;
	}

	private static int sumAll(int[][] map, int[][] arr, int n) {
		int sum = 0;
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				int now = map[i][j];
				Student s = findArround(map,m.get(now),n,i,j);
				sum += s.loveCount == 0 ? 0 : Math.pow(10, s.loveCount-1);
			}
		}
		return sum;
	}

	private static void find(int[][] map, int[] arr, int n) {
		HashSet<Integer> set = new HashSet<>();
		for(int i=1;i<arr.length;++i) {
			set.add(arr[i]);
		}
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(!visit[i][j]) {
					pq.offer(findArround(map,set,n,i,j));
				}
			}	
		}
		m.put(arr[0], set);
	}

	private static Student findArround(int[][] map, Set<Integer> set, int n, int y, int x) {
		int blank = 0;
		int loveCount = 0;
		for(int i=0;i<4;++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(isRange(nx,ny,n)) {
				if(map[ny][nx] == 0) {
					blank++;
				}else if(set.contains(map[ny][nx])) {
					loveCount++;
				}
			}
		}
		return new Student(x, y, loveCount, blank);
	}

	private static boolean isRange(int x, int y, int n) {
		return 0 <= x && x < n && 0 <= y && y < n;
	}

}
