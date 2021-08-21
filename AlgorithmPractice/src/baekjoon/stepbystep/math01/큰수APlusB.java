package baekjoon.stepbystep.math01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Å«¼öAPlusB {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		BigInteger big1 = new BigInteger(strs[0]);
		BigInteger big2 = new BigInteger(strs[1]);
		System.out.println(solution(big1,big2));
	}

	private static BigInteger solution(BigInteger big1, BigInteger big2) {
		return big1.add(big2);
	
	
	}

}
