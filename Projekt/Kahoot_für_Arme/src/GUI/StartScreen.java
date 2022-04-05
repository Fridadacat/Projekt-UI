package GUI;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Data.User;

public class StartScreen extends JFrame implements ActionListener{
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JPanel buttonGrid = new JPanel();
	JPanel textFieldGrid = new JPanel();
	JLabel willkommen = new JLabel("Willkommen beim Kahoot für Arme!", SwingConstants.CENTER);
	JLabel namen = new JLabel("Gib deinen Namen ein:", SwingConstants.CENTER);
	JTextField textField = new JTextField(SwingConstants.CENTER);
	JButton spielen = new JButton("Spielen!");
	JButton leaderboards = new JButton("Leaderboards");
	User user;
	
	public StartScreen(User user) {
		
		this.user = user; 
		
		willkommen.setFont(new Font("Calibri", Font.BOLD, 20));
		
		panel.setLayout(new GridLayout(4, 1, 10, 10));
		buttonGrid.setLayout(new GridLayout(1, 2, 10, 10));
		textFieldGrid.setLayout(new GridLayout(1, 1, 10 , 10));
		
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		spielen.addActionListener(this);
		leaderboards.addActionListener(this);
		
		buttonGrid.add(spielen);
		buttonGrid.add(leaderboards);
		textFieldGrid.add(textField);
		
		panel.add(willkommen);
		panel.add(namen);
		panel.add(textFieldGrid);
		panel.add(buttonGrid);
		
		frame.add(panel);
		
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setTitle("Kahoot für Arme");
		frame.setSize(400, 300);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String name = textField.getText();
		user.setUserName(name);
		
		if (e.getSource() == spielen && name != null) {
			frame.setVisible(false);
			new ChooseTopicScreen(user);
		} else if (e.getSource() == leaderboards && name != null) {
			frame.setVisible(false);
			new ChooseLeaderBoardTopic(user);
		}
		
	}

}
