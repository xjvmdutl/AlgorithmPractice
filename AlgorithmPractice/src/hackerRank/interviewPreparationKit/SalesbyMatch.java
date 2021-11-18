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

public class SalesbyMatch {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = sockMerchant(n, ar);

        bufferedReader.close();
    }

	private static int sockMerchant(int n, List<Integer> ar) {
		Map<Integer,Integer> map = new HashMap<>();// 숫자 : 갯수
        for(int num : ar){
            map.put(num,map.getOrDefault(num,0)+1); // 갯수가 있을 경우 : 갯수 +1 , 없을 경우 갯수 : 0 + 1
        }
        int answer = 0;
        for(int key : map.keySet()){
            answer += map.get(key)/2; //갯수를 2로 나눈 값을 더해준다.
        }
        return answer;
	}

}
