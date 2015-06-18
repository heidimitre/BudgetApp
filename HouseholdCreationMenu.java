package BudgetApp;
import java.util.ArrayList;

public class HouseholdCreationMenu extends javax.swing.JFrame
{

    /**
     * Creates new form HouseholdCreationMenu
     */
    
    private static ArrayList <Household> householdList = new ArrayList <Household>();
    
    public HouseholdCreationMenu()
    {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        householdPromptLabel = new javax.swing.JLabel();
        householdNameLabel = new javax.swing.JLabel();
        householdText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        householdDisplayArea = new javax.swing.JTextArea();
        createHouseholdButton = new javax.swing.JButton();
        existingHouseholdLabel = new javax.swing.JLabel();
        errorTextLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        householdPromptLabel.setText("Please enter a name for this household or scenario.");

        householdNameLabel.setText("Household name:");

        householdText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                householdTextActionPerformed(evt);
            }
        });

        householdDisplayArea.setColumns(20);
        householdDisplayArea.setRows(5);
        jScrollPane1.setViewportView(householdDisplayArea);

        createHouseholdButton.setText("Create");
        createHouseholdButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createHouseholdButtonActionPerformed(evt);
            }
        });

        existingHouseholdLabel.setText("Existing Households:");

        errorTextLabel.setText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void householdTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_householdTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_householdTextActionPerformed

    private void createHouseholdButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createHouseholdButtonActionPerformed
        String householdName = householdText.getText();
        if(isDuplicate(householdName) == true)
        {
            errorTextLabel.setText("A household with that name already exists.");
            return;
        }
        
        Household newHousehold = new Household(householdName);
        householdList.add(newHousehold);
        householdDisplayArea.append(householdName);
        
        
    }//GEN-LAST:event_createHouseholdButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HouseholdCreationMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HouseholdCreationMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HouseholdCreationMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HouseholdCreationMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run() {
                new HouseholdCreationMenu().setVisible(true);
            }
        });
    }
    
    	public boolean isDuplicate(String householdName) //checks all households in the arraylist to see if household with that name has already been created
        {
            for(int i = 0 ; i < HouseholdCreationMenu.householdList.size() ; i++)
            {
                if(householdName.compareTo(householdList.get(i).getHouseholdName()) == 0)
                    return true;
            }
                return false;
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createHouseholdButton;
    private javax.swing.JLabel errorTextLabel;
    private javax.swing.JLabel existingHouseholdLabel;
    private javax.swing.JTextArea householdDisplayArea;
    private javax.swing.JLabel householdNameLabel;
    private javax.swing.JLabel householdPromptLabel;
    private javax.swing.JTextField householdText;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
