package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Á¢µÎ»ç {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		String[] arr = new String[n];
		for(int i=0;i<n;++i) {
			arr[i] = reader.readLine();
		}
		
		System.out.println(solution(arr,n));
	}

	private static int solution(String[] arr, int n) {
		int answer = 0;
		Arrays.sort(arr);
		Set<String> set = new HashSet<>();
		for(int i=0;i<n;++i) {
			String now = arr[i];
			int count = 0;
			for(int j=0;j<n;++j) {
				if(i != j) {
					String next = arr[j];
					if(now.length() < next.length()) {
						if(!next.startsWith(now)) {
							count++;
						}
					}else {
						count++;
					}
				}
			}
			if(count == n-1) {
				set.add(now);
			}
		}
		return set.size();
	}

}
