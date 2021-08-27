package progammers.level1.review;

public class 가운데글자가져오기 {
	public static String solution(String s) {
        String answer = "";
        if(s.length()%2 == 0) {
        	answer = s.substring(s.length()/2-1,s.length()/2+1);
        }else {
        	answer = String.valueOf(s.charAt(s.length()/2));
        }
        return answer;
    }
	public static void main(String[] args) {
		//s	return
		//"abcde"	"c"
		//"qwer"	"we"
		
		System.out.println(solution("abcde"));
		System.out.println(solution("qwer"));
	}

}
