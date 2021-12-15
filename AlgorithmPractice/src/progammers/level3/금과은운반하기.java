package progammers.level3;

public class 금과은운반하기 {
	public static long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = (long) Math.pow(10, 9) * (long) Math.pow(10, 5) * 4;
        long start = 0;
        long end = (long) Math.pow(10, 9) * (long) Math.pow(10, 5) * 4;
       
        
        while(start <= end) {
        	long mid = (start + end) / 2;
        	long goldMax = 0;
            long silverMax = 0;
            long add = 0;
        	for(int i=0;i<t.length;++i) {
        		long move = mid / (t[i] * 2);
        		if(mid % (t[i] * 2) >= t[i]) {
        			move++;
        		}
        		goldMax += (g[i] < move * w[i]) ? g[i] : move * w[i];
        		silverMax += (s[i] < move * w[i]) ? s[i] : move * w[i];
        		add += (g[i] + s[i] < move * w[i]) ? g[i] + s[i] : move * w[i];
        		
        	}
        	if(goldMax >= a && silverMax >= b && add >= a + b) {
                end = mid - 1;
                answer = Math.min(mid, answer);
            }else {
                start = mid + 1;
            }
        }
        return answer;
    }
	public static void main(String[] args) {
		//a		b	g		s		w	t		result
		//10	10	[100]	[100]	[7]	[10]	50
		//90	500	[70,70,0]	[0,0,500]	[100,100,2]	[4,8,1]	499
		int a1 = 10;
		int b1 = 10;
		int[] g1 = {100};
		int[] s1 = {100};
		int[] w1 = {7};
		int[] t1 = {10};
		System.out.println(solution(a1,b1,g1,s1,w1,t1));
		
		int a2 = 90;
		int b2 = 500;
		int[] g2 = {70,70,0};
		int[] s2 = {0,0,500};
		int[] w2 = {100,100,2};
		int[] t2 = {4,8,1};
		System.out.println(solution(a2,b2,g2,s2,w2,t2));
	}
	

}
