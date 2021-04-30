//ClientThread Class
//Author: Travis Defty

//Import
import static java.lang.System.out;
import java.net.*;
import java.io.*;

//define server class
public class ClientThread implements Runnable{
	Socket socket;
	String hostname = "127.0.0.1";
	int port = 6898;
	String serverResponse = "start";
	DataOutputStream dataOut;
	DataInputStream dataIn;
	
	public void setupSocket() throws UnknownHostException, IOException {
		socket = new Socket(hostname, port);
		OutputStream output = socket.getOutputStream();
		BufferedOutputStream bout = new BufferedOutputStream(output);
		dataOut = new DataOutputStream(output);

		InputStream input = socket.getInputStream();
		BufferedInputStream reader = new BufferedInputStream(input);
		dataIn = new DataInputStream(reader);
	}
	
	public void messageServer(String msg) {
		try {
			dataOut.writeUTF(msg);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readServer() {
		try {
			serverResponse = dataIn.readUTF();
			System.out.println(serverResponse);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run(){
		try {
			setupSocket();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		readServer();
			

	}
}