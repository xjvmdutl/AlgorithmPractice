package progammers.level2;

public class JadenCase문자열만들기 {
	public static String solution(String s) {
        char[] sArr = s.toLowerCase().toCharArray();
        
        for(int i=0;i< sArr.length;++i) {
        	if(sArr[i] == ' ') {
        		if(i<sArr.length-1 && 'a' <= sArr[i+1] && sArr[i+1] <= 'z') {
        			int abs = 'a' - 'A';
        			sArr[i+1] = (char) (sArr[i+1] - abs);
        		}
        	}else if(i == 0 ){
        		if('a' <= sArr[i] && sArr[i] <= 'z') {
        			int abs = 'a' - 'A';
        			sArr[i] = (char) (sArr[i] - abs);
        		}
        	}
        }
        
        
        return new String(sArr);
    }
	public static void main(String[] args) {
//		s	return
//		"3people unFollowed me"	"3people Unfollowed Me"
//		"for the last week"	"For The Last Week"
		String s1 = "3people unFollowed me";
		String s2 = "for the last week";
		String s3 = "    123 43d  ";
		
		System.out.println(solution(s1));
		System.out.println(solution(s2));
		System.out.println(solution(s3));
	}

}
