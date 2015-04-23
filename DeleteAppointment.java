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

public class DeleteAppointment extends JFrame implements ActionListener
{
		
		private JButton AddToDatabase,butReset,butExit;
		private JTextField patientID;
		private JTextField appID;
		private JLabel lblName, lblID;
		
		public DeleteAppointment(String name)
		{
			super(name);
			AddToDatabase = new JButton("Delete a Patients Appointment");
			butReset = new JButton("Reset");
			butExit = new JButton("Exit");
			patientID = new JTextField();
			appID = new JTextField();
			lblName = new JLabel("Patient ID");
			lblID = new JLabel("Appointment ID");
			
			this.setLayout(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			AddToDatabase.addActionListener(this);
			butReset.addActionListener(this);
			butExit.addActionListener(this);
			
			lblName.setBounds(10,10,120,20);
			lblID.setBounds(10,30,120,20);
			patientID.setBounds(140,10,160,20);
			appID.setBounds(140,30,160,20);

			
			AddToDatabase.setBounds(40, 80, 210, 20);
			butReset.setBounds(255, 80, 70, 20);
			butExit.setBounds(330, 180, 70, 20);
			
			this.add(AddToDatabase);
			this.add(butReset);
			this.add(butExit);
			this.add(appID);
			this.add(patientID);
			this.add(lblName);
			this.add(lblID);
			
			this.setSize(450,250);
			this.setVisible(true);
		}

		public static void main(String[] args)
		{
			DeleteAppointment d = new DeleteAppointment("Delete a patients appointment");
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
				else if(appID.getText().equals(null) || appID.getText().equals(""))
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
					String apptID = appID.getText();
					electronicDoctorsOffice d = new electronicDoctorsOffice();
					if(d.deleteAppointment(patID, apptID))
					{
						JFrame f1 = new JFrame("Appointment Deleted");
						f1.setSize(200,75);
						f1.setVisible(true);
						JLabel lbl = new JLabel("The appointment was successfully deleted");
						JPanel pan = new JPanel();
						f1.add(pan);
						pan.add(lbl);
					}
					else
					{
						JFrame f1 = new JFrame("Appointment Not Deleted");
						f1.setSize(200,75);
						f1.setVisible(true);
						JLabel lbl = new JLabel("The appointment was not successfully deleted");
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
