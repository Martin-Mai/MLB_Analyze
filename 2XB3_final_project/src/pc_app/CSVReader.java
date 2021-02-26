package pc_app;
/**
 * @file CSVReader.java
 * @author 2XB3 L01 Group 8
 * @date April 12, 2020
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @brief Converts the data in the given .csv files into usable data for the program
 * 
 * Has one public method which returns a list of all the players in the Batting.csv file
 *
 */
public class CSVReader {
	
	/**
	 * @brief Returns a list of all the players
	 * 
	 * Within the Batting.csv file the players have are assigned a playerid and teamid, therefore
	 * their full name and team name are unknown. The unknown information is contained
	 * within three other .csv files which must be read. The IDs must be hashed so that
	 * Information read from the other three files can be accessed in constant time in order
	 * to properly assign all players their full name and team name.
	 * 
	 * @return A list of all the players
	 * @throws IOException If the files do not exist
	 */
	public static Player[] readData() throws IOException{
		ArrayList<Player> temp = readBatting();
		Player[] players = temp.toArray(new Player[temp.size()]);
		
		//HashMapLP rcons = readBattingPost();
		HashMapLP<String, String> names = readMaster();
		HashMapLP<String, String> franchs = readTeams();
		HashMapLP<String, String> teams = readTF();
		
		for(Player p : players) {
			//p.setRconPost(rcons.get(p.getYear()+p.getPlayerId()));
			
			String[] pname = names.get(p.getPlayerId()).split(" ");
			p.setFirst(pname[0]);
			p.setLast(pname[1]);
			
			p.setFranId(franchs.get(p.getTeamId()));
			p.setTeam(teams.get(p.getFranId()));
		}
		
		return players;
		
	}
	
	//Reads the Batting.csv files and creates Player objects based on the data,
	//then return the ArrayList containing all created Player objects
	private static ArrayList<Player> readBatting() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("data/Batting.csv"));
		ArrayList<Player> players = new ArrayList<>();
		
		String in = br.readLine();
		
		while((in = br.readLine()) != null) {
			String[] data = in.split(",");
			Player p = new Player(data[0], data[3], data[1], data[23]);
			players.add(p);
		}
		
		return players;
	}

//Removed as it was discovered most of the players from Batting.csv do no exist within BattingPost.csv and vice versa	
	
//	private static HashMapLP readBattingPost() throws IOException{
//		BufferedReader br = new BufferedReader(new FileReader("data/BattingPost.csv"));
//		HashMapLP rcons = new HashMapLP();
//		
//		String in = br.readLine();
//		
//		while((in = br.readLine()) != null) {
//			String[] data = in.split(",");
//			rcons.put(data[0]+data[2], data[23]);
//		}
//		
//		return rcons;
//	}
	
	//Reads Master.csv and hashes all player IDs to the corresponding full name
	//Returns the created hashmap
	private static HashMapLP readMaster() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("data/Master.csv"));
		HashMapLP names = new HashMapLP();
		
		String in = br.readLine();
		
		while((in = br.readLine()) != null) {
			String[] data = in.split(",");
			names.put(data[0], data[13]+" "+data[14]);
		}
		
		return names;
	}
	
	//Reads Teams.csv and hashes all team IDs to the corresponding franchise ID 
	//Returns the created hashmap
	private static HashMapLP readTeams() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("data/Teams.csv"));
		HashMapLP franchs = new HashMapLP();
		
		String in = br.readLine();
		
		while((in = br.readLine()) != null) {
			String[] data = in.split(",");
			franchs.put(data[2], data[3]);
		}
		
		return franchs;
	}
	
	//Reads TeamsFranchises.csv and hashes all franchise IDs to the corresponding team name
	//Returns the created hashmap
	private static HashMapLP readTF() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("data/TeamsFranchises.csv"));
		HashMapLP teams = new HashMapLP();
		
		String in = br.readLine();
		
		while((in = br.readLine()) != null) {
			String[] data = in.split(",");
			teams.put(data[0], data[1]);
		}
		
		return teams;
	}
	
}
