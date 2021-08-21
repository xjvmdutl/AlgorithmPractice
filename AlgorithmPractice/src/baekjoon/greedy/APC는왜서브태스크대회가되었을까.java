package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class APC는왜서브태스크대회가되었을까 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		int n = Integer.parseInt(strs[0]);
		int l = Integer.parseInt(strs[1]);
		int k = Integer.parseInt(strs[2]);
		int[][] arr = new int[n][2];
		for(int i =0;i<n;++i) {
			strs = reader.readLine().split(" ");
			arr[i][0] = Integer.parseInt(strs[0]);
			arr[i][1] = Integer.parseInt(strs[1]);
		}
		System.out.println(solution(n,l,k,arr));
	}

	private static int solution(int n, int l, int k, int[][] arr) {
		int answer = 0;
		Arrays.sort(arr,(o1,o2)->{
			if(o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}else {
				return o1[0] - o2[0];
			}
		});
		
		for(int i=0;i<arr.length;++i) {
			if(k<=0)
				break;
			if(l < arr[i][0]) {
				break;
			}else if(l<arr[i][1]) {
				answer+=100;
			}else {
				answer+=140;
			}
		}
		return answer;
	}

}
