package pc_app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;

public class searchpage {

	JFrame frmMlbAnalysis;
	private JLabel lblNewLabel;
	private JTextField SearchingBar;
	private JButton s_f_button;
	private JButton s_y_button;
	private JButton s_l_button;
	private JButton s_R_button;
	private JLabel picture_frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the application.
	 */
	public searchpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMlbAnalysis = new JFrame();
		frmMlbAnalysis.setTitle("MLB Analysis");
		frmMlbAnalysis.setBounds(100, 100, 790, 759);
		frmMlbAnalysis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMlbAnalysis.getContentPane().setLayout(null);
		Image search_img = new ImageIcon(this.getClass().getResource("/search.png")).getImage();

		/* set the label of the page */
		lblNewLabel = new JLabel("MLB Analysis: searching");
		lblNewLabel.setFont(new Font("Sitka Display", Font.BOLD, 40));
		lblNewLabel.setBounds(10, 32, 597, 128);
		frmMlbAnalysis.getContentPane().add(lblNewLabel);
		// set the searching bar
		SearchingBar = new JTextField();
		SearchingBar.setBounds(10, 192, 756, 91);
		frmMlbAnalysis.getContentPane().add(SearchingBar);
		SearchingBar.setColumns(10);
		// "Search By Team" button
		JButton s_t_button = new JButton("Search By Team");
		s_t_button.setIcon(new ImageIcon(search_img));
		s_t_button.setFont(new Font("SimSun", Font.BOLD, 20));
		s_t_button.addActionListener(new ActionListener() {
			// button will call byTeam method from BinarySearch class and show the output in
			// the new page
			public void actionPerformed(ActionEvent e) {
				showpage sl = new showpage();
				sl.setVisible(true);
				sl.setlabel("Search By Team");
				String in = SearchingBar.getText();
				lblNewLabel.setText("MLB Analysis: searching");
				try {
					for (Player p : BinarySearch.byTeam(CSVReader.readData(), in)) {
						if (p.getRcon() == -100) {
							sl.gettest().append("(" + p.getFirst() + " " + p.getLast() + ", " + p.getYear() + ", "
									+ p.getTeam() + ", " + "N/A" + ")" + "\n");
						} else {
							sl.gettest().append(p.toString() + "\n");
						}
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		s_t_button.setBounds(10, 427, 330, 75);
		frmMlbAnalysis.getContentPane().add(s_t_button);
		// "Search By First Name" button
		s_f_button = new JButton("Search By First Name");
		s_f_button.setIcon(new ImageIcon(search_img));
		s_f_button.setFont(new Font("SimSun", Font.BOLD, 20));
		s_f_button.addActionListener(new ActionListener() {
			// button will call byFirst method from BinarySearch class and show the output
			// in the new page
			public void actionPerformed(ActionEvent e) {
				showpage sl = new showpage();
				sl.setVisible(true);
				sl.setlabel("Search By First Name");
				String in = SearchingBar.getText();
				lblNewLabel.setText("MLB Analysis: searching");
				try {
					for (Player p : BinarySearch.byFirst(CSVReader.readData(), in)) {
						if (p.getRcon() == -100) {
							sl.gettest().append("(" + p.getFirst() + " " + p.getLast() + ", " + p.getYear() + ", "
									+ p.getTeam() + ", " + "N/A" + ")" + "\n");
						} else {
							sl.gettest().append(p.toString() + "\n");
						}
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		s_f_button.setBounds(10, 316, 330, 75);
		frmMlbAnalysis.getContentPane().add(s_f_button);
		// "Search By First Name" button
		s_y_button = new JButton("Search By Year");
		s_y_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// button will call byYear method from BinarySearch class and show the output in
				// the new page
				showpage sl = new showpage();
				sl.setVisible(true);
				sl.setlabel("Search By Year");
				String iin = SearchingBar.getText();
				int in = Integer.parseInt(iin);
				lblNewLabel.setText("MLB Analysis: searching");
				try {
					for (Player p : BinarySearch.byYear(CSVReader.readData(), in)) {
						if (p.getRcon() == -100) {
							sl.gettest().append("(" + p.getFirst() + " " + p.getLast() + ", " + p.getYear() + ", "
									+ p.getTeam() + ", " + "N/A" + ")" + "\n");
						} else {
							sl.gettest().append(p.toString() + "\n");
						}
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		s_y_button.setIcon(new ImageIcon(search_img));
		s_y_button.setFont(new Font("SimSun", Font.BOLD, 20));
		s_y_button.setBounds(436, 427, 330, 75);
		frmMlbAnalysis.getContentPane().add(s_y_button);
		// "Search By Last Name" button
		s_l_button = new JButton("Search By Last Name");
		s_l_button.setIcon(new ImageIcon(search_img));
		s_l_button.addActionListener(new ActionListener() {
			// button will call byLast method from BinarySearch class and show the output in
			// the new page
			public void actionPerformed(ActionEvent e) {
				showpage sl = new showpage();
				sl.setVisible(true);
				sl.setlabel("Search By Last Name");
				String in = SearchingBar.getText();
				lblNewLabel.setText("MLB Analysis: searching");
				try {
					for (Player p : BinarySearch.byLast(CSVReader.readData(), in)) {
						if (p.getRcon() == -100) {
							sl.gettest().append("(" + p.getFirst() + " " + p.getLast() + ", " + p.getYear() + ", "
									+ p.getTeam() + ", " + "N/A" + ")" + "\n");
						} else {
							sl.gettest().append(p.toString() + "\n");
						}
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		s_l_button.setFont(new Font("SimSun", Font.BOLD, 20));
		s_l_button.setBounds(436, 317, 330, 73);
		frmMlbAnalysis.getContentPane().add(s_l_button);
		// "Search By Rcon" button
		s_R_button = new JButton("Search By Rcon");
		s_R_button.addActionListener(new ActionListener() {
			// button will call byRcon method from BinarySearch class and show the output in
			// the new page
			public void actionPerformed(ActionEvent e) {
				showpage sl = new showpage();
				sl.setVisible(true);
				sl.setlabel("Search By Rcon");
				String iin = SearchingBar.getText();
				double in = Double.parseDouble(iin);
				lblNewLabel.setText("MLB Analysis: searching");
				try {
					for (Player p : BinarySearch.byRcon(CSVReader.readData(), in)) {
						if (p.getRcon() == -100) {
							sl.gettest().append("(" + p.getFirst() + " " + p.getLast() + ", " + p.getYear() + ", "
									+ p.getTeam() + ", " + "N/A" + ")" + "\n");
						} else {
							sl.gettest().append(p.toString() + "\n");
						}
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		s_R_button.setIcon(new ImageIcon(search_img));
		s_R_button.setFont(new Font("SimSun", Font.BOLD, 20));
		s_R_button.setBounds(10, 544, 330, 75);
		frmMlbAnalysis.getContentPane().add(s_R_button);
		// insert an image into the page
		picture_frame = new JLabel("");
		picture_frame.setVerticalAlignment(SwingConstants.TOP);
		Image img = new ImageIcon(this.getClass().getResource("/logol.png")).getImage();
		picture_frame.setIcon(new ImageIcon(img));
		picture_frame.setBounds(455, 14, 311, 168);
		frmMlbAnalysis.getContentPane().add(picture_frame);
		// "Sort" button
		JButton sort_button = new JButton("Sort");
		sort_button.addActionListener(new ActionListener() {
			// it will open the sorting page
			public void actionPerformed(ActionEvent e) {
				sortpage s2 = new sortpage();
				s2.setVisible(true);
			}
		});
		sort_button.setFont(new Font("SimSun", Font.BOLD, 38));
		sort_button.setBounds(436, 544, 330, 91);
		frmMlbAnalysis.getContentPane().add(sort_button);
		// "See the players that were on the same team in the same year ->->" button,
		// shows the strongly conencted components of the players computed by the graph
		// algorithm
		JButton btnNewButton = new JButton("See the players that were on the same team in the same year ->->");
		btnNewButton.addActionListener(new ActionListener() {
			// it will run the graph algorithm and show the output to the pop-up
			public void actionPerformed(ActionEvent e) {
				showpage sl = new showpage();
				sl.setVisible(true);
				sl.setlabel("players that are connected");
				lblNewLabel.setText("MLB Analysis: searching");
				Player[] a;
				String s;
				try {
					a = CSVReader.readData();
					WeightedDigraph g = new WeightedDigraph(a.length);
					EdgeCreator.create(a, g);
					SCCFinder scc = new SCCFinder(g);
					int m = scc.count();
					sl.gettest().append(m + " Strongly Connected Components: " + "\n");
					Queue<Player>[] components = new LinkedList[m];
					for (int i = 0; i < scc.count(); i++) {
						components[i] = new LinkedList<>();
					}
					for (Player v : a) {
						components[scc.id(v)].add(v);
					}

					for (int i = 0; i < m; i++) {
						s = "";
						for (Player v : components[i]) {
							s += v.toString() + " ";
						}
						sl.gettest().append(s + "\n");
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("SimSun", Font.BOLD, 20));
		btnNewButton.setBounds(10, 663, 756, 49);
		frmMlbAnalysis.getContentPane().add(btnNewButton);

	}
}
