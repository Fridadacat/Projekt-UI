package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Data.User;

public class Leaderboard extends JFrame implements ActionListener{
	
	User actualPlayer;
	String topic;
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel info = new JLabel("Leaderboard", SwingConstants.CENTER);
	JPanel player1 = new JPanel();
	JPanel player2 = new JPanel();
	JPanel player3 = new JPanel();
	JPanel player4 = new JPanel();
	JPanel player5 = new JPanel();
	JPanel you = new JPanel();
	JPanel list = new JPanel();
	JPanel buttons = new JPanel();
	JButton back = new JButton("Zurück");
	JButton exit = new JButton("Beenden");
	JLabel player1Points = new JLabel();
	JLabel player2Points = new JLabel();
	JLabel player3Points = new JLabel();
	JLabel player4Points = new JLabel();
	JLabel player5Points = new JLabel();
	JLabel yourPoints = new JLabel();
		
	public Leaderboard(String topic, User actualPlayer) {
		
		this.topic = topic;
		this.actualPlayer = actualPlayer;
		
		panel.setLayout(new BorderLayout());
		list.setLayout(new GridLayout(6, 1));
		buttons.setLayout(new GridLayout(1, 2, 10, 10));
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		buttons.setBorder(new EmptyBorder(10, 0, 0, 0));
		
		info.setFont(new Font("Calibri", Font.BOLD, 20));
		
		player1Points.setHorizontalAlignment(JLabel.RIGHT);
		player2Points.setHorizontalAlignment(JLabel.RIGHT);
		player3Points.setHorizontalAlignment(JLabel.RIGHT);
		player4Points.setHorizontalAlignment(JLabel.RIGHT);
		player5Points.setHorizontalAlignment(JLabel.RIGHT);
		yourPoints.setHorizontalAlignment(JLabel.RIGHT);
		
		if(topic == "Natur") {
			setPlayersNature();
		} else if (topic == "Politik") {
			setPlayersPolitics();
		} else {
			setPlayersInformatics();
		}
		
		player1.setBorder(BorderFactory.createLineBorder(Color.black));
		player2.setBorder(BorderFactory.createLineBorder(Color.black));
		player3.setBorder(BorderFactory.createLineBorder(Color.black));
		player4.setBorder(BorderFactory.createLineBorder(Color.black));
		player5.setBorder(BorderFactory.createLineBorder(Color.black));
		you.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		
		player1.setBackground(Color.LIGHT_GRAY);
		player2.setBackground(Color.LIGHT_GRAY);
		player3.setBackground(Color.LIGHT_GRAY);
		player4.setBackground(Color.LIGHT_GRAY);
		player5.setBackground(Color.LIGHT_GRAY);
		you.setBackground(Color.LIGHT_GRAY);
		
		list.add(player1);
		list.add(player2);
		list.add(player3);
		list.add(player4);
		list.add(player5);
		list.add(you);
		
		back.addActionListener(this);
		exit.addActionListener(this);
		
		buttons.add(back);
		buttons.add(exit);
		
		panel.add(info, BorderLayout.NORTH);
		panel.add(list, BorderLayout.CENTER);
		panel.add(buttons, BorderLayout.SOUTH);
		
		frame.add(panel);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setTitle("Leaderboard");
		frame.setSize(400, 420);
		frame.setVisible(true);
	}

	
	private void setPlayersInformatics() {
		
		player1.setLayout(new GridLayout(1, 2));
		player1.add(new JLabel("1. Donald Trump"));
		player1Points.setText("77P ");
		player1.add(player1Points);
		
		player2.setLayout(new GridLayout(1, 2));
		player2.add(new JLabel("2. Ignazio Cassis"));
		player2Points.setText("76.99P ");
		player2.add(player2Points);
		
		player3.setLayout(new GridLayout(1, 2));
		player3.add(new JLabel("3. Sebastian Kurz"));
		player3Points.setText("50P ");
		player3.add(player3Points);
		
		player4.setLayout(new GridLayout(1, 2));
		player4.add(new JLabel("4. Enea"));
		player4Points.setText("49P ");
		player4.add(player4Points);
		
		player5.setLayout(new GridLayout(1, 2));
		player5.add(new JLabel("5. Alain Berset"));
		player5Points.setText("16P ");
		player5.add(player5Points);
		
		int points = actualPlayer.getPointsinformatics();
		String pointsString = String.valueOf(points);
		you.setLayout(new GridLayout(1, 2));
		if (actualPlayer.getUserName().isEmpty()) {
			you.add(new JLabel("6. Du"));
		} else {
			you.add(new JLabel("6. " + actualPlayer.getUserName()));
		}
		yourPoints.setText(pointsString + " ");
		you.add(yourPoints);
		
	}


	private void setPlayersPolitics() {
		
		player1.setLayout(new GridLayout(1, 2));
		player1.add(new JLabel("1. Hans Ueli"));
		player1Points.setText("100P ");
		player1.add(player1Points);
		
		player2.setLayout(new GridLayout(1, 2));
		player2.add(new JLabel("2. Der Soosenbinder"));
		player2Points.setText("87P ");
		player2.add(player2Points);
		
		player3.setLayout(new GridLayout(1, 2));
		player3.add(new JLabel("3. asdfghjklöä"));
		player3Points.setText("80P ");
		player3.add(player3Points);
		
		player4.setLayout(new GridLayout(1, 2));
		player4.add(new JLabel("4. Herbert"));
		player4Points.setText("50P ");
		player4.add(player4Points);
		
		player5.setLayout(new GridLayout(1, 2));
		player5.add(new JLabel("5. Terminator"));
		player5Points.setText("34P ");
		player5.add(player5Points);
		
		int points = actualPlayer.getPointsPolitics();
		String pointsString = String.valueOf(points);
		you.setLayout(new GridLayout(1, 2));
		if (actualPlayer.getUserName().isEmpty()) {
			you.add(new JLabel("6. Du"));
		} else {
			you.add(new JLabel("6. " + actualPlayer.getUserName()));
		}
		yourPoints.setText(pointsString + " ");
		you.add(yourPoints);
		
	}


	private void setPlayersNature() {
		
		player1.setLayout(new GridLayout(1, 2));
		player1.add(new JLabel("1. Angela Merkel"));
		player1Points.setText("100P ");
		player1.add(player1Points);
		
		player2.setLayout(new GridLayout(1, 2));
		player2.add(new JLabel("2. Marcel D' Avis"));
		player2Points.setText("99P ");
		player2.add(player2Points);
		
		player3.setLayout(new GridLayout(1, 2));
		player3.add(new JLabel("3. Woldomir Putin"));
		player3Points.setText("32P ");
		player3.add(player3Points);
		
		player4.setLayout(new GridLayout(1, 2));
		player4.add(new JLabel("4. Metternich"));
		player4Points.setText("30P ");
		player4.add(player4Points);
		
		player5.setLayout(new GridLayout(1, 2));
		player5.add(new JLabel("5. Ueli Muurer"));
		player5Points.setText("16P ");
		player5.add(player5Points);
		
		int points = actualPlayer.getPointsNature();
		String pointsString = String.valueOf(points);
		you.setLayout(new GridLayout(1, 2));
		if (actualPlayer.getUserName().isEmpty()) {
			you.add(new JLabel("6. Du"));
		} else {
			you.add(new JLabel("6. " + actualPlayer.getUserName()));
		}
		yourPoints.setText(pointsString + " ");
		you.add(yourPoints);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == back) {
			frame.setVisible(false);
			new ChooseTopicScreen(actualPlayer);
		} else {
			System.exit(0);
		}
		
	}

}
