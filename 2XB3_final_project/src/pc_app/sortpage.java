package pc_app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class sortpage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sortpage frame = new sortpage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public sortpage() {
		setTitle("MLB Analysis");
		Image az_img = new ImageIcon(this.getClass().getResource("/az.png")).getImage();
		Image za_img = new ImageIcon(this.getClass().getResource("/za.png")).getImage();
		Image sb_img = new ImageIcon(this.getClass().getResource("/sb.png")).getImage();
		Image bs_img = new ImageIcon(this.getClass().getResource("/bs.png")).getImage();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 766, 759);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// set the label of the page
		JLabel lblNewLabel = new JLabel("MLB Analysis: sorting");
		lblNewLabel.setFont(new Font("Sitka Display", Font.BOLD, 40));
		lblNewLabel.setBounds(181, 27, 658, 114);
		contentPane.add(lblNewLabel);
		// "Sort By First Name" button that will sort the first names of the players
		// from a to z
		JButton btnNewButton = new JButton("Sort By First Name");
		btnNewButton.setIcon(new ImageIcon(az_img));
		btnNewButton.addActionListener(new ActionListener() {
			// the button will call byFirst method from Mergesort class when it is active
			public void actionPerformed(ActionEvent e) {
				showpage sl = new showpage();
				sl.setVisible(true);
				sl.setlabel("Sort By First Name");
				try {
					for (Player p : Mergesort.byFirst(CSVReader.readData(), true)) {
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
		btnNewButton.setFont(new Font("SimSun", Font.BOLD, 20));
		btnNewButton.setBounds(10, 210, 340, 61);
		contentPane.add(btnNewButton);
		// "Sort By Last Name" button that will sort the first names of the players from
		// a to z
		JButton btnNewButton_1 = new JButton("Sort By Last Name");
		btnNewButton_1.setIcon(new ImageIcon(az_img));
		btnNewButton_1.setFont(new Font("SimSun", Font.BOLD, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			// the button will call byLast method from Mergesort class when it is active
			public void actionPerformed(ActionEvent e) {
				showpage sl = new showpage();
				sl.setVisible(true);
				sl.setlabel("Sort By Last Name");
				try {
					for (Player p : Mergesort.byLast(CSVReader.readData(), true)) {
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
		btnNewButton_1.setBounds(387, 210, 340, 61);
		contentPane.add(btnNewButton_1);
		// "Sort By Year" button that will sort the years in ascending order
		JButton btnNewButton_2 = new JButton("Sort By Year");
		btnNewButton_2.setIcon(new ImageIcon(sb_img));
		btnNewButton_2.addActionListener(new ActionListener() {
			// the button will call byYear method from Mergesort class when it is active
			public void actionPerformed(ActionEvent e) {
				showpage sl = new showpage();
				sl.setVisible(true);
				sl.setlabel("Sort By Year");
				try {
					for (Player p : Mergesort.byYear(CSVReader.readData(), true)) {
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
		btnNewButton_2.setFont(new Font("SimSun", Font.BOLD, 20));
		btnNewButton_2.setBounds(10, 586, 340, 66);
		contentPane.add(btnNewButton_2);
		// "Sort By Rcon" button that will sort the Rcons of the players in ascending
		// order
		JButton btnNewButton_3 = new JButton("Sort By Rcon");
		btnNewButton_3.setIcon(new ImageIcon(sb_img));
		btnNewButton_3.addActionListener(new ActionListener() {
			// the button will call byRcon method from Mergesort class when it is active
			public void actionPerformed(ActionEvent e) {
				showpage sl = new showpage();
				sl.setVisible(true);
				sl.setlabel("Sort By Rcon");
				try {
					for (Player p : Mergesort.byRcon(CSVReader.readData(), true)) {
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
		btnNewButton_3.setFont(new Font("SimSun", Font.BOLD, 20));
		btnNewButton_3.setBounds(387, 589, 340, 61);
		contentPane.add(btnNewButton_3);
		// "Sort By Team" button that will sort the first names of the players from a to
		// z
		JButton btnNewButton_4 = new JButton("Sort By Team");
		btnNewButton_4.setIcon(new ImageIcon(az_img));
		btnNewButton_4.addActionListener(new ActionListener() {
			// the button will call byTeam method from Mergesort class when it is active
			public void actionPerformed(ActionEvent e) {
				showpage sl = new showpage();
				sl.setVisible(true);
				sl.setlabel("Sort By Team");
				try {
					for (Player p : Mergesort.byTeam(CSVReader.readData(), true)) {
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
		btnNewButton_4.setFont(new Font("SimSun", Font.BOLD, 20));
		btnNewButton_4.setBounds(224, 393, 288, 66);
		contentPane.add(btnNewButton_4);
		// "Sort By First Name" button that will sort the first names of the players
		// from z to a
		JButton btnNewButton_5 = new JButton("Sort By First Name");
		btnNewButton_5.setIcon(new ImageIcon(za_img));
		btnNewButton_5.addActionListener(new ActionListener() {
			// the button will call byFirst method from Mergesort class when it is active
			public void actionPerformed(ActionEvent e) {
				showpage sl = new showpage();
				sl.setVisible(true);
				sl.setlabel("Sort By First Name");
				try {
					for (Player p : Mergesort.byFirst(CSVReader.readData(), false)) {
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
		btnNewButton_5.setFont(new Font("SimSun", Font.BOLD, 20));
		btnNewButton_5.setBounds(10, 271, 340, 61);
		contentPane.add(btnNewButton_5);
		// "Sort By Last Name" button that will sort the first names of the players from
		// z to a
		JButton btnNewButton_6 = new JButton("Sort By Last Name");
		btnNewButton_6.setIcon(new ImageIcon(za_img));
		btnNewButton_6.addActionListener(new ActionListener() {
			// the button will call byLast method from Mergesort class when it is active
			public void actionPerformed(ActionEvent e) {
				showpage sl = new showpage();
				sl.setVisible(true);
				sl.setlabel("Sort By Last Name");
				try {
					for (Player p : Mergesort.byLast(CSVReader.readData(), false)) {
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
		btnNewButton_6.setFont(new Font("SimSun", Font.BOLD, 20));
		btnNewButton_6.setBounds(387, 271, 340, 61);
		contentPane.add(btnNewButton_6);
		// "Sort By Team" button that will sort the first names of the players from z to
		// a
		JButton btnNewButton_7 = new JButton("Sort By Team");
		btnNewButton_7.setIcon(new ImageIcon(za_img));
		btnNewButton_7.addActionListener(new ActionListener() {
			// the button will call byTeam method from Mergesort class when it is active
			public void actionPerformed(ActionEvent e) {
				showpage sl = new showpage();
				sl.setVisible(true);
				sl.setlabel("Sort By Team");
				try {
					for (Player p : Mergesort.byTeam(CSVReader.readData(), false)) {
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
		btnNewButton_7.setFont(new Font("SimSun", Font.BOLD, 20));
		btnNewButton_7.setBounds(224, 458, 288, 61);
		contentPane.add(btnNewButton_7);
		// "Sort By Year" button that will sort the years in descending order
		JButton btnNewButton_8 = new JButton("Sort By Year");
		btnNewButton_8.setIcon(new ImageIcon(bs_img));
		btnNewButton_8.addActionListener(new ActionListener() {
			// the button will call byYear method from Mergesort class when it is active
			public void actionPerformed(ActionEvent e) {
				showpage sl = new showpage();
				sl.setVisible(true);
				sl.setlabel("Sort By Year");
				try {
					for (Player p : Mergesort.byYear(CSVReader.readData(), false)) {
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
		btnNewButton_8.setFont(new Font("SimSun", Font.BOLD, 20));
		btnNewButton_8.setBounds(10, 651, 340, 61);
		contentPane.add(btnNewButton_8);
		// "Sort By Rcon" button that will sort the Rcons of the players in descending
		// order
		JButton btnNewButton_9 = new JButton("Sort By Rcon");
		btnNewButton_9.setIcon(new ImageIcon(bs_img));
		btnNewButton_9.addActionListener(new ActionListener() {
			// the button will call byRcon method from Mergesort class when it is active
			public void actionPerformed(ActionEvent e) {
				showpage sl = new showpage();
				sl.setVisible(true);
				sl.setlabel("Sort By Rcon");
				try {
					for (Player p : Mergesort.byRcon(CSVReader.readData(), false)) {
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
		btnNewButton_9.setFont(new Font("SimSun", Font.BOLD, 20));
		btnNewButton_9.setBounds(387, 651, 340, 61);
		contentPane.add(btnNewButton_9);
	}
}
