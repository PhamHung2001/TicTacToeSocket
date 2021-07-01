package com.hung.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.hung.game.Game;

public class ChatPanel extends JPanel implements ActionListener {
	private JTextArea areaChat;
	private JTextField tfChat;
	private JButton btSend;
	private JScrollPane sp;
	private JLabel lbChat;

	private Game game;

	public ChatPanel(Game game) {
		this.game = game;
		setLayout(null);

		lbChat = new JLabel("Conversation");
		lbChat.setLocation(50, -20);
		lbChat.setSize(400, 100);
		lbChat.setFont(new Font("Arial", Font.ITALIC, 16));
		lbChat.setForeground(Color.black);

		areaChat = new JTextArea();
		areaChat.setEditable(false);
		areaChat.setFont(new Font("Arial", Font.BOLD, 16));
		areaChat.setForeground(Color.BLACK);
		areaChat.setBorder(BorderFactory.createLineBorder(Color.black));

		sp = new JScrollPane(areaChat);
		sp.setBounds(50, 50, 340, 390);

		tfChat = new JTextField();
		tfChat.setFont(new Font("Arial", Font.BOLD, 15));
		tfChat.setBounds(sp.getX(), sp.getY() + sp.getHeight() + 10, sp.getWidth() - 70, 30);
		tfChat.setBorder(BorderFactory.createLineBorder(Color.black));

		btSend = new JButton("Send");
		btSend.setBounds(tfChat.getX() + tfChat.getWidth() + 5, tfChat.getY(), 65, 30);
		btSend.setBorder(BorderFactory.createLineBorder(Color.black));
		btSend.addActionListener(this);

		add(lbChat);
		add(sp);
		add(tfChat);
		add(btSend);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btSend)) {
			if (tfChat.getText() != "") {
				areaChat.setText(areaChat.getText() + "Player " + game.getThisPlayer() + ":" + tfChat.getText() + "\n");
				game.sendPacketChat(tfChat.getText());
				tfChat.setText("");
			}
		}

	}

	public void updateConverstation(String smg) {
		if (game.getThisPlayer() == 1) {
			areaChat.setText(areaChat.getText() + "Player 2:" + smg + "\n");
		} else {
			areaChat.setText(areaChat.getText() + "Player 1:" + smg + "\n");
		}

	}

}