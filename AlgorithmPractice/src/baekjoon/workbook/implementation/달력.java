package baekjoon.workbook.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ดÞทย {
	private final static int LAST_DAY = 365;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][2];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr, n));
	}

	private static int solution(int[][] arr, int n) {
		Arrays.sort(arr, (o1, o2)-> {
			if(o1[0] == o2[0]) {
				return o2[1] - o1[1];
			}
			return o1[0] - o2[0];
		});
		int[] calendar = getCalendar();
		for(int i=0;i<arr.length;++i) {
			int start = arr[i][0];
			int end = arr[i][1];
			fill(calendar, start, end);
		}
		int answer = calculator(calendar); 
		return answer;
	}

	private static int[] getCalendar() {
		int[] calendar  = new int[LAST_DAY + 1];
		return calendar;
	}
	private static void fill(int[] calendar, int start, int end) {
		for(int i=start;i<=end;++i)
			calendar[i] += 1;
	}
	private static int calculator(int[] calendar) {
		int max = 0;
		int start = 0;
		int answer = 0;
		for(int i=1;i<=LAST_DAY;++i) {
			if(isZero(calendar[i])) {
				answer += max * (i - start); 
				max = 0;
				start = i;
			}else if(isLastIndex(i)) {
				if(isZero(max)) {
					start = i;
				}
				max = Math.max(max, calendar[i]);
				answer += max * (i - start + 1); 
				
			}else if (isZero(max)){
				start = i;
				max = calendar[i]; 
			}else if(!isZero(max)){
				max = Math.max(max, calendar[i]);
			}
		}
		return answer;
	}

	private static boolean isLastIndex(int index) {
		return index == LAST_DAY;
	}

	private static boolean isZero(int coting) {
		return coting == 0;
	}
	

}
