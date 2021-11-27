package progammers.level3;


public class 다단계칫솔판매 {
	public static int[] parents;
	public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		int[] answer = new int[enroll.length];
        parents = new int[enroll.length];
        for(int i=0;i<enroll.length;++i) {
        	parents[i] = find(enroll,referral[i]);
        }
        for(int i=0;i<seller.length;++i) {
        	String now = seller[i];
        	int money = 100 * amount[i];
        	for(int j=0;j<enroll.length;++j) {
    			if(enroll[j].equals(now)) {
    				dfs(enroll,referral,j,money,answer);
    				break;
    			}
    		}
        }
        return answer;
    }
	private static int find(String[] enroll, String parent) {
		for(int i=0;i<enroll.length;++i) {
			if(enroll[i].equals(parent)) {
				return i;
			}
		}
		return -1;
	}
	private static void dfs(String[] enroll, String[] referral, int now, int money, int[] answer) {
		if(now == -1) {
			return;
		}
		answer[now] += money - (money/10);
		dfs(enroll, referral, parents[now], money/10, answer);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] enroll1 = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral1 = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller1 = {"young", "john", "tod", "emily", "mary"};
		int[] amount1 = {12, 4, 2, 5, 10};
		System.out.println(solution(enroll1,referral1,seller1,amount1));
	}

}
