package progammers.level2;

public class N개의최소공배수 {
    public static int solution(int[] arr) {
        int answer = 0;
        int min = Math.min(arr[0], arr[1]);
    	int max = Math.max(arr[0], arr[1]);
    	answer = (min * max) / gcd(min,max); // 최대공약수
        for(int i=2;i<arr.length;++i) {
        	min = Math.min(answer, arr[i]);
        	max = Math.max(answer, arr[i]);
        	answer =  (min * max) / gcd(min,max); // 최대공약수
        }
        return answer;
    }
    public static int gcd(int i,int j) {
    	
    	if(j == 0)
    		return i;
    	else
    		return gcd(j,i%j);
    }
	public static void main(String[] args) {
//		arr	result
//		[2,6,8,14]	168
//		[1,2,3]	6
		int[] arr1 = {2,6,8,14};
		int[] arr2 = {1,2,3};
		System.out.println(solution(arr1));
		System.out.println(solution(arr2));
	}

}
