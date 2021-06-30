package progammers.level1;

public class 시저암호 {
	public static String solution(String s, int n) {
        String answer = "";
        
        for(int i=0;i<s.length();++i){
            char c = s.charAt(i);
            char tmp = ' ';
            int num = 0;
            if('A'<=c && c<='Z'){
               num = (c-'A'+n)%26;
               tmp = (char)(num+'A');    
            }else if('a'<=c && c<='z') {
            	num = (c-'a'+n)%26;
                tmp = (char)(num+'a');
            }
            answer+=tmp;
        }
        return answer;
    }
	public static void main(String[] args) {
		
		String s = solution("a B z",4);
	}

}
