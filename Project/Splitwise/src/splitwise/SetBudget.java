package splitwise;

import java.awt.BorderLayout;

public class SetBudget extends javax.swing.JFrame 
{
    int user_id;
    float budget;
    public SetBudget() {
        initComponents();
    }
    
    public SetBudget(int user_id) {
        initComponents();
        this.user_id = user_id;
        NewBudgetLabel.setVisible(false);
        SetBudgetButton.setVisible(false);
        NewBudget.setVisible(false);
        api a = new api();
        budget = a.getUserBudget(user_id);
        Budget.setText(Float.toString(budget));
        DisplayCharts.setLayout(new java.awt.BorderLayout());
        DisplayCharts.add(new PieChart("User Budget", user_id).CP, BorderLayout.CENTER);
        DisplayCharts.setVisible(true);
        DisplayCharts.validate();
        a.closeConnection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        WelcomeBanner = new javax.swing.JLabel();
        BudgetLabel = new javax.swing.JLabel();
        Budget = new javax.swing.JLabel();
        NewBudgetLabel = new javax.swing.JLabel();
        NewBudget = new javax.swing.JTextField();
        UpdateButton = new javax.swing.JButton();
        SetBudgetButton = new javax.swing.JButton();
        MessageBox = new javax.swing.JLabel();
        BackButton = new javax.swing.JButton();
        DisplayCharts = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 600));

        WelcomeBanner.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        WelcomeBanner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        WelcomeBanner.setText("Budget");

        BudgetLabel.setText("Your Current Budget:");

        NewBudgetLabel.setText("New Budget");

        NewBudget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewBudgetActionPerformed(evt);
            }
        });

        UpdateButton.setText("Update Budget");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        SetBudgetButton.setText("Set Budget");
        SetBudgetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SetBudgetButtonActionPerformed(evt);
            }
        });

        MessageBox.setForeground(new java.awt.Color(255, 0, 0));
        MessageBox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DisplayChartsLayout = new javax.swing.GroupLayout(DisplayCharts);
        DisplayCharts.setLayout(DisplayChartsLayout);
        DisplayChartsLayout.setHorizontalGroup(
            DisplayChartsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 365, Short.MAX_VALUE)
        );
        DisplayChartsLayout.setVerticalGroup(
            DisplayChartsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 416, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(WelcomeBanner, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MessageBox, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BudgetLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(Budget, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(SetBudgetButton)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(NewBudgetLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NewBudget, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(UpdateButton)
                                .addGap(18, 18, 18)
                                .addComponent(BackButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                        .addComponent(DisplayCharts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(WelcomeBanner, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MessageBox, javax.swing.GroupLayout.DEFAULT_SIZE, 12, Short.MAX_VALUE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Budget, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BudgetLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UpdateButton)
                            .addComponent(BackButton))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NewBudgetLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NewBudget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(SetBudgetButton))
                    .addComponent(DisplayCharts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NewBudgetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewBudgetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NewBudgetActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        // TODO add your handling code here:
        NewBudgetLabel.setVisible(true);
        SetBudgetButton.setVisible(true);
        NewBudget.setVisible(true);
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void SetBudgetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SetBudgetButtonActionPerformed
        // TODO add your handling code here:
        api a = new api();
        if(a.setBudget(Float.parseFloat(NewBudget.getText()), this.user_id) == -1)
        {
            MessageBox.setText("Something Went Wrong");
        }
        this.budget = a.getUserBudget(user_id);
        Budget.setText(Float.toString(this.budget));
        a.closeConnection();
    }//GEN-LAST:event_SetBudgetButtonActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new UserHomepage(this.user_id).setVisible(true);
    }//GEN-LAST:event_BackButtonActionPerformed

    public static void main(String args[]) {
        
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
            java.util.logging.Logger.getLogger(SetBudget.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SetBudget.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SetBudget.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SetBudget.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SetBudget(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JLabel Budget;
    private javax.swing.JLabel BudgetLabel;
    private javax.swing.JPanel DisplayCharts;
    private javax.swing.JLabel MessageBox;
    private javax.swing.JTextField NewBudget;
    private javax.swing.JLabel NewBudgetLabel;
    private javax.swing.JButton SetBudgetButton;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JLabel WelcomeBanner;
    // End of variables declaration//GEN-END:variables
}
