
import java.util.ArrayList;

public class Household
{
    private String householdName;
    private ArrayList <Income> incomeSource;
    private ArrayList <Asset> assetList;
    private ArrayList <Expense> fixedExpense; //includes monthly expenses from MonthlyExpense arraylist in Budget App class
    private ArrayList <Expense> oneTimeExpense;  //includes lump-sum expenses from lumpSumExpense arraylist in Budget App class

  
    private static double totalMonthlyIncome;
    private static double totalAssetValue;
    private static double totalFixedExpenses;
    private static double totalLumpSumExpenses;
    
    public Household(String newHouseholdName)
    {
        householdName = newHouseholdName;
        fixedExpense = BudgetApp.monthlyExpense;
        oneTimeExpense = BudgetApp.lumpSumExpense;
        incomeSource = BudgetApp.incomeList;
        assetList = BudgetApp.currentAsset;
    }
    
    public String getHouseholdName()
    {
	return householdName;
    }
	
    public void setHouseholdName(String name)
    {
	householdName = name;
    }
    
    public ArrayList <Income> getIncomeList()
    {
        return incomeSource;
    }
    
    public ArrayList <Asset> getAssetList()
    {
        return assetList;
    }
    
    public ArrayList <Expense> getFixedExpenseList()
    {
        return fixedExpense;
    }
        
    public ArrayList <Expense> getLumpSumExpenseList()
    {
        return oneTimeExpense;
    }

    public static double addIncome(ArrayList <Income> incomeList)
    {
        totalMonthlyIncome = 0;
        
        for(Income i : incomeList) //for each Income object in incomeList
            totalMonthlyIncome = totalMonthlyIncome + i.getMonthlyIncome();
        
        return totalMonthlyIncome;

    }
    
    public static double addAssets(ArrayList <Asset> assetList)
    {
        totalAssetValue = 0;
        for(Asset a : assetList)
            totalAssetValue = totalAssetValue + a.getAssetValue();

        
        return totalAssetValue;

    }
    
    public static double addFixedExpenses(ArrayList <Expense> fixedExpenseList)
    {
        totalFixedExpenses = 0;
        for(Expense f : fixedExpenseList)
        {
            if(f.isFixedExpense() == true)
                totalFixedExpenses = totalFixedExpenses + f.getExpenseAmount(); 
        }
        
        return totalFixedExpenses;
    }
    
    public static double addLumpSumExpenses(ArrayList <Expense> lumpSumExpenseList)
    {
        totalLumpSumExpenses = 0;
        for(Expense l : lumpSumExpenseList)
        {
            if(l.isFixedExpense() == false)
                totalLumpSumExpenses = totalLumpSumExpenses + l.getExpenseAmount();
        }

        
        return totalLumpSumExpenses;
    }
}
