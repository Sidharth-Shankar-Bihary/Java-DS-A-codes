import java.util.*;

public class KReverse{
	
	public static node list;
	public static node kReverse(node head, int k) {
		Stack<node> stk = new Stack<node>();
		int count = 0;
		node result = new node(-1);
		node tempResult = result;
		
		while(head != null) {
			while(head != null && count < k) {
				node temp = head;
				head = head.next;
				temp.next = null;
				stk.push(temp);
				count++;
			}
			while(!stk.isEmpty()) {
				node temp = stk.peek();
				stk.pop();
				result.next = temp;
				result = result.next;
			}
			count = 0;
		}
		result = tempResult;
		tempResult = result.next;
		result.next = null;
		result = tempResult;
		return result;
	}
	
	public static void main(String []args) {
		list = new node(1);
		node temp = list;
		for(int i=2; i<=8; i++) {
			temp.next = new node(i);
			temp = temp.next;
		}
		int k = 5;
		System.out.println("original linked list: ");
		temp = list;
		while(temp != null) {
			System.out.print(temp.value+" ");
			temp = temp.next;
		}
		System.out.println();
		node result = kReverse(list, k);
		System.out.println(Integer.toString(k)+"-reverse linked list: ");
		while(result != null) {
			System.out.print(result.value+" ");
			result = result.next;
		}
	}
}