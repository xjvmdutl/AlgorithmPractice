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

public class NewYearChaos {
    public static void minimumBribes(List<Integer> q) {
        int answer = 0;
        
        for(int i=0;i<q.size();++i){
        	  if(q.get(i) - (i+1) > 2){
	              System.out.println("Too chaotic");
	              return;
        	  }
        	  for (int j = Math.max(0, q.get(i) - 2); j < i; j++) //인당 최대 2명까지만 뇌물 가능
                  if (q.get(j) > q.get(i))
                	  answer++;
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }

}
