package progammers.level1;

public class 평균구하기 {
	public double solution(int[] arr) {
        int sum = 0;
        for(int i=0;i<arr.length;++i){
            sum+=arr[i];
        }
        return (double)sum/arr.length;
    }
	/*
	 * public int getMean(int[] array) {//자바 8문법
     *   return (int) Arrays.stream(array).average().orElse(0);
     *	}
	 * */
}
