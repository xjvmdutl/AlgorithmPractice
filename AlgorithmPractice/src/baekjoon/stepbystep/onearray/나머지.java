package baekjoon.stepbystep.onearray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class ³ª¸ÓÁö {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[10];
		for(int i=0;i<arr.length;++i)
			arr[i] = Integer.parseInt(reader.readLine());
		System.out.println(solution(arr));
	}

	private static int solution(int[] arr) {
		HashSet<Integer> set = new HashSet<>();
		for(int i=0;i<arr.length;++i) {
			int remainder = arr[i] % 42;
			if(!set.contains(remainder))
				set.add(remainder);
		}
		return set.size();
	}
	
}
