package progammers.golevelkit;

import java.util.Arrays;

public class 전화번호목록 {

	public static boolean solution(String[] phone_book) {
		boolean answer = true;
		Arrays.sort(phone_book);
        for(int i=1;i<phone_book.length;++i) {
        	String str = phone_book[i];
    		if(str.startsWith(phone_book[i-1])) {
    			return false;
    		}
        }
        
        return answer;
    }
	public static void main(String[] args) {
		//phone_book	return
		//["119", "97674223", "1195524421"]	false
		//["123","456","789"]	true
		//["12","123","1235","567","88"]	false
		String[] phhone_book1 = {"119", "97674223", "1195524421"};
		System.out.println(solution(phhone_book1));
		String[] phhone_book2 = {"123","456","789"};
		System.out.println(solution(phhone_book2));
		String[] phhone_book3 = {"12","123","1235","567","88"};
		System.out.println(solution(phhone_book3));
	}
}
