package baekjoon.problems.samsungSwTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class �Ը��Ǵ���2 {
	public static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] map = new int[n][n];
		int totalCount = 0;
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<n;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
				totalCount += map[i][j];
			}
		}
		System.out.println(solution(map,n,totalCount));
	}

	private static int solution(int[][] map, int n, int totalCount) {
		answer = Integer.MAX_VALUE;
		for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                for (int d1 = 1; d1 < n; d1++) {
                    for (int d2 = 1; d2 < n; d2++) {
                        if (x + d1 + d2 >= n) continue;
                        if (y - d1 < 0 || y + d2 >= n) continue;

                        counting(map,x, y, d1, d2,totalCount,n);
                    }
                }
            }
        }
		return answer;
	}

	private static void counting(int[][] map,int x, int y, int d1, int d2, int totalCount,int n) {
		boolean[][] border = new boolean[n][n];
		// ��輱 ����
        for (int i = 0; i <= d1; i++) {
            border[x + i][y - i] = true;
            border[x + d2 + i][y + d2 - i] = true;
        }
        for (int i = 0; i <= d2; i++) {
            border[x + i][y + i] = true;
            border[x + d1 + i][y - d1 + i] = true;
        }
        int[] peopleSum = new int[5];

        // 1 ���� �α���
        for (int i = 0; i < x + d1; i++) {
            for (int j = 0; j <= y; j++) {
                if (border[i][j]) break;
                peopleSum[0] += map[i][j];
            }
        }

        // 2 ���� �α���
        for (int i = 0; i <= x + d2; i++) {
            for (int j = n - 1; j > y; j--) {
                if (border[i][j]) break;
                peopleSum[1] += map[i][j];
            }
        }

        // 3 ���� �α���
        for (int i = x + d1; i < n; i++) {
            for (int j = 0; j < y - d1 + d2; j++) {
                if (border[i][j]) break;
                peopleSum[2] += map[i][j];
            }
        }

        // 4 ���� �α���
        for (int i = x + d2 + 1; i < n; i++) {
            for (int j = n - 1; j >= y - d1 + d2; j--) {
                if (border[i][j]) break;
                peopleSum[3] += map[i][j];
            }
        }

        // 5 ���� �α���
        peopleSum[4] = totalCount;
        for (int i = 0; i < 4; i++) {
            peopleSum[4] -= peopleSum[i];
        }
        // ����
        Arrays.sort(peopleSum);

        // �ִ� - �ּ�
        answer = Math.min(answer, peopleSum[4] - peopleSum[0]);
	}

}
