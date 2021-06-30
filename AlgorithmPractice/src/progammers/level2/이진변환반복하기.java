package progammers.level2;

import java.util.ArrayList;
import java.util.List;

public class 이진변환반복하기 {
	public static int[] solution(String s) {
		
		int count = 0;
		int cnt = 0;
		while(true) {
			cnt++;
			StringBuilder sb= new StringBuilder();
		    for(int i=0;i<s.length();++i) {
		    	char c = s.charAt(i);
		    	if(c == '0') {
		    		count++;
		    		continue;
		    	}
		      	sb.append(c);
		    }
		   
		    s = Integer.toBinaryString(sb.length());
		    if(s.equals("1"))
		    	break;
		}
		
		
	    return new int[]{cnt,count};
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//s	result
		//"110010101001"	[3,8]
		//"01110"	[3,3]
		//"1111111"	[4,1]
		String s1 = "110010101001";
		int[] result1 = solution(s1);
		for(int i : result1)
			System.out.print(i + " ");
		System.out.println();
		String s2 = "01110";
		int[] result2 = solution(s2);
		for(int i : result2)
			System.out.print(i + " ");
		System.out.println();
		String s3 = "1111111";
		int[] result3 = solution(s3);
		for(int i : result3)
			System.out.print(i + " ");
		System.out.println();
		
	}

}
