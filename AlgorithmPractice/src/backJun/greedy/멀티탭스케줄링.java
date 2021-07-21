package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 멀티탭스케줄링 {
	/*
	testcase 모음

	2 7
	2 3 2 3 1 2 7
	답: 2

	2 5
	5 2 2 3 5
	답: 1

	2 4
	5 3 1 5
	답: 1

	3 6
	1 1 1 1 2 3
	답: 0

	3 8
	1 2 3 4 1 1 1 2
	답: 1

	2 15
	3 2 1 2 1 2 1 2 1 3 3 3 3 3 3
	답: 2

	1 3
	1 2 1
	답: 2
	*/
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		int n = Integer.parseInt(strs[0]);
		int k = Integer.parseInt(strs[1]);
		int[] arr = new int[k];
		strs = reader.readLine().split(" ");
		for(int i=0;i<k;++i)
			arr[i] = Integer.parseInt(strs[i]);
		System.out.println(solution(n,k,arr));
	}
	private static int solution(int n, int k, int[] arr) {
		int answer = 0;
		
		if(n >= k)
			return answer;
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<arr.length;++i) {
			if(list.contains(arr[i])) {
				continue;
			}
			if(list.size() < n) {
				list.add(arr[i]);
				continue;
			}
			boolean[] ischk = new boolean[list.size()];
			int deleteIdx = arr.length-1;
			for(int j=i;j<arr.length;++j) {
				int data = arr[j];
				if(list.contains(data)) {
					int idx = list.indexOf(data);
					if(!ischk[idx]) {
						ischk[idx] = true;
						deleteIdx = idx;
						continue;
					}
				}
			}
			boolean flag = true;
			for(int l=ischk.length-1;l>=0;--l) {
				if(ischk[l] == false) {
					list.remove(l);
					list.add(arr[i]);
					answer++;
					flag = false;
					break;
				}
			}
			if(flag) {
				list.remove(deleteIdx);
				list.add(arr[i]);
				answer++;
			}
		}
		return answer;
	}

}
