package baekjoon.sieveofEratosthenes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 수학은너무쉬워 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr,n));
	}

	private static String solution(int[] arr, int n) {
		StringBuilder sb = new StringBuilder();
		boolean[] sosu = new boolean[1000001];
		Map<Integer,Integer> map = new HashMap<>();
		sosu[1] = true;
		List<Map<Integer,Integer>> list = new ArrayList<>();
		for(int i=2;i<=1000000;++i) {
			if(sosu[i])
				continue;
			for(int j=i+i;j<=1000000;j+=i) {
				sosu[j] = true;
			}
		}
		for(int i=0;i<arr.length;++i) {
			int num = arr[i];
			list.add(new HashMap<>());
			while(num > 1) {
				int idx = 2;
				for(;idx<=num;++idx) {
					if(!sosu[idx] && num % idx == 0) {
						list.get(i).put(idx,list.get(i).getOrDefault(idx, 0)+1);
						map.put(idx, map.getOrDefault(idx, 0)+1);
						num /= idx;
						break;
					}
				}
			}
			
		}
		int answer = 1;
		for(int key : map.keySet()) {
			answer *= Math.pow(key, map.get(key)/n);
		}
		int retrunCount = 0;
		for (int i = 0; i < list.size(); i++) {
	        Map<Integer,Integer> tmp = list.get(i);
	        for(int key : map.keySet()) {
				int now = map.get(key)/n;
				int count = 0;
				if(tmp.containsKey(key)) {
					count = tmp.get(key);
				}
				if(count < now) {
					retrunCount += now - count;
				}
			}
	      
	    }
		
		sb.append(answer +  " " + retrunCount);
		return sb.toString();
	}

}
