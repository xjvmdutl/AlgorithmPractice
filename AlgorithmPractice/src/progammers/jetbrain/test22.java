package progammers.jetbrain;

public class test22 {
	 public static int[] solution(int n, long left, long right) {
		long start1 = left/n;
		long start2 = left%n;
		long end1 = right/n;
		long end2 = right%n;
		int[] answer = new int[(int)(right-left+1)];
		int idx = 0;
		while(start1 <= end1) {
			while(start2 <n) {
				if(start2 <= start1) {
					answer[idx++] = (int) (start1 + 1);
				}else {
					answer[idx++] = (int) (start2 + 1);
				}
				if(start1 == end1 && start2 == end2)
					return answer;
				start2++;
			}
			start1++;
			start2 = 0;
		}
        return answer;
    }
	public static void main(String[] args) {
		int[] a = solution(3,2,5);
		System.out.println(a);
	}

}
