package progammers.level2;

import java.util.StringTokenizer;

public class k진수에서소수개수구하기 {
	public static int solution(int n, int k) {
        int answer = 0;
        String kBinary = Integer.toString(n, k).replaceAll("0", " ");
        StringTokenizer tokens = new StringTokenizer(kBinary);
        while(tokens.hasMoreTokens()) {
        	if(isSosu(tokens.nextToken())) {
        		answer++;
        	}
        }
        return answer;
    }
	private static boolean isSosu(String number) {
		long num = Long.parseLong(number);
		if(num < 2)
			return false;
		for(long i=2; i*i <= num;++i ) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		//n			k	result
		//437674	3	3
		//110011	10	2
		System.out.println(solution(1000000,2));
		System.out.println(solution(110011, 10));
	}
}
