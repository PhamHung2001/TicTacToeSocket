package com.hung.game;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.hung.connect.Connection;

public class ClientGame extends Game {
	private Socket socket;

	public ClientGame() {
		super(Game.PLAYER_TWO);
		try {
			socket = new Socket("localhost", Game.PORT);
			connection = new Connection(this, socket);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void receivedPacket(Object object) {
		super.receivedPacket(object);
		checkWin(PLAYER_ONE);
	}

	@Override
	protected void close() {
		super.close();
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
