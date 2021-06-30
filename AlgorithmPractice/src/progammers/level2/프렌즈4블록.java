package progammers.level2;

import java.util.HashMap;
import java.util.Map;

public class «¡∑ª¡Ó4∫Ì∑œ {

	public static int solution(int m, int n, String[] board) {
		int answer = 0;
        Map<Character,Integer> map = new HashMap<>();
        int[][] arr = new int[m][n];
        init(map,board,arr);
        while(true){
            boolean isEnd = true;
            boolean[][] visit = new boolean[m][n];
            for(int i=0;i<m-1;++i){
                for(int j=0;j<n-1;++j){
                    if(arr[i][j] == 0) continue;
                    if(arr[i][j] == arr[i][j+1]
                      && arr[i][j] == arr[i+1][j]
                      && arr[i][j] == arr[i+1][j+1]){
                        isEnd = false;
                        visit[i][j] = true;
                        visit[i][j+1] = true;
                        visit[i+1][j] = true;
                        visit[i+1][j+1] = true;
                    }
                }
            }
            if(isEnd){
                break;
            }
            for(int i=0;i<visit.length;++i){
                for(int j=0;j<visit[i].length;++j){
                    if(visit[i][j]) {
                        arr[i][j] = 0;
                        answer++;
                        for(int k=i;k>0;--k){
                            int tmp = arr[k][j];
                            arr[k][j] = arr[k-1][j];
                            arr[k-1][j] = tmp;
                        }
                    }
                    
                }
            }
        }
        
        
        return answer;
        
    }
	private static void init(Map<Character,Integer> map,String[] board,int[][] arr){
        int cnt = 0;
        for(int i =0;i<board.length;++i){
            for(int j=0;j<board[i].length();++j){
                char c =board[i].charAt(j);
                if(!map.containsKey(c)){
                    map.put(c,++cnt);
                }
                arr[i][j] = map.get(c);
            }      
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//m	n	board	answer
		//4	5	["CCBDE", "AAADE", "AAABF", "CCBBF"]	14
		//6	6	["TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"]	15
		int m1 = 4;
		int n1 = 5;
		String[] board1 = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		System.out.println(solution(m1, n1, board1));
		
		int m2 = 6;
		int n2 = 6;
		String[] board2 = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
		System.out.println(solution(m2, n2, board2));
	}

}
