package progammers.level2.review;

public class n진수게임 {
	public static String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder sb= new StringBuilder();
        int count = 0;
        sb.append("0");
        while(sb.length() <= m*t) {
        	StringBuilder nBinary = new StringBuilder();
        	int tmpCount = count;
        	while(tmpCount > 0) {
        		nBinary.append(Integer.toString(tmpCount%n, n));
        		tmpCount/=n;
        	}
        	count++;
        	sb.append(nBinary.reverse().toString());
        }
        int index = p-1 ;
        for(int i=0;i<t;++i) {//1,3,5,7
        	answer += String.valueOf(sb.charAt(index));
        	index+=m;
        }
        return answer.toUpperCase();
    }
	public static void main(String[] args) {
		//n		t	m	p	result
		//2		4	2	1		"0111"
		//16	16	2	1	"02468ACE11111111"
		//16	16	2	2	"13579BDF01234567"
		int n1 = 2;
		int t1 = 4;
		int m1 = 2;
		int p1 = 1;
		System.out.println(solution(n1,t1,m1,p1));
		int n2 = 16;
		int t2 = 16;
		int m2 = 2;
		int p2 = 1;
		System.out.println(solution(n2,t2,m2,p2));
		int n3 = 16;
		int t3 = 16;
		int m3 = 2;
		int p3 = 2;
		System.out.println(solution(n3,t3,m3,p3));
	}

}
