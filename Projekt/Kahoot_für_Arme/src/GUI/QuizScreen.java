package GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Data.User;

public class QuizScreen extends JFrame implements ActionListener {
	
	User actualPlayer;
	JPanel panel = new JPanel();
	JFrame frame = new JFrame();
	JPanel questionGrid = new JPanel();
	JPanel bottomGrid = new JPanel();
	JLabel question = new JLabel();
	JButton answer1 = new JButton();
	JButton answer2 = new JButton();
	JButton answer3 = new JButton();
	JButton correctAnswer = new JButton();
	JLabel time = new JLabel("Verbleibende Zeit: 20");
	JLabel counter = new JLabel("1 / 20");
	int points = 0;
	JLabel labelPoints = new JLabel("Aktuelle Punktzahl: " + points);
	String topic;
	
	public QuizScreen(String topic, User actualPlayer) {
		
		this.actualPlayer= actualPlayer;
		this.topic = topic;
		
		question.setFont(new Font("Calibri", Font.BOLD, 20));
		
		panel.setLayout(new BorderLayout());
		questionGrid.setLayout(new GridLayout(2, 2, 10, 10));
		bottomGrid.setLayout(new GridLayout(2, 2, 10, 10));
		
		panel.setBorder(new EmptyBorder(20, 20, 20, 20));
		bottomGrid.setBorder(new EmptyBorder(10, 0, 0, 0));
		questionGrid.setBorder(new EmptyBorder(10, 0, 0, 0));
		
		if (this.topic == "Natur") {
			setLabelsNature();
			this.topic = "Natur";
		} else if (this.topic == "Politik") {
			setLabelPolitics();
			this.topic = "Politik";
		} else {
			setLabelInformatics();
			this.topic = "Informatik";
		}
		
		answer1.addActionListener(this);
		answer2.addActionListener(this);
		answer3.addActionListener(this);
		correctAnswer.addActionListener(this);
		
		questionGrid.add(answer1);
		questionGrid.add(answer2);
		questionGrid.add(correctAnswer);
		questionGrid.add(answer3);
		
		time.setHorizontalAlignment(JLabel.RIGHT);
		labelPoints.setHorizontalAlignment(JLabel.RIGHT);
		
		bottomGrid.add(new JLabel(" "));
		bottomGrid.add(time);
		bottomGrid.add(counter);
		bottomGrid.add(labelPoints);
		
		panel.add(question, BorderLayout.NORTH);
		panel.add(questionGrid, BorderLayout.CENTER);
		panel.add(bottomGrid, BorderLayout.SOUTH);
		
		frame.add(panel);
		
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setTitle("Kahoot für Arme");
		frame.setSize(400, 300);
		frame.setVisible(true);
		
		
		
	}

	private void setLabelInformatics() {
		question.setText("Was ist cooler?");
		answer1.setText("Java");
		answer2.setText("C++");
		answer3.setText("Python");
		correctAnswer.setText("Scratch");
	}

	private void setLabelPolitics() {
		question.setText("Wer war der 1. US-Präsident?");
		answer1.setText("Lenin");
		answer2.setText("Madison");
		answer3.setText("Trump");
		correctAnswer.setText("Washington");
		
	}

	private void setLabelsNature() {
		question.setText("Welches ist kein Säugetier?");
		answer1.setText("Schnabeltier");
		answer2.setText("Wal");
		answer3.setText("Delfin");
		correctAnswer.setText("Leguan");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == answer1) {
			setPoints(false);
			frame.setVisible(false);
			new AnswerWas(topic, actualPlayer, false);
		} else if (e.getSource() == answer2) {
			setPoints(false);
			frame.setVisible(false);
			new AnswerWas(topic, actualPlayer, false);
		} else if (e.getSource() == answer3) {
			setPoints(false);
			frame.setVisible(false);
			new AnswerWas(topic, actualPlayer, false);
		} else {
			setPoints(true);
			frame.setVisible(false);
			new AnswerWas(topic, actualPlayer, true);
		}
		
	}

	private void setPoints(boolean correctAnswer) {
		if (correctAnswer == true) {
			points = points + 12;
		}
		setUserPoints();
	}
	
	public void setUserPoints() {
		if (topic == "Natur") {
			actualPlayer.setpointsNature(points);
		} else if (topic == "Politik") {
			actualPlayer.setPointsPolitics(points);
		} else {
			actualPlayer.setPointsInformatics(points);
		}
	}

}
