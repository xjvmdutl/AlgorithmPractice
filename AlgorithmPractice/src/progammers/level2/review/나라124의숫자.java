package progammers.level2.review;

public class 나라124의숫자 {
	public static String solution(int n) {
		StringBuilder sb = new StringBuilder();
		
        while(n>0) {
        	n-=1;
        	int num = n%3;
        	if(num == 0) {
        		sb.append(1);
        	}else if(num ==1) {
        		sb.append(2);
        	}else {
        		sb.append(4);
        	}
        	n /= 3;
        }
        
        return sb.reverse().toString();
    }
	public static void main(String[] args) {
		//10진법	124 나라	10진법	124 나라
		//1		1		6		14
		//2		2		7		21
		//3		4		8		22
		//4		11		9		24
		//5		12		10		41
		System.out.println(solution(1));
		System.out.println(solution(2));
		System.out.println(solution(3));
		System.out.println(solution(4));
		System.out.println(solution(5));
		System.out.println(solution(6));
		System.out.println(solution(7));
		System.out.println(solution(8));
		System.out.println(solution(9));
		System.out.println(solution(10));
	}

}
