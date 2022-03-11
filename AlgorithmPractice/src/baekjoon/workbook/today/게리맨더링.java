package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 게리맨더링 {
	public static boolean[] visit;
	public static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(reader.readLine());
		List<Integer>[] map = new ArrayList[n];
		int[] arr = new int[n];
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<arr.length;++i) {
			map[i] = new ArrayList<Integer>();
			arr[i] = Integer.parseInt(tokens.nextToken());// 인구
		}
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int m = Integer.parseInt(tokens.nextToken());
			for(int j=0;j<m;++j) {
				map[i].add(Integer.parseInt(tokens.nextToken()) - 1);
			}
		}
		System.out.println(solution(map, arr, n));
		
	}

	private static int solution(List<Integer>[] map, int[] arr, int n) {
		answer  = Integer.MAX_VALUE;
		visit = new boolean[n];
		permulate(map, arr, 0, n);
		return answer == Integer.MAX_VALUE ? -1 : answer;
	}

	private static void permulate(List<Integer>[] map, int[] arr, int count, int n) {
		if(count == n) {
			if(check(map, arr, n)) {
				int sum1 = 0;
				int sum2 = 0;
				for(int i=0;i<n;++i) {
					if(!visit[i]) sum1 += arr[i];
					else sum2 += arr[i];
				}
				answer = Math.min(answer, Math.abs(sum1 - sum2));
			}
			return;
		}
		visit[count] = true; // 선거 구역 선택
		permulate(map, arr, count+1, n);
		
		visit[count] = false; //선거 구역 선택 X
		permulate(map, arr, count+1, n);
	}

	

	private static boolean check(List<Integer>[] map, int[] arr, int n) {
		boolean[] vst = new boolean[n];
		int areaA = -1;
		for(int i=0;i<n;++i) {
			if(visit[i]) {
				areaA = i;
				break;
			}
		}
		int areaB = -1;
		for(int i=0;i<n;++i) {
			if(!visit[i]) {
				areaB = i;
				break;
			}
		}
		if(areaA == -1 || areaB == -1)
			return false;
		
		Queue<Integer> Aarea = new LinkedList<>();
		Aarea.offer(areaA);
		vst[areaA] = true;
		while(!Aarea.isEmpty()) {
			int now = Aarea.poll();
			for(int next : map[now]) {
				if(!vst[next] && visit[next]) {
					vst[next] = true;
					Aarea.offer(next);
				}
			}
		}
		
		Queue<Integer> Barea = new LinkedList<>();
		vst[areaB] = true;
		Barea.offer(areaB);
		while(!Barea.isEmpty()) {
			int now = Barea.poll();
			for(int next : map[now]) {
				if(!vst[next] && !visit[next]) {
					vst[next] = true;
					Barea.offer(next);
				}
			}
		}
		for(int i=0;i<n;++i) {
			if(!vst[i]) {
				return false;
			}
		}
		return true;
	}
}
