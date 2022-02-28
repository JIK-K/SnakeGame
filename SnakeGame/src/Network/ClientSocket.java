package NetWork;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocket {
	Socket socket;
	BufferedReader reader = null;
	PrintWriter writer = null;
	OutputStream output;
	String data;
	
	public ClientSocket() {
		setUpNetworking();
		go();
	}
	
	private void setUpNetworking() {
		try {
			socket = new Socket("127.0.0.1", 4242);
//			socket = new Socket("211.199.81.93", 4242);
			InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
			reader = new BufferedReader(streamReader);
			writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void sendData(String data) {
            this.data = data;
            writer.println(this.data);
            writer.flush();
	}
        
        public String returnData(){
            return data;
        }
	
	public void go() {
		Thread readerThread = new Thread(new IncomingReader());
		readerThread.start();
	}
	
	public class IncomingReader implements Runnable{
		public void run() {
			String message;
			try {
				while((message = reader.readLine()) != null) {
					System.out.println("어딘가서에 온 메세지...  " + message);
				}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	private static class SingleTonHolder{
		private static final ClientSocket instance = new ClientSocket();
	}
	public static ClientSocket getInstance() {
		return SingleTonHolder.instance;
	}
}