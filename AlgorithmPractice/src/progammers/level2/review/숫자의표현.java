package progammers.level2.review;

public class 숫자의표현 {
	public static int answer;
	public static int solution(int n) {
		answer = 0;
        for(int i=1;i<=n;++i) {
        	dfs(i,0,n);
        }
        return answer;
    }
	private static void dfs(int index, int sum, int n) {
		if(sum >= n) {
			if(sum == n)
				answer++;
			return;
		}
		sum += index;
		dfs(index+1, sum, n);
	}
	public static void main(String[] args) {
		//n	result
		//15	4
		System.out.println(solution(15));
	}

}
