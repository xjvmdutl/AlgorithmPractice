package progammers.level1.review;

public class 문자열다루기기본 {
	public static boolean solution(String s) {
        boolean answer = true;
        if(s.length() != 4 && s.length() != 6)
        	return false;
        for(int i=0;i<s.length();++i) {
        	if(!Character.isDigit(s.charAt(i))) {
        		return false;
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(solution("a234"));
		System.out.println(solution("1234"));
	}

}
