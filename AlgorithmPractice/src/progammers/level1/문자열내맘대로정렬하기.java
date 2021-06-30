package progammers.level1;

public class 문자열내맘대로정렬하기 {
	public static String[] solution(String[] strings, int n) {


        for(int i=0;i< strings.length;++i) {
        	for(int j=i+1;j<strings.length;++j) {
        		if(strings[i].substring(n,n+1).compareTo(strings[j].substring(n,n+1))>0) {
    				String tmp =strings[i];
    				strings[i] =strings[j];
    				strings[j]=tmp;
        		}else if(strings[i].substring(n,n+1).compareTo(strings[j].substring(n,n+1))==0){
        			if(strings[i].compareTo(strings[j])>0) {
        				String tmp =strings[i];
        				strings[i] =strings[j];
        				strings[j]=tmp;
        			}
        		}
        	}

        }
        return strings;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = {"abcd", "abce", "cdx"};
		String[] s2 = solution(s,2);
	}

}
