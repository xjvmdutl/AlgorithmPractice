package progammers.level2.review;

public class 점프와순간이동 {
	public static int solution(int n) {
        int ans = 0;
        while( n > 0) {
        	if(n%2 == 1) {
        		ans++;
        	}
        	n/=2;
        }
	    return ans;
	}
	public static void main(String[] args) {
		//N	result
		//5	2
		//6	2
		//5000	5
		System.out.println(solution(5));
		System.out.println(solution(6));
		System.out.println(solution(5000));
	}

}
