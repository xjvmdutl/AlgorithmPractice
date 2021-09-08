package progammers.golevelkit.stackqueue;

public class 주식가격 {
	public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i=0;i<prices.length;++i) {
        	int n = prices[i];
        	int count = 0;
        	for(int j=i+1;j<prices.length;++j) {
        		if(n <= prices[j]) {
        			count++;
        		}else {
        			count++;
        			break;
        		}
        	}
        	answer[i] = count;
        }
        return answer;
    }
	public static void main(String[] args) {
		//prices	return
		//[1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]
		int[] prices = {1, 2, 3, 2, 3};
		
		System.err.println(solution(prices));
	}

}
