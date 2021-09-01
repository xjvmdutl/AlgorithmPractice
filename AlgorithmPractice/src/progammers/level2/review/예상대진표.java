package progammers.level2.review;

public class 예상대진표 {
	 public static int solution(int n, int a, int b){
        int answer = 0;
        while(a != b) {
        	answer++;
        	a = (a+1) / 2;
        	b = (b+1) / 2;
        }

        return answer;
    }
	public static void main(String[] args) {
		//N		A		B		answer
		//8		4		7		3
		System.out.println(solution(8,1,7));
	}

}
