package proj1;
public class bill 
{
	private String ID;
	private String amount;
	
	public bill(String ID, String amount)
	{
		this.ID = ID;
		this.amount = amount;
	}

	public String getID()
	{
		return ID;
	}
	
	public String viewBill()
	{
		return amount;
	}
	
}
