package pc_app;
/**
 * @file SCCFinder.java
 * @author 2XB3 L01 Group 8
 * @date April 12, 2020
 */

public class SCCFinder {
	private HashMapLP<Player, Boolean> marked;
	private HashMapLP<Player, Integer>id;
	private int count;
	
	/**
	 * @brief Constructor for the class
	 * @param G A weighted digraph
	 */
	public SCCFinder(WeightedDigraph G) {
		this.marked = new HashMapLP<>();
		this.id = new HashMapLP<>();
		DepthFirstOrder order = new DepthFirstOrder(G.reverse());
		
		for(Player p : G.edges().keyset()) {
			this.marked.put(p, false);
		}
		
		for (Player s : order.reversePostorder()) {
			if (!this.marked.get(s)) {
				dfs(G, s);
				this.count++;
			}
		}
	}
	
	//Performs a dfs
	private void dfs(WeightedDigraph G, Player v) {
		marked.put(v, true);
		id.put(v, this.count);

		if (G.adj(v) != null) {
			for (Edge e : G.adj(v)) {
				if (marked.get(e.to()) == null || !marked.get(e.to())) {
					dfs(G, e.to());
				}
			}
		}
	}
	
	/**
	 * @brief Returns if two given players are strongly connected
	 * @param v The first player
	 * @param w The second player
	 * @return If two players are strongly connected
	 */
	public boolean stronglyConnected(Player v, Player w) {
		return id.get(v) == id.get(w);
	}
	
	/**
	 * @brief Returns the component id of the strong component containing node v
	 * @param v The Player v
	 * @return The component id
	 */
	public int id(Player v) {
		if(id.get(v) != null) return id.get(v);
		return 0;
	}
	
	/**
	 * @brief Returns the number of strongly connected components
	 * @return The number of strongly connected components
	 */
	public int count() {
		return count;
	}
}
