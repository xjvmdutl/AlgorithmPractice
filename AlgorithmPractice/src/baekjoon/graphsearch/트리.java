package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Æ®¸® {
	public static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] parents = new int[n];
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			parents[i] = Integer.parseInt(tokens.nextToken());
		}
		int remove = Integer.parseInt(reader.readLine());
		System.out.println(solution(parents,n,remove));
	}

	private static int solution(int[] parents, int n, int remove) {
		answer = 0;
		int root=0;
		for(int i=0;i<parents.length;++i) {
			if(parents[i] == -1) {
				root = i;
				break;
			}
		}
		removeNode(parents,remove);
		
		dfs(parents,root);
		
		return answer;
	}

	private static void dfs(int[] parents, int idx) {
		boolean isLeaf = true;
		 if(parents[idx] != Integer.MIN_VALUE) {
            for(int i = 0; i < parents.length; i++) {
                if(parents[i] == idx) {
                	dfs(parents,i);
                	isLeaf = false;
                }
            }
            if(isLeaf) 
            	answer++;
        }
	}

	private static void removeNode(int[] parents, int remove) {
		parents[remove] = Integer.MIN_VALUE;
		for(int i = 0; i < parents.length; i++) {
            if(parents[i] == remove) {
            	removeNode(parents,i);
            }
        }
	}

}
