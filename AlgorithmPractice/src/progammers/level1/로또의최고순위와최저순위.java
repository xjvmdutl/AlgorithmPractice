package progammers.level1;

public class 로또의최고순위와최저순위 {
	public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int count = 0;
        int zeroCount =0;
        for(int lotto : lottos) {
        	if(lotto == 0) {
    			zeroCount++;
    			continue;
        	}
        	for(int win_num : win_nums) {
        		if(lotto == win_num) 
        			count++;
        		
        		
        	}	
        }
        
        return new int[] {7-(count+zeroCount) >= 6? 6:7-(count+zeroCount),7-count >= 6 ? 6:7-count};
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
