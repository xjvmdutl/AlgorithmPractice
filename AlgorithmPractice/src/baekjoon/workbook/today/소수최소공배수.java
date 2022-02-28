package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class 소수최소공배수 {
	public static boolean[] sosu = new boolean[1000001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr, n));
	}

	private static long solution(int[] arr, int n) {
		long answer = 0;
		makeSosu();
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<n;++i) {
			if(!sosu[arr[i]]) {
				set.add(arr[i]);
			}
		}
		List<Integer> list = new ArrayList<>(set);
		Collections.sort(list);
		if(list.isEmpty()) {
			answer = -1;
		}else if(list.size() == 1) {
			answer = list.get(0);
		}else {
			long now = list.get(0);
			for(int i=1;i<list.size();++i) {
				long next = (long)list.get(i);
				long gcd = GCD(now, next);
				now = (now * next) / gcd;
			}
			answer = now;
		}
		return answer;
	}

	private static long GCD(long x, long y) {
		if(x == 0) {
			return y;
		}
		return GCD(y % x, x);
	}

	private static void makeSosu() {
		sosu[1] = true;
		sosu[0] = true;
		for(int i=2;i<sosu.length;++i) {
			for(int j=i+i;j<sosu.length;j += i) {
				sosu[j] = true;
			}
		}
	}

}
