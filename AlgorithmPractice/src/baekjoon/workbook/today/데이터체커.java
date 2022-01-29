package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
class Circle implements Comparable<Circle>{
	int start;
	int end;
	public Circle(int start, int end) {
		this.start = start;
		this.end = end;
	}
	@Override
	public int compareTo(Circle o) {
		if(o.start == this.start)
			return this.end - o.end;
		return this.start - o.start;
	}
}
public class 데이터체커 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][2];
		for(int i = 0 ;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr,n));
	}

	private static String solution(int[][] arr, int n) {
		String answer = "YES";
		Queue<Circle> pq = new PriorityQueue<>();

		for(int i=0;i<arr.length;++i) {
			pq.offer(new Circle(arr[i][0] - arr[i][1] ,arr[i][0] + arr[i][1]));
		}
		Circle now = pq.poll();
		
		while(!pq.isEmpty()) {
			Circle c = pq.poll();
			if(c.start <= now.end && now.end <= c.end) {
				return "NO";
			}
			now = c;
		}
		
		return answer;
	}

}
