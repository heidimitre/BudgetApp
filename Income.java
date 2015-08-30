/*
 * This class contains methods relating to Income objects.
 * Examples of Income objects belonging to a household include salaries, passive/rental income and dividends/interest earnings.
 */

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
