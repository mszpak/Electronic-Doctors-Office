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

public class CompleteMedication extends JFrame implements ActionListener
{
		
		private JButton AddToDatabase,butReset,butExit;
		private JTextField medName;
		private JTextField patientID;
		private JLabel lblName, lblID;
		
		public CompleteMedication(String name)
		{
			super(name);
			AddToDatabase = new JButton("Complete Medication");
			butReset = new JButton("Reset");
			butExit = new JButton("Exit");
			patientID = new JTextField();
			medName = new JTextField();
			lblName = new JLabel("Patient ID");
			lblID = new JLabel("Medication Name");
			
			this.setLayout(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			AddToDatabase.addActionListener(this);
			butReset.addActionListener(this);
			butExit.addActionListener(this);
			
			lblName.setBounds(10,10,120,20);
			lblID.setBounds(10,30,120,20);
			patientID.setBounds(140,10,160,20);
			medName.setBounds(140,30,160,20);

			
			AddToDatabase.setBounds(100, 80, 150, 20);
			butReset.setBounds(255, 80, 70, 20);
			butExit.setBounds(330, 180, 70, 20);
			
			this.add(AddToDatabase);
			this.add(butReset);
			this.add(butExit);
			this.add(medName);
			this.add(patientID);
			this.add(lblName);
			this.add(lblID);
			
			this.setSize(450,250);
			this.setVisible(true);
		}

		public static void main(String[] args)
		{
			CompleteMedication d = new CompleteMedication("Complete a Medication (delete)");
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
				else if(medName.getText().equals(null) || medName.getText().equals(""))
				{
					JFrame f1 = new JFrame("enter medication name");
					f1.setSize(200,75);
					f1.setVisible(true);
					JLabel lbl = new JLabel("Medication name must be given");
					JPanel pan = new JPanel();
					f1.add(pan);
					pan.add(lbl);
				}
				else
				{
					String patID = patientID.getText();
					String medname = medName.getText();
					electronicDoctorsOffice d = new electronicDoctorsOffice();
					if(d.completeMedication(patID, medname))
					{
						JFrame f1 = new JFrame("Medication Complete");
						f1.setSize(200,75);
						f1.setVisible(true);
						JLabel lbl = new JLabel("The medication was successfully removed");
						JPanel pan = new JPanel();
						f1.add(pan);
						pan.add(lbl);
					}
					else
					{
						JFrame f1 = new JFrame("Medication Not Complete");
						f1.setSize(200,75);
						f1.setVisible(true);
						JLabel lbl = new JLabel("The medication was not successfully completed");
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
