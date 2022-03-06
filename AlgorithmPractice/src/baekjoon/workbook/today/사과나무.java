package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SecureCacheResponse;
import java.util.StringTokenizer;

public class 사과나무 {
	public static int[][] parent;
	public static int[] depth;
	public static int[] zeroInSeq;
	public static int[] nodeInSeq;
	public static int[] oneInSeq;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int S = 0;
        for (int i = 1; i <= n; i *= 2) {
            S++;
        }
		parent = new int[S][n+1];
		depth = new int[n+1];
		nodeInSeq = new int[2 * n + 1];
		oneInSeq = new int[n+1];
		zeroInSeq = new int[n+1];
		int current = 1;
		int id = 1;
		String seq = reader.readLine();
		for(int i=1;i<=seq.length();++i) {
			if(seq.charAt(i-1) == '0') {
				parent[0][id] = current;
				depth[id] = depth[current];
				nodeInSeq[i] = id;
				zeroInSeq[id] = i;
				current = id++;
			}else {
				nodeInSeq[i] = current;
				oneInSeq[current] =i;
				current = parent[0][current];
			}
		}
		for(int i=1;i<S;++i) {
			for(int j=1;j<=n;++j) {
				parent[i][j] = parent[i - 1][parent[i - 1][j]];
			}
		}
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int a = Integer.parseInt(tokens.nextToken());
		int b = Integer.parseInt(tokens.nextToken());
		int A = nodeInSeq[a];
		int B = nodeInSeq[b];
		int lca = LCA(A, B, S);
		System.out.println(zeroInSeq[lca] + " "+ oneInSeq[lca]);
	}
	private static int LCA(int a, int b, int s) {
		 if(depth[a] > depth[b]) { // 항상 b가 더 깊도록
	            int temp = a;
	            a = b;
	            b = temp;
	        }

	        for (int i = s - 1; i >= 0; i--) { // 깊이 맞춰주기
	            if (depth[a] <= depth[parent[i][b]]) {
	                b = parent[i][b];
	            }
	        }
	        if(a == b) return a;

	        for (int i = s - 1; i >= 0; i--) {
	            if (parent[i][a] != parent[i][b]) {
	                a = parent[i][a];
	                b = parent[i][b];
	            }
	        }
	        return parent[0][a];
	}

}
