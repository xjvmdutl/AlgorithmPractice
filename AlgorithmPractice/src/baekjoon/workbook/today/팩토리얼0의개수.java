package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팩토리얼0의개수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(reader.readLine());
		System.out.println(solution(m));
	}

	private static int solution(int m) {
		int answer = Integer.MAX_VALUE;
		int start = 1;
		int end = 1000000000;
		while(start <= end) {
			int mid = (start+ end) /2;
			int count = getCount(mid);
			
			if(m <= count) {
				if(m == count) {
					answer = Math.min(answer, mid); 
				}
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		return answer == Integer.MAX_VALUE ? -1 : answer;
	}

	private static int getCount(int mid) {
		int count = 0 ;
		int tmp = mid;
		while(tmp >= 5) {
			tmp /= 5;
			count += tmp;
		}
		return count;
	}

}
