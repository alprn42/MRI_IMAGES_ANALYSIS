import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class userPanel extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private final JPanel panel_1 = new JPanel();

	
//	we use java java swing to design our ui(added it to library)
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userPanel frame = new userPanel();
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
	public userPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 904, 469);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 204, 255));
		panel.setBounds(0, 0, 366, 422);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(46, 5, 320, 287);
		label.setIcon(new ImageIcon("C:\\Users\\mbozk\\eclipse-workspace\\BEN\\img\\login-button.png"));
		panel.add(label);
		
		JLabel lblLogIn = new JLabel("LOG IN");
		lblLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogIn.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblLogIn.setBounds(105, 291, 181, 40);
		panel.add(lblLogIn);
		
		
		
//		when we click sign up, login panel(this panel) disappears and sign up panel comes.
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);				
				signUp su = new signUp();
				su.setVisible(true);
			

			}
		});
		btnNewButton.setBounds(148, 382, 97, 25);
		panel.add(btnNewButton);
		
		JLabel lblUserName = new JLabel("USER NAME:");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUserName.setBounds(420, 85, 132, 31);
		contentPane.add(lblUserName);
		
		textField = new JTextField();
		textField.setBounds(420, 141, 319, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(420, 192, 132, 31);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(420, 236, 319, 38);
		contentPane.add(passwordField);
		
		
//		when we click log in button first it checks the user name and password(we get the text from ui to variables) and if those are in db we can log in.
//		else a message dialog shows up that says wrong user name or passwors
		
		JButton btnLogIn = new JButton("LOG IN");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String username = textField.getText();
				String pass = new String(passwordField.getPassword());
				db db = new db();
				boolean x = db.check(username, pass);
				
				if(x==true) {
					setVisible(false);
					deneme2.main(null);
				}
				
				else
			JOptionPane.showMessageDialog(rootPane, "Wrong username or password!");	
								
			}
		});
		btnLogIn.setBounds(420, 305, 97, 25);
		contentPane.add(btnLogIn);
		panel_1.setBounds(855, 0, 31, 31);
		contentPane.add(panel_1);
	}
}
