package baekjoon.problems.samsungSwTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
class Chicken{
	int x;
	int y;
	public Chicken(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
public class 치킨배달 {
	public static int answer;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static List<Chicken> chickenHouse;
	public static List<Chicken> house;
	public static List<Chicken> selectChicken;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[n][n];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<n;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		System.out.println(solution(map,n,m));
	}

	private static int solution(int[][] map, int n, int m) {
		answer = Integer.MAX_VALUE;
		chickenHouse = new ArrayList<>();
		house = new ArrayList<>();
		selectChicken = new ArrayList<>();
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(map[i][j] == 2) {
					chickenHouse.add(new Chicken(j, i));
				}else if(map[i][j] == 1) {
					house.add(new Chicken(j, i));
				}
			}
		}
		dfs(map,n,0,0,m);
		return answer;
	}

	private static void dfs(int[][] map, int n, int index, int count, int m) {
		if(count == m) {
			find();
			return;
		}
		for (int i = index; i < chickenHouse.size(); i++) {
            selectChicken.add(chickenHouse.get(i));
            dfs(map,n,i+1,count+1,m);
            selectChicken.remove(selectChicken.size()-1);
        }
	}

	private static void find() {
		int sum = 0;
		for(int i=0;i<house.size();++i) {
			Chicken c = house.get(i);
			int min = Integer.MAX_VALUE;
			for(int j=0;j<selectChicken.size();++j) {
				Chicken chicken = selectChicken.get(j);
				min = Math.min(Math.abs(c.x-chicken.x) +Math.abs(c.y-chicken.y), min);
			}
			sum += min;
		}
		answer = Math.min(sum,answer);
	}

}
