package progammers.level2.review;

public class 피보나치수 {
	
	public static int solution(int n) {
        int answer = 0;
        int[] numbers = new int[n+1];
        numbers[0] = 0;
        numbers[1] = 1;
        for(int i=2;i<=n;++i) {
        	numbers[i] = (numbers[i-1] + numbers[i-2])%1234567;
        }
        answer = numbers[n];
        return answer;
    }
	public static void main(String[] args) {
		//n	return
		//3	2
		//5	5
		System.out.println(solution(3));
		System.out.println(solution(5));
	}

}
