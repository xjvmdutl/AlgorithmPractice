package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열2 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr, n));
	}

	private static int solution(int[] arr, int n) {
		List<Integer> list = new ArrayList<>();
		list.add(arr[0]);
		for(int i=1;i<n;++i) {
			if(list.get(list.size()-1) < arr[i]) {
				list.add(arr[i]);
			}else {
				int start = 0;
				int end = list.size() - 1;
				while(start <= end) {
					int mid = (start + end) / 2;
					if(list.get(mid) < arr[i]) {
						start = mid + 1;
					}else {
						end = mid - 1;
					}
				}
				list.set(start, arr[i]);
			}
		}
		return list.size();
	}

}
