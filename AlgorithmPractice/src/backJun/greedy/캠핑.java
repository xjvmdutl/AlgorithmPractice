package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class д╥гн {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;
		while(true) {
			String[] strs = reader.readLine().split(" ");
			int l = Integer.parseInt(strs[0]);
			int p = Integer.parseInt(strs[1]);
			int v = Integer.parseInt(strs[2]);
			if(l == 0 && p == 0 && v == 0)
				break;
			System.out.println("Case " + ++count + ": " + solution(l,p,v));
			
		}
	}

	private static int solution(int l, int p, int v) {
		int day = l*(v/p);
		v %= p;
		if(v < l)
			day += v;
		else
			day += l;
		return day;
	}

}
