/*
 * This class contains methods relating to Expense objects.
 * Expense objects can be one of two types: Fixed (isFixed = true) or Lump-Sum (isFixed = false).
 * Examples of Fixed Expense objects include rent expense, phone bill or groceries.
 * Examples of Lump-Sum Expense objects include vacation expenses, gifts, etc.
 */


public class Expense
{
	private String expenseDescription;
	private double expenseAmount;
	private boolean isFixedExpense; //monthly expense, as opposed to lump-sum (one-time) expense
	
	public Expense(String newExpenseDescription, double newExpenseAmount, boolean isFixed)
	{
		expenseDescription = newExpenseDescription;
		expenseAmount = newExpenseAmount;
		isFixedExpense = isFixed;
	}
	
	public String getDescription()
	{
		return expenseDescription;
	}
	
	public double getExpenseAmount()
	{
		return expenseAmount;
	}
	
	public void setDescription(String newExpenseDescription)
	{
		expenseDescription = newExpenseDescription;
	}
	
	public void setExpenseAmount(double newExpenseAmount)
	{
		expenseAmount = newExpenseAmount;
	}
        
        public boolean isFixedExpense()
        {
            if(isFixedExpense == true)
                return true;
            else
                return false;
        }
}
