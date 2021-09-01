package progammers.level2.review;

public class JadenCase문자열만들기 {
	public static String solution(String s) {
        StringBuilder sb= new StringBuilder();
        sb.append(Character.toUpperCase(s.charAt(0)));
        for(int i=1;i<s.length();++i) {
        	char c = s.charAt(i);
        	if(s.charAt(i-1) == ' ') {
        		c = Character.toUpperCase(c);
        	}else {
        		c = Character.toLowerCase(c);
        	}
        	sb.append(c);
        }
        return sb.toString();
    }
	public static void main(String[] args) {
		//s	return
		//"3people unFollowed me"	"3people Unfollowed Me"
		//"for the last week"	"For The Last Week"
		System.out.println(solution("3people unFollowed me"));
		System.out.println(solution("for the last week"));
		System.out.println(solution("d  d"));
	}

}
