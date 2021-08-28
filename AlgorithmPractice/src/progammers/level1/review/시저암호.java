package progammers.level1.review;

public class 시저암호 {
	 public static String solution(String s, int n) {
		StringBuilder sb= new StringBuilder();
		for(char c : s.toCharArray()) {
			if (Character.isLowerCase(c)) {
				int tmp = c-'a' + n;
				tmp %= 26;
				tmp += 'a';
				c = (char)tmp;
			}else if(Character.isUpperCase(c)) {
				int tmp = c-'A' + n;
				tmp %= 26;
				tmp += 'A';
				c = (char)tmp;
			}
			sb.append(c);
        }
        return sb.toString();
    }
	public static void main(String[] args) {
		//s	n	result
		//"AB"	1	"BC"
		//"z"	1	"a"
		//"a B z"	4	"e F d"
		System.out.println(solution("AB",1));
		System.out.println(solution("z",1));
		System.out.println(solution("a B z",4));
	}

}
