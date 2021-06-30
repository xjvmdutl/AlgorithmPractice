package progammers.level2;

public class 숫자의표현 {
	public static int answer = 0;
	 public static int solution(int n) {
        for(int i=1; i<= n;++i) {
        	dfs(i,n);
        }
        return answer;
    }
	public static void dfs(int i, int n) {
		if(n - i == 0) {
			++answer;
			return;
		}
		if(n-i > 0) {
			dfs(i+1,n-i);
		}
	}
	public static void main(String[] args) {
		int n = 15;
		System.out.println(solution(n));
	}

}
