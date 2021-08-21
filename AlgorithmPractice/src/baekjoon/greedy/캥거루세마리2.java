package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 캥거루세마리2 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while((str = reader.readLine()) != null ) {
            String[] strs = str.split(" ");
            int[] arr = new int[strs.length];
            for(int i=0;i<3;++i) {
                arr[i] = Integer.parseInt(strs[i]);
            }
            System.out.println(solution(arr));
		}
	}

	private static int solution(int[] arr) {
		int answer = 0;
		int left = arr[0];
		int right = arr[2];
		int mid = arr[1];
		if(mid - left > right - mid) {
			while(true) {
				int tmp = mid;
				right = tmp;
				mid = mid -1;
				if(left == mid)
					break;
				answer++;
			}
		}else {
			while(true) {
				int tmp = mid;
				left = tmp;
				mid = mid + 1;
				if(right == mid)
					break;
				answer++;
			}
		}
		
		return answer;
	}

}
