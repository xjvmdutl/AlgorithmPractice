package progammers.level2.review;

import java.util.Arrays;

public class 파일명정렬 {
	public static String[] solution(String[] files) {
        String[] answer = new String[files.length];
        String[][] tmp = new String[files.length][3];
        for(int i=0;i<files.length;++i) {
        	String file = files[i];
        	for(int j=0;j<file.length();++j) {
        		if(Character.isDigit(file.charAt(j))) {
        			tmp[i][0] = file.substring(0,j);//head
        			int idx = j;
        			while(j < file.length() && Character.isDigit(file.charAt(j)) && j - idx < 5) {
        				j++;
        			}
        			tmp[i][1] = file.substring(idx,j);
        			tmp[i][2] = file.substring(j);
        			break;
        		}
        	}
        }
        Arrays.sort(tmp,(o1,o2)->{
        	String s1 = o1[0].toUpperCase();
        	String s2 = o2[0].toUpperCase();
        	if(s1.equals(s2)) {
        		int n1 = Integer.parseInt(o1[1]);
        		int n2 = Integer.parseInt(o2[1]);
        		return n1-n2;
        	}
        	return s1.compareTo(s2);
        });
        for(int i=0;i<tmp.length;++i) {
        	answer[i] = tmp[i][0] + tmp[i][1] + tmp[i][2];
        }
        return answer;
    }
	public static void main(String[] args) {
		//파일명																					Result
		//["img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"]			["img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"]
		//["F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"]	["A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"]
		//["img0 00012345", "img1.png","img2","IMG02"]											["img000012345", "img1.png","img2","IMG02"]
		String[] file1 = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		System.out.println(solution(file1));
		String[] file2 = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
		System.out.println(solution(file2));
		String[] file3 = {"muzi123-457", "MUZI123-456"};
		System.out.println(solution(file3));
	
	}
	

}
