package pc_app;
/**
 * @file BinarySearch.java
 * @author 2XB3 L01 Group 8
 * @date April 12, 2020
 */

import java.util.Arrays;

/**
 * @brief An implementation of binary search
 * 
 * The class has 5 different methods, each corresponding
 * to one of the 5 enum types. The classes all return a sub-array
 * of the array to be searched containing all entries that match
 * the specified search term.
 */
public class BinarySearch {
	
	/**
	 * @brief Searching by player's first name
	 * @param in The list of all players
	 * @param first The first name to be searched
	 * @return The sub-array containing all players with the specified name
	 */
	public static Player[] byFirst(Player[] in, String first) {
		return search(in, first, null, null, 0, 0, Flag.F);
	}

	/**
	 * @brief Searching by player's last name
	 * @param in The list of all players
	 * @param first The last name to be searched
	 * @return The sub-array containing all players with the specified name
	 */
	public static Player[] byLast(Player[] in, String last) {
		return search(in, null, last, null, 0, 0, Flag.L);
	}
	
	/**
	 * @brief Searching by player's team
	 * @param in The list of all players
	 * @param first The team to be searched
	 * @return The sub-array containing all players in the specified team
	 */
	public static Player[] byTeam(Player[] in, String team) {
		return search(in, null, null, team, 0, 0, Flag.T);
	}
	
	/**
	 * @brief Searching by the year
	 * @param in The list of all players
	 * @param first The year to be searched
	 * @return The sub-array containing all players that played during the specified year
	 */
	public static Player[] byYear(Player[] in, int year) {
		return search(in, null, null, null, year, 0, Flag.Y);
	}
	
	/**
	 * @brief Searching by player's RCon score
	 * @param in The list of all players
	 * @param first The RCon score to be searched
	 * @return The sub-array containing all players that have the specified RCon score
	 */
	public static Player[] byRcon(Player[] in, double rcon) {
		return search(in, null, null, null, 0, rcon, Flag.R);
	}
	
	//Main logic of the binary search, modified so that it can compare values differently based on the flag given.
	//Also modified so that the search ends when it finds the first occurrence of an entry rather than any occurrence.
	private static Player[] search(Player[] in, String first, String last, String team, int year, double rcon, Flag flag) {

		Player[] input;
		if 		(flag.equals(Flag.F)) input = Mergesort.byFirst(in, true);
		else if (flag.equals(Flag.L)) input = Mergesort.byLast(in, true);
		else if (flag.equals(Flag.T)) input = Mergesort.byTeam(in, true);
		else if (flag.equals(Flag.Y)) input = Mergesort.byYear(in, true);
		else 						  input = Mergesort.byRcon(in, true);
		
		int lo = 0, hi = input.length - 1, firstoccur = -1, lastoccur = -1;
		
		while (lo <= hi) {
			int mid = (lo + hi)/2;
			if (flag.equals(Flag.F)) {
				if (input[mid].getFirst().equals(first)) {
					firstoccur = mid;
					hi = mid - 1;
				}
				else if (input[mid].getFirst().compareTo(first) > 0) hi = mid - 1;
				else lo = mid + 1;
			}
			else if (flag.equals(Flag.L)) {
				if (input[mid].getLast().equals(last)) {
					firstoccur = mid;
					hi = mid - 1;
				}
				else if (input[mid].getLast().compareTo(last) > 0) hi = mid - 1;
				else lo = mid + 1;
			}
			else if (flag.equals(Flag.T)) {
				if (input[mid].getTeam().equals(team)) {
					firstoccur = mid;
					hi = mid - 1;
				}
				else if (input[mid].getTeam().compareTo(team) > 0) hi = mid - 1;
				else lo = mid + 1;
			}
			else if (flag.equals(Flag.Y)) {
				if (input[mid].getYear() == year) {
					firstoccur = mid;
					hi = mid - 1;
				}
				else if (input[mid].getYear() > year) hi = mid - 1;
				else lo = mid + 1;
			}
			else {
				if (input[mid].getRcon() == rcon) {
					firstoccur = mid;
					hi = mid - 1;
				}
				else if (input[mid].getRcon() > rcon) hi = mid - 1;
				else lo = mid + 1;
			}
		}
		
		if (firstoccur < 0) return new Player[0];
		
		if 		(flag.equals(Flag.F))
			for(int i = firstoccur; i < input.length && input[i].getFirst().equals(first); i++) 
				lastoccur = i;
		else if (flag.equals(Flag.L))
			for(int i = firstoccur; i < input.length && input[i].getLast().equals(last); i++) 
				lastoccur = i;
		else if (flag.equals(Flag.T))
			for(int i = firstoccur; i < input.length && input[i].getTeam().equals(team); i++) 
				lastoccur = i;
		else if (flag.equals(Flag.Y))
			for(int i = firstoccur; i < input.length && input[i].getYear() == year; i++) 
				lastoccur = i;
		else 
			for(int i = firstoccur; i < input.length && input[i].getRcon() == rcon; i++) 
				lastoccur = i;
	
		
		return Arrays.copyOfRange(input, firstoccur, lastoccur + 1);
	}
}
