package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Calendar implements Comparable<Calendar>{
	int start;
	int end;
	public Calendar(int start, int end) {
		this.start = start;
		this.end = end;
	}
	@Override
	public int compareTo(Calendar o) {
		if(this.start == o.start)
			return o.end - this.end; 
		return this.start - o.start;
	}
	
}

public class ดÞทย {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][2];
		for(int i = 0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr, n));
	}

	private static int solution(int[][] arr, int n) {
		int answer = 0;
		Queue<Calendar> pq = new PriorityQueue<>();
		int maxDay = 0;
		for(int i =0;i<n;++i) {
			maxDay = Math.max(maxDay, arr[i][1]);
			pq.offer(new Calendar(arr[i][0], arr[i][1]));
		}
		boolean[][] map = new boolean[n][maxDay + 2];
		makeCalendar(pq, map, n);
		
		
		int start = 365;
		int end = 0;
		int height = 0;
		for (int j = 1; j < map[0].length; j++) {
			boolean stop = true;
			for (int i = 0; i < n; i++) { 
				if (map[i][j]) { 
					end = Math.max(end, j);
					start = Math.min(start, j); 
					height = Math.max(height, i + 1); 
					stop = false;
				}
			}
			if(stop) {
				answer += (end - start + 1) * height;
				start = 365;
				end = 0;
				height = 0;
			}
		}

		return answer;
	}

	private static void makeCalendar(Queue<Calendar> pq, boolean[][] map, int n) {
		while(!pq.isEmpty()) {
			Calendar c = pq.poll();
			for(int i=0;i<n;++i) {
				if(map[i][c.start]) {
					continue;
				}
				for(int j = c.start;j<=c.end;++j) {
					map[i][j] = true;
				}
				break;
			}
		}
	}

}
