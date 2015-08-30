import java.util.Scanner;
import java.util.ArrayList;

public class BudgetApp
{
    public static ArrayList <Income> incomeList = new ArrayList <Income>();
    public static ArrayList <Asset> currentAsset = new ArrayList <Asset>();
    public static ArrayList <Expense> lumpSumExpense = new ArrayList <Expense>();
    public static ArrayList <Expense> monthlyExpense = new ArrayList <Expense>();
    public static ArrayList <Household> householdList;
    public static Household userHousehold;
    
    public static final int FIXED_EXPENSE = 1;
    public static final int LUMP_SUM_EXPENSE = 2;
    
    public static void main (String [] args)
    {
    	System.out.println("******************************************************");
    	System.out.println("Welcome to BudgetApp!");
    	System.out.println("******************************************************");
    	
    	initializeHousehold();
    	inputUserData();
    }
    
    public static void initializeHousehold()
    {
    	Scanner keyboard = new Scanner(System.in);
    	String householdName = "";
    	
    	System.out.println("Please enter a name for your household:");
    	
    	householdName = keyboard.next();
    	
    	userHousehold = new Household(householdName);
    	
    	System.out.println("You have created a new household: " + householdName);
    	System.out.println();
    }
    
    public static void inputUserData()
    {
    	Scanner keyboard = new Scanner(System.in);
    	boolean allValuesEntered = false;
    	int userInput = 0;
    	
    	while(allValuesEntered == false)
    	{
    		System.out.println("Please make a selection to enter your household financial data:");
    		System.out.println("1- Add new income data to your budget");
    		System.out.println("2- Add new asset data to your budget");
    		System.out.println("3- Add new expense data to your budget");
    		System.out.println("4- Done providing data for this budget");
    		
    		userInput = keyboard.nextInt();
    		
    		switch(userInput)
    		{
    			case 1:
    				incomeCreation();
    				break;
    			case 2:
    				assetCreation();
    				break;
    			case 3:
    				expenseCreation();
    				break;
    			case 4:
    				allValuesEntered = true;
    				displayBudgetReport();
    				break;
    			default:
    				System.out.println("Please enter a number between 1 and 4 to make a selection from the menu.");
    				System.out.println();
    				break;
    		}
    	}
    }
    	
    public static void displayBudgetReport()
    {
    	Scanner keyboard = new Scanner(System.in);
    	int numberOfMonths = 0;
    	
    	while(numberOfMonths < 1 || numberOfMonths > 12)
    	{
    		System.out.println("Please enter the number of months your budget will cover:");
    		System.out.println("(Budgets can cover from 1 to 12 months.)");
    		numberOfMonths = keyboard.nextInt();
    	}
    	
    	generateBudgetReport(numberOfMonths);
    	
    }
    
    public static void incomeCreation()
    {
    	Scanner keyboard = new Scanner(System.in);
    	String incomeDescriptionInput = "";
    	double monthlyIncomeAmount = 0;
    	
    	System.out.println("Please enter the description for the income you would like to add:");
    	
    	incomeDescriptionInput = keyboard.nextLine();
    	
    	while(monthlyIncomeAmount <= 0)
    	{
	    	System.out.println("Please enter the monthly amount in dollars and cents for " + incomeDescriptionInput + ":");    	
	    	monthlyIncomeAmount = keyboard.nextDouble();
	    	
	    	if(monthlyIncomeAmount < 0)
	    	{
	    		System.out.println("Monthly income must be a positive dollar amount.");
	    	}
    	}

    	Income newIncome = new Income(incomeDescriptionInput, monthlyIncomeAmount);
    	incomeList.add(newIncome);
    	
    	System.out.println("You have added the following income amounts to " + userHousehold.getHouseholdName() + ":");
    	
    	for(Income i : incomeList) //for each Income object in incomeList
    	{    
    		System.out.println(i.getName());
    		System.out.println(i.getMonthlyIncome());
    		System.out.println(); 		
    	}
    	
    }
    
    public static void assetCreation()
    {
    	Scanner keyboard = new Scanner(System.in);
    	String assetDescriptionInput = "";
    	double assetAmount = 0;
    	
    	System.out.println("Please enter the description for the asset you would like to add:");
    	
    	assetDescriptionInput = keyboard.nextLine();
    	
    	while(assetAmount <= 0)
    	{
	    	System.out.println("Please enter the amount of the asset in dollars and cents for " + assetDescriptionInput + ":");    	
	    	assetAmount = keyboard.nextDouble();
	    	
	    	if(assetAmount < 0)
	    	{
	    		System.out.println("Asset value must be a positive dollar amount.");
	    	}
    	}

    	Asset newAsset = new Asset(assetDescriptionInput, assetAmount);
    	currentAsset.add(newAsset);
    	
    	System.out.println("You have added the following assets to " + userHousehold.getHouseholdName() + ":");
    	
    	for(Asset a : currentAsset)
    	{    
    		System.out.println(a.getDescription());
    		System.out.println(a.getAssetValue());
    		System.out.println(); 		
    	}
    	
    }
    
    public static void expenseCreation()
    {
    	Scanner keyboard = new Scanner(System.in);
    	int expenseTypeSelection = 0;
    	
    	while(expenseTypeSelection != FIXED_EXPENSE && expenseTypeSelection != LUMP_SUM_EXPENSE)
    	{
    		System.out.println("Please choose an expense type:");
    		System.out.println("1- Fixed Expense (recurring on a monthly basis)");
    		System.out.println("2- Lump-Sum Expense (a one-time payment that will not be paid on a regular basis)");
    		
    		expenseTypeSelection = keyboard.nextInt();
    	}
    	
    	if(expenseTypeSelection == FIXED_EXPENSE)
    	{
    		String fixedExpenseDescriptionInput = "";
        	double fixedExpenseAmount = 0;
        	
        	System.out.println("Please enter the description for the fixed expense you would like to add:");
        	keyboard.nextLine();
        	fixedExpenseDescriptionInput = keyboard.nextLine();
        	
        	while(fixedExpenseAmount <= 0)
        	{
    	    	System.out.println("Please enter the amount of the fixed expense in dollars and cents for " + fixedExpenseDescriptionInput + ":");    	
    	    	fixedExpenseAmount = keyboard.nextDouble();
    	    	
    	    	if(fixedExpenseAmount < 0)
    	    	{
    	    		System.out.println("Fixed expense amount must be a positive dollar amount.");
    	    	}
        	}

        	Expense newFixedExpense = new Expense(fixedExpenseDescriptionInput, fixedExpenseAmount, true);
        	monthlyExpense.add(newFixedExpense);
        	
        	System.out.println("You have added the following fixed expenses to " + userHousehold.getHouseholdName() + ":");
        	
        	for(Expense f : monthlyExpense)
            {
                if(f.isFixedExpense() == true)
                {    
	        		System.out.println(f.getDescription());
	        		System.out.println(f.getExpenseAmount());
	        		System.out.println(); 		
                }
        	}
    	}
    	
    	else //if expenseTypeSelection = LUMP_SUM_EXPENSE
    	{
    		String lumpSumExpenseDescriptionInput = "";
        	double lumpSumExpenseAmount = 0;
        	
    		System.out.println("Please enter the description for the lump-sum expense you would like to add:");
    		keyboard.nextLine();
	        lumpSumExpenseDescriptionInput = keyboard.nextLine();
        	
        	while(lumpSumExpenseAmount <= 0)
        	{
    	    	System.out.println("Please enter the amount of the lump-sum expense in dollars and cents for " + lumpSumExpenseDescriptionInput + ":");    	
    	    	lumpSumExpenseAmount = keyboard.nextDouble();
    	    	
    	    	if(lumpSumExpenseAmount < 0)
    	    	{
    	    		System.out.println("Lump-sum expense amount must be a positive dollar amount.");
    	    	}
        	}

        	Expense newLumpSumExpense = new Expense(lumpSumExpenseDescriptionInput, lumpSumExpenseAmount, false);
        	lumpSumExpense.add(newLumpSumExpense);
        	
        	System.out.println("You have added the following lump-sum expenses to " + userHousehold.getHouseholdName() + ":");
        	
        	for(Expense f : lumpSumExpense)
            {
                if(f.isFixedExpense() == false)
                {    
	        		System.out.println(f.getDescription());
	        		System.out.println(f.getExpenseAmount());
	        		System.out.println(); 		
                }
        	}
    	}   	
    }
    
	
	public static void generateBudgetReport(int inputMonths)
	{
		double excessCashFlow = 0;
		double totalIncome = userHousehold.addIncome(incomeList) * inputMonths;
		double totalMonthlyExpenses = userHousehold.addFixedExpenses(monthlyExpense)* inputMonths;
		
		System.out.println("Monthly cash flow for " + userHousehold.getHouseholdName()+ " household is as follows:");
		
		System.out.println("Total available assets: " + userHousehold.addAssets(currentAsset));
		System.out.println("Total monthly income: " + userHousehold.addIncome(incomeList));
		System.out.println("Total monthly (fixed) expenses: " + userHousehold.addFixedExpenses(monthlyExpense));
		System.out.println("Total estimated lump-sum expenses: " + userHousehold.addLumpSumExpenses(lumpSumExpense));
		
		System.out.println("Cash flow over " + inputMonths + " months:");
		
		System.out.println("Total available assets: " + userHousehold.addAssets(currentAsset));
		System.out.println("Total income for " + inputMonths + " months:" + totalIncome);
		System.out.println("Total monthly expenses for " + inputMonths + " months:" + totalMonthlyExpenses);
		System.out.println("Total estimated lump-sum expenses: " + userHousehold.addLumpSumExpenses(lumpSumExpense));
		
		excessCashFlow = userHousehold.addAssets(currentAsset) + totalIncome + totalMonthlyExpenses + userHousehold.addLumpSumExpenses(lumpSumExpense);

		if(excessCashFlow < 0)
			System.out.println("Your excess cash is: " + excessCashFlow);
		else
			System.out.println("Your negative cash is: " + excessCashFlow);
	}
    	 
    	/*
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
         */
    
    public BudgetApp()
    {
        //initialize HouseholdList
        householdList = new ArrayList<Household>();
    }

}
 
