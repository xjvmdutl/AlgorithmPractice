package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 캥거루세마리2 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str = reader.readLine();
			if(str == "")
				break;
			String[] strs = str.split(" ");
			int[] arr = new int[strs.length];
			for(int i=0;i<arr.length;++i) {
				arr[i] = Integer.parseInt(strs[i]);
			}
			System.out.println(solution(arr));
		}
	}

	private static int solution(int[] arr) {
		int answer = 0;
		
		while(true) {
			int middle = arr[1];
			if(middle - arr[0] == 1
					&& arr[2] - middle == 1)
				break;
			if(arr[1] - middle < arr[2] - middle) {
				arr[0] = arr[1];
				arr[1] = arr[1]+1;
			}else {
				arr[2] = arr[1];
				arr[1] = arr[2]-1;
			}
			answer++;
		}
		
		return answer;
	}

}
