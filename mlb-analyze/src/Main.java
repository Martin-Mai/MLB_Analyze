/**
 * @file Main.java
 * @author 2XB3 L01 Group 8
 * @date April 12, 2020
 */

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @brief The main class where the program is run
 */
public class Main {
	public static void main(String[] args) throws IOException {
		Player[] a = CSVReader.readData();
		Player[] sorted = Mergesort.byTeam(a, true);
		Player[] search = BinarySearch.byYear(a, 2015);
		System.out.println(sorted[0]);
		System.out.println(search[0]);
		
		WeightedDigraph g = new WeightedDigraph(a.length);
		EdgeCreator.create(a, g);
		System.out.println(g.adj(a[2]));
		
		
		SCCFinder scc = new SCCFinder(g);
		
        int m = scc.count();
        
        System.out.println(m+" Strongly Connected Components");
        
        Queue<Player>[] components = new LinkedList[m];
        for (int i = 0; i < scc.count(); i++) {
            components[i] = new LinkedList<>();
        }
        for (Player v : a) {
            components[scc.id(v)].add(v);
        }

        for (int i = 1; i < m; i++) {
            for (Player v : components[i]) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
	}
}
