import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class LogInPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	UserAccess ua;
	static User U;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInPage frame = new LogInPage();
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
	public LogInPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 425);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(5, 0, 273, 387);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Masrou'a");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Wide Latin", Font.PLAIN, 20));
		lblNewLabel.setBounds(48, 49, 190, 45);
		panel.add(lblNewLabel);
		
		JLabel lblLogIn = new JLabel("LogIn Page");
		lblLogIn.setFont(new Font("Snap ITC", Font.PLAIN, 15));
		lblLogIn.setForeground(Color.WHITE);
		lblLogIn.setBounds(75, 159, 131, 45);
		panel.add(lblLogIn);
		
		Button button = new Button("Log In");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String UN=textField.getText();
				char[]arr=passwordField.getPassword();
				String Pass="";for(int i=0;i<arr.length;i++){Pass+=arr[i];}
				U=new User();
				U.SetUserName(UN);U.SetPassword(Pass);
				ua=new UserAccess();
				boolean Succeded=ua.Login(U);
				if(!Succeded)
				{
					JOptionPane.showMessageDialog(null, "Wrong password Or E-Mail, please try again.");
				}
				else
				{

					JOptionPane.showMessageDialog(null, "LogIn Completed Successfully.");
					connection c=new connection();
			        Form f=new Form();
			        FormDB formdd=new FormDB();
			        Scanner reader=new Scanner(System.in);
					f.setUsername(U.GetUserName());
	                System.out.println("Please Fill the form:\n\n");
	                System.out.print("Enter Category: ");
	                reader=new Scanner(System.in);
	                String cat=reader.nextLine();
	                f.setCategory(cat);
	                System.out.print("Enter Color: ");
	                String Color=reader.nextLine();
	                f.setColor(Color);
	                System.out.print("Enter Quantity: ");
	                String quan=reader.nextLine();
	                f.setQuantity(quan);
	                System.out.print("Enter Location: ");
	                String location=reader.nextLine();
	                f.setLocation(location);
	                System.out.print("Enter 1 if founder and 0 if loser: ");
	                String status=reader.nextLine();
	                f.setStatus(status);
	                
	                if(status.equals("0"))
	                {
	                    System.out.println("Enter additional info if exist");
	                    String additional=reader.nextLine();
	                    f.setAdditionalInfo(additional);
	                    
	                }
	                reader.close();
	                formdd.AddFormRec(f);
	                c.Search(f);
				}
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241, 57,83));
		button.setBounds(358, 249, 262, 35);
		contentPane.add(button);
		
		textField = new JTextField();
		textField.setBounds(361, 93, 259, 47);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(361, 167, 259, 47);
		contentPane.add(passwordField);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(361, 69, 91, 21);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(361, 151, 91, 14);
		contentPane.add(lblPassword);
	}
}
