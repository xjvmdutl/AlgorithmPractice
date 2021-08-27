package progammers.level1;


import java.util.Arrays;

public class K¹øÂ°¼ö {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
        for(int l=0;l<commands.length;++l){
            int i=commands[l][0]-1;
            int j=commands[l][1]-1;
            int k=commands[l][2];
            int[] tmp = new int[j-i+1];
            for(int index=0;index<j-i+1;++index){
                tmp[index] = array[i+index];
            }
            Arrays.sort(tmp);
            answer[l] = tmp[k-1];
        }
        return answer;
	}
	public static void main(String[] args) {

	}

}
