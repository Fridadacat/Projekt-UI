package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Data.User;

public class AnswerWas extends JFrame implements ActionListener{

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel info = new JLabel();
	JButton ok = new JButton("ok");
	User actualPlayer;
	String topic;
	boolean answerWas;
	
	public AnswerWas(String topic, User actualPlayer, boolean answerWas) {
		
		this.actualPlayer = actualPlayer;
		this.topic = topic;
		this.answerWas = answerWas;
		
		if (answerWas == true) {
			setCorrectAnswer();
		} else {
			setWrongAnswer();
		}
		
		ok.addActionListener(this);
		
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel.setLayout(new BorderLayout());
		panel.add(info, BorderLayout.CENTER);
		panel.add(ok, BorderLayout.SOUTH);
		
		frame.add(panel);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setTitle("Info");
		frame.setSize(400, 150);
		frame.setVisible(true);
	}

	private void setWrongAnswer() {
		panel.setBackground(Color.RED);
		info.setText("Deine Antwort war leider falsch, hier gehts zum Leaderboard:");
	}

	private void setCorrectAnswer() {
		panel.setBackground(Color.GREEN);
		info.setText("Deine Antwort war richtig!");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.setVisible(false);
		new Leaderboard(topic, actualPlayer);
	}
}
