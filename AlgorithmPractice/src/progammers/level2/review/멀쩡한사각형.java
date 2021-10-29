package progammers.level2.review;


public class 멀쩡한사각형 {
	 public static long solution(int w, int h) {
        long answer = 0;
        long gcd = gcd(w, h);
        answer = (long)w * (long)h - ((long)w + (long)h - gcd);
        return answer;
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
		int w = 3;
		int h = 5;
		System.out.println(solution(w,h));
	}

}
