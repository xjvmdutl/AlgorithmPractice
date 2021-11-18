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
import static java.util.stream.Collectors.toList;

public class ArraysLeftRotation {
	public static List<Integer> rotLeft(List<Integer> a, int d) {
        if(a.size() == d)
            return a;
        List<Integer> list = new ArrayList<>();
        for(int i=d;i<a.size();++i){
            list.add(a.get(i));
        }
        for(int i=0;i<d;++i){
            list.add(a.get(i));
        }
        return list;
    }

	  public static void main(String[] args) throws IOException {
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

	        int n = Integer.parseInt(firstMultipleInput[0]);

	        int d = Integer.parseInt(firstMultipleInput[1]);

	        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
	            .map(Integer::parseInt)
	            .collect(toList());

	        List<Integer> result = rotLeft(a, d);


	        bufferedReader.close();
	    }

}
