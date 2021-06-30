package progammers.level2;

public class 점프와순간이동 {
	public static int ans;
	public static int solution(int n) {
        int ans = 0;
        while(n>0) {
        	if(n%2==1) {
        		ans++;
        		n-=1;
        	}else {
        		n/=2;
        	}
        }
        
        return ans;
    }
	public static void main(String[] args) {
		//N	result
		//5	2
		//6	2
		//5000	5
		int N1 = 5;
		int N2 = 6;
		int N3 = 5000;
		System.out.println(solution(N1));
		System.out.println(solution(N2));
		System.out.println(solution(N3));
	}

}
