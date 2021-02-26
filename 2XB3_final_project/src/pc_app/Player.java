package pc_app;
/**
 * @file Player.java
 * @author 2XB3 L01 Group 8
 * @date April 12, 2020
 */

/**
 * @brief A Player object containing all relevant information such ass
 * 
 * Their first and last name, their team, the year they played, and their RCon score
 */
public class Player {
	private String playerid;
	private String teamid;
	private int year;
	private double rcon;
	//private double rconpost;
	private String franid;
	private String first;
	private String last;
	private String team;
	
	/**
	 * @brief The constructor for the class
	 * @param playerid Their playerid
	 * @param teamid Their teamid
	 * @param year The year they played
	 * @param rcon Their RCon score
	 */
	public Player(String playerid, String teamid, String year, String rcon) {
		this.playerid = playerid;
		this.teamid = teamid;
		this.year = Integer.parseInt(year);
		
		try {
			this.rcon = Double.parseDouble(rcon); 	//Some entries are N/A for RCon, so a value
		} catch (NumberFormatException e) { 		//of -100 is assigned if this is the case
			this.rcon = -100.00;
		}
	}
	
	/**
	 * @brief Gets the playerid
	 * @return The playerid
	 */
	public String getPlayerId() {
		return this.playerid;
	}
	
	/**
	 * @brief Gets the teamid
	 * @return The teamid
	 */
	public String getTeamId() {
		return this.teamid;
	}
	
	/**
	 * @brief Gets the year
	 * @return The year
	 */
	public int getYear() {
		return this.year;
	}
	
	/**
	 * @brief Gets the RCon score
	 * @return The RCon score
	 */
	public double getRcon() {
		return this.rcon;
	}
	
//Removed, see CSVReader.java for reason	
//	public double getRconPost() {
//		return this.rconpost;
//	}
	
	/**
	 * @brief Gets the franchiseid
	 * @return The franchiseid
	 */
	public String getFranId() {
		return this.franid;
	}
	
	/**
	 * @brief Gets the player's first name
	 * @return The player's first name
	 */
	public String getFirst() {
		return this.first;
	}
	
	/**
	 * @brief Gets the player's last name
	 * @return The player's last name
	 */
	public String getLast() {
		return this.last;
	}
	
	/**
	 * @brief Gets the player's team
	 * @return The player's team
	 */
	public String getTeam() {
		return this.team;
	}
	
//Removed, see CSVReader.java for reason	
//	public void setRconPost(String rconpost) {
//		try {
//			this.rconpost = Double.parseDouble(rconpost);
//		} catch (Exception e) {
//			this.rconpost = -100.00;
//		}
//	}
	
	/**
	 * @brief Sets the player's franchiseid
	 * @param franid The franchiseid
	 */
	public void setFranId(String franid) {
		this.franid = franid;
	}
	
	/**
	 * @brief Sets the player's first name
	 * @param first The first name
	 */
	public void setFirst(String first) {
		this.first = first;
	}
	
	/**
	 * @brief Sets the player's last name
	 * @param last The last name
	 */
	public void setLast(String last) {
		this.last = last;
	}
	
	/**
	 * @brief Sets the player's team 
	 * @param team The team
	 */
	public void setTeam(String team) {
		this.team = team;
	}
	
	/**
	 * @brief Returns a string representation of a Player Object
	 * @return The string representation
	 */
	public String toString() {
		return "(" + this.first + " " + this.last + ", " + this.year + ", " + this.team + ", " + this.rcon + ")";
	}
}
