public class Osterei extends Ei 
{
	private String colour;
	private boolean cooked;
	
	public Osterei(int crackChance) 
	{
		super(crackChance);
		this.cooked = false;
		this.colour = "None";
	}

	public String getColour() 
	{
		return colour;
	}
	public void setColour(String colour) 
	{
		this.colour = colour;
	}
	public boolean isCooked() 
	{
		return cooked;
	}
	public void setCooked(boolean cooked) 
	{
		this.cooked = cooked;
	}
	public void cook() throws EggCrackedException
	{
		if(this.cooked == true || this.getDmg() == true)
		{
			throw new EggCrackedException("Das Ei ist geplatzt pow pow");
		}
		else if(this.cooked == false)
		{	
			this.cooked = true;
		}
	}
	public void paint(String colour)
	{
		if(!this.colour.equals("None"))
		{
			this.colour = "ugly";
		}
		else
		{
			this.colour = colour;
		}
	}
}
