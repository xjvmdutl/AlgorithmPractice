package backJun.stepBystep.funcTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ÇÑ¼ö {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int cnt = 0;
		for(int i=1;i<=n;++i) {
			boolean ischk = hansu(i);
			if(ischk)
				cnt++;
		}
		System.out.println(cnt);
	}

	private static boolean hansu(int num) {
		boolean ischk = true;
		if(num < 100)
			return ischk;
		int first = num %10;
		num /= 10;
		int tmp = num % 10;
		num /= 10;
		int l = tmp - first;
		while(num > 0) {
			int data = num%10;
			num/=10;
			if(l != data - tmp) {
				return false;
			}
			tmp = data;
		}
		
		return ischk;
	}
}
