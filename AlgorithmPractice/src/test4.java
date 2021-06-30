import java.util.Arrays;

public class test4 {
	public static int[] solution(int[] array, int[][] commands) {
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
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] com = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		int[] d = solution(array,com);
	}

}
