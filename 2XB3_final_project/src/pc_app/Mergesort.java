package pc_app;
/**
 * @file Main.java
 * @author 2XB3 L01 Group 8
 * @date April 12, 2020
 */

/**
 * @brief A modified version of mergesort from the textbook
 * 
 * Mergesort based on what the user wants to sort by
 *
 */
public class Mergesort {
	
	/**
	 * @brief Returns the list of players sorted by firstname
	 * @param input The list pf players
	 * @param asc If the user wants it in ascending or descending order
	 * @return The sorted list
	 */
    public static Player[] byFirst(Player[] input, boolean asc) {
        int N = input.length;
        if (N <= 1) return input;
        Player[] a = new Player[N/2];
        Player[] b = new Player[N - N/2];
        for (int i = 0; i < a.length; i++)
            a[i] = input[i];
        for (int i = 0; i < b.length; i++)
            b[i] = input[i + N/2];
        return mergeByFirst(byFirst(a, asc), byFirst(b, asc), asc);
    }
    //The main logic of the mergesort
    private static Player[] mergeByFirst(Player[] a, Player[] b, boolean asc) {
        Player[] c = new Player[a.length + b.length];
        int i = 0, j = 0;
        for (int k = 0; k < c.length; k++) {
        	if (asc)
	            if      (i >= a.length) c[k] = b[j++];
	            else if (j >= b.length) c[k] = a[i++];
	            else if (a[i].getFirst().compareTo(b[j].getFirst()) <= 0)  c[k] = a[i++];
	            else                    c[k] = b[j++];
        	else
        		if      (i >= a.length) c[k] = b[j++];
	            else if (j >= b.length) c[k] = a[i++];
	            else if (a[i].getFirst().compareTo(b[j].getFirst()) >= 0)  c[k] = a[i++];
	            else                    c[k] = b[j++];
        }
        return c;
    }
    
	/**
	 * @brief Returns the list of players sorted by last name
	 * @param input The list of players
	 * @param asc If the user wants it in ascending or descending order
	 * @return The sorted list
	 */
    public static Player[] byLast(Player[] input, boolean asc) {
        int N = input.length;
        if (N <= 1) return input;
        Player[] a = new Player[N/2];
        Player[] b = new Player[N - N/2];
        for (int i = 0; i < a.length; i++)
            a[i] = input[i];
        for (int i = 0; i < b.length; i++)
            b[i] = input[i + N/2];
        return mergeByLast(byLast(a, asc), byLast(b, asc), asc);
    }
    //The main logic of the mergesort
    private static Player[] mergeByLast(Player[] a, Player[] b, boolean asc) {
        Player[] c = new Player[a.length + b.length];
        int i = 0, j = 0;
        for (int k = 0; k < c.length; k++) {
        	if (asc)
	            if      (i >= a.length) c[k] = b[j++];
	            else if (j >= b.length) c[k] = a[i++];
	            else if (a[i].getLast().compareTo(b[j].getLast()) <= 0)  c[k] = a[i++];
	            else                    c[k] = b[j++];
        	else
        		if      (i >= a.length) c[k] = b[j++];
	            else if (j >= b.length) c[k] = a[i++];
	            else if (a[i].getLast().compareTo(b[j].getLast()) >= 0)  c[k] = a[i++];
	            else                    c[k] = b[j++];
        }
        return c;
    }
    
