package backJun.stepBystep.oneArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ÃÖ´ñ°ª {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9];
		for(int i=0;i<9;++i)
			arr[i] = Integer.parseInt(reader.readLine());
		System.out.println(solution(arr));
	}

	private static String solution(int[] arr) {
		StringBuilder sb = new StringBuilder();
		int max = arr[0];
		int maxPos = 1;
		for(int i=1;i<arr.length;++i) {
			if(max < arr[i]) {
				maxPos = i+1;
				max = arr[i];
			}
		}
		sb.append(max + "\n" + maxPos);
		return sb.toString();
	}

}
