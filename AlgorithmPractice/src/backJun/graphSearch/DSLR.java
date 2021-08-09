package backJun.graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Register{
	String command;
	int num;
	public Register(String command,int num) {
		this.command = command;
		this.num = num;
	}
	int D() {
        return (num * 2) % 10000;
    }

    int S() {
        return num == 0 ? 9999 : num - 1;
    }

    int L() {
        return num % 1000 * 10 + num / 1000;
    }

    int R() {
        return num % 10 * 1000 + num / 10;
    }
}
public class DSLR {
	public static StringBuilder sb;
	public static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for(int i=0;i<t;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			System.out.println(solution(a,b));
		}
	}

	private static String solution(int a, int b) {
		sb = new StringBuilder(); 
		visit = new boolean[10000];
		bfs(a,b);
		
		return sb.toString();
	}

	private static void bfs(int a, int b) {
        

        Queue<Register> que = new LinkedList<>();
        visit[a] = true;
        que.add(new Register("",a));

        String ans = "";
        while (!que.isEmpty()) {
            Register cur = que.poll();

            if (cur.num == b) {
                System.out.println(cur.command);
                break;
            }

            if (!visit[cur.D()]) {
                que.add(new Register(cur.command + "D",cur.D()));
                visit[cur.D()] = true;
            }
            if (!visit[cur.S()]) {
                que.add(new Register(cur.command + "S",cur.S()));
                visit[cur.S()] = true;
            }
            if (!visit[cur.L()]) {
                que.add(new Register( cur.command + "L",cur.L()));
                visit[cur.L()] = true;
            }
            if (!visit[cur.R()]) {
                que.add(new Register(cur.command + "R",cur.R()));
                visit[cur.R()] = true;
            }

        }

	}

}
