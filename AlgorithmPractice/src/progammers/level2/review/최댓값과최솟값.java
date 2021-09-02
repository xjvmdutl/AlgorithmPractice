package progammers.level2.review;

import java.util.Arrays;

public class ÃÖ´ñ°ª°úÃÖ¼Ú°ª {
	public static String solution(String s) {
        
        String[] strs = s.split(" ");
        int[] arr = new int[strs.length];
        for(int i=0;i<strs.length;++i) {
        	arr[i] = Integer.parseInt(strs[i]);
        }
        Arrays.sort(arr);
        return arr[0] + " " + arr[arr.length-1];
    }
	public static void main(String[] args) {
		//s	return
		//"1 2 3 4"	"1 4"
		//"-1 -2 -3 -4"	"-4 -1"
		//"-1 -1"	"-1 -1"
		System.out.println(solution("1 2 3 4"));
		System.out.println(solution("-1 -2 -3 -4"));
		System.out.println(solution("-1 -1"));
	}
}
