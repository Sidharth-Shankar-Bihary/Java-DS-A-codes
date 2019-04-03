import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Connect{
	
	public static int connect(List<Integer> list) {
		if(list.isEmpty()) return 0;
		if(list.size() == 1) return list.get(0);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int cost = 0;
		for(int i: list) {
			pq.add(i);
		}
		while(pq.size() > 1) {
			int a = pq.peek();
			pq.remove();
			int b = pq.peek();
			pq.remove();
			pq.add(a+b);
			cost += a+b;
		}
		return cost;
	}
	
	public static void main(String []args) {
		List<Integer> list = Arrays.asList(3,7,4,2,6,8,5);
		int result = connect(list);
		System.out.println("the rope lengths are: "+list);
		System.out.println("and the min cost of joining them is: "+result);
	}
}