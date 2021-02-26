package pc_app;
/**
 * @file Edge.java
 * @author 2XB3 L01 Group 8
 * @date April 12, 2020
 */

import java.util.ArrayList;

/**
 * @brief An implementation of a weighted digraph from the textbook
 *
 */
public class WeightedDigraph {
	private final int V;
	private int E;
	private HashMapLP<Player, ArrayList<Edge>> adj;
	
	/**
	 * @brief The constructor for the class
	 * @param V The amount of nodes
	 */
	public WeightedDigraph(int V) {
		this.V = V;
		this.E = 0;
		this.adj = new HashMapLP<>();
	}
	
	/**
	 * @brief The amount of nodes in the graph
	 * @return The amount of nodes
	 */
	public int getV() {
		return this.V;
	}
	
	/**
	 * @brief The amount of edges in the graph
	 * @return The amount of nodes
	 */
	public int getE() {
		return this.E;
	}
	
	/**
	 * @brief Adds an edge to the graph
	 * @param e The edge to be added
	 */
	public void addEdge(Edge e) {
		if (this.adj.get(e.from()) != null){
			ArrayList<Edge> update = this.adj.get(e.from());
			update.add(e);
			this.adj.put(e.from(), update);
		}
		else {
			ArrayList<Edge> edges = new ArrayList<>();
			edges.add(e);
			this.adj.put(e.from(), edges);
		}
		this.E++;
	}
	
	/**
	 * @brief Returns all the adjacent nodes to the specified nodes
	 * @param V The specified node
	 * @return The list of adjacent nodes
	 */
	public ArrayList<Edge> adj(Player V){
		return this.adj.get(V);
	}
	
	/**
	 * @brief Returns a the list of all edges in the graph
	 * @return The list of all the edges
	 */
	public HashMapLP<Player, ArrayList<Edge>> edges(){
		return this.adj;
	}
	
	/**
	 * @brief Returns the graph with all edge directions reversed
	 * @return The new graph
	 */
	public WeightedDigraph reverse() {
		WeightedDigraph R = new WeightedDigraph(this.V);
		for(Player v : adj.keyset()) {
			for (Edge e : adj(v)) {
				R.addEdge(new Edge(e.to(), v, e.weight()));
			}
		}
		return R;
	}
}

