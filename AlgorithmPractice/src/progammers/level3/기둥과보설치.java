package progammers.level3;



public class 기둥과보설치 {
    public static int[][] solution(int n, int[][] build_frame) {
        int count = 0;
        boolean[][] pillar = new boolean[n+1][n+1];
        boolean[][] bar = new boolean[n+1][n+1];
        for(int[] frame: build_frame) {
        	int x = frame[0];
        	int y = frame[1];
        	int type = frame[2];
        	int flag = frame[3];
        	if(type == 0) {//기둥
        		if(flag == 1) { //설치
        			if(CheckPillar(pillar,bar,x,y)) {
        				pillar[x][y] = true;
            			count++;
        			}
        		}else { //삭제
        			pillar[x][y] = false;
        			if(!DeleteOkay(pillar,bar,n)) {
        				pillar[x][y] = true;
        			}else {
        				count--;
        			}
        		}
        	}else { // 보
        		if(flag == 1) { //설치
        			if(CheckBar(pillar,bar,x,y)) {
        				bar[x][y] = true;
            			count++;
        			}
        		}else {
        			bar[x][y] = false;
        			if(!DeleteOkay(pillar,bar,n)) {
        				bar[x][y] = true;
        			}else {
        				count--;
        			}
        		}
        	}
        }
        int[][] answer = new int[count][3];
        int idx = 0;
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                if(pillar[i][j]) {
                    answer[idx][0] = i;
                    answer[idx][1] = j; 
                    answer[idx++][2] = 0;
                }
                if(bar[i][j]) {
                	answer[idx][0] = i;
                	answer[idx][1] = j;
                	answer[idx++][2] = 1;
                }
            }
        }
        return answer;
    }
	private static boolean DeleteOkay(boolean[][] pillar, boolean[][] bar, int n) {
		for(int i=0;i<=n;++i) {
			for(int j=0;j<=n;++j) {
				   if(pillar[i][j] && !CheckPillar(pillar,bar,i, j))
	                	return false;  
	                else if(bar[i][j] && !CheckBar(pillar,bar,i, j))
	                	return false; 
			}	
		}
		return true;
	}
	
	private static boolean CheckBar(boolean[][] pillar, boolean[][] bar, int x, int y) {
		if(y > 0 && pillar[x][y-1] || pillar[x+1][y-1]) {
			return true;
		}else if(x > 0 && bar[x-1][y] && bar[x+1][y]) {
			return true;
		}
		return false;
	}
	private static boolean CheckPillar(boolean[][] pillar, boolean[][] bar, int x, int y) {
		if(y == 0) 
			return true;
		else if(y > 0 && pillar[x][y-1])
			return true;
		else if((x > 0 && bar[x-1][y]) || bar[x][y])
			return true;
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//n	build_frame	result
		//5	[[1,0,0,1],[1,1,1,1],[2,1,0,1],[2,2,1,1],[5,0,0,1],[5,1,0,1],[4,2,1,1],[3,2,1,1]]	[[1,0,0],[1,1,1],[2,1,0],[2,2,1],[3,2,1],[4,2,1],[5,0,0],[5,1,0]]
		//5	[[0,0,0,1],[2,0,0,1],[4,0,0,1],[0,1,1,1],[1,1,1,1],[2,1,1,1],[3,1,1,1],[2,0,0,0],[1,1,1,0],[2,2,0,1]]	[[0,0,0],[0,1,1],[1,1,1],[2,1,1],[3,1,1],[4,0,0]]
		int[][] build_frame1 = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
		
		System.out.println(solution(5,build_frame1));
	}

}
