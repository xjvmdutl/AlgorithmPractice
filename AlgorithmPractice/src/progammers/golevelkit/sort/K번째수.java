package progammers.golevelkit.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class K¹øÂ°¼ö {
	public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0;i<commands.length;++i) {
        	int start = commands[i][0]-1;
        	int end = commands[i][1]-1;
        	int k = commands[i][2]-1;
        	List<Integer> list = new ArrayList<>();
        	for(int j=start;j<=end;++j) {
        		list.add(array[j]);
        	}
        	Collections.sort(list);
        	answer[i]=list.get(k);
        }
        return answer;
    }
	public static void main(String[] args) {
		//array	commands	return
		//[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}; 
		System.out.println(solution(array,commands));
	}

}
