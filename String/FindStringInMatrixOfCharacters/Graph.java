import java.util.*;

public class Graph{
	
	private int totalNodes;
	private LinkedList<Integer>[] admat;
	public Graph(int k) {
		this.totalNodes = k;
		admat = new LinkedList[k];
		for(int i=0; i<k; i++) {
			admat[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int a, int b) {
		this.admat[a].addLast(b);
	}
	
	public void print() {
		for(int i=0; i<totalNodes; i++) {
			for(int j=0; j<admat[i].size(); j++) {
				System.out.println(admat[i].get(j)+" ");
			}
			System.out.println();
		}
	}
}
