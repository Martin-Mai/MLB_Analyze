package pc_app;
/**
 * @file Edge.java
 * @author 2XB3 L01 Group 8
 * @date April 12, 2020
 */

/**
 * @brief Implementation of DirectedEdge from the textbook 
 *
 */
public class Edge {
	private final Player v;
	private final Player w;
	private final double weight;
	
	/**
	 * @brief Constructor for the class
	 * @param v The starting node
	 * @param w The destination node
	 * @param weight The weight of the edge
	 */
	public Edge(Player v, Player w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	/**
	 * @brief Gets the starting node
	 * @return The starting node
	 */
	public Player from() {
		return this.v;
	}
	
	/**
	 * @brief Gets the destination node
	 * @return The destination node
	 */
	public Player to() {
		return this.w;
	}
	
	/**
	 * @brief Gets the weight of the node
	 * @return The weight of the node
	 */
	public double weight() {
		return this.weight;
	}
	
	/**
	 * @brief Returns the string representation of the edge connection
	 * @return The string representation
	 */
	public String toString() {
		return ""+this.v+"-->"+this.w+": "+this.weight;
	}
}
