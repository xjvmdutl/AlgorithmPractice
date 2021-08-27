package progammers.level1.review;

public class ¾à¼öÀÇ°³¼ö¿Íµ¡¼À {
	public static int solution(int left, int right) {
        int answer = 0;
        for(int i=left;i<=right;++i) {
        	if(counting(i)%2 == 0) {
        		answer+=i;
        	}else {
        		answer-=i;
        	}
        }
        return answer;
    }
	private static int counting(int num) {
		int count = 0;
		for(int i=1;i<=num;++i) {
			if(num%i == 0)
				count++;
		}
		return count;
	}
	public static void main(String[] args) {
		//left	right	result
		//13	17	43
		//24	27	52
		int l1 = 13;
		int r1 = 17;
		System.out.println(solution(l1,r1));
		int l2 = 24;
		int r2 = 27;
		System.out.println(solution(l2,r2));
	}

}
