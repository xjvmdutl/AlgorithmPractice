package progammers.level2.review;

import java.util.LinkedList;
import java.util.Queue;
class Person{
	int x;
	int y;
	public Person(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
public class 거리두기확인하기 {
	public static boolean[][] visit;
	public static boolean flag;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int i=0;i<places.length;++i) {
        	int result = 1;
        	char[][] arr = new char[5][5];
        	for(int j=0;j<places[i].length;++j) {
            	String s = places[i][j];
            	for(int k=0;k<s.length();++k) {
            		arr[j][k] = s.charAt(k);
            	}
            }	
        	flag = true;
        	visit = new boolean[5][5];
        	for(int j=0;j<arr.length;++j) {
            	for(int k=0;k<arr[i].length;++k) {
            		if(arr[j][k] == 'P') {
            			bfs(arr,k,j);
            			if(!flag) {
            				result = 0;
            				break;
            			}
            		}
            	}
            	if(!flag)
            		break;
            }	
        	answer[i] = result;
        }
        return answer;
    }
	private static void bfs(char[][] arr, int x, int y) {
		Queue<Person> que = new LinkedList<>();
		visit[y][x] = true;
		que.offer(new Person(x, y));
		while(!que.isEmpty()) {
			Person p = que.poll();
			for(int i=0;i<4;++i) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(0 <= nx && nx < 5 && 0 <= ny && ny < 5) {
					int manhattan = Math.abs(x - nx) + Math.abs(y - ny);
					if(!visit[ny][nx] && manhattan <= 2) {
						visit[ny][nx] = true;
						if(arr[ny][nx] == 'X') {
							continue;
						}else if(arr[ny][nx] == 'P') {
							flag = false;
							return;
		                }else {
		                	que.offer(new Person(nx, ny));
		                }
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		//places	result
		//[["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"], ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"], ["PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"], ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"], ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]]	[1, 0, 1, 1, 1]
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
							{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
							{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
							{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
							{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		System.out.println(solution(places));
	}

}
