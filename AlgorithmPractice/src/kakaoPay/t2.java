package kakaoPay;

import java.util.Arrays;

public class t2 {
	  public static int[] solution(int[] m, int[] b) {
        int[] answer = new int[m.length];
        int cnt = 0;
        for(int i=0;i<m.length;++i) {
        	int[] arr = new int[m[i]];
        	for(int j=cnt;j<cnt+m[i];++j) {
        		arr[j-cnt] = b[j];
        	}
        	int count = 0;
        	Arrays.sort(arr);
        	String str = Integer.toBinaryString(arr[0]);
        	for(int j =0;j<str.length();++j) {
        		boolean flag = false;
        		for(int k=0;k<arr.length;++k) {
            		String bi = Integer.toBinaryString(arr[k]);
            		bi = bi.substring(bi.length()-str.length());
            		if(bi.charAt(j) == '0') {
            			flag = true;
            			break;
            		}
            	}	
        		if(!flag) {
        			count+=Math.pow(2, str.length()-j-1);
        		}
        	}
        	for(int j=0;j<4;++j) {
        		System.out.println(Integer.toBinaryString(arr[j]));
        	}
        	cnt += m[i];
        	answer[i] = count;
        }
        return answer;
    }
	public static void main(String[] args) {
		int[] m = {4};
		int[] b = {63,62,61,60};
		solution(m,b);
	}

}
