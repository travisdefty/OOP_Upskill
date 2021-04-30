//Server Class
//Author: Travis Defty

//Import
import java.net.Socket;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.PrintWriter;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.System.out;
import java.net.*;
import java.io.ObjectOutputStream;

//define server class
public class ServerThread implements Runnable{
	//attributes
	ServerSocket serverSocket;
	Socket socket;
	DataInputStream dataIn;
	DataOutputStream dataOut;
	String clientInput ="check";

	public void setupSocket(int port) throws IOException {
		//start the socket
		serverSocket = new ServerSocket(port);
		System.out.println("Server is listeining on port " + port);
	}

	public void acceptClient() throws IOException {
		//wait for client to connect
		socket = serverSocket.accept();
		System.out.println("New client connected");

		//setup input stream
		InputStream input = socket.getInputStream();
		BufferedInputStream reader = new BufferedInputStream(input);
		dataIn = new DataInputStream(reader);

		//setup output stream
		OutputStream output = socket.getOutputStream();
		dataOut = new DataOutputStream(output);
		
	}

	public void replyClient() {
		try {
			clientInput = dataIn.readUTF();
			dataOut.writeUTF("From server:" + clientInput);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run(){
		int port = 6898;
		
		try {
			setupSocket(port);
			acceptClient();
		} catch (IOException e) {

			e.printStackTrace();
		}

		while(!clientInput.equals("stop")) {
			replyClient();

		}

	}
}


