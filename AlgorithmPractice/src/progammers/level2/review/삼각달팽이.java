package progammers.level2.review;

public class ªÔ∞¢¥ﬁ∆ÿ¿Ã {
	public static int[] solution(int n) {
        
        int[][] arr = new int[n][n];
        
        int x = -1, y = 0;
        int num = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) { 	
                if (i % 3 == 0) {
                    x++;
                } else if (i % 3 == 1) {
                    y++;
                } else if (i % 3 == 2) {
                    x--;
                    y--;
                }
                arr[x][y] = num++;
            }
        }
        int[] answer = new int[--num];
        int idx = 0;
        for(int i=0;i<arr.length;++i) {
        	for(int j=0;j<arr[i].length;++j) {
        		if(arr[i][j] == 0) {
        			break;
        		}
        		answer[idx++] = arr[i][j];
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		//n	result
		//4	[1,2,9,3,10,8,4,5,6,7]
		//5	[1,2,12,3,13,11,4,14,15,10,5,6,7,8,9]
		//6	[1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11]
		int n1 = 4;
		System.out.println(solution(n1));
		int n2 = 5;
		System.out.println(solution(n2));
		int n3 = 6;
		System.out.println(solution(n3));
	}

}
