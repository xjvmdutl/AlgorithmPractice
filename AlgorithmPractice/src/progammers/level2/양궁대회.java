package progammers.level2;

public class ¾ç±Ã´ëÈ¸ {
	public static int[] answer = {-1};
	public static int max;
	public static int[] lion;
	public static int[] solution(int n, int[] info) {
		lion = new int[info.length];
        max = -1000;
        permulate(info,0,n);
        return answer;
    }
	private static void permulate( int[] info, int count, int n) {
		if(count == n) {
			int lionPoint = 0;
			int apeachPoint = 0;
			for(int i=0;i<info.length;++i) {
				if(info[i] != 0 || lion[i] != 0 ) {
					if(info[i] < lion[i]) 
						lionPoint += 10 - i;
                    else 
                    	apeachPoint += 10 - i;
				}
			}
			if(lionPoint > apeachPoint ) {
				if(lionPoint - apeachPoint >= max) {
					answer = lion.clone();
					max = lionPoint - apeachPoint;
				}
			}
			return;
		}
		
		for(int i=0;i<info.length && lion[i] <= info[i];++i) {
			lion[i]++;
			permulate(info, count+1, n);
			lion[i]--;
		}
	}
	public static void main(String[] args) {
		//n	info	result
		//5	[2,1,1,1,0,0,0,0,0,0,0]	[0,2,2,0,1,0,0,0,0,0,0]
		//1	[1,0,0,0,0,0,0,0,0,0,0]	[-1]
		//9	[0,0,1,2,0,1,1,1,1,1,1]	[1,1,2,0,1,2,2,0,0,0,0]
		//10	[0,0,0,0,0,0,0,0,3,4,3]	[1,1,1,1,1,1,1,1,0,0,2]
		int[] info1 = {2,1,1,1,0,0,0,0,0,0,0};
		System.out.println(solution(5,info1));
		int[] info2 = {1,0,0,0,0,0,0,0,0,0,0};
		System.out.println(solution(1,info2));
		int[] info3 = {0,0,1,2,0,1,1,1,1,1,1};
		System.out.println(solution(9,info3));
		int[] info4 = {0,0,0,0,0,0,0,0,3,4,3};
		System.out.println(solution(10,info4));
	}

}
