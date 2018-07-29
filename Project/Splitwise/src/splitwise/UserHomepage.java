package splitwise;

public class UserHomepage extends javax.swing.JFrame {

    int user_id;
    String name;
    float credit=0.0f,debit=0.0f,total_bal;
    public UserHomepage() {
        initComponents();
    }
    
    public UserHomepage(int userid)
    {
        initComponents();
        user_id = userid;
        api a = new api();
        name = a.getUserName(user_id);
        WelcomeBanner.setText("Welcome "+name);
       //TODO: Uodate Credit Debit Logic
//        credit = a.getCredit(user_id);
//        debit = a.getDebit(user_id);
//        total_bal = credit - debit;
        CreditValue.setText(Float.toString(credit));
        DebitValue.setText(Float.toString(debit));
        TotalValue.setText(Float.toString(total_bal));
        PendingRequests.setText(Integer.toString(a.getPendingRequests(user_id)));
        a.closeConnection();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        WelcomeBanner = new javax.swing.JLabel();
        Credit = new javax.swing.JLabel();
        Total = new javax.swing.JLabel();
        Debit = new javax.swing.JLabel();
        TotalValue = new javax.swing.JLabel();
        DebitValue = new javax.swing.JLabel();
        CreditValue = new javax.swing.JLabel();
        NewBillButton = new javax.swing.JButton();
        PendingRequestsLabel = new javax.swing.JLabel();
        PendingRequests = new javax.swing.JLabel();
        HandleRequests = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setSize(new java.awt.Dimension(800, 600));

        WelcomeBanner.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        WelcomeBanner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Credit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Credit.setText("You Are Owed");

        Total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Total.setText("Total");

        Debit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Debit.setText("You Owe");

        TotalValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        DebitValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        CreditValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        NewBillButton.setText("New Bill");
        NewBillButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewBillButtonActionPerformed(evt);
            }
        });

        PendingRequestsLabel.setText("Pending Bill Requests");

        HandleRequests.setText("View Reuqests");
        HandleRequests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HandleRequestsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(WelcomeBanner, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(CreditValue, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TotalValue, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Credit, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(78, 78, 78)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Debit, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DebitValue, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(451, 451, 451)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(HandleRequests)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(NewBillButton)
                                .addGap(18, 18, 18)
                                .addComponent(PendingRequestsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(PendingRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(WelcomeBanner, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Credit, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Debit, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TotalValue, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DebitValue, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreditValue, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(NewBillButton)
                        .addComponent(PendingRequestsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PendingRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(HandleRequests)
                .addContainerGap(313, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NewBillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewBillButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new NewBillForm(user_id).setVisible(true);
    }//GEN-LAST:event_NewBillButtonActionPerformed

    private void HandleRequestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HandleRequestsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HandleRequestsActionPerformed

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
            java.util.logging.Logger.getLogger(UserHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserHomepage(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Credit;
    private javax.swing.JLabel CreditValue;
    private javax.swing.JLabel Debit;
    private javax.swing.JLabel DebitValue;
    private javax.swing.JButton HandleRequests;
    private javax.swing.JButton NewBillButton;
    private javax.swing.JLabel PendingRequests;
    private javax.swing.JLabel PendingRequestsLabel;
    private javax.swing.JLabel Total;
    private javax.swing.JLabel TotalValue;
    private javax.swing.JLabel WelcomeBanner;
    // End of variables declaration//GEN-END:variables
}
