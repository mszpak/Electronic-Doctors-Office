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
import proj1.medication;

public class AddPatientToDoctor extends JFrame implements ActionListener
{
		
		private JButton AddToDatabase,butReset,butExit;
		private JTextField doctorID;
		private JTextField patientID;
		private JLabel lblName, lblID;
		
		public AddPatientToDoctor(String name)
		{
			super(name);
			AddToDatabase = new JButton("Add Patient To Doctor");
			butReset = new JButton("Reset");
			butExit = new JButton("Exit");
			patientID = new JTextField();
			doctorID = new JTextField();
			lblName = new JLabel("Patient ID");
			lblID = new JLabel("Doctor ID");
			
			this.setLayout(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			AddToDatabase.addActionListener(this);
			butReset.addActionListener(this);
			butExit.addActionListener(this);
			
			lblName.setBounds(10,10,120,20);
			lblID.setBounds(10,30,120,20);
			patientID.setBounds(140,10,160,20);
			doctorID.setBounds(140,30,160,20);

			
			AddToDatabase.setBounds(100, 80, 150, 20);
			butReset.setBounds(255, 80, 70, 20);
			butExit.setBounds(330, 180, 70, 20);
			
			this.add(AddToDatabase);
			this.add(butReset);
			this.add(butExit);
			this.add(doctorID);
			this.add(patientID);
			this.add(lblName);
			this.add(lblID);
			
			this.setSize(450,250);
			this.setVisible(true);
		}

		public static void main(String[] args)
		{
			AddPatientToDoctor d = new AddPatientToDoctor("Add a Patient to a Doctor");
		}
		
		
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == AddToDatabase)
			{
				if(patientID.getText().equals(null) || patientID.getText().equals(""))
				{
					JFrame f1 = new JFrame("enter ID");
					f1.setSize(200,75);
					f1.setVisible(true);
					JLabel lbl = new JLabel("Patient ID must be given");
					JPanel pan = new JPanel();
					f1.add(pan);
					pan.add(lbl);
				}
				else if(doctorID.getText().equals(null) || doctorID.getText().equals(""))
				{
					JFrame f1 = new JFrame("enter ID");
					f1.setSize(200,75);
					f1.setVisible(true);
					JLabel lbl = new JLabel("Doctor ID must be given");
					JPanel pan = new JPanel();
					f1.add(pan);
					pan.add(lbl);
				}
				else
				{
					String patID = patientID.getText();
					String docID = doctorID.getText();
					electronicDoctorsOffice d = new electronicDoctorsOffice();
					if(d.addPatientToDoctor(docID, patID))
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
			else if(e.getSource() == butExit)
			{
				setVisible(false);
				dispose();
			}
			else if(e.getSource() == butReset)
			{
				for(Component C : this.getContentPane().getComponents())
				{
					if(C instanceof JTextField){
						
						((JTextField) C).setText("");
					}
				}
			}
			
		}
		
}
