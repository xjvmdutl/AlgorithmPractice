package progammers.level2;

import java.math.BigInteger;

public class 멀쩡한사각형 {
	
	public static long solution(int w, int h) {
		int gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();
		return ((((long) w / gcd) + ((long) h / gcd) - 1) * gcd);
    }
	public static void main(String[] args) {
//		W	H	result
//		8	12	80
		int W = 8;
		int H = 12;
		System.out.println(solution(W, H));
	}

}
