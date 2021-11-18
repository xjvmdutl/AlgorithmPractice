package hackerRank.interviewPreparationKit;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

public class JumpingontheClouds {

    public static int jumpingOnClouds(List<Integer> c) {
        int index = 0;
        int answer = 0;
        while(index < c.size()){
            if(index+2 < c.size()){
                if(c.get(index+2) == 0){
                	index += 2;
                }else{
                	index++;
                }
            }else if(index  == c.size()-1){ // index +1 < ÃÖÁ¾ °¹¼ö
                break;
            }else {
            	index++;
            }
            answer++;
        }
        return answer;
    }
	public static void main(String[] args) throws IOException {
		//7
		//0 0 1 0 0 1 0
		//6
		//0 0 0 0 1 0
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = jumpingOnClouds(c);
        
        System.out.println(result);

        bufferedReader.close();
	}

}
