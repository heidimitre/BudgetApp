import java.util.ArrayList;
import javax.swing.JPanel;

public class HouseholdCreationMenu extends JPanel
{

    private javax.swing.JButton createHouseholdButton;
    private javax.swing.JLabel errorTextLabel;
    private javax.swing.JLabel existingHouseholdLabel;
    private javax.swing.JTextArea householdDisplayArea;
    private javax.swing.JLabel householdNameLabel;
    private javax.swing.JLabel householdPromptLabel;
    private javax.swing.JTextField householdText;
    private javax.swing.JScrollPane jScrollPane1;
	
    public HouseholdCreationMenu()
    {
        initComponents();
    }

    private void initComponents()
    {

        householdPromptLabel = new javax.swing.JLabel();
        householdNameLabel = new javax.swing.JLabel();
        householdText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        householdDisplayArea = new javax.swing.JTextArea();
        createHouseholdButton = new javax.swing.JButton();
        existingHouseholdLabel = new javax.swing.JLabel();
        errorTextLabel = new javax.swing.JLabel();

        householdPromptLabel.setText("Please enter a name for this household or scenario.");

        householdNameLabel.setText("Household name:");

        householdDisplayArea.setColumns(20);
        householdDisplayArea.setRows(5);
        jScrollPane1.setViewportView(householdDisplayArea);

        createHouseholdButton.setText("Create");
        createHouseholdButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                createHouseholdButtonActionPerformed(evt);
            }
        });

        existingHouseholdLabel.setText("Existing Households:");

        errorTextLabel.setText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(existingHouseholdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(householdNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(householdText, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(createHouseholdButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(householdPromptLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 22, Short.MAX_VALUE))
                    .addComponent(errorTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(householdPromptLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(householdNameLabel)
                    .addComponent(householdText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createHouseholdButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(existingHouseholdLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(errorTextLabel)
                .addContainerGap())
        );

        //pack();
    }


    private void createHouseholdButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createHouseholdButtonActionPerformed
        String householdName = householdText.getText();
        if(isDuplicate(householdName) == true)
        {
            errorTextLabel.setText("A household with that name already exists.");
            return;
        }
        
        Household newHousehold = new Household(householdName);
        BudgetApp.householdList.add(newHousehold);
        householdDisplayArea.append(householdName);
        
        
    }//GEN-LAST:event_createHouseholdButtonActionPerformed
   
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
