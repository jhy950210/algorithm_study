package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

/* 올림픽 */
public class solution8 {
	static HashMap<Integer, String> medal = new HashMap<>();
	static int count = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		StringTokenizer st1 = new StringTokenizer(str1);
		int n = Integer.parseInt(st1.nextToken());
		int k = Integer.parseInt(st1.nextToken());
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			
			int country = Integer.parseInt(st.nextToken());
			medal.put(country, st.nextToken()+st.nextToken()+st.nextToken());
			
		}
		
		List<Integer> keySetList = new ArrayList<>(medal.keySet());
		Collections.sort(keySetList, (o1, o2) -> (medal.get(o2).compareTo(medal.get(o1))));
		
		String tmp = "";
		for( int key : keySetList ) {
			if(!medal.get(key).equals(tmp)) {
				count++;
			}
			if(key == k) {
				System.out.println(count);
				break;
			}
			tmp = medal.get(key);
		}
		
	}
	
}
