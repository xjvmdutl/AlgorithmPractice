package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 공주님의정원 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][2];
		for(int i = 0;i < n; ++i) {
			String[] strs = reader.readLine().split(" ");
			int m1 = Integer.parseInt(strs[0]) * 100;
			int n1 = Integer.parseInt(strs[1]);
			int m2 = Integer.parseInt(strs[2]) * 100;
			int n2 = Integer.parseInt(strs[3]);
			arr[i][0] = m1 + n1;
			arr[i][1] = m2 + n2;
		}
		System.out.println(solution(arr,n));
	}

	private static int solution(int[][] arr, int n) {
		int answer = 0;
		Arrays.sort(arr,(o1,o2)->{
			if(o1[0] == o2[0])
				return o1[1] - o2[1];
			return o1[0] - o2[0];
		});
		int start = 301;
		int max = 0;
		int idx = 0;
		while(start<1201) {
			max = 0;
			boolean flag = false;
			for(int i=idx;i<arr.length;++i) {
				if(arr[i][0] > start) break;
				if(arr[i][0] <= start && arr[i][1] > max ) {
					max = arr[i][1];
					idx = i + 1;
					flag = true;
				}
			}
			if(flag) {
				start = max;
				answer += 1;
			}else {
				break;
			}
		}
		if(max < 1201)
			answer = 0;
		return answer;
	}
}
