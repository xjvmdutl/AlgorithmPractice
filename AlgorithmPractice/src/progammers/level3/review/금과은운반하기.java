package progammers.level3.review;

public class 금과은운반하기 {
	public static long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {

		long answer = (long) Math.pow(10, 9) * (long) Math.pow(10, 5) * 4;
        long start = 0;
        long end = (long) Math.pow(10, 9) * (long) Math.pow(10, 5) * 4;
        while(start <= end) {
        	long mid = (start + end) / 2;
        	long gMax = 0;
        	long sMax = 0;
        	long add = 0;
        	for(int i=0;i<t.length;++i) {
        		long move = mid/(t[i]*2);
        		if(mid%(t[i]*2) >= t[i]) {
        			move++;
        		}
        		gMax += (g[i] < move * w[i]) ?  g[i] : move * w[i];
        		sMax += (s[i] < move * w[i]) ?  s[i] : move * w[i];
        		add += (g[i] + s[i] < move * w[i]) ? g[i] + s[i] : move * w[i];
        	}
        	if(gMax >= a && sMax >= b && add >= a + b) {
        		answer = Math.min(answer, mid);
        		end = mid - 1;
        	}else {
        		start = mid + 1;
        	}
        }
        
        return answer;
    }
	public static void main(String[] args) {
		//a	b	g	s	w	t	result
		//10	10	[100]	[100]	[7]	[10]	50
		//90	500	[70,70,0]	[0,0,500]	[100,100,2]	[4,8,1]	499
		int[] g1 = {100};
		int[] s1 = {100};
		int[] w1 = {100};
		int[] t1 = {100};
		System.out.println(solution(10,10,g1,s1,w1,t1));
	}

}
