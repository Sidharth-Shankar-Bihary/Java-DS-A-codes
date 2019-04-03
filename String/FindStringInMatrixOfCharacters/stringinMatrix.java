import java.util.*;

class stringinMatrix{
	
	
	public static String findString(List<ArrayList<Character>> list, String target){
		if(list.get(0).get(0) != target.charAt(0)) return "NO PATH";
		else {
			String s1 = find(list, target, 0, 1, 1, "R");
			String s2 = find(list, target, 1, 0, 1, "D");
			if(s1.isEmpty() && s2.isEmpty()) return "NO PATH";
			else if(!s1.isEmpty()) return s1;
			else return s2;
		}
	}
	
	public static String find(List<ArrayList<Character>> list, String target, int i, int j, int count, String ans) {
		//System.out.println(ans + count+ " "+i+" "+j+" "+target.length());
		if(i == list.size() || j == list.get(0).size()) return "";
		else if(count == target.length()-1 && list.get(i).get(j) == target.charAt(count)){
			return ans;
		}
	    else if(list.get(i).get(j) != target.charAt(count)) return "";
		
		else {
			if(i == list.size()-1) {
				return find(list, target, i, j+1, count+1, ans+"R");
			}
			else if(j == list.get(0).size()-1) {
				return find(list, target, i+1, j, count+1, ans+"D");
			}
			else {
				String s1 = find(list, target, i, j+1, count+1, ans+"R");
				String s2 = find(list, target, i+1, j, count+1, ans+"D");
				if(!s1.isEmpty()) return s1;
				else return s2;
			}
		}
		
	}
	
	public static void main(String []args) {
		List<ArrayList<Character>> list = new ArrayList<ArrayList<Character>>();
		/*
		list.get(0).add('a'); list.get(0).add('b'); list.get(0).add('j'); list.get(0).add('d');
		list.get(1).add('n'); list.get(1).add('j'); list.get(1).add('k'); list.get(1).add('m');
		list.get(2).add('e'); list.get(2).add('f'); list.get(2).add('q'); list.get(2).add('z');
		*/
		ArrayList<Character> list1 = new ArrayList<Character>();
		list1.add('a'); list1.add('b'); list1.add('j'); list1.add('d');
		list.add(list1);
		
		ArrayList<Character> list2 = new ArrayList<Character>();
		list2.add('n'); list2.add('j'); list2.add('k'); list2.add('m');
		list.add(list2);
		
		ArrayList<Character> list3 = new ArrayList<Character>();
		list3.add('e'); list3.add('f'); list3.add('q'); list3.add('z');
		list.add(list3);
		
		String s = findString(list, "abjfqz");
		System.out.println(s);
	}
}