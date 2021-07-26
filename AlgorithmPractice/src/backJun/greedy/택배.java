package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ец╧Х {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		int n = Integer.parseInt(strs[0]);
		int c = Integer.parseInt(strs[1]);
		int m = Integer.parseInt(reader.readLine());
		int[][] arr = new int[m][3];
		for(int i=0;i<m;++i) {
			strs = reader.readLine().split(" ");
			arr[i][0] = Integer.parseInt(strs[0]);
			arr[i][1] = Integer.parseInt(strs[1]);
			arr[i][2] = Integer.parseInt(strs[2]);
			}
		System.out.println(solution(n,c,m,arr));
	}

	private static int solution(int n, int c, int m, int[][] arr) {
		int answer = 0;
		Arrays.sort(arr,(o1,o2)->{
			if(o1[1] == o2[1])
				return o1[0] - o2[0];
			return o1[1] - o2[1];
		});
		
		int[] weights = new int[n];
		for(int i=0;i<n;++i) {
			weights[i] = c;
		}
		for(int i=0;i<arr.length;++i) {
			int start = arr[i][0] - 1;
			int end = arr[i][1] - 1;
			int maxNum = Integer.MAX_VALUE;
			for(int j=start;j<end;++j)
				maxNum = Math.min(maxNum, weights[j]);
			if(maxNum >= arr[i][2]) {
				for(int j=start;j<end;++j) 
					weights[j] -= arr[i][2];
				answer += arr[i][2];
			}else {
				for(int j=start;j<end;++j) 
					weights[j] -= maxNum;
				answer += maxNum;
			}
		}
		
		return answer;
	}

}
