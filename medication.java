package proj1;
public class medication
{

    private String name;
    private String ID;
    private String type;
    
    public medication(String ID, String name, String type)
    {
        this.name = name;
        this.ID = ID;
        this.type = type;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getID()
    {
        return ID;
    }
    
	public String getType()
	{
		return type;
	}
	
}