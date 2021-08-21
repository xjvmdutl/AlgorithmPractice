package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class µµ¼­°ü {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		int n = Integer.parseInt(strs[0]);
		int m = Integer.parseInt(strs[1]);
		int[] arr = new int[n];
		strs = reader.readLine().split(" ");
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(strs[i]);
		}
		System.out.println(solution(arr,n,m));
		
	}

	private static int solution(int[] arr, int n, int m) {
		int answer = 0;
		Arrays.sort(arr);
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		for(int i=0;i<arr.length;++i) {
			if(arr[i] > 0) {
				list1.add(arr[i]);
			}else {
				list2.add(arr[i]*-1);
			}
		}
		int idx = list1.size()-1;
		boolean flag = true;
		int max = 0;
		while(idx >= 0 ) {
			int data = list1.get(idx);
			if(flag) {
				flag = false;
				max = data;
			}
			answer += data*2;
			idx -= m;
		}
		idx = list2.size()-1;
		Collections.sort(list2);
		flag = true;
		while(idx >= 0 ) {
			int data = list2.get(idx);
			if(flag) {
				flag = false;
				max = Math.max(max, data);
			}
			answer += data*2;
			idx -= m;
		}
		answer -= max;
		return answer;
	}

}
