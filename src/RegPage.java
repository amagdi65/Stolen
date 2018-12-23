
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Button;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Font;

public class RegPage extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTextField UserName;
	 JTextField Phone;
	 JTextField Address;
	 JPasswordField passwordField;
	UserAccess ur;
	static User U;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegPage frame = new RegPage();
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
	public RegPage() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 794, 417);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 328, 379);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblSignup = new JLabel("Masrou'a");
		lblSignup.setForeground(Color.WHITE);
		lblSignup.setFont(new Font("Wide Latin", Font.BOLD, 20));
		lblSignup.setBounds(64, 26, 194, 51);
		panel.add(lblSignup);
		
		JLabel lblNewLabel = new JLabel("SignUp Page");
		lblNewLabel.setBounds(91, 137, 126, 45);
		panel.add(lblNewLabel);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setFont(new Font("Snap ITC", Font.PLAIN, 15));
		lblNewLabel.setForeground(Color.WHITE);
		Button button = new Button("SignUp");
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("resource")
			public void actionPerformed(ActionEvent e) {
				U=new User();
				U.SetUserName(UserName.getText());
				U.SetAddress(Address.getText());
				U.SetPhone(Phone.getText());
				char[]temp=passwordField.getPassword();
				String pass="";for(int i=0;i<temp.length;i++){pass+=temp[i];}
				U.SetPassword(pass);
				ur=new UserAccess();
				boolean Succeded=ur.SignUp(U);
				if(!Succeded)
				{
					JOptionPane.showMessageDialog(null, "Required Field Missing, please try again.");
				}
				else
				{
			        connection c=new connection();
			        Form f=new Form();
			        FormDB formdd=new FormDB();
			        Scanner reader=new Scanner(System.in);
					JOptionPane.showMessageDialog(null, "Regestration Completed Successfully.");
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
		button.setBounds(388, 333, 262, 35);
		contentPane.add(button);
		
		UserName = new JTextField();
		UserName.setBounds(388, 72, 262, 41);
		contentPane.add(UserName);
		UserName.setColumns(10);
		JSeparator separator = new JSeparator();
		separator.setBounds(404, 98, 262, -7);
		contentPane.add(separator);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setBounds(388, 47, 66, 24);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(387, 114, 67, 22);
		contentPane.add(lblPassword);
		
		Phone = new JTextField();
		Phone.setColumns(10);
		Phone.setBounds(387, 197, 262, 41);
		contentPane.add(Phone);
		
		
		Address= new JTextField();
		Address.setColumns(10);
		Address.setBounds(387, 259, 262, 41);
		contentPane.add(Address);
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(387, 175, 57, 22);
		contentPane.add(lblPhone);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(387, 239, 57, 22);
		contentPane.add(lblAddress);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(387, 136, 262, 41);
		contentPane.add(passwordField);
	}
}

