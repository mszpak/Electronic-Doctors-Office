package Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import proj1.electronicDoctorsOffice;

public class AddPatient extends JFrame implements ActionListener
{
		
		private JButton AddToDatabase,butReset,butExit;
		private JTextField patientName;
		private JTextField ID;
		private JTextField dob;
		private JLabel lblName, lblID, lblDate;
		
		public AddPatient(String name)
		{
			super(name);
			AddToDatabase = new JButton("Add Patient");
			butReset = new JButton("Reset");
			butExit = new JButton("Exit");
			patientName = new JTextField();
			ID = new JTextField();
			dob = new JTextField();
			lblName = new JLabel("Patient Name");
			lblID = new JLabel("ID");
			lblDate = new JLabel("Date of Birth");
			
			this.setLayout(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			AddToDatabase.addActionListener(this);
			butReset.addActionListener(this);
			butExit.addActionListener(this);
			
			lblName.setBounds(10,10,120,20);
			lblID.setBounds(10,30,120,20);
			lblDate.setBounds(10,50,120,20);
			patientName.setBounds(140,10,160,20);
			ID.setBounds(140,30,160,20);
			dob.setBounds(140,50,80,20);
			
			AddToDatabase.setBounds(140, 80, 100, 20);
			butReset.setBounds(245, 80, 70, 20);
			butExit.setBounds(310, 140, 70, 20);
			
			this.add(AddToDatabase);
			this.add(butReset);
			this.add(butExit);
			this.add(patientName);
			this.add(ID);
			this.add(dob);
			this.add(lblName);
			this.add(lblID);
			this.add(lblDate);
			
			this.setSize(400,200);
			this.setVisible(true);
		}

		public static void main(String[] args)
		{
			AddPatient p = new AddPatient("Add Patient");
		}
		
		
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == AddToDatabase)
			{
				if(ID.getText().equals(null) || ID.getText().equals(""))
				{
					JFrame f1 = new JFrame("enter ID");
					f1.setSize(200,75);
					f1.setVisible(true);
					JLabel lbl = new JLabel("A patient must have an ID");
					JPanel pan = new JPanel();
					f1.add(pan);
					pan.add(lbl);
				}
				else
				{
					String patientID = ID.getText();
					String name = patientName.getText();
					String birthDate = dob.getText();
					electronicDoctorsOffice d = new electronicDoctorsOffice();
					if(d.addPatient(patientID, birthDate, name))
					{
						JFrame f1 = new JFrame("Patient Added");
						f1.setSize(200,75);
						f1.setVisible(true);
						JLabel lbl = new JLabel("The patient was added successfully");
						JPanel pan = new JPanel();
						f1.add(pan);
						pan.add(lbl);
					}
					else
					{
						JFrame f1 = new JFrame("Patient Not Added");
						f1.setSize(200,75);
						f1.setVisible(true);
						JLabel lbl = new JLabel("The patient was not added successfully");
						JPanel pan = new JPanel();
						f1.add(pan);
						pan.add(lbl);
					}
				}
			}
			
		}
}
