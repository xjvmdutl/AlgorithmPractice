package progammers.level3;

public class 스티커모으기2 {
	public static int[] dp1;
	public static int[] dp2;
	public static int solution(int sticker[]) {
		dp1 = new int[sticker.length];
		dp2 = new int[sticker.length];
		int answer = 0;
		//1번 선택
		dp1[0] = sticker[0];
		dp1[1] = sticker[0];
		for(int i=2;i<sticker.length-1;++i) {
			dp1[i] = Math.max(dp1[i-1], dp1[i-2] + sticker[i]);
		}
		//2번 선택
		dp2[0] = 0;
		dp2[1] = sticker[1];
		for(int i=2;i<sticker.length;++i) {
			dp2[i] = Math.max(dp2[i-1], dp2[i-2] + sticker[i]);
		}
		answer = Math.max(dp1[sticker.length-2],dp2[sticker.length-1]);

		
        return answer;
	}
	public static void main(String[] args) {
		//sticker	answer
		//[14, 6, 5, 11, 3, 9, 2, 10]	36
		//[1, 3, 2, 5, 4]	8
		int[] sticker1 = {14, 6, 5, 11, 3, 9, 2, 10};
		System.out.println(solution(sticker1));
		int[] sticker2 = {1, 3, 2, 5, 4};
		System.out.println(solution(sticker2));
		int[] sticker3 = {1};
		System.out.println(solution(sticker3));
	}

}
