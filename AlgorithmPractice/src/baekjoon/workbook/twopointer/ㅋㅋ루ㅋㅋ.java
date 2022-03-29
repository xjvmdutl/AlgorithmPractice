package baekjoon.workbook.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class せせ欠せせ {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		System.out.println(solution(s));
	}

	private static int solution(String s) {
		int answer = 0;
		List<Integer> leftK = new ArrayList<>();
		List<Integer> rightK = new ArrayList<>();
		int count = 0;
		for(char c : s.toCharArray()) {
			if(c == 'R')
				leftK.add(count);
			else
				count++;
				
		}
		count = 0;
		for(int i = s.length()-1; i>=0; --i) {
			if(s.charAt(i) == 'R')
				rightK.add(count);
			else
				count++;
		}
		rightK.sort(Comparator.reverseOrder());
		int start = 0;
		int end = leftK.size() - 1;
		while(start <= end) {
			answer = Math.max(answer, (end - start + 1) + 2 * (Math.min(leftK.get(start), rightK.get(end))));
			if(leftK.get(start) < rightK.get(end)) {
				start++;
			}else {
				end--;
			}
		}
		return answer;
	}

}
