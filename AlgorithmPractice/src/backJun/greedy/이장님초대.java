package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ¿Ã¿Â¥‘√ ¥Î {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr= new int[n];
		String[] str = reader.readLine().split(" ");
		for(int i = 0;i<str.length;++i) {
			arr[i] = Integer.parseInt(str[i]);
		}
		System.out.println(solution(n,arr));
	}

	private static int solution(int n, int[] arr) {
		int answer = 0;
		int[] reverse = Arrays.stream(arr).boxed().sorted((o1,o2)->{
			return o2-o1;
		}).mapToInt(Integer::intValue).toArray();
		int day =1;
		for(int i=0;i<reverse.length;++i) {
			day++;
			answer = Math.max(answer, reverse[i] + day);
		}
		
		return answer;
	}

}
