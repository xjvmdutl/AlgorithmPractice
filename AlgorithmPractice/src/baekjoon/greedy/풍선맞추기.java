package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ç³¼±¸ÂÃß±â {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		String[] strs = reader.readLine().split(" ");
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(strs[i]);
		}
		System.out.println(solution(arr,n));
	}

	private static int solution(int[] arr, int n) {
		int answer = 0;
		int[] cnt = new int[1000001];
		for(int i=0;i<arr.length;++i) {
			if (cnt[arr[i]+1] == 0) {
				cnt[arr[i]]++;
				answer++;
			}else {
				cnt[arr[i]+1]--;
				cnt[arr[i]]++;
			}
		}
		
		return answer;
	}

}
