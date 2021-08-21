package baekjoon.stepbystep.fortest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ºü¸¥APlusB {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(reader.readLine());
		for(int i=0;i<t;++i) {
			String[] strs = reader.readLine().split(" ");
			int a = Integer.parseInt(strs[0]);
			int b = Integer.parseInt(strs[1]);
			writer.write(solution(a,b) + "\n");
		}
		writer.flush();
	}

	private static int solution(int a, int b) {
		return a+b;
	}

}
