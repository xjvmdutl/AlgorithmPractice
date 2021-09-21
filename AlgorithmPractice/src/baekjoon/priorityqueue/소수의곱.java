package baekjoon.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class ¼Ò¼öÀÇ°ö {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int k = Integer.parseInt(tokens.nextToken());
		int n = Integer.parseInt(tokens.nextToken());
		tokens = new StringTokenizer(reader.readLine());
		int[] arr = new int[k];
		for(int i=0;i<k;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr,n,k));
	}

	private static long solution(int[] arr, int n, int k) {
		Queue<Long> que = new PriorityQueue<>();
		for(int i=0;i<k;++i) {
			que.offer((long) arr[i]);
		}
		long answer = 0;
		while(n-- > 0) {
			answer = que.poll();
			for(int i=0;i<k;++i) {
				if ((answer * arr[i]) >= ((long) 2 << 30)) {
                    break;
                }
				que.offer(arr[i] * answer);
				if (answer % arr[i] == 0) {
                    break;
                }
			}
			
		}
		return answer;
	}

}
