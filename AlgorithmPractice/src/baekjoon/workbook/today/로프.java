package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ทฮวม {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;++i)
			arr[i] = Integer.parseInt(reader.readLine());
		System.out.println(solution(arr,n));
	}

	private static int solution(int[] arr, int n) {
		int answer = 0;
		int[] reverse = Arrays.stream(arr).boxed().sorted((o1,o2)->o2-o1).mapToInt(Integer::intValue).toArray();
		for(int i=0;i<n;++i) {
			answer = Math.max(answer, reverse[i]*(i+1));
		}
		return answer;
	}

}
