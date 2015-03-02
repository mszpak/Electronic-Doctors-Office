package proj1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginScreen extends JFrame implements ActionListener
{
		
		private JButton butLogin,butReset,butExit;
		private JTextField enter;
		private JPasswordField pass;
		private JLabel lblUser, lblPass;
		
		public LoginScreen(String name)
		{
			super(name);
			butLogin = new JButton("Login");
			butReset = new JButton("Reset");
			butExit = new JButton("Exit");
			enter = new JTextField();
			pass = new JPasswordField();
			lblUser = new JLabel("Username");
			lblPass = new JLabel("Password");
			
			this.setLayout(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			butLogin.addActionListener(this);
			butReset.addActionListener(this);
			butExit.addActionListener(this);
			
			lblUser.setBounds(10,10,120,20);
			lblPass.setBounds(10,30,120,20);
			enter.setBounds(140,10,150,20);
			pass.setBounds(140,30,150,20);
			
			butLogin.setBounds(140, 55, 70, 20);
			butReset.setBounds(220, 55, 70, 20);
			butExit.setBounds(310, 100, 70, 20);
			
			this.add(butLogin);
			this.add(butReset);
			this.add(butExit);
			this.add(enter);
			this.add(pass);
			this.add(lblUser);
			this.add(lblPass);
			
			this.setSize(400,160);
			this.setVisible(true);
		}
		
		public static void main(String[] args)
		{
			LoginScreen ls = new LoginScreen("Login");
		}

		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == butLogin)
			{
				if(enter.getText().equals(null) || enter.getText().equals(""))
				{
					JFrame f1 = new JFrame("enter username");
					f1.setSize(200,75);
					f1.setVisible(true);
					JLabel lbl = new JLabel("Please enter a username");
					JPanel pan = new JPanel();
					f1.add(pan);
					pan.add(lbl);
				}
				else
				{
					electronicDoctorsOffice d = new electronicDoctorsOffice();
					char[] password = pass.getPassword();
					String pw = "";
					for(int i=0; i < password.length; ++i){ pw += password[i]; }
					if(d.login(enter.getText(), pw))
					{
						System.out.println();
						System.out.println("//////////////////////////////////////////////////////////////////////");
						System.out.println();
						System.out.println("MENU: TO PERFORM AN ACTION, ENTER THE NUMBER NEXT TO THE OPTION");
						System.out.println("1: ADD A PATIENT");
						System.out.println("2: REMOVE A PATIENT");
						System.out.println("3: SEARCH FOR A PATIENT");
						System.out.println("4: ADD A DOCTOR");
						System.out.println("5: VIEW BILL");
					}
				}
			}
			else if(e.getSource() == butReset)
			{
				enter.setText(null);
				pass.setText(null);
			}
			else if(e.getSource() == butExit)
			{
				System.exit(0);
			}
			
		}

}

