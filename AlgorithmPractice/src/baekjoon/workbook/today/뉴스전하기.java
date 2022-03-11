package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
class News{
	int index;
	int time;
	public News(int index, int time) {
		this.index = index;
		this.time = time;
	}
}
public class 뉴스전하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		List<News>[] map = new ArrayList[n];
		for(int i=0;i<n;++i) {
			map[i] = new ArrayList<>();
			int now = Integer.parseInt(tokens.nextToken());
			if(now == -1)
				continue;
			map[now].add(new News(i, 0));
		}
		System.out.println(solution(map, n));
	}

	private static int solution(List<News>[] map, int n) {
		return permulate(map, 0, n);
	}


	private static int permulate(List<News>[] map, int count, int n) {
		int result = 0;
		for(int i=0;i<map[count].size();++i) {
			map[count].get(i).time = 1 + permulate(map, map[count].get(i).index, n);
		}
		Collections.sort(map[count], (o1, o2)->{
			return o2.time - o1.time;
		});
		for(int i=0; i<map[count].size(); i++) {
			map[count].get(i).time += i;
            result = Math.max(result, map[count].get(i).time);
        }
		return result;
	}

}
