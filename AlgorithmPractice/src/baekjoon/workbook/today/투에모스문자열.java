package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 투에모스문자열 {
	public static long[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Long k = Long.parseLong(reader.readLine());
		arr= new long[64];
		arr[0] = 1;
	
		for(int i=1;i<arr.length;++i)
			arr[i] = arr[i-1] * 2;
		System.out.println(solution(k));
	}

	private static int solution(long k) {
		if(k == 1)
			return 0;
		long n = 0;
		for (int i = 0; i < arr.length; ++i) {
            if (k > arr[i])
            	n = arr[i];
            else
            	break;
        }
		return 1 - solution(k - n);
	}

}
