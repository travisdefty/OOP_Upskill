//Main
//Author Travis Defty
//Import
import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.IOException;
import static java.lang.System.out;
import java.lang.Thread;

public class Main {

	public static void main(String[] args) {
		int in = 0;

		System.out.println("Do you want to start the server? (1/0)");
		try {
			in = System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(in==1) {

			Runnable server = new ServerThread();
			Thread serverThread = new Thread(server);
			serverThread.start();
			
		

		}if(in==1) {
			Runnable client = new ClientThread();
			Thread clientThread = new Thread(client);
			clientThread.start();

		}
		userInterface.main(args);
		while(true) {
			
			
		}

	}

}
