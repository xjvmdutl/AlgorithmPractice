package progammers.level2.review;

public class Å¸°Ù³Ñ¹ö {
	public static boolean[] visit;
	public static int answer;
	public static int solution(int[] numbers, int target) {
        answer = 0;
        visit = new boolean[numbers.length];
        dfs(numbers,0,0,target);
        return answer;
    }
	private static void dfs(int[] numbers, int idx,int number, int target) {
		if(idx == numbers.length) {
			if(number == target)
				answer++;
			return;
		}
		dfs(numbers, idx+1, number + numbers[idx], target);
		dfs(numbers, idx+1, number - numbers[idx], target);
	}
	public static void main(String[] args) {
		//numbers	target	return
		//[1, 1, 1, 1, 1]	3	5
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		System.out.println(solution(numbers,target));
	}

}
