package progammers.level1.review;

public class 진법3뒤집기 {
	public static int solution(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
        	sb.append(n % 3);
        	n /= 3;
        }
        return Integer.parseInt(sb.toString(),3);
    }
	public static void main(String[] args) {
		//n	result
		//45	7
		//125	229
		int n1 = 45;
		int n2 = 125;
		System.out.println(solution(n1));
		System.out.println(solution(n2));
	}

}
