package progammers.golevelkit;

public class 카펫 {
	public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int i=1;i<=yellow/2;++i) {
        	if(yellow%i == 0) {
        		int x = yellow/i; // 가로
        		int y = i;        // 세로
        		int brownX = x + 2;
        		int brownY = y + 2;
        		if((brownX * brownY) - (x * y) == brown) {
        			answer[0] = brownX;
        			answer[1] = brownY;
        			return answer;
        		}
        	}
        }
        answer[0] = yellow + 2;
        answer[1] = 3;
        return answer;
    }
	public static void main(String[] args) {
		//brown	yellow	return
		//10	2	[4, 3]
		//8	1	[3, 3]
		//24	24	[8, 6]
		System.out.println(solution(10,2));
		System.out.println(solution(8,1));
		System.out.println(solution(24,24));
	}

}
