import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class HouseholdCreation extends JPanel implements ActionListener
{
    JTextField householdNameText;
    JLabel accountCreationError;
    JTextArea householdDisplayArea;

    public HouseholdCreation()
    {
        JPanel householdCreationPanel = new JPanel();
        householdCreationPanel.setLayout(new GridLayout(2,1));

        //Create Labels
        JLabel householdName = new JLabel("Household Name");
        accountCreationError = new JLabel("");
        accountCreationError.setForeground(Color.red);

        householdNameText = new JTextField();

        //create display area field to display all accounts
        householdDisplayArea = new JTextArea();
        householdDisplayArea.setEditable(false);
        householdDisplayArea.setPreferredSize(new Dimension(500, 300));


        JButton createHouseholdButton = new JButton("Create Household");
        createHouseholdButton.addActionListener(this);


        //Create inner Panel for BoxLayout
        JPanel UserInput= new JPanel();
        UserInput.setLayout(new GridLayout(0,2,0,0));


        //Add Content to nested panel
        UserInput.add(householdNameText);
        UserInput.add(accountCreationError);
        UserInput.add(householdDisplayArea);
        UserInput.add(createHouseholdButton);
        
        householdCreationPanel.add(UserInput);
        
        //add Account Displayer to second half of AccountCreationPanel
        JPanel list = new JPanel();
        list.add(householdDisplayArea);
        householdCreationPanel.add(list);
        this.add(householdCreationPanel);
        //setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String householdName = householdNameText.getText();
        accountCreationError.setText("");
               
        if(isDuplicate(householdName) == true)
        {
            accountCreationError.setText("A household with that name already exists.");
            return;
        }
        
        BudgetApp.householdList.add(Household(householdName));
        BudgetApp.update(); //still need to add update method in Budget App

        householdDisplayArea.append(householdName + "\n");   
    }
    
    public boolean isDuplicate(String householdName) //checks all households in the arraylist to see if household with that name has already been created
    {
        for(int i = 0 ; i < BudgetApp.householdList.size() ; i++)
        {
            if(householdName.compareTo(BudgetApp.householdList.get(i).getHouseholdName()) == 0)
                return true;
        }
            return false;
    }    
}