package progammers.level3;


public class 가장긴팰린드롬 {
	public static int solution(String s){
        int answer = 1;
        //subString,reverse 함수 쓰지 말고 하기
        for(int length=s.length();length>1;--length) {
        	for(int i=0;i+length <= s.length();++i) {
        		int n = length/2;
        		boolean flag= true;
        		for(int j=0;j<n;++j) {
        			if(s.charAt(i+j) != s.charAt(i+length-1-j)) {
        				flag = false;
        				break;
        			}
        		}
        		if(flag) {
        			return length;
        		}
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		//s	answer
		//"abcdcba"	7
		//"abacde"	3
		System.out.println(solution("abcdcba"));
		System.out.println(solution("abacde"));
	}

}
