package progammers.level1;

public class 문자열내p와y의개수 {
	public static boolean solution(String s) {
		int pCount = 0;
        int sCount = 0;
        for(int i=0;i<s.length();++i){
            if("p".equals(s.toLowerCase().substring(i, i+1))){
                pCount++;
            }else if("y".equals(s.toLowerCase().substring(i, i+1))){
                sCount++;
            }
        }
        
        return pCount==sCount? true:false;
    }
	/*
	 * 
	 *  s = s.toUpperCase();

        return s.chars().filter( e -> 'P'== e).count() == s.chars().filter( e -> 'Y'== e).count();
	 * 
	 * */
	public static void main(String[] args) {
		boolean s = solution("Pyy");
	}
}
