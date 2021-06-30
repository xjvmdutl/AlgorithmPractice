package progammers.level1;

public class 제일작은수 {
	public static int[] solution(int[] arr) {
        if(arr.length<=1) {
           return new int[]{-1};
        } 
        int min = arr[0];
        for(int i=1; i<arr.length; i++) {
           if(min>arr[i]) {
        	   min = arr[i];
           }
        }
        int[] answer = new int[arr.length-1];
        int j =0;
        for(int i=0;i<arr.length;++i) {
        	if(arr[i] == min) {
        		continue;
        	}
        	answer[j] = arr[i];
        	j++;
        }
           
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
