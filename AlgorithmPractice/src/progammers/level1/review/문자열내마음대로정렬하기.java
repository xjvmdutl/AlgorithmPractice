package progammers.level1.review;

import java.util.Arrays;

public class 문자열내마음대로정렬하기 {
	public static String[] solution(String[] strings, int n) {
        Arrays.sort(strings,(o1,o2)->{
        	if(o1.charAt(n)==o2.charAt(n)) {
        		return o1.compareTo(o2);
        	}
        	return o1.charAt(n)-o2.charAt(n);
        });
        return strings;
    }
	public static void main(String[] args) {
		/*
		 * strings n return
		 *  ["sun", "bed", "car"] 1 ["car", "bed", "sun"] 
		 *  ["abce","abcd", "cdx"] 2 ["abcd", "abce", "cdx"]
		 */
		String[] s1 = {"sun", "bed", "car"};
		String[] s2 = {"abce","abcd", "cdx"};
		System.out.println(solution(s1,1));
		System.out.println(solution(s2,2));
	}

}
