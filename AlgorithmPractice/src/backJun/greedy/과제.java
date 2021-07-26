package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class °úÁ¦ {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][2];
		
		for(int i=0;i<n;++i) {
			String[] strs = reader.readLine().split(" ");
			int d = Integer.parseInt(strs[0]);
			int w = Integer.parseInt(strs[1]);
			arr[i][0] = d;
			arr[i][1] = w;
		}
		System.out.println(solution(arr,n));
	}

	private static int solution(int[][] arr, int n) {
		int answer = 0;
		Arrays.sort(arr,(o1,o2)->{
			if(o1[1] == o2[1])
				return o1[0]-o2[0];
			return o2[1] - o1[1];
		});
		int maxDay = 0;
		for(int i=0;i<arr.length;++i) {
			maxDay = Integer.max(maxDay, arr[i][0]);
		}
		int[] day = new int[maxDay];
		for(int i=0;i<arr.length;++i) {
			int weight = arr[i][1];
			int date = arr[i][0]-1;
			while(date >= 0  && day[date] >= arr[i][1]) {
				date--;
			}
			if(date < 0)
				continue;
			else
				day[date] = weight;
		}
		for(int i=0;i<day.length;++i)
			answer+= day[i];
		return answer;
	}
}
