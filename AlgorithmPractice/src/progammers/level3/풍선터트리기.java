package progammers.level3;

public class 풍선터트리기 {
	public static int solution(int[] a) {
        int answer = 0;
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        for(int i=0;i<a.length;++i) {
        	if(a[i] < left) {
        		answer++;
        		left = a[i];
        	}
        	if(a[a.length-i-1] < right) {
        		answer++;
        		right = a[a.length-i-1];
        	}
        	if(right == left) {
        		break;
        	}
        }
        return answer + (left == right ? -1 :0);
    }
	
	public static void main(String[] args) {
		//a	result
		//[9,-1,-5]	3
		//[-16,27,65,-2,58,-92,-71,-68,-61,-33]	6
		int[] a1 = {9,-1,-5};
		int[] a2 = {-16,27,65,-2,58,-92,-71,-68,-61,-33};
		System.out.println(solution(a1));
		System.out.println(solution(a2));
	}
}
