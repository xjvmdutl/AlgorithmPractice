package progammers.level1;

public class ��ձ��ϱ� {
	public double solution(int[] arr) {
        int sum = 0;
        for(int i=0;i<arr.length;++i){
            sum+=arr[i];
        }
        return (double)sum/arr.length;
    }
	/*
	 * public int getMean(int[] array) {//�ڹ� 8����
     *   return (int) Arrays.stream(array).average().orElse(0);
     *	}
	 * */
}
