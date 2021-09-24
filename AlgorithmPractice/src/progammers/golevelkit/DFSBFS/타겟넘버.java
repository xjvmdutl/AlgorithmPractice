package progammers.golevelkit.DFSBFS;

public class Å¸°Ù³Ñ¹ö {
	public static int answer;
	public static int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers,0,numbers.length,0,target);
        return answer;
    }
	private static void dfs(int[] numbers, int index, int length, int sum,int target) {
		if(index == length) {
			if(sum == target) {
				answer++;
			}
			return;
		}
		dfs(numbers, index+1, length, sum+numbers[index], target);
		dfs(numbers, index+1, length, sum-numbers[index], target);
		
	}
	public static void main(String[] args) {
		//numbers	target	return
		//[1, 1, 1, 1, 1]	3	5
		int[] numbers = {1,1,1,1,1};
		System.out.println(solution(numbers,3));
	}

}
