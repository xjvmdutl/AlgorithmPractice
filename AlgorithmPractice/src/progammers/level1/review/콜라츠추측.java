package progammers.level1.review;

public class ÄÝ¶óÃ÷ÃßÃø {
	public static int solution(int num) {
        int answer = 0;
        long tmpNum = num;
        while(tmpNum != 1) {
        	if(tmpNum%2==0)
        		tmpNum /= 2;
        	else
        		tmpNum = tmpNum * 3 + 1;
        	if(answer >= 500) {
        		answer = -1;
        		break;
        	}
        	answer++;
        }
        return answer;
    }
	public static void main(String[] args) {
		//n	result
		//6	8
		//16	4
		//626331	-1
		System.out.println(solution(6));
		System.out.println(solution(16));
		System.out.println(solution(626331));
	}

}
