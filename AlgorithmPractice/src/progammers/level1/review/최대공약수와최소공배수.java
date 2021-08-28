package progammers.level1.review;

public class 최대공약수와최소공배수 {
	public static int[] solution(int n, int m) {
        int[] answer = new int[2];
        int lcm = LCM(n,m);
        answer[0] = lcm;
        answer[1] = n * m / lcm;
        return answer;
    }
	
	private static int LCM(int x, int y) {
		if(x == 0) {
			return y;
		}
		return LCM(y%x , x);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//n	m	return
		//3	12	[3, 12]
		//2	5	[1, 10]
		System.out.println(solution(3,12));
		System.out.println(solution(2,5));
	}

}
