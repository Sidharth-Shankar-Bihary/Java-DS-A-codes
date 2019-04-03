import java.util.*;

class intersection{
	
	public static int findIntersection(node list1, node list2) {
		int length1 = length(list1);
		int length2 = length(list2);
		int diff = 0;
		if(length1 == 0 || length2 == 0) return 0;
		if(length1 > length2) {
			diff= length1 - length2;
			for(int i=1; i<=diff; i++) {
				list1 = list1.next;
			}
		}
		else {
			diff = length2 - length1;
			for(int i=1; i<= diff; i++) {
				list2 = list2.next;
			}
		}
		while(list1.value != list2.value && list1 != null && list2 != null) {
			list1 = list1.next;
			list2 = list2.next;
		}
		return list1.value;
	}
	
	public static int length(node list) {
		int length = 0;
		while(list != null) {
			length++;
			list = list.next;
		}
		return length;
	}
	
	public static void main(String []args) {
		createlist c = new createlist();
		int ans = findIntersection(c.list1, c.list2);
		System.out.println(ans);
	}
}