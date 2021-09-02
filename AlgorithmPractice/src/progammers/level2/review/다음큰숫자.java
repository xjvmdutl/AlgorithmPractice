package progammers.level2.review;

public class 다음큰숫자 {
	public static int solution(int n) {
        String binary = Integer.toBinaryString(n);
        int count = 0;
        for(int i=0;i<binary.length();++i) {
        	if(binary.charAt(i) == '1')
        		count++;
        }
        while(true) {
        	int oneCount = 0;
        	binary = Integer.toBinaryString(++n);
        	for(int i=0;i<binary.length();++i) {
            	if(binary.charAt(i) == '1')
            		oneCount++;
            }
        	if(oneCount == count)
        		break;
        }
        return n;
    }
	public static void main(String[] args) {
		//n	result
		//78	83
		//15	23
		System.out.println(solution(78));
		System.out.println(solution(15));
	}

}
