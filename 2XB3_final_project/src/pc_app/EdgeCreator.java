package pc_app;
/**
 * @file EdgeCreator.java
 * @author 2XB3 L01 Group 8
 * @date April 12, 2020
 */

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @brief Creates edges and adds them to a graph
 */
public class EdgeCreator {
	
	/**
	 * @brief The main logic of the class
	 * @param input The list of all the Players
	 * @param G A weighted directed graph
	 */
	public static void create(Player[] input, WeightedDigraph G) {
		
		HashMapLP<String, ArrayList<Player>>  teamyear = new HashMapLP<>();
		
		for(Player p : input) {                                                            //Populates the teamyear hashmap with
			if(teamyear.get(p.getTeam()+p.getYear()) != null) {                            //key value pairs
				ArrayList<Player> teammembers = teamyear.get(p.getTeam()+p.getYear());     //Appends an entry to the value array if criteria is met
				teammembers.add(p);
				teamyear.put(p.getTeam()+p.getYear(), teammembers);
			}
			else {
				ArrayList<Player> teammembers = new ArrayList<>();
				teamyear.put(p.getTeam()+p.getYear(), teammembers);
			}
		}
		
		for(Player p : input) {                                                                    			//Goes through the player list and makes a connection to
			ArrayList<Player> teammates = teamyear.get(p.getTeam()+p.getYear());                            //everyone that is in the corresponding teamyear array
			for(Player tm : teammates) {
				if(tm.getPlayerId() != p.getPlayerId() && p.getRcon() > -100 && tm.getRcon() > -100) {
					Edge e;
					double rcondif = p.getRcon() - tm.getRcon();
					if (rcondif >= 0) 	e = new Edge(tm, p, Math.abs(rcondif)); 
					else 			 	e = new Edge(p, tm, Math.abs(rcondif));
					G.addEdge(e);
				}
			}
		}
		
	}
	
}
