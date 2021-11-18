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
		  int fre = 0; // ���ڿ� �� a Ƚ��
	    for(char c : s.toCharArray()) {
	    	if(c == 'a') {
	    		fre++;
	    	}
	    }
	    long count = fre * ((n-1) / s.length()); // ���ڿ� �� a Ƚ�� * ((n-1) / ���ڿ� ����) 
	    int idx = (int) ((n-1) % s.length()); // ���ڿ� ������ ���Ҵ��� 
	    for(int i=0;i <=idx;++i) {//�߰��� ���� ���� ���� for��
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
