package progammers.level1;

public class 자리수더하기 {
	public int solution(int n) {
        int answer = 0;
        while(n>0){
            answer += n%10;
            n/=10;
        }
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
