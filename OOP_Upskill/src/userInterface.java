import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class userInterface {

	private JFrame frame;
	private JTextField outPut;
	private JTextField Input;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userInterface window = new userInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public userInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnStartClient = new JButton("Start Client");
		btnStartClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Runnable client = new ClientThread();
				Thread clientThread = new Thread(client);
				clientThread.start();
			}
		});
		frame.getContentPane().add(btnStartClient, BorderLayout.WEST);
		
		JButton btnStartServer = new JButton("Start Server");
		btnStartServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Runnable server = new ServerThread();
				Thread serverThread = new Thread(server);
				serverThread.start();
			}
		});
		frame.getContentPane().add(btnStartServer, BorderLayout.NORTH);
		
		JTextPane textPane = new JTextPane();
		frame.getContentPane().add(textPane, BorderLayout.CENTER);
		
		outPut = new JTextField();
		frame.getContentPane().add(outPut, BorderLayout.EAST);
		outPut.setColumns(10);
		
		Input = new JTextField();
		frame.getContentPane().add(Input, BorderLayout.SOUTH);
		Input.setColumns(10);
	}

}
