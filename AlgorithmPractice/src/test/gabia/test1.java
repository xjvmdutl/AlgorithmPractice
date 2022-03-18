package test.gabia;

public class test1 {

	public static void main(String[] args) {
		int mod1 = 4;
		int mod2 = 3;
		int max_range = 20;
		System.out.println(solution(mod1, mod2, max_range));
		System.out.println(solution(3, 4, 20));
	}

	private static int solution(int mod1, int mod2, int max_range) {
		int answer = max_range / mod1;
		int gcd = GCD(Math.max(mod1, mod2), Math.min(mod1, mod2));
		int num = (mod1 * mod2) / gcd;
		answer -= max_range/num;
		return answer;
	}

	private static int GCD(int x, int y) {
		if(y == 0) {
			return x;
		}
		return GCD(y, x%y);
	}

}
