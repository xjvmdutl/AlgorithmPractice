package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ���������ѽ��۽�ŸK {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		int n = Integer.parseInt(strs[0]);
		int m = Integer.parseInt(strs[1]);
		int k = Integer.parseInt(strs[2]);
		Map<Integer,Double> map = new HashMap<>();
		for(int i=0;i<m;++i) {
			strs = reader.readLine().split(" ");
			for(int j=0;j<n;++j) {
				if(map.containsKey(Integer.parseInt(strs[j*2]))) {
					if(map.get(Integer.parseInt(strs[j*2])) < Double.parseDouble(strs[j*2+1])) {
						map.put(Integer.parseInt(strs[j*2]), Double.parseDouble(strs[j*2+1]));
					}
				}else {
					map.put(Integer.parseInt(strs[j*2]), Double.parseDouble(strs[j*2+1]));
				}
			}
		}
		// Map.Entry ����Ʈ �ۼ�
		List<Entry<Integer,Double>> list_entries = new ArrayList<Entry<Integer,Double>>(map.entrySet());

		// ���Լ� Comparator�� ����Ͽ� ���� �������� ����
		Collections.sort(list_entries, new Comparator<Entry<Integer,Double>>() {
			// compare�� ���� ��
			@Override
			public int compare(Entry<Integer, Double> o1, Entry<Integer, Double> o2) {
				// ���� �������� ����
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		int idx = 1;
		double sum = 0;
		for(Entry<Integer, Double> entry : list_entries) {
			if(idx>k)
				break;
			sum += entry.getValue();
			idx++;
		}
		System.out.println(Math.round(sum*10)/10.0);
	}

}
