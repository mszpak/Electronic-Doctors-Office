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

public class AddMedication extends JFrame implements ActionListener
{
		
		private JButton AddToDatabase,butReset,butExit;
		private JTextField medicineName;
		private JTextField ID;
		private JTextField medType;
		private JLabel lblName, lblID, lblMedType;
		
		public AddMedication(String name)
		{
			super(name);
			AddToDatabase = new JButton("Add Medicine");
			butReset = new JButton("Reset");
			butExit = new JButton("Back");
			medicineName = new JTextField();
			ID = new JTextField();
			medType = new JTextField();
			lblName = new JLabel("Medicine Name");
			lblID = new JLabel("ID");
			lblMedType = new JLabel("Medicine Type");
			
			this.setLayout(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			AddToDatabase.addActionListener(this);
			butReset.addActionListener(this);
			butExit.addActionListener(this);
			
			lblName.setBounds(10,10,120,20);
			lblID.setBounds(10,30,120,20);
			lblMedType.setBounds(10,50,120,20);
			medType.setBounds(140,50,80,20);
			medicineName.setBounds(140,10,160,20);
			ID.setBounds(140,30,160,20);

			
			AddToDatabase.setBounds(140, 80, 110, 20);
			butReset.setBounds(255, 80, 70, 20);
			butExit.setBounds(330, 180, 70, 20);
			
			this.add(AddToDatabase);
			this.add(butReset);
			this.add(butExit);
			this.add(medicineName);
			this.add(ID);
			this.add(medType);
			this.add(lblName);
			this.add(lblID);
			this.add(lblMedType);
			
			this.setSize(450,250);
			this.setVisible(true);
		}

		public static void main(String[] args)
		{
			AddMedication m = new AddMedication("Add Medication");
		}
		
		
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == AddToDatabase)
			{
				if(ID.getText().equals(null) || ID.getText().equals(""))
				{
					JFrame f1 = new JFrame("enter ID");
					f1.setSize(200,75);
					f1.setVisible(true);
					JLabel lbl = new JLabel("A medicine must have an ID");
					JPanel pan = new JPanel();
					f1.add(pan);
					pan.add(lbl);
				}
				else
				{
					String medID = ID.getText();
					String medName = medicineName.getText();
					String medicineType = medType.getText();
					electronicDoctorsOffice d = new electronicDoctorsOffice();
					if(d.addMedication(medID, medName, medicineType))
					{
						JFrame f1 = new JFrame("Medicine Added");
						f1.setSize(200,75);
						f1.setVisible(true);
						JLabel lbl = new JLabel("The medicine was added successfully");
						JPanel pan = new JPanel();
						f1.add(pan);
						pan.add(lbl);
					}
					else
					{
						JFrame f1 = new JFrame("Medicine Not Added");
						f1.setSize(200,75);
						f1.setVisible(true);
						JLabel lbl = new JLabel("The medicine was not added successfully");
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
