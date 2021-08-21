package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자구슬 {
	public static int upperBound,lowerBound;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		tokens = new StringTokenizer(reader.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
			upperBound += arr[i];
            lowerBound = Math.max(lowerBound, arr[i]);
		}
		System.out.println(solution(n,m,arr));
	}

	private static String solution(int n, int m, int[] arr) {
		int mid = 0;
		//이분 탐색
        while (lowerBound <= upperBound) {
            mid = (lowerBound + upperBound) / 2;
            int cnt = isPossible(arr,mid,n);
            if (cnt > m) {
                lowerBound = mid + 1;
            } else {
                upperBound = mid - 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(lowerBound + "\n");
        int cnt = 0, sum = 0, i;
        for (i = 1; i <= n; i++) {
            sum += arr[i-1];
            if (sum > lowerBound) {
                m--;
                cnt = (cnt == 0 ? 1 : cnt);
                sb.append(cnt + " ");
                sum = arr[i-1];
                cnt = 0;
            }
            cnt++;
            // 1개씩 배치할 만한 구슬은 남겨둬야한다.
            if (m == n - i + 1) {
                break;
            }
        }
        for (; i <= n; i++) {
        	sb.append(cnt + " ");
            cnt = 1;
        }
		return sb.toString();
	}

	private static int isPossible(int[] arr,int mid,int n) {
		int start = 0, cnt = 1;
        for (int i = 0; i < n; i++) {
            start += arr[i];
            if (start > mid) {
                start = arr[i];
                cnt++;
            }
        }

        return cnt;
	}

}
