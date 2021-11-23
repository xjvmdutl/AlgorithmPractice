package progammers.level3;

public class N으로표현 {
	public static int answer;
	public static int solution(int N, int number) {
        answer = Integer.MAX_VALUE;
        dfs(N,number,0,0);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
	private static void dfs(int n, int number, int count, int sum) {
		if(count > 8)
			return;
		if(number == sum) {
			answer = Math.min(answer, count);
		}
		int x = n;
		for(int i=1;i<=8;++i) {
			dfs(n, number, i+count, sum+x);
			dfs(n, number, i+count, sum-x);
			dfs(n, number, i+count, sum*x);
			dfs(n, number, i+count, sum/x);
			x = (10*x) + n;
		}
			
	}
	public static void main(String[] args) {
		int N=5;
		int number = 2;
		System.out.println(solution(N, number));
	}

}
