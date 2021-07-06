package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ¹ÚÅÍ¶ß¸®±â {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] str = reader.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);
		System.out.println(solution(n,k));
	}

	private static int solution(int n, int k) {
		int sum = 0;
		int middle = n/k;
		int halfLength = k/2;
		int start = middle - halfLength;
		
		if(start<1)
			return -1;
		int end = middle + halfLength;
		System.out.println();
		if((end-start+1) % 2 == 0)
			start += 1;
		if((end-start+1) * middle <n)
			end++;
		
		return end-start;
		
	}

}
