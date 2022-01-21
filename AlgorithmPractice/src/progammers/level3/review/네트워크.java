package progammers.level3.review;

public class 네트워크 {
	public static int solution(int n, int[][] computers) {
        int answer = 0;
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//n	computers	return
		//3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]	2
		//3	[[1, 1, 0], [1, 1, 1], [0, 1, 1]]	1
		int n1 = 3;
		int[][] computers1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		System.out.println(solution(n1, computers1));
	
		int n2 = 3;
		int[][] computers2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		System.out.println(solution(n2, computers2));
	}

}
