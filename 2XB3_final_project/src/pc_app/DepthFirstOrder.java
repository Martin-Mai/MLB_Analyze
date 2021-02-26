package pc_app;
/**
 * @file DepthFirstOrder.java
 * @author 2XB3 L01 Group 8
 * @date April 12, 2020
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @brief Implementation of DepthFirstOrder from the textbook
 *
 */
public class DepthFirstOrder {
	private HashMapLP<Player, Boolean> marked;
	private Queue<Player> pre;
	private Queue<Player> post;
	private Stack<Player> reversePost;
	
	/**
	 * @brief Constructor for the class
	 * @param G A weighted digraph
	 */
	public DepthFirstOrder(WeightedDigraph G) {
		this.pre = new LinkedList<>();
		this.post = new LinkedList<>();
		this.reversePost = new Stack<>();
		this.marked = new HashMapLP<>();
		
		for(Player p : G.edges().keyset()) {
			this.marked.put(p, false);
		}
		
		for(Player v : marked.keyset()) {
			if (!this.marked.get(v)) dfs(G, v);
		}
	}
	
	//Performs a dfs on the given graph starting a the Player V
	private void dfs(WeightedDigraph G, Player v) {
		pre.add(v);
		marked.put(v, true);

		if (G.adj(v) != null) {
			for (Edge e : G.adj(v)) {
				if (marked.get(e.to()) == null || !marked.get(e.to())) {
					dfs(G, e.to());
				}
			}
		}
		
		post.add(v);
		reversePost.add(v);
	}
	
	/**
	 * @brief Gives the nodes in preorder
	 * @return The nodes in preorder
	 */
	public ArrayList<Player> preorder(){
		return new ArrayList<>(this.pre);
	}
	
	/**
	 * @brief Gives the nodes in postorder
	 * @return The nodes in postorder
	 */
	public ArrayList<Player> postorder(){
		return new ArrayList<>(this.post);
	}
	
	/**
	 * @brief Gives the nodes in reverse postorder
	 * @return The nodes in reverse postorder
	 */
	public ArrayList<Player> reversePostorder(){
		return new ArrayList<>(this.reversePost);
	}
}
