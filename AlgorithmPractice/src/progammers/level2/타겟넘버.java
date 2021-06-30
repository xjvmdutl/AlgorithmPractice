package progammers.level2;

public class Å¸°Ù³Ñ¹ö {
	
	public static int solution(int[] numbers, int target) {
		int answer = 0;
		answer = bfs(numbers,target,numbers[0],1) + bfs(numbers,target,-numbers[0],1);
		return answer;
    }
	public static int bfs(int[] numbers,int target,int sum,int index) {
		if(index == numbers.length) {
			if(sum == target)
				return 1;
			else return 0;
		}
		int result = 0;
		result += bfs(numbers,target,sum+numbers[index],index+1);
		result += bfs(numbers,target,sum-numbers[index],index+1);
		
		return result;
	}
	public static void main(String[] args) {
//		numbers	target	return
//		[1, 1, 1, 1, 1]	3	5
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		System.out.println(solution(numbers, target));
	}
}
