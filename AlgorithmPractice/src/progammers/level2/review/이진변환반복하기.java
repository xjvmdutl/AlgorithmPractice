package progammers.level2.review;

public class 이진변환반복하기 {
	public static int[] solution(String s) {
        
        int remove = 0;
        int count = 0;
        while(!s.equals("1")) {
        	count++;
        	for(int i=0;i<s.length();++i) {
        		if(s.charAt(i) == '0')
        			remove++;
        	}
        	s = s.replaceAll("0", "");
        	s = Integer.toBinaryString(s.length());
        }
        int[] answer = {count,remove};
        return answer;
    }
	public static void main(String[] args) {
		//s	result
		//"110010101001"	[3,8]
		//"01110"	[3,3]
		//"1111111"	[4,1]
		System.out.println(solution("110010101001"));
		System.out.println(solution("01110"));
		System.out.println(solution("1111111"));
	}
}
