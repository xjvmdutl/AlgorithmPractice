package progammers.level1.review;

public class 문자열내p와y의개수 {
	public static boolean solution(String s) {
        boolean answer = true;
        int yCount = 0;
        int pCount = 0;
        s = s.toLowerCase();
        for(int i=0;i<s.length();++i) {
        	if(s.charAt(i) == 'p') {
        		pCount++;
        	}else if(s.charAt(i)=='y') {
        		yCount++;
        	}
        }
        return yCount == pCount;
    }
	public static void main(String[] args) {
		System.out.println(solution("pPoooyY"));
		System.out.println(solution("Pyy"));
	}

}
