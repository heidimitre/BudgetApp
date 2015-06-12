
public class Income
{
	String earnerName;
	double monthlyIncome;
	
	public Income(String name, double incomeAmount)
	{
		earnerName = name;
		monthlyIncome = incomeAmount;
	}
	
	public String getName()
	{
		return earnerName;
	}
	
	public void setName(String name)
	{
		earnerName = name;
	}
	
	public double getMonthlyIncome()
	{
		return monthlyIncome;
	}
	
	public void setMonthlyIncome(double incomeAmount)
	{
		monthlyIncome = incomeAmount;
	}
}
