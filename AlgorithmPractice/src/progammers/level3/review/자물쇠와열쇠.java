package progammers.level3.review;

public class ÀÚ¹°¼è¿Í¿­¼è {
	public static boolean solution(int[][] key, int[][] lock) {
        int N = key.length;
        int[][][] rotationKey = new int[4][N][N];
        rotationKey[0] = key;
        for(int i=1;i<rotationKey.length;++i) {
        	rotationKey[i] = rotation(rotationKey[i-1], N);
        }
        for(int k=0;k<4;++k) {
        	int size = lock.length - 1;
        	int[][] paddingKey = padding(rotationKey[k], N, size);
        	for(int i=0;i<paddingKey.length - size;++i) {
        		OUTER:for(int j=0;j<paddingKey.length - size;++j) {
            		int M = lock.length;
            		for(int R=0; R < M; ++R) {
            			for(int C=0; C < M; ++C) {
                            if(paddingKey[i + R][j + C] == lock[R][C]) {
                            	continue OUTER;
                            }
                		}	
            		}
            		return true;
            	}	
        	}
        }
        return false;
	}
	private static int[][] padding(int[][] key, int N, int size) {
		int[][] padding = new int[N + 2*size][N + 2*size];
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				padding[i+size][j+size] = key[i][j]; 
			}	
		}
		return padding;
	}
	private static int[][] rotation(int[][] key, int N) {
		int[][] result = new int[N][N];
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				result[i][j] = key[N-j-1][i];
			}	
		}
		return result;
	}
	public static void main(String[] args) {
		//key								lock								result
		//[[0, 0, 0], [1, 0, 0], [0, 1, 1]]	[[1, 1, 1], [1, 1, 0], [1, 0, 1]]	true
		int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
		int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		System.out.println(solution(key, lock));
	}

}
