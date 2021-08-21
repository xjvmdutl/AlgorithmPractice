package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
class Info implements Comparable<Info> {
    int node;
    int time;
    Info(int node,int time){
        this.node=node;
        this.time=time;
    }
    @Override
    public int compareTo(Info o) {
        return Integer.compare(o.time,this.time);
    }
}

public class 뉴스전하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int[] arr = new int[n];
		List<Info>[] list = new ArrayList[n];
		for(int i=0;i<n;++i) {
			list[i] = new ArrayList<>();
		}
		tokens.nextToken();
		for(int i=1;i<n;++i) {
			int index = Integer.parseInt(tokens.nextToken());
			list[index].add(new Info(i, 0));
		}
		System.out.println(solution(list,n,0));
	}

	private static int solution(List<Info>[] list, int n,int idx) {
		int result = 0; 
        for(int i=0; i<list[idx].size(); i++) {
            int next = list[idx].get(i).node;
            list[idx].get(i).time = 1 + solution(list,n,next);
        }
        Collections.sort(list[idx]);
        for(int i=0; i<list[idx].size(); i++) {
        	list[idx].get(i).time += i;
            result = Math.max(result, list[idx].get(i).time);
        }
		return result;
	}

	

}
