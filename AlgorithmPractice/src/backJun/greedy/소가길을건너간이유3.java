package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 소가길을건너간이유3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][2];
		for(int i =0;i<n;++i) {
			String[] str = reader.readLine().split(" ");
			arr[i][0] = Integer.parseInt(str[0]);
			arr[i][1] = Integer.parseInt(str[1]);
		}
		System.out.println(solution(arr,n));
	}

	private static int solution(int[][] arr, int n) {
		Arrays.sort(arr,(o1,o2)->{
			if(o1 == o2) {
				return o1[1] - o2[1];
			}else {
				return o1[0]-o2[0];
			}
		});
		int time = 0;
		int idx = 0;
		while(idx < arr.length) {
			if(time < arr[idx][0]) {
				time++;
				continue;
			}
			time += arr[idx++][1];
		}
		return time;
	}

}
