package backJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수들의합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		long s = Long.parseLong(reader.readLine());
		long sum = 0;
		int idx;
		for(idx=1;sum<s;++idx) {
			sum+=idx;
		}
		if(sum == s)
			System.out.println(--idx);
		else {
			idx -= 2;
			System.out.println(idx);
		}
	}

}
