package baekjoon.workbook.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ¿À¸® {
	public static boolean isError = false;
	private static int solution(String crying) {
		int[] counts = new int[5];
		List<Stack<Character>> docks = new ArrayList<>();
		for(char c :crying.toCharArray()) {
			switch (c) {
			case 'q': 
				counts[0]++;
				if(docks.isEmpty()) {
					docks.add(new Stack<>());
					docks.get(0).push('q');
				}else if(!findLocation(docks, 'k', 'q')) {
					docks.add(new Stack<>());
					docks.get(docks.size()-1).add('q');
				}
				break;
			case 'u' :
				counts[1]++;
				if(!findLocation(docks, 'q', 'u')) {
					return -1;
				}
				break;
			case 'a' :
				counts[2]++;
				if(!findLocation(docks, 'u', 'a')) {
					return -1;
				}
				break;
			case 'c' :
				counts[3]++;
				if(!findLocation(docks, 'a', 'c')) {
					return -1;
				}
				break;
			case 'k' :
				counts[4]++;
				if(!findLocation(docks, 'c', 'k')) {
					return -1;
				}
				break;
			}
			
		}
		int totalDock = 0, qCnt = counts[0];
    	boolean isOk = true;
    	for(int i = 0; i < 5; i++) {
    		totalDock += counts[i];
    		if(qCnt != counts[i]) {
    			isOk = false;
    			break;
    		}
    	}
    	if(totalDock % 5 != 0)
    		isOk = false;
    	if(isOk)
    		return docks.size();
    	else
    		return -1;
	}
	
	private static boolean findLocation(List<Stack<Character>> docks, char lastCharcter, char nowCharacter) {
		for(int i=0;i<docks.size();++i) {
			if(docks.get(i).peek() == lastCharcter) {
				docks.get(i).add(nowCharacter);
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String crying = reader.readLine();
		System.out.println(solution(crying));
	}



}
