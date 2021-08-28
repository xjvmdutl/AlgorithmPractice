package progammers.level1.review;

public class 정수제곱근판별 {
	public static long solution(long n) {
		long l=(long) Math.sqrt(n);
		return l*l == n ? (l+1) * (l+1) : -1;
    }
	public static void main(String[] args) {
		//n	return
		//121	144
		//3	-1
		System.out.println(solution(121));
		System.out.println(solution(3));
	}

}
