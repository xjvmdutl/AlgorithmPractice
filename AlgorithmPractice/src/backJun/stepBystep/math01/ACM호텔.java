package backJun.stepBystep.math01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ACMÈ£ÅÚ {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for(int i=0;i<t;++i) {
			String[] strs = reader.readLine().split(" ");
			int h = Integer.parseInt(strs[0]);
			int w = Integer.parseInt(strs[1]);
			int n = Integer.parseInt(strs[2]);
			System.out.println(solution(h,w,n));
		}
	}

	private static int solution(int h, int w, int n) {
		
		
		int telnum = 0;
		telnum += (((n-1)%h)+1) * 100;
		
		int ho= (n-1)/h + 1;
		
		return ho + telnum;
	}

}
