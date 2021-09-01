package progammers.level2.review;

public class Ä«Æê {
	public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int i=1;i<=yellow;++i) {
        	if(yellow%i == 0) {
        		int n = i;
        		int m = yellow/i;
        		int brownN = n+2;
        		int brownM = m+2;
        		if(brown == (brownN * brownM) - (n * m)) {
        			answer[0] = brownM;
        			answer[1] = brownN;
        			break;
        		}
        	}
        }
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
