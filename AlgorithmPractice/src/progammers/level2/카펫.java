package progammers.level2;

import java.util.ArrayList;
import java.util.List;

public class Ä«Æê {
	public static int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
        int data = brown + yellow;
        List<Integer> list = new ArrayList<>();
        for(int i =1;i<=data;++i){
            if(data%i==0)
                list.add(i);
        }
        for(int i=0;i<=list.size()/2;++i){
            int tmpN = Math.max(list.get(i),list.get(list.size()-1-i));
            int tmpM = Math.min(list.get(i),list.get(list.size()-1-i));
            if(tmpM -2 <=0 || tmpN - 2 <= 0){
            	continue;
            }
            int tmpYellowCount = (tmpM -2) * (tmpN -2);
            int tmpBrownCount = (tmpN*tmpM)-tmpYellowCount;
            if(tmpBrownCount == brown && tmpYellowCount == yellow){
                return new int[]{tmpN,tmpM};
            }
                
        }
        return new int[]{0,0};
    }
	
	public static void main(String[] args) {
//		brown	yellow	return
//		10	2	[4, 3]
//		8	1	[3, 3]
//		24	24	[8, 6]
		int brown1 = 10;
		int brown2 = 8;
		int brown3 = 24;
		
		int yellow1 = 2;
		int yellow2 = 1;
		int yellow3 = 24;
		
		int[] result1 = solution(brown1, yellow1);
		for(int i:result1)
			System.out.println(i);
		int[] result2 = solution(brown2, yellow2);
		for(int i:result2)
			System.out.println(i);
		int[] result3 = solution(brown3, yellow3);
		for(int i:result3)
			System.out.println(i);
		
		
	}

}
