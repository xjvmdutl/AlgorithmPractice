package hackerRank.interviewPreparationKit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

public class RepeatedString {
	public static long repeatedString(String s, long n) {
		  int fre = 0; // 문자열 내 a 횟수
	    for(char c : s.toCharArray()) {
	    	if(c == 'a') {
	    		fre++;
	    	}
	    }
	    long count = fre * ((n-1) / s.length()); // 문자열 내 a 횟수 * ((n-1) / 문자열 길이) 
	    int idx = (int) ((n-1) % s.length()); // 문자열 어디까지 돌았는지 
	    for(int i=0;i <=idx;++i) {//중간에 끊긴 지점 까지 for문
	    	char c = s.charAt(i);
	    	if(c == 'a')
	    		count++;
	    }
	    return count;
    }
	public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = repeatedString(s, n);
        System.out.println(result);

        bufferedReader.close();
    }

}
