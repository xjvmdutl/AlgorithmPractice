package progammers.level2.review;

public class N개의최소공배수 {
	public static int solution(int[] arr) {
        int answer = (arr[0] * arr[1]) /gcd(arr[0],arr[1]);
        for(int i=2;i<arr.length;++i) {
        	answer= (answer * arr[i]) /gcd(answer, arr[i]);
        }
        return answer;
    }
	private static int gcd(int x, int y) {
		if(x <= 0) {
			return y;
		}
		return gcd(y%x, x);
	}
	public static void main(String[] args) {
		//arr	result
		//[2,6,8,14]	168
		//[1,2,3]	6
		int[] arr1 = {2,6,8,14};
		int[] arr2 = {1,2,3};
		System.out.println(solution(arr1));
		System.out.println(solution(arr2));
	}

}
