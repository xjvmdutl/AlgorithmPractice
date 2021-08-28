package progammers.level1.review;

import java.util.Arrays;

public class 문자열내림차순으로배치하기 {

	public static String solution(String s) {
		char[] cArr = s.toCharArray();
		Arrays.sort(cArr);
		StringBuilder sb= new StringBuilder();
		for(int i=cArr.length-1;i>=0;--i) {
			sb.append(cArr[i]);
		}
        return sb.toString();
    }
	public static void main(String[] args) {
		//s	return
		//"Zbcdefg"	"gfedcbZ"
		System.out.println(solution("Zbcdefg"));
	}

}
