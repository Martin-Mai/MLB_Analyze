package pc_app;

import java.awt.EventQueue;

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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchpage window = new searchpage();
					window.frmMlbAnalysis.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
