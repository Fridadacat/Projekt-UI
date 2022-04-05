package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Data.User;

public class ChooseLeaderBoardTopic extends JFrame implements ActionListener{

	User actualPlayer;
	JFrame frame = new JFrame();
	JLabel quizthema = new JLabel("Leaderboard zu Thema:");
	JButton natur = new JButton("Natur");
	JButton politik = new JButton("Politik");
	JButton informatik = new JButton("Informatik");
	JButton back = new JButton("Zurück");
	JButton close = new JButton("beenden");
	JPanel panel = new JPanel();
	JPanel backEndPanel = new JPanel();
	
	public ChooseLeaderBoardTopic(User user) {

		this.actualPlayer = user;
		
		panel.setLayout(new GridLayout(5,1,10,10));
		backEndPanel.setLayout(new GridLayout(1, 2, 20, 20));
		
		backEndPanel.add(back);
		backEndPanel.add(close);
		
		panel.add(quizthema);
		panel.add(natur);
		panel.add(politik);
		panel.add(informatik);
		panel.add(backEndPanel);
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		natur.addActionListener(this);
		politik.addActionListener(this);
		informatik.addActionListener(this);
		back.addActionListener(this);
		close.addActionListener(this);
		
		frame.add(panel);
		
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setTitle("Kahoot für Arme");
		frame.setSize(450, 400);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == natur) {
			frame.setVisible(false);
			new Leaderboard("Natur", actualPlayer);
		} else if (e.getSource() == politik) {
			frame.setVisible(false);
			new Leaderboard("Politik", actualPlayer);
		} else if (e.getSource() == informatik) {
			frame.setVisible(false);
			new Leaderboard("Informatik", actualPlayer);
		} else if (e.getSource() == back) {
			frame.setVisible(false);
			new StartScreen(actualPlayer);
		} else {
			//assume it was "close"
			System.exit(0);
		}
	}
}
