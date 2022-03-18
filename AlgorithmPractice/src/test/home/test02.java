package test.home;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test02 {
	public static Map<Integer, Integer> map;
	public static int answer;
	public static void main(String[] args) {
		//arr	result
		//[3, 3, 6, 7, 7, 9]	12
		//[2, 2, 3, 3, 8, 8]	13
		//[5, 5, 5, 5, 5]	6
		int[] arr1 = {3, 3, 6, 7, 7, 9};
		System.out.println(solution(arr1));
		int[] arr2 = {2, 2, 3, 3, 8, 8};
		System.out.println(solution(arr2));
		int[] arr3 = {5, 5, 5, 5, 5,5, 5, 5, 5, 5,5, 5, 5, 5, 5,5, 5, 5, 5, 5,5, 5, 5, 5, 5,5, 5, 5, 5, 5,5, 5, 5, 5, 5,5, 5, 5, 5, 5,5, 5, 5, 5, 5,5, 5, 5, 5, 5,5, 5, 5, 5, 5,5, 5, 5, 5, 5,5, 5, 5, 5, 5,5, 5, 5, 5, 5,5, 5, 5, 5, 5,5, 5, 5, 5, 5,5, 5, 5, 5, 5,5, 5, 5, 5, 5,5, 5, 5, 5, 5,5, 5, 5, 5, 5,5, 5, 5, 5, 5,5, 5, 5, 5, 5,5, 5, 5, 5, 5,5, 5, 5, 5, 5,5, 5, 5, 5, 5,5, 5, 5, 5, 5,5, 5, 5, 5, 5};
		System.out.println(solution(arr3));
	}

	private static int solution(int[] arr) {
		answer = 0;
		Arrays.sort(arr);
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<arr.length;++i) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		int last = Integer.MAX_VALUE;
		List<Integer> datas = new ArrayList<>(map.keySet());
		Collections.sort(datas);
		permutation(datas, map, last, 0, datas.size()-1);
		return answer;
	}

	private static void permutation(List<Integer> arr, Map<Integer, Integer> map, int last, int length, int index) {
		answer = Math.max(answer, length);
		if(index < 0)
			return;
		int now = map.get(arr.get(index));
		if(now >= 2) {
			map.put(arr.get(index), map.get(arr.get(index)) - 2);
			for(Integer num2 : map.keySet()) {
				if(map.get(num2) >= 1 && last >= num2) {
					map.put(num2, map.get(num2) - 1);
					if(map.get(num2) <= 0)
						map.remove(num2);
					permutation(arr, map, num2, length + arr.get(index) + 1, index);		
					map.put(num2, map.get(num2) + 1);
				}
			}
			map.put(arr.get(index), map.get(arr.get(index)) + 2);
		}else {
			permutation(arr, map, last, length, index-1);
		}
	}
	
}
