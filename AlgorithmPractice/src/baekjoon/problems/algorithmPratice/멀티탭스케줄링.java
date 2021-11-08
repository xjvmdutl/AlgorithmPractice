package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 멀티탭스케줄링 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		int[] arr = new int[k];
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<k;++i)
			arr[i] = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(arr,n,k));
	}

	private static int solution(int[] arr, int n, int k) {
		int answer = 0;
		List<Integer> list = new ArrayList<>();
		if(n >= k)
			return answer;
		OUTER:for(int i=0;i<k;++i) {
			if(list.contains(arr[i]))
				continue;
			else if(list.size() < n) {
				list.add(arr[i]);
			}else {
				boolean[] remove = new boolean[list.size()];
				int removeIdx = arr.length-1;
				for(int j=i;j<arr.length;++j) {
					if(list.contains(arr[j])) {
						int index = list.indexOf((Integer)arr[j]);
						if(!remove[index]) {
							remove[index] = true;
							removeIdx = index;
						}
					}
				}
				for(int j=list.size()-1;j>=0;--j) {
					if(!remove[j]) {
						list.remove(j);
						answer++;
						list.add(arr[i]);
						continue OUTER;
					}
				}
				list.remove(removeIdx);
				answer++;
				list.add(arr[i]);
			}
		}
		return answer;
	}

}
