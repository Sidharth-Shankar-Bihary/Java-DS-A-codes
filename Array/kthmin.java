import java.util.*;


class kthmin{
	
	private static List<Integer> list = new ArrayList<Integer>();
	
	public static int kmin(int k){
		int n = list.size();
		int ans = 0;
		if(k > n) return 0;
		else {
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
			for(int i:list) {
				pq.add(i);
			}
			for(int i=1;i<=k;i++) {
				ans = pq.peek();
				pq.remove();
			}
			return ans;
		}
	}
	

	public static int kmax(int k){
		int n = list.size();
		int ans = 0;
		if(k > n) return 0;
		else {
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
			for(int i:list) {
				pq.add(i);
			}
			for(int i=1;i<=k;i++) {
				ans = pq.peek();
				pq.remove();
			}
			return ans;
		}
	}
	

	public static void main(String args[]) {
		
		list.add(5);
		list.add(7);
		list.add(11);
		list.add(21);
		list.add(15);
		list.add(23);
		list.add(18);
		list.add(4);
		int kmin = 5;
		int kmax = 6;
		int minAns = kmin(kmin);
		int maxAns = kmax(kmax);
		System.out.println(list);
		System.out.println(kmin+"th min = "+minAns+"\n"+kmax+"th max = "+maxAns);
	}
}