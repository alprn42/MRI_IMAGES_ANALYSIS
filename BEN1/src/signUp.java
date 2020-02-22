import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class signUp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signUp frame = new signUp();
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
	public signUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1201, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 366, 422);
		panel.setBackground(new Color(0, 0, 0));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblSgnUp = new JLabel("SIGN UP");
		lblSgnUp.setForeground(new Color(60, 179, 113));
		lblSgnUp.setBounds(98, 291, 181, 40);
		lblSgnUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSgnUp.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel.add(lblSgnUp);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\mbozk\\eclipse-workspace\\BEN\\img\\160-128.png"));
		lblNewLabel.setBounds(0, 5, 366, 287);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("USER NAME:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(428, 54, 132, 31);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(428, 98, 319, 38);
		contentPane.add(textField);
		
		JLabel label_1 = new JLabel("PASSWORD:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(428, 149, 132, 31);
		contentPane.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(428, 193, 319, 38);
		contentPane.add(passwordField);
		
		JLabel lblConfrmPassword = new JLabel("CONFIRM PASSWORD:");
		lblConfrmPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConfrmPassword.setBounds(428, 244, 194, 31);
		contentPane.add(lblConfrmPassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(428, 288, 319, 38);
		contentPane.add(passwordField_1);
		
		JButton btnSubmit = new JButton("Back");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				userPanel up = new userPanel();
				up.setVisible(true);

				
			}
		});
		btnSubmit.setBounds(428, 368, 97, 25);
		contentPane.add(btnSubmit);
//		when we click submit button,save the data
		JButton button = new JButton("Submit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = textField.getText();
				String pass1 = new String(passwordField.getPassword());
				String pass2 = new String (passwordField_1.getPassword());
				String name = textField_1.getText();
				String surname = textField_2.getText();
				String email = textField_3.getText();
				db db = new db();
//				checking passwords
				if(!pass1.equals(pass2)) {
					JOptionPane.showMessageDialog(rootPane, "Passwords are not matched");
				}
				else {
					db.addTable(username, pass1, name, surname, email);
					JOptionPane.showMessageDialog(rootPane, "You have succesfully sign uped. You can log in now");
				}
					
			}
		});
		button.setBounds(555, 368, 97, 25);
		contentPane.add(button);
		
		JLabel lblName = new JLabel("NAME:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(783, 54, 132, 31);
		contentPane.add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(783, 98, 319, 38);
		contentPane.add(textField_1);
		
		JLabel lblSurname = new JLabel("SURNAME:");
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSurname.setBounds(783, 149, 132, 31);
		contentPane.add(lblSurname);
		
		JLabel lblEmal = new JLabel("EMAIL:");
		lblEmal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmal.setBounds(783, 244, 132, 31);
		contentPane.add(lblEmal);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(783, 193, 319, 38);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(783, 288, 319, 38);
		contentPane.add(textField_3);
	}
}
