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


public class ArrayManipulation {
	 public static long arrayManipulation(int n, List<List<Integer>> queries) {
        int[] arr = new int[n+1];
        long max = 0;
        long x = 0;

        for(int i=0;i<queries.size();++i){
            int a = queries.get(i).get(0);
            int b = queries.get(i).get(1);
            int k = queries.get(i).get(2);
            arr[a] += k;
            if((b+1) <= n){
                arr[b+1] -= k;
            }
        }
        for(int i=1;i<n+1;++i) {
        	x += arr[i];
            if(max < x) max = x;
        }
        
        return max;
    }
	 public static void main(String[] args) throws IOException {
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

	        int n = Integer.parseInt(firstMultipleInput[0]);

	        int m = Integer.parseInt(firstMultipleInput[1]);

	        List<List<Integer>> queries = new ArrayList<>();

	        IntStream.range(0, m).forEach(i -> {
	            try {
	                queries.add(
	                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
	                        .map(Integer::parseInt)
	                        .collect(toList())
	                );
	            } catch (IOException ex) {
	                throw new RuntimeException(ex);
	            }
	        });

	        long result = arrayManipulation(n, queries);

	        bufferedReader.close();
	    }

}
