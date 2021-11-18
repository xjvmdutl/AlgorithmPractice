package hackerRank.interviewPreparationKit;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CountingValleys {
	 public static int countingValleys(int steps, String path) {
		 int n = 0;//���鼱
	    int answer = 0;//���
	    for(int i=0;i<steps;++i){
	    char c = path.charAt(i);//�ö󰡴��� ���������� ('U', 'D')
		    if(c == 'U'){//�ö� ���
		        n++; // ���鼱 ����
		    }else{ // ������ ���
		        if(n == 0){ // 0���� ��������� ��, 0 -> -1 (���)
		            answer++;
		        }
	            n--;
	        }
	    }
	    return answer;
	}
	public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = countingValleys(steps, path);

        System.out.println(result);
        
        bufferedReader.close();
    }

}
