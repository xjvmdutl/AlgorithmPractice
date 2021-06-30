package progammers.level2;

public class n진수게임 {
	public static String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        int turn = 0;
        int i = -1;
        while(answer.length() < t) {
        	i++;
        	int num = i;
        	StringBuilder nData = new StringBuilder();
        	if(i==0)
        		nData.append(i);
        	while(num>0) {
        		
        		nData.append(Integer.toHexString(num%n).toUpperCase());
        		num = num/n;
        	}        	
        	String result = nData.reverse().toString();
        	for(int j=0;j<result.length();++j) {
        		turn=turn+1;
        		if(answer.length() == t) {
    				return answer.toString();				
    			}
        		if(turn == p ) {
        			answer.append(result.charAt(j));
        		}
        		turn %= m;
        	}
        }
        return answer.toString();
    }
	public static void main(String[] args) {
		//n		t	m	p	result
		//2		4	2	1	"0111"
		//16	16	2	1	"02468ACE11111111"
		//16	16	2	2	"13579BDF01234567"
		int n1 = 2;
		int t1 = 4;
		int m1 = 2;
		int p1 = 1;

		int n2 = 16;
		int t2 = 16;
		int m2 = 2;
		int p2 = 1;
		
		int n3 = 16;
		int t3 = 16;
		int m3 = 2;
		int p3 = 2;
		
		System.out.println(solution(n1, t1, m1, p1));
		System.out.println(solution(n2, t2, m2, p2));
		System.out.println(solution(n3, t3, m3, p3));
	}

}
