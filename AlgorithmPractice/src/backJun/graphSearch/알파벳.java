package backJun.graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class ¾ËÆÄºª {
	public static boolean[] visit;
	public static int ans,R,C;
	public static char[][] map;
	public static int[] dr = {-1,1,0,0};
	public static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		map = new char[R][C];
		for(int i=0;i<R;++i) {
			String s = reader.readLine();
			map[i] = s.toCharArray();
		}
		System.out.println(solution());
	}


    private static int solution() {
    	ans = 0;
    	visit = new boolean[26];
        visit[map[0][0] - 'A'] = true;
        DFS(0, 0, 1);
        return ans;
	}


	private static void DFS(int i, int j, int cnt) {
        if (ans < cnt)
            ans = cnt;
        else if (ans == 26)
            return;
        for (int dir = 0; dir < dr.length; dir++) {
            int nr = i + dr[dir];
            int nc = j + dc[dir];

            if (isRange(nr, nc) && !visit[map[nr][nc] - 'A']) {
                visit[map[nr][nc] - 'A'] = true;
                DFS(nr, nc, cnt + 1);
                visit[map[nr][nc] - 'A'] = false;
            }
        }

    }

    private static boolean isRange(int nr, int nc) {
        if (0 <= nr && nr < R && 0 <= nc && nc < C)
            return true;
        return false;
    }
	
}
