package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연료채우기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr= new int[n][2];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
		}
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int l = Integer.parseInt(tokens.nextToken());
		int p = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(arr,n,l,p));
	}

	private static int solution(int[][] arr, int n, int l, int p) {
		int answer = 0;
		Arrays.sort(arr,(o1,o2)->{
			if(o1[0] == o2[0])
				return o2[1] - o1[1];
			return o1[0] -o2[0];
		});
		Queue<Integer> que = new PriorityQueue<>((o1,o2)->o2-o1);
		int road = p;
		int cnt = 0;
		for(int i=0;i<n;++i) {
			if(road >= arr[i][0]) {
				que.offer(arr[i][1]);
				continue;
			}else {
				if(!que.isEmpty()) {
					i--;
					cnt++;
					road += que.poll();
				}else {
					return -1;
				}
				continue;
			}
		}
		while(road < l) {
			if(que.isEmpty())
				return -1;
			int w = que.poll();
			cnt++;
			road += w;
		}
		return cnt;
	}

}
