package Game;

import java.io.BufferedReader;
import java.net.Socket;

public class ClientSocket {
	Socket socket;
	BufferedReader reader;
	
	public ClientSocket() {
		setUpNetworking();
	}
	
	private void setUpNetworking() {
		try {
			socket = new Socket("211.199.81.93", 4242);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
