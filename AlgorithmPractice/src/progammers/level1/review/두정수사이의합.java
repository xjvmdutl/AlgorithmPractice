package progammers.level1.review;

public class 두정수사이의합 {
	public static long solution(int a, int b) {
        long answer = 0;
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        for(int i=min;i<=max;++i) {
        	answer+=i;
        }
        return answer;
    }
	public static void main(String[] args) {
		//a	b	return
		//3	5	12
		//3	3	3
		//5	3	12
		int a1 = 3;
		int a2 = 3;
		int a3 = 5;
		int b1 = 5;
		int b2 = 3;
		int b3 = 3;
		System.out.println(solution(a1,b1));
		System.out.println(solution(a2,b2));
		System.out.println(solution(a3,b3));
	}
}
