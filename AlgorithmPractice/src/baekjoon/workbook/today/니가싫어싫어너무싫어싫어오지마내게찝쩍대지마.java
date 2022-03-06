package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
class Morse implements Comparable<Morse>{
	long start;
	long end;
	public Morse(long start, long end) {
		this.start = start;
		this.end = end;
	}
	@Override
	public int compareTo(Morse o) {
		if(this.end == o.end) {
			return Long.compare(this.start, o.start);
		}
		return Long.compare(this.end, o.end);
	}
}
public class ´Ï°¡½È¾î½È¾î³Ê¹«½È¾î½È¾î¿ÀÁö¸¶³»°ÔÂóÂ½´ëÁö¸¶ {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		long[][] arr= new long[n][2];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			arr[i][0] = Long.parseLong(tokens.nextToken());
			arr[i][1] = Long.parseLong(tokens.nextToken());
		}
		System.out.println(solution(arr, n));
	}

	private static String solution(long[][] arr, int n) {
		/**
		2 16
		2 4
		3 4
		8 10
		9 10
		 */
		StringBuilder sb = new StringBuilder();
		boolean isFirst = false;
		long max = 0;
		long start = 0;
		long end = 0;
		Arrays.sort(arr, (o1, o2)->{
			if(o1[0] == o2[0]) {
				return Long.compare(o1[1] , o2[1]);
			}
			return Long.compare(o1[0] , o2[0]);
		});
		Queue<Morse> pq = new PriorityQueue<>();
		for(int i=0;i<n;++i) {
			while(!pq.isEmpty() && arr[i][0] >= pq.peek().end) {
				
				pq.poll();
			}
			if(end < arr[i][0]) {
				isFirst = false;
			}
			pq.offer(new Morse(arr[i][0], arr[i][1]));
			if(max == pq.size() && isFirst) {
				end = pq.peek().end;
			}else if(max < pq.size()) {
				max = pq.size();
				isFirst = true;
				start = arr[i][0];
				end = pq.peek().end;
			}else {
				isFirst = false;
			}
		}
		sb.append(max + " \n");
		sb.append(start + " " + end);

		return sb.toString();
	}

}
