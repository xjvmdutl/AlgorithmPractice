package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ProjectTeams {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n*2];
		String[] strs = reader.readLine().split(" ");
		for(int i=0;i<n*2;++i) {
			arr[i] = Integer.parseInt(strs[i]);
		}
		System.out.println(solution(n,arr));
	}

	private static int solution(int n, int[] arr) {
		int[] reverse = Arrays.stream(arr).boxed().sorted((o1,o2)->o2-o1).mapToInt(Integer::intValue).toArray();
		int answer = Integer.MAX_VALUE;
		Arrays.sort(arr);
		for(int i=0;i<n;++i) {
			answer = Math.min(answer, reverse[i] + arr[i]);
		}
		return answer;
	}

}
