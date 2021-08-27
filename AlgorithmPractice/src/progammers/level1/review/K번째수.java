package progammers.level1.review;

import java.util.Arrays;

public class K¹øÂ°¼ö {

	public static void main(String[] args) {
		//array	commands	return
		//[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}; 
		System.out.println(solution(array,commands));
	}

  public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0;i<commands.length;++i) {
        	int start = commands[i][0];
        	int end = commands[i][1];
        	int now = commands[i][2];
        	int[] tmp = new int[end-start+1];
        	int idx = 0;
        	for(int j=start-1;j<end;++j) {
        		tmp[idx++] = array[j];
        	}
        	Arrays.sort(tmp);
        	answer[i] = tmp[now-1];
        }
        return answer;
    }

}
