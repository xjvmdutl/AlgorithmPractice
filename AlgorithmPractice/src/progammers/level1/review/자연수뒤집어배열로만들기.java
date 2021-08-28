package progammers.level1.review;

public class 자연수뒤집어배열로만들기 {
	 public static int[] solution(long n) {
        int[] answer = new int[String.valueOf(n).length()];
        int idx = 0;
        while(n > 0) {
        	answer[idx++] = (int) (n%10);
        	n/=10;
        }
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(solution(12345));
	}

}
