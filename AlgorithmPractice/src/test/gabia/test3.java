package test.gabia;

public class test3 {
	public static int answer;
	public static boolean[] visit;
	public static void main(String[] args) {
		int[] arr = {2,5,3,8,1};
		int k = 3;
		int t =11;
		System.out.println(solution(arr, k, t));
	}

	private static int solution(int[] arr, int k, int t) {
		answer = 0;
		for(int i=k;i<=arr.length;++i) {
			visit = new boolean[arr.length];
			permutation(arr, 0, 0, i, t, 0);
		}
		return answer;
	}

	private static void permutation(int[] arr, int index, int count, int length, int t, int sum) {
		if(count == length) {
			if(sum <= t)
				answer++;
			return;
		}
		for(int i=index ; i< arr.length;++i) {
			if(!visit[i]) {
				visit[i] = true;
				permutation(arr, i, count+1, length, t, sum + arr[i]);
				visit[i]= false;
			}
		}
	}

}
