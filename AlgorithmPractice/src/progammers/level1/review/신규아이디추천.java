package progammers.level1.review;

public class 신규아이디추천 {
	public static String solution(String new_id) {
	    new_id = new_id.toLowerCase();//1단계
	    StringBuilder sb = new StringBuilder();
	    for(char c : new_id.toCharArray()) {
	    	if('a' <= c && c <= 'z') {
	    		sb.append(c);
	    	}else if(Character.isDigit(c)) {
	    		sb.append(c);
	    	}else if(c == '-' || c=='_' || c=='.') {
	    		sb.append(c);
	    	}else {
	    		continue;
	    	}
	    }
	    new_id = sb.toString();
	    while(new_id.indexOf("..") > -1) {
	    	new_id = new_id.replace("..", ".");
	    }
	    sb = new StringBuilder(new_id);
	    if(sb.length() > 0 && sb.charAt(0)== '.')
	    	sb.delete(0, 1);
	    if(sb.length() > 0 && sb.charAt(sb.length()-1)=='.')
	    	sb.delete(sb.length()-1, sb.length());
	    
	    if(sb.length() == 0)
	    	sb.append("a");
	    else if(sb.length() >= 16) {
	    	sb.delete(15, sb.length());
	    	if(sb.charAt(sb.length()-1)=='.') {
	    		sb.delete(sb.length()-1, sb.length());
	    	}
	    }
	    
	    if(sb.length() <= 2) {
	    	while(sb.length() < 3) {
	    		sb.append(sb.charAt(sb.length()-1));
	    	}
	    }
	    new_id = sb.toString();
	    return new_id;
	}
	public static void main(String[] args) {
		System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
		System.out.println(solution("z-+.^."));
		System.out.println(solution("=.="));
		System.out.println(solution("123_.def"));
		System.out.println(solution("abcdefghijklmn.p"));
	}

}
