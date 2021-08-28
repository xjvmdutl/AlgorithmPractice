package progammers.level1.review;

import java.util.Arrays;

public class 정수내림차순으로배치하기 {
	public static long solution(long n) {
        int[] arr = new int[String.valueOf(n).length()];
        for(int i=0;i<arr.length;++i) {
        	arr[i] = (int)(n%10);
        	n/=10;
        }
        int[] reverse= Arrays.stream(arr).boxed().sorted((o1,o2)->o2-o1).mapToInt(Integer::intValue).toArray();
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<reverse.length;++i) {
        	sb.append(reverse[i]);
        }
        return Long.parseLong(sb.toString());
    }
	public static void main(String[] args) {
		//n	return
		//118372	873211
		System.out.println(solution(118372));
	}

}
