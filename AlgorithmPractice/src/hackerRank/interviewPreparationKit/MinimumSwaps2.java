package hackerRank.interviewPreparationKit;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinimumSwaps2 {
	 private static final Scanner scanner = new Scanner(System.in);
	// Complete the minimumSwaps function below.
	    static int minimumSwaps(int[] arr) {
	        int answer = 0;
	        for(int i=0;i<arr.length;){
	            if(arr[i] != (i+1)){
	                int tmp = arr[arr[i]-1];
	                arr[arr[i]-1] = arr[i];
	                arr[i] = tmp;
	                answer++;
	            }else {
	            	i++;
	            }
	        }
	        return answer;
	    }

	    public static void main(String[] args) throws IOException {

	        int n = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        int[] arr = new int[n];

	        String[] arrItems = scanner.nextLine().split(" ");
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int i = 0; i < n; i++) {
	            int arrItem = Integer.parseInt(arrItems[i]);
	            arr[i] = arrItem;
	        }

	        int res = minimumSwaps(arr);

	        scanner.close();
	    }

}
