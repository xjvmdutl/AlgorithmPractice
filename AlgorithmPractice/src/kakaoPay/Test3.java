package kakaoPay;

public class Test3 {

	public static void main(String[] args) {
		String line1 ="abacaba";
		String line2 = "acb";
		System.out.println(solution(line1,line2));
	}

	private static int solution(String line1, String line2) {
		int answer = 0;
		int length = line2.length();
		String s = line2;
		int[] idxs = new int[line2.length()];
		char[] datas = new char[line2.length()];
		for(int i=0;i<line2.length();++i) {
			datas[i] = line2.charAt(i);
		}
		while(length <= line1.length()) {
			StringBuilder sb = new StringBuilder();
			int idx = 0;
			for(int i =0 ;i<s.length();++i) {
				char c = s.toString().charAt(i);
				if(c == '_')
					sb.append('_');
				else {
					sb.append(s.charAt(i));
					idxs[idx++] = i;
					sb.append('_');
				}
			}
			sb.delete(sb.length()-1, sb.length());
			int l = line1.length() - idxs[idx-1];
			for(int i=0;i<l;++i) {
				boolean flag = false;
				for(int j=0;j<idxs.length;++j) {
					char c = line1.charAt(idxs[j]+i);
					if(datas[j] != c) {
						flag = true;
						break;
					}
				}
				if(!flag)
					answer++;
			}
			s = sb.toString();
			length = s.length();
		}
		return answer;
	}

}
