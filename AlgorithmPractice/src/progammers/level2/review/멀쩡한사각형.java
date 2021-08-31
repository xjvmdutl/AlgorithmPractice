package progammers.level2.review;


public class 멀쩡한사각형 {
	public static long solution(int w, int h) {
        long answer = 0;
        long n = gcd(w,h);
        return (w*h) - (((long) w / n) + ((long) h / n) - 1) * n;
    }
	private static long gcd(long x, long y) {
		if(x == 0)
			return y;
		else
			return gcd(y%x, x);
	}
	public static void main(String[] args) {
		//W	H	result
		//8	12	80
		int w = 8;
		int h = 12;
		System.out.println(solution(100000000,100000000));
	}

}
