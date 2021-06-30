package progammers.level2;

public class 피보나치수 {

	public static int solution(int n) {
        int num1 = 0;
        int num2 = 1;
        for(int i=0;i<n;++i) {
        	int c = (num1 + num2)%1234567;
        	num1 = num2%1234567;
        	num2 = c%1234567;
        }
        return num1;
        //시간초과 문제 발생하여 for문 수행
    }
//	public static int fibonach(int n) {
//		
//		if(n == 0)
//			return 0;
//		else if(n == 1)
//			return 1;
//		return fibonach(n-1) + fibonach(n-2); 
//	}
	public static void main(String[] args) {
//		n	return
//		3	2
//		5	5
		int n1 = 100000;
		int n2 = 5;
		System.out.println(solution(n1));
		System.out.println(solution(n2));
	}

}
