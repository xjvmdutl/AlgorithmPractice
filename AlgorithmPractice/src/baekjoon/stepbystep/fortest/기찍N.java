package baekjoon.stepbystep.fortest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ±âÂïN {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		for(int i=n;i>=1;--i) {
			System.out.println(i);
		}
	}

}
