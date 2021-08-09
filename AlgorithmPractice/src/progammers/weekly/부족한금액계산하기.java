package progammers.weekly;

public class 부족한금액계산하기 {
	public static long solution(int price, int money, int count) {
		long answer = 0;
        for(int i=1;i<=count;++i){
            long m = i * price;
            answer += m;
        }
        answer = answer - money > 0 ? answer - money : 0;
        return answer;
    }
	public static void main(String[] args) {
		//price	money	count	result
		//3	    20	      4  	10
		int price = 3;
		int money = 20;
		int count = 4;
		System.out.println(solution(price,money,count));
	}

}
