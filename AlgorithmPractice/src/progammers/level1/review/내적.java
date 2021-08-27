package progammers.level1.review;

public class ³»Àû {
	public static int solution(int[] a, int[] b) {
        int answer = 0;
        for(int i=0;i<a.length;++i) {
        	answer += a[i] * b[i];
        }
        return answer;
    }
	public static void main(String[] args) {
		//a	b	result
		//[1,2,3,4]	[-3,-1,0,2]	3
		//[-1,0,1]	[1,0,-1]	-2
		int[] a1 = {1,2,3,4};
		int[] b1 = {-3,-1,0,2};
		System.out.println(solution(a1,b1));
		int[] a2 = {-1,0,1};
		int[] b2 = {1,0,-1};
		System.out.println(solution(a2,b2));
	}

}
