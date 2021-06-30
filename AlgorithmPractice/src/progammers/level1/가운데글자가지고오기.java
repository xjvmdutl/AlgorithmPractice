package progammers.level1;

public class 가운데글자가지고오기 {
	public static String solution(String s) {
        String answer = "";
        if(s.length()%2 == 0) {
            answer = s.substring(s.length()/2-1,s.length()/2+1);
        }else{
        	answer = s.substring(s.length()/2,s.length()/2+1);
        }
        return answer;
    }
	public static void main(String[] args) {
		String s1 = solution("abcde"); 
		String s2 = solution("qwer");
	}

}
