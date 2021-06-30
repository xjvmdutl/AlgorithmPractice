package progammers.level1;

public class ÄÝ¶óÃ÷ÃßÃø {
	public static int solution(int num) {
		int answer = 0;
		long n = num;
		while(n!=1){
			if(answer >= 500){
				answer = -1;
			    break;
			}
			answer++;
			if(n%2 == 0){
				n/=2;
			}else{
				n = (n*3)+1;
			}
		}
	    return answer;
	}
	public static void main(String[] args) {
		int i = solution(626331);

	}

}
