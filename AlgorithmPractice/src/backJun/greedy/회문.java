package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class È¸¹® {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		for(int i=0;i<n;++i) {
			String str = reader.readLine();
			System.out.println(solution(str));
		}
	}

	private static int solution(String str) {
		StringBuilder sb= new StringBuilder(str);
		StringBuilder sb1 = new StringBuilder(str.substring(0,str.length()/2));
		StringBuilder sb2;
		if(str.length() % 2 == 0) {
			sb2 = new StringBuilder(str.substring(str.length()/2)).reverse();
		}else {
			sb2 = new StringBuilder(str.substring(str.length()/2+1)).reverse();
		}
		if(sb2.toString().equals(sb1.toString()))
			return 0;
		else {
			for(int i =0;i<sb1.length();++i) {
				if(sb1.charAt(i) != sb2.charAt(i)) {
				
					sb.delete(i, i+1);
					sb1 = new StringBuilder(sb.substring(0,sb.length()/2));
					if(sb.length() % 2 == 0) {
						sb2 = new StringBuilder(sb.substring(sb.length()/2)).reverse();
					}else {
						sb2 = new StringBuilder(sb.substring(sb.length()/2+1)).reverse();
					}
					if(sb2.toString().equals(sb1.toString()))
						return 1;
					sb = new StringBuilder(str);
					
					sb.delete(sb.length() - i -1, sb.length() - i);
					sb1 = new StringBuilder(sb.substring(0,sb.length()/2));
					if(sb.length() % 2 == 0) {
						sb2 = new StringBuilder(sb.substring(sb.length()/2)).reverse();
					}else {
						sb2 = new StringBuilder(sb.substring(sb.length()/2+1)).reverse();
					}
					if(sb2.toString().equals(sb1.toString()))
						return 1;
					break;
				}
			}
		}
			
		return 2;
	}

}
