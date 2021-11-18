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
public class twoDArrayDS {
	public static int max;
    public static int hourglassSum(List<List<Integer>> arr) {
        max = Integer.MIN_VALUE;
        for(int i=0;i<arr.size()-2;++i){
            for(int j=0;j<arr.get(i).size()-2;++j){
                counting(arr,i, j);
            }   
        }
        return max;
    }
    public static void counting(List<List<Integer>> arr,int startI,int startJ){
        int sum = 0;
        for(int i=startI;i<=startI+2;++i){
            for(int j=startJ;j<=startJ+2;++j){
                sum += arr.get(i).get(j);
            }   
        }
        sum -= arr.get(startI+1).get(startJ); 
        sum -= arr.get(startI+1).get(startJ+2); 
        max = Math.max(max,sum);
    }
	    public static void main(String[] args) throws IOException {
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	        List<List<Integer>> arr = new ArrayList<>();

	        IntStream.range(0, 6).forEach(i -> {
	            try {
	                arr.add(
	                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
	                        .map(Integer::parseInt)
	                        .collect(toList())
	                );
	            } catch (IOException ex) {
	                throw new RuntimeException(ex);
	            }
	        });

	        int result = hourglassSum(arr);
	        System.out.println(result);

	        bufferedReader.close();
	    }

}
