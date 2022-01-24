package progammers.level3.review;

import java.util.HashMap;
import java.util.Map;

public class 다단계칫솔판매 {
	public static Map<String, Integer> indexes;
	public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        indexes = new HashMap<>();
        for(int i=0;i<enroll.length;++i) {
        	indexes.put(enroll[i],i);
        }
        
        for(int i=0;i<seller.length;++i) {
        	int index = indexes.get(seller[i]);
        	dfs(referral, answer, index, 100 * amount[i]);
        }
        
        return answer;
    }
	private static void dfs(String[] referral, int[] answer, int index, int money) {
		answer[index] += money - (money / 10);
		if(referral[index].equals("-") || (money/10) <= 0)
			return;
		dfs(referral, answer, indexes.get(referral[index]), (money / 10));
		
	}
	public static void main(String[] args) {
		//enroll																referral															seller										amount				result
		//["john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"]	["-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"]	["young", "john", "tod", "emily", "mary"]	[12, 4, 2, 5, 10]	[360, 958, 108, 0, 450, 18, 180, 1080]
		//["john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"]	["-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"]	["sam", "emily", "jaimie", "edward"]		[2, 3, 5, 4]		[0, 110, 378, 180, 270, 450, 0, 0]
		String[] enroll1 = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral1 = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller1 = {"young", "john", "tod", "emily", "mary"};
		int[] amount1 = {12, 4, 2, 5, 10};
		System.out.println(solution(enroll1, referral1, seller1, amount1));
		
		
		String[] enroll2 = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral2 = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller2 = {"sam", "emily", "jaimie", "edward"};
		int[] amount2 = {2, 3, 5, 4};
		System.out.println(solution(enroll2, referral2, seller2, amount2));
		
	}

}
