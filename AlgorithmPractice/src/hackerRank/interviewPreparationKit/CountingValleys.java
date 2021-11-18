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
		 int n = 0;//수면선
	    int answer = 0;//결과
	    for(int i=0;i<steps;++i){
	    char c = path.charAt(i);//올라가는지 내려가는지 ('U', 'D')
		    if(c == 'U'){//올라갈 경우
		        n++; // 수면선 증가
		    }else{ // 내려갈 경우
		        if(n == 0){ // 0에서 내려갈경우 즉, 0 -> -1 (잠수)
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
