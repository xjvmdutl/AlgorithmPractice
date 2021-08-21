package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여행가자 {
	public static int[] join;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int m = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][n];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<n;++j) {
				arr[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int[] route = new int[m];
		for(int i=0;i<m;++i) {
			route[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr,route,n,m));
	}

	private static String solution(int[][] arr, int[] route, int n, int m) {
		String answer = "YES";
		join = new int[n];
		for(int i=0;i<n;++i) {
			join[i] = i;
		}
		 for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                if (arr[i][j] == 1) {
	                    if (i < j) {
	                        union(j, i);
	                    } else {
	                        union(i, j);
	                    }
	                }
	            }
	        }

		int index = find(route[0]-1);
		for (int i = 1; i < route.length; i++) {
            if (index != find(route[i]-1)) {
            	answer = "NO";
            	return answer;
            }
        }
		return answer;
	}
	private static void union(int city1, int city2) {
	    int x = find(city1);
	    int y = find(city2);
	
	    if (x != y) {
	        join[x] = y;
	    }
	}
	private static int find(int city) {
	    if (join[city] == city) {
	        return city;
	    }
	
	    int p = find(join[city]);
	    join[city] = p;
	
	    return p;
	}
}
