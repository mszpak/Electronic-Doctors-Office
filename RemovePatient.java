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

public class RemovePatient extends JFrame implements ActionListener
{
		
		private JButton removeFromDatabase,butReset,butExit;
		private JTextField ID;
		private JLabel lblName, lblID, lblDate;
		
		public RemovePatient(String name)
		{
			super(name);
			removeFromDatabase = new JButton("Remove Patient");
			butReset = new JButton("Reset");
			butExit = new JButton("Exit");
			ID = new JTextField();
			lblID = new JLabel("ID");
			
			this.setLayout(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			removeFromDatabase.addActionListener(this);
			butReset.addActionListener(this);
			butExit.addActionListener(this);
			
			lblID.setBounds(10,30,120,20);
			ID.setBounds(70,30,160,20);
			
			removeFromDatabase.setBounds(70, 60, 130, 20);
			butReset.setBounds(210, 60, 70, 20);
			butExit.setBounds(310, 140, 70, 20);
			
			this.add(removeFromDatabase);
			this.add(butReset);
			this.add(butExit);
			this.add(ID);
			this.add(lblID);
			
			this.setSize(400,200);
			this.setVisible(true);
		}

		public static void main(String[] args)
		{
			RemovePatient p = new RemovePatient("Add Patient");
		}
		
		
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == removeFromDatabase)
			{
				if(ID.getText().equals(null) || ID.getText().equals(""))
				{
					JFrame f1 = new JFrame("enter ID");
					f1.setSize(200,75);
					f1.setVisible(true);
					JLabel lbl = new JLabel("Please enter ID of patient");
					JPanel pan = new JPanel();
					f1.add(pan);
					pan.add(lbl);
				}
				else
				{
					String patientID = ID.getText();
					electronicDoctorsOffice d = new electronicDoctorsOffice();
					if(d.userExists(patientID))
					{
						if(d.deletePatient(patientID))
						{
							JFrame f1 = new JFrame("Delete Successful");
							f1.setSize(200,75);
							f1.setVisible(true);
							JLabel lbl = new JLabel("Patient deleted from database");
							JPanel pan = new JPanel();
							f1.add(pan);
							pan.add(lbl);
						}
						else
						{
							JFrame f1 = new JFrame("Delete Unsuccessful");
							f1.setSize(200,75);
							f1.setVisible(true);
							JLabel lbl = new JLabel("Patient was not deleted from database");
							JPanel pan = new JPanel();
							f1.add(pan);
							pan.add(lbl);
						}
					}
					else
					{
						JFrame f1 = new JFrame("Invalid Patient");
						f1.setSize(200,75);
						f1.setVisible(true);
						JLabel lbl = new JLabel("No patient with entered id exists");
						JPanel pan = new JPanel();
						f1.add(pan);
						pan.add(lbl);
					}
				}
			}
			
		}
}
