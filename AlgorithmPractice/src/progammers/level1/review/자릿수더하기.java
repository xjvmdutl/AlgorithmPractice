package progammers.level1.review;

public class 자릿수더하기 {
	public static int solution(int n) {
        int answer = 0;
        while(n>0) {
        	answer += n%10;
        	n/=10;
        }
        return answer;
    }
	public static void main(String[] args) {
		//N	answer
		//123	6
		//987	24
		System.out.println(solution(123));
		System.out.println(solution(987));
	}
}
