package progammers.level1.review;

public class x만큼간격이있는n개의숫자 {
	public static long[] solution(int x, int n) {
        long[] answer = new long[n];
        long sum = 0;
        for(int i=0;i<n;++i) {
        	sum += x;
        	answer[i] = sum;
        }
        return answer;
    }
	public static void main(String[] args) {
		//x	n	answer
		//2	5	[2,4,6,8,10]
		//4	3	[4,8,12]
		//-4	2	[-4, -8]
		System.out.println(solution(2,5));
		System.out.println(solution(4,3));
		System.out.println(solution(-4,2));
	}

}