	/**
	 * @brief Returns the list of players sorted by team
	 * @param input The list of players
	 * @param asc If the user wants it in ascending or descending order
	 * @return The sorted list
	 */
    public static Player[] byTeam(Player[] input, boolean asc) {
        int N = input.length;
        if (N <= 1) return input;
        Player[] a = new Player[N/2];
        Player[] b = new Player[N - N/2];
        for (int i = 0; i < a.length; i++)
            a[i] = input[i];
        for (int i = 0; i < b.length; i++)
            b[i] = input[i + N/2];
        return mergeByTeam(byTeam(a, asc), byTeam(b, asc), asc);
    }
    //The main logic of the mergesort
    private static Player[] mergeByTeam(Player[] a, Player[] b, boolean asc) {
        Player[] c = new Player[a.length + b.length];
        int i = 0, j = 0;
        for (int k = 0; k < c.length; k++) {
        	if (asc)
	            if      (i >= a.length) c[k] = b[j++];
	            else if (j >= b.length) c[k] = a[i++];
	            else if (a[i].getTeam().compareTo(b[j].getTeam()) <= 0)  c[k] = a[i++];
	            else                    c[k] = b[j++];
        	else
        		if      (i >= a.length) c[k] = b[j++];
	            else if (j >= b.length) c[k] = a[i++];
	            else if (a[i].getTeam().compareTo(b[j].getTeam()) >= 0)  c[k] = a[i++];
	            else                    c[k] = b[j++];
        }
        return c;
    }
    
	/**
	 * @brief Returns the list of players sorted by year
	 * @param input The list of players
	 * @param asc If the user wants it in ascending or descending order
	 * @return The sorted list
	 */
    public static Player[] byYear(Player[] input, boolean asc) {
        int N = input.length;
        if (N <= 1) return input;
        Player[] a = new Player[N/2];
        Player[] b = new Player[N - N/2];
        for (int i = 0; i < a.length; i++)
            a[i] = input[i];
        for (int i = 0; i < b.length; i++)
            b[i] = input[i + N/2];
        return mergeByYear(byYear(a, asc), byYear(b, asc), asc);
    }
    //The main logic of the mergesort
    private static Player[] mergeByYear(Player[] a, Player[] b, boolean asc) {
        Player[] c = new Player[a.length + b.length];
        int i = 0, j = 0;
        for (int k = 0; k < c.length; k++) {
        	if (asc)
	            if      (i >= a.length) c[k] = b[j++];
	            else if (j >= b.length) c[k] = a[i++];
	            else if (a[i].getYear() <= b[j].getYear())  c[k] = a[i++];
	            else                    c[k] = b[j++];
        	else
        		if      (i >= a.length) c[k] = b[j++];
	            else if (j >= b.length) c[k] = a[i++];
	            else if (a[i].getYear() >= b[j].getYear())  c[k] = a[i++];
	            else                    c[k] = b[j++];
        }
        return c;
    }

    
	/**
	 * @brief Returns the list of players sorted by RCon
	 * @param input The list of players
	 * @param asc If the user wants it in ascending or descending order
	 * @return The sorted list
	 */
    public static Player[] byRcon(Player[] input, boolean asc) {
        int N = input.length;
        if (N <= 1) return input;
        Player[] a = new Player[N/2];
        Player[] b = new Player[N - N/2];
        for (int i = 0; i < a.length; i++)
            a[i] = input[i];
        for (int i = 0; i < b.length; i++)
            b[i] = input[i + N/2];
        return mergeByRcon(byRcon(a, asc), byRcon(b, asc), asc);
    }
    //The main logic of the mergesort
    private static Player[] mergeByRcon(Player[] a, Player[] b, boolean asc) {
        Player[] c = new Player[a.length + b.length];
        int i = 0, j = 0;
        for (int k = 0; k < c.length; k++) {
        	if (asc)
	            if      (i >= a.length) c[k] = b[j++];
	            else if (j >= b.length) c[k] = a[i++];
	            else if (a[i].getRcon() <= b[j].getRcon())  c[k] = a[i++];
	            else                    c[k] = b[j++];
        	else
        		if      (i >= a.length) c[k] = b[j++];
	            else if (j >= b.length) c[k] = a[i++];
	            else if (a[i].getRcon() >= b[j].getRcon())  c[k] = a[i++];
	            else                    c[k] = b[j++];
        }
        return c;
    }
}