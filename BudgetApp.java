

import java.util.ArrayList;


public class BudgetApp
{
    public static ArrayList <Income> incomeList = new ArrayList <Income>();
    public static ArrayList <Asset> currentAsset = new ArrayList <Asset>();
    public static ArrayList <Expense> lumpSumExpense = new ArrayList <Expense>();
    public static ArrayList <Expense> monthlyExpense = new ArrayList <Expense>();
    
    public static void main (String [] args)
    {
	Income jackIncome = new Income("Jack", 2000);
        Income jillIncome = new Income("Jill", 2500);
        
        incomeList.add(jackIncome);
        incomeList.add(jillIncome);
        
        Asset savingsAccount = new Asset("Joint Savings", 5000);
        Asset checkingAccount = new Asset("Joint Checking", 2000);
        
        currentAsset.add(savingsAccount);
        currentAsset.add(checkingAccount);
        
        Expense summerVacation = new Expense("Los Angeles Trip", 2000, false);
        Expense carRepairs = new Expense ("Car Break Repair", 1000, false);
        
        lumpSumExpense.add(summerVacation);
        lumpSumExpense.add(carRepairs);
        
        Expense electricBill = new Expense("Electricity Bill", 150, true);
        Expense phoneBill = new Expense("Cell Phone Bill", 120, true);
        Expense groceryBill = new Expense("Groceries", 300, true);
        
        monthlyExpense.add(electricBill);
        monthlyExpense.add(phoneBill);
        monthlyExpense.add(groceryBill);
        
        Household smithHousehold = new Household("Smith");
        
        System.out.println(smithHousehold.addIncome(smithHousehold.getIncomeList()));
        System.out.println(smithHousehold.addAssets(smithHousehold.getAssetList()));
        System.out.println(smithHousehold.addLumpSumExpenses(smithHousehold.getLumpSumExpenseList()));
        System.out.println(smithHousehold.addFixedExpenses(smithHousehold.getFixedExpenseList()));


    }

}
 
