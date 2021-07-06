package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ¹°º´ {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		int n = Integer.parseInt(strs[0]);
		int k = Integer.parseInt(strs[1]);
		System.out.println(solution(n,k));
	}

	private static int solution(int n, int k) {
		int count = Integer.bitCount(n);
		int bottles_merged = (int)Math.pow(2, Integer.toBinaryString(n).length() -1);
		int bottles_left = n - bottles_merged;
		int new_bottle= 0;
		while(count > k 
				&& bottles_merged > bottles_left) {
			bottles_left += 1;
			new_bottle += 1;
			count = Integer.bitCount(bottles_left) + 1;
		}
		
		return new_bottle;
	}

}
