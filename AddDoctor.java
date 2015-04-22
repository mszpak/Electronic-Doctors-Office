package Graphics;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import proj1.electronicDoctorsOffice;

public class AddDoctor extends JFrame implements ActionListener
{
		
		private JButton AddToDatabase,butReset,butExit;
		private JTextField doctorName;
		private JTextField ID;
		private JTextField dob;
		private JTextField special;
		private JTextField location;
		private JLabel lblName, lblID, lblDate, lblSpecial, lblLocation;
		
		public AddDoctor(String name)
		{
			super(name);
			AddToDatabase = new JButton("Add Doctor");
			butReset = new JButton("Reset");
			butExit = new JButton("Back");
			doctorName = new JTextField();
			ID = new JTextField();
			dob = new JTextField();
			special = new JTextField();
			location = new JTextField();
			lblName = new JLabel("Doctor Name");
			lblID = new JLabel("ID");
			lblDate = new JLabel("Date of Birth");
			lblSpecial = new JLabel("Doctor Specialty");
			lblLocation = new JLabel("Doctor's Location");
			
			this.setLayout(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			AddToDatabase.addActionListener(this);
			butReset.addActionListener(this);
			butExit.addActionListener(this);
			
			lblName.setBounds(10,10,120,20);
			lblID.setBounds(10,30,120,20);
			lblDate.setBounds(10,90,120,20);
			lblSpecial.setBounds(10,50,120,20);
			lblLocation.setBounds(10,70,120,20);
			doctorName.setBounds(140,10,160,20);
			ID.setBounds(140,30,160,20);
			dob.setBounds(140,90,80,20);
			special.setBounds(140,50,160,20);
			location.setBounds(140,70,160,20);
			
			AddToDatabase.setBounds(140, 120, 100, 20);
			butReset.setBounds(245, 120, 70, 20);
			butExit.setBounds(330, 180, 70, 20);
			
			this.add(AddToDatabase);
			this.add(butReset);
			this.add(butExit);
			this.add(doctorName);
			this.add(ID);
			this.add(dob);
			this.add(special);
			this.add(location);
			this.add(lblName);
			this.add(lblID);
			this.add(lblDate);
			this.add(lblSpecial);
			this.add(lblLocation);
			
			this.setSize(450,250);
			this.setVisible(true);
		}

		public static void main(String[] args)
		{
			AddDoctor p = new AddDoctor("Add Doctor");
		}
		
		
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == AddToDatabase)
			{
				if(ID.getText().equals(null) || ID.getText().equals(""))
				{
					JFrame f1 = new JFrame("enter ID");
					f1.setSize(200,75);
					f1.setVisible(true);
					JLabel lbl = new JLabel("A doctor must have an ID");
					JPanel pan = new JPanel();
					f1.add(pan);
					pan.add(lbl);
				}
				else
				{
					String doctorID = ID.getText();
					String name = doctorName.getText();
					String birthDate = dob.getText();
					String specialty = special.getText();
					String docLocation = location.getText();
					electronicDoctorsOffice d = new electronicDoctorsOffice();
					if(d.addDoctor(doctorID, birthDate, name, specialty, docLocation))
					{
						JFrame f1 = new JFrame("Doctor Added");
						f1.setSize(200,75);
						f1.setVisible(true);
						JLabel lbl = new JLabel("The doctor was added successfully");
						JPanel pan = new JPanel();
						f1.add(pan);
						pan.add(lbl);
					}
					else
					{
						JFrame f1 = new JFrame("Doctor Not Added");
						f1.setSize(200,75);
						f1.setVisible(true);
						JLabel lbl = new JLabel("The doctor was not added successfully");
						JPanel pan = new JPanel();
						f1.add(pan);
						pan.add(lbl);
					}
				}
			}
			else if(e.getSource() == butExit)
			{
				setVisible(false);
				dispose();
			}
			else if(e.getSource() == butReset)
			{
				for (Component C : this.getContentPane().getComponents())
				{    
				    if (C instanceof JTextField){

				        ((JTextField) C).setText(""); //abstract superclass
				    }
				}
			}
			
		}
}
