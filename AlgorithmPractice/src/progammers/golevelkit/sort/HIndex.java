package progammers.golevelkit.sort;

import java.util.Arrays;

public class HIndex {
	public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i=0;i<citations.length;++i) {
        	int h = citations[i];
        	int k = citations.length -i;
        	if(k <= h) {
        		answer = k;
        		break;
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		//citations	return
		//[3, 0, 6, 1, 5]	3
		int[] citations = {3, 0, 6, 1, 5};
		System.out.println(solution(citations));
	}

}
