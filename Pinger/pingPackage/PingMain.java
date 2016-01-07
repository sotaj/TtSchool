package pingPackage;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.PrintStream;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import testOut.TextAreaOutputStream;

public class PingMain extends JFrame {

	private JPanel contentPane;
	public static JTextField ipIn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PingMain frame = new PingMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PingMain() {
		
		setTitle("Pinger 2k");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 255);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
	
		
		JLabel textfield = new JLabel("Ip to be pinged");
		
		RunGet myRunnable = new RunGet(); 
		Thread myThread ;
		
		
		JButton close = new JButton("Close");
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit( 0 );
			}
		});
		
		JTextArea output = new JTextArea();
		    final TextAreaOutputStream taOutputStream = new TextAreaOutputStream(
			         output, "Test");
		      System.setOut(new PrintStream(taOutputStream));
		
		JButton btnStart = new JButton("Start");
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { 
				
				 new Thread(myRunnable).start(); 
		}});
		ipIn = new JTextField();
		ipIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new Thread(myRunnable).start(); 
			}
		});
		ipIn.setColumns(10);
		JButton btnStop = new JButton("Stop");
		btnStop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
					myRunnable.stahp();
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textfield)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnStart)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnStop)))
							.addGap(30)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(ipIn, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
								.addComponent(close, Alignment.TRAILING)))
						.addComponent(output, GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textfield)
						.addComponent(ipIn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(output, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(close)
						.addComponent(btnStart)
						.addComponent(btnStop))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
