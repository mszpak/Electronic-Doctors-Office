package Graphics;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import proj1.electronicDoctorsOffice;

public class AssignMedication extends JFrame implements ActionListener{

	/**
	 * @param args
	 */
	private JTextField ID, name, type;
	private JLabel lblID, lblName, lblType;
	private JButton butAssign, butReset, butExit;
	
	public AssignMedication(String windowName)
	{
		super(windowName);
		ID = new JTextField();
		name = new JTextField();
		type = new JTextField();
		
		lblID = new JLabel("Medicine ID");
		lblName = new JLabel("Medicine Name");
		lblType = new JLabel("Medicine Type");
		
		butAssign = new JButton("Assign Medication");
		butReset = new JButton("Reset");
		butExit = new JButton("Back");
		
		butAssign.addActionListener(this);
		butReset.addActionListener(this);
		butExit.addActionListener(this);
		
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblName.setBounds(10,10,120,20);
		lblID.setBounds(10,30,120,20);
		lblType.setBounds(10,50,120,20);
		type.setBounds(140,50,80,20);
		name.setBounds(140,10,160,20);
		ID.setBounds(140,30,160,20);

		
		butAssign.setBounds(140, 80, 110, 20);
		butReset.setBounds(255, 80, 70, 20);
		butExit.setBounds(330, 180, 70, 20);
		
		this.add(butAssign);
		this.add(butReset);
		this.add(butExit);
		this.add(name);
		this.add(ID);
		this.add(type);
		this.add(lblName);
		this.add(lblID);
		this.add(lblType);
		
		this.setSize(450,250);
		this.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		
		AssignMedication a = new AssignMedication("assign medication");
	}


	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == butAssign)
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
				String medName = name.getText();
				String medicineType = type.getText();
				electronicDoctorsOffice d = new electronicDoctorsOffice();
				if(d.assignMedication(medID, medName, medicineType))
				{
					JFrame f1 = new JFrame("Medicine Assigned");
					f1.setSize(200,75);
					f1.setVisible(true);
					JLabel lbl = new JLabel("The medicine was assigned successfully");
					JPanel pan = new JPanel();
					f1.add(pan);
					pan.add(lbl);
				}
				else
				{
					JFrame f1 = new JFrame("Medicine Not Assigned");
					f1.setSize(200,75);
					f1.setVisible(true);
					JLabel lbl = new JLabel("The medicine was not assigned successfully");
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
