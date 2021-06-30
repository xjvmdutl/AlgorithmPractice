package progammers.level1;

public class 정수제곱근판별 {
	public static long solution(long n) {
		long answer = 0;
		long root=(long)Math.sqrt(n);
		if(root*root==n) {
			answer=(root+1)*(root+1);
		}else {
			answer=-1;
		}
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long l = solution(121);
	}

}
