package progammers.level1.review;

public class 약수의합 {
	 public static int solution(int n) {
        int answer = 0;
        for(int i=1;i<=n;++i) {
        	if(n%i == 0)
        		answer+=i;
        }
        return answer;
    }
	public static void main(String[] args) {
		//n	return
		//12	28
		//5	6
		int n1 = 12;
		int n2 = 5;
		System.out.println(solution(n1));
		System.out.println(solution(n2));
	}

}
