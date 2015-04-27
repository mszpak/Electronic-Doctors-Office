package Graphics;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import proj1.electronicDoctorsOffice;

public class EditAppointmentNotes extends JFrame implements ActionListener
{
		
		private JButton AddToDatabase,butReset,butExit;
		private JTextField ID, notes, patientID;
		private JLabel lblID, lblNotes, lblPatientID;
		
		public EditAppointmentNotes(String name)
		{
			super(name);
			AddToDatabase = new JButton("Edit Appointment");
			butReset = new JButton("Reset");
			butExit = new JButton("Back");
			notes = new JTextField();
			ID = new JTextField();
			lblNotes = new JLabel("Appointment Notes");
			lblID = new JLabel("Appointment ID");
			lblPatientID = new JLabel("Patient ID");
			patientID = new JTextField();
			
			this.setLayout(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			AddToDatabase.addActionListener(this);
			butReset.addActionListener(this);
			butExit.addActionListener(this);
			
			lblID.setBounds(10,30,120,20);
			ID.setBounds(140,30,160,20);
			patientID.setBounds(140,50,160,20);
			lblPatientID.setBounds(10, 50, 120, 20);
			lblNotes.setBounds(10, 70, 120, 20);
			notes.setBounds(140,70,170,90);

			
			AddToDatabase.setBounds(100, 180, 135, 20);
			butReset.setBounds(255, 180, 70, 20);
			butExit.setBounds(330, 180, 70, 20);
			
			this.add(AddToDatabase);
			this.add(butReset);
			this.add(butExit);
			this.add(notes);
			this.add(ID);
			this.add(lblNotes);
			this.add(lblID);
			this.add(patientID);
			this.add(lblPatientID);
			
			this.setSize(450,250);
			this.setVisible(true);
		}

		public static void main(String[] args)
		{
			EditAppointmentNotes m = new EditAppointmentNotes("Edit Appointment");
		}
		
		
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == AddToDatabase)
			{
				if(ID.getText().equals(null) || ID.getText().equals(""))
				{
					JFrame f1 = new JFrame("enter ID");
					f1.setSize(200,75);
					f1.setVisible(true);
					JLabel lbl = new JLabel("An appointment must have an ID");
					JPanel pan = new JPanel();
					f1.add(pan);
					pan.add(lbl);
				}
				else
				{
					String appID = ID.getText();
					String appNotes = notes.getText();
					String pID = patientID.getText();
					if(patientID.getText().equals(""))
					{
						JFrame f1 = new JFrame("enter ID");
						f1.setSize(200,75);
						f1.setVisible(true);
						JLabel lbl = new JLabel("Must enter patient ID");
						JPanel pan = new JPanel();
						f1.add(pan);
						pan.add(lbl);
					}
					if(ID.getText().equals(""))
					{
						JFrame f1 = new JFrame("enter ID");
						f1.setSize(200,75);
						f1.setVisible(true);
						JLabel lbl = new JLabel("Must enter appointment ID");
						JPanel pan = new JPanel();
						f1.add(pan);
						pan.add(lbl);
					}
					electronicDoctorsOffice d = new electronicDoctorsOffice();
					if(d.editPatientNotes(pID, appID, appNotes))
					{
						JFrame f1 = new JFrame("Appointment Notes Changed");
						f1.setSize(200,75);
						f1.setVisible(true);
						JLabel lbl = new JLabel("The appointment notes were changed successfully");
						JPanel pan = new JPanel();
						f1.add(pan);
						pan.add(lbl);
					}
					else
					{
						JFrame f1 = new JFrame("Appointment Not Added");
						f1.setSize(200,75);
						f1.setVisible(true);
						JLabel lbl = new JLabel("The appointment was not added successfully");
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
