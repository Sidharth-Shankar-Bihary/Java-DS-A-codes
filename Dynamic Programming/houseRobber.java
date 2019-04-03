import java.util.*;

class houseRobber{
	
	public static int findMax(List<Integer> list) {
		if(list.size() == 1) return list.get(0);
		else if(list.size() == 2) return Math.max(list.get(0), list.get(1));
		else{
			int[] dp = new int[list.size()];
			dp[0] = list.get(0);
			dp[1] = Math.max(list.get(0), list.get(1));
			for(int i=2; i<list.size(); i++) {
				dp[i] = Math.max(dp[i-2]+list.get(i), dp[i-1]);
			}
			return dp[list.size()-1];
		}
		
	}
	
	
	public static void main(String []args) {
		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(5);
		list.add(23);
		list.add(22);
		list.add(1);
		list.add(45);
		int ans = findMax(list);
		System.out.println(ans);
	}
}