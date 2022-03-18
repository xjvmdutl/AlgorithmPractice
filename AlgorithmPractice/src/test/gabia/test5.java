package test.gabia;

public class test5 {

	public static void main(String[] args) {
		int[] gold1 = {1,100,101,102,1,5};
		//System.out.println(solution(gold1));
		int[] gold2 = {1,2,3,1,1,1,2};
		//System.out.println(solution(gold2));
		int[] gold3 = {2,5,1,3,4};
		System.out.println(solution(gold3));
		int[] gold4 = {7,2,5,6,1,4,2,8};
		System.out.println(solution(gold4));
	}

	public static int solution(int[] gold_prices) {
		int answer = 0;
		int gold = gold_prices[0];
		boolean[] visit = new boolean[gold_prices.length];
		boolean isFirst = true;
		for(int i=1;i<gold_prices.length;++i) {
			if(isFirst && gold_prices[i] < gold) {
				gold = gold_prices[i];
				continue;
			}
			isFirst = false; 
			if(gold_prices[i-1] <= gold_prices[i]) {
				if(i == gold_prices.length-1 ) {
					answer += gold_prices[i] - gold;
				}
				continue;
			}else {
				if(i+1 >= gold_prices.length) {
					answer += gold_prices[i - 1] - gold; // 금을 팔아	
					i++;
					continue;
				}
				if(i -2 >= 0 && gold_prices[i+1] - gold_prices[i] < gold_prices[i-1] - gold_prices[i-2]) {
					answer += gold_prices[i - 1] - gold; // 금을 팔아	
					visit[i-1] = true;
					visit[i] = true;
					i++;//다음날까지 이동
				}else {
					//전날 까지 금을 사
					if(i-2 >= 0 && gold < gold_prices[i-2] && !visit[i-2]) {
						visit[i-2] = true;
						visit[i-1] = true;
						answer += gold_prices[i-2] - gold;
					}
					gold = gold_prices[i];
				}
				//오르는 지점까지 이동
				for(;i <gold_prices.length-1;++i) {
					if(gold_prices[i] < gold_prices[i+1]) {
						break;
					}
				}
				gold = gold_prices[i];
			}
		}
		return answer;
	}

}
