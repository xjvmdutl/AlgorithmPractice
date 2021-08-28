package progammers.level1.review;

public class ÇÏ»þµå¼ö {
	public static boolean solution(int x) {
        int sum = 0;
        int tmp = x;
        while(tmp > 0) {
        	sum += tmp%10;
        	tmp/=10;
        }
        return x % sum == 0 ? true : false;
    }
	public static void main(String[] args) {
		//arr	return
		//10	true
		//12	true
		//11	false
		//13	false
		System.out.println(solution(10));
		System.out.println(solution(12));
		System.out.println(solution(11));
		System.out.println(solution(13));
	}

}
