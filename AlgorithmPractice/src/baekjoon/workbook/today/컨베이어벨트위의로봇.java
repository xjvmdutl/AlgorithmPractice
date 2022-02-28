package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 컨베이어벨트위의로봇 {
	public static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		tokens = new StringTokenizer(reader.readLine());
		int[] arr = new int[2*n];
		for(int i=0;i<2*n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr,n,k));
	}

	private static int solution(int[] arr, int n, int k) {
		int answer = 0;
		visit = new boolean[2 * n];
		int count = 0;
		while(count < k) {
			answer++;
			move(arr, n, k);
			checkLast(n);
			count = moveRobot(arr, n, k);
			checkLast(n);
			insertRobot(arr, 0);
			count = counting(arr);
		}
		return answer;
	}

	private static int counting(int[] arr) {
		int count = 0;
		for(int i=0;i < arr.length;++i)
			if(arr[i] <= 0) 
				count++;
			
		return count;
	}

	private static void checkLast(int n) {
		if(visit[n-1]) {
			visit[n-1] = false;
		}
	}

	private static void insertRobot(int[] arr, int start) {
		if(arr[start] > 0 && !visit[start]) {
			arr[start]--;
			visit[0] = true;
		}
	}

	private static int moveRobot(int[] arr, int n, int k) {
		int count = 0;
		for(int i=n-1;i>0;--i) {
			if(visit[i-1] && !visit[i] && arr[i] > 0) {
				arr[i]--;
				visit[i-1] = false;
				visit[i] = true;
			}
		}
		if(arr[0] <= 0)
			count++;
		return count;
	}

	private static void move(int[] arr, int n, int k) {
		int last = arr[2*n - 1];
		for(int i=2*n -1;i>0;--i) {
			arr[i] = arr[i-1];
			visit[i] = visit[i-1];
		}
		arr[0] = last;
		visit[0] = false;
	}

}
