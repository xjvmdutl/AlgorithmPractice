package progammers.level1.review;

import java.util.Arrays;

public class 로또의최고순위와최저순위 {
	 public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zeroCount = 0;
        int count=0;
        for(int i=0;i<lottos.length;++i) {
        	int data = lottos[i];
        	if(data == 0)
        		zeroCount++;
        	long n = Arrays.stream(win_nums).filter((o1)->o1==data).count();
        	count+=n;
        }
        int max = count + zeroCount;
        int min = count;
        for(int i=0;i<2;++i) {
        	switch (max) {
			case 6: {
				answer[i] = 1;	
				break;
			}
			case 5: {
				answer[i] = 2;	
				break;
			}
			case 4: {
				answer[i] = 3;	
				break;
			}
			case 3: {
				answer[i] = 4;	
				break;
			}
			case 2: {
				answer[i] = 5;	
				break;
			}
			default : {
				answer[i] = 6;	
			}
    	}
        	
        	
        	
        	max = count;
        }
        
        return answer;
    }
	public static void main(String[] args) {
		//lottos	win_nums	result
		//[44, 1, 0, 0, 31, 25]	[31, 10, 45, 1, 6, 19]	[3, 5]
		//[0, 0, 0, 0, 0, 0]	[38, 19, 20, 40, 15, 25]	[1, 6]
		//[45, 4, 35, 20, 3, 9]	[20, 9, 3, 45, 4, 35]	[1, 1]
		int[] lottos1 = {44, 1, 0, 0, 31, 25};
		int[] win_nums1 = {31, 10, 45, 1, 6, 19};
		int[] result = solution(lottos1, win_nums1);
		for(int i: result)
			System.out.println(i);
		int[] lottos2 = {0, 0, 0, 0, 0, 0};
		int[] win_nums2 = {38, 19, 20, 40, 15, 25};
		result = solution(lottos2, win_nums2);
		for(int i: result)
			System.out.println(i);
		int[] lottos3 = {45, 4, 35, 20, 3, 9};
		int[] win_nums3 = {20, 9, 3, 45, 4, 35};
		result = solution(lottos3, win_nums3);
		for(int i: result)
			System.out.println(i);
		
	}

}
