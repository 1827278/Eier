public class Ei 
{
	private int weight;
	private String date;
	private boolean dmg;
	private String size;
	
	public Ei(int crackChance)
	{
		this.date = "27.03.2019";
		this.weight = (int)Math.random()*100;
		while(true)
		{
			if(this.weight < 40 && this.weight >80)
			{
				this.weight = (int)Math.random()*100;
			}
			else
			{	
				break;
			}			
			int random = (int)Math.random()*100;
			if(random > crackChance)
			{
				this.setDmg(true);
			}
			else
			{
				this.setDmg(false);
			}	
		}
	}

	public String getDate() 
	{
		return date;
	}
	public void setDate(String date)
	{
		this.date = date;
	}
	public boolean getDmg() 
	{
		return dmg;
	}
	public void setDmg(boolean dmg) 
	{
		this.dmg = dmg;
	}
	public void setWeight( int weight) 
	{
		this.weight = weight;
	}
	public int getWeight() 
	{
		return weight;
	}

	public String getSize()
	{
		if(this.weight < 53)
		{
			this.size = "S";
		}
		else if(this.weight >= 53 && this.weight <= 62)
		{
			this.size = "M";
		}
		else if(this.weight >= 63 && this.weight <= 73)
		{
			this.size = "L";
		}
		else if(this.weight > 73)
		{
			this.size = "XL";
		}
		return size;
	}
	
	 
}
