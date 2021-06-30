package progammers.level2;

import java.util.Arrays;

public class 전화번호목록 {
	public static boolean solution(String[] phone_book) {
		Arrays.sort(phone_book);
        for(int i = 0 ;i<phone_book.length-1;++i) {
    		if(phone_book[i+1].startsWith(phone_book[i])) {
    			return false;
    		}
    	
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//phone_book	return
		//["119", "97674223", "1195524421"]	false
		//["123","456","789"]	true
		//["12","123","1235","567","88"]	false
		String[] phone_book1 = {"119", "97674223", "1195524421"};
		System.out.println(solution(phone_book1));
		String[] phone_book2 = {"123","456","789"};
		System.out.println(solution(phone_book2));
		String[] phone_book3 = {"12","123","1235","567","88"};
		System.out.println(solution(phone_book3));
	}

}
