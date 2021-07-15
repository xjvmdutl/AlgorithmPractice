package backJun.stepBystep.ifTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 알람시계 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		int h = Integer.parseInt(strs[0]);
		int m = Integer.parseInt(strs[1]);
		System.out.println(solution(h,m));
	}

	private static String solution(int h, int m) {
		StringBuilder sb = new StringBuilder();
		if(m > 45) {
			m-=45;
			sb.append(h + " " + m);
		}else {
			m += 60;
			m -= 45;
			if(h == 0)
				h = 24;
			h -= 1;
			if(m == 60) {
				m = 0;
				h++;
				if(h == 24)
					h=0;
			}
			sb.append(h + " " + m);
		}
		
		
		return sb.toString();
	}

}
