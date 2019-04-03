import java.util.*;

public class createlist{
	node list1;
	node list2;
	node list3;
	
	createlist(){
		node temp;
		temp = new node(2);
		list3 = temp;
		temp.next = new node(4);
		temp.next.next = new node(7);
		
		temp = new node(3);
		list2 = temp;
		temp.next = new node(9);
		temp.next.next = list3;
		
		temp = new node(1);
		list1 = temp;
		temp.next = new node(5);
		temp.next.next = new node(6);
		temp.next.next.next = new node(10);
		temp.next.next.next.next = new node(11);
		temp.next.next.next.next.next = list3;
	}
}