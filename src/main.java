import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, String> person = new HashMap<Integer, String>();
		String name = "";
		int score;
		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		for(int i=0; i < n; i++) {
			name = scan.next();
			score = scan.nextInt();
			
			person.put(score, name);
		}
		
		ArrayList<Integer> intScore = new ArrayList<Integer>();
		
		for(Integer i : person.keySet()){ //저장된 key값 확인
		    intScore.add(i);
		}
		
		Collections.sort(intScore, Collections.reverseOrder());
		
		System.out.println(person.get(intScore.get(2)));
		
	}
	
}
