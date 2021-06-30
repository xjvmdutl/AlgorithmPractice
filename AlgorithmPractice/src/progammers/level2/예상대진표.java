package progammers.level2;

public class 예상대진표 {
	public static int solution(int n, int a, int b)
    {
        int answer = 1;
        
        int left = 0;
        int right = 0;
        if(a < b) {
        	left = a;
        	right = b;
        }else {
        	left = b;
        	right = a;
        }
        while(true) {
        	if(left % 2 != 0 && right-left == 1) {
        		break;
        	}
        	left = (left+1)/2;
        	right = (right+1)/2;
        	answer++;
        	
        }
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		N	A	B	answer
//		8	4	7	3
		int N = 8;
		int A = 4;
		int B = 7;
		System.out.println(solution(N, A, B));
	}

}
