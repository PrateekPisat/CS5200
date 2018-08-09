package splitwise;

import java.util.*;

public class FillBillRequest extends javax.swing.JFrame {

    int bill_id;
    int user_id;
    List<BillItem> items;
    BillItem currentItem;
    int count;
    Bill b;
    public FillBillRequest() {
        initComponents();
    }
    
    public FillBillRequest(int bill_id, int user_id) {
        initComponents();
        this.bill_id = bill_id;
        this.user_id = user_id;
        api a = new api();
        b = a.getBill(bill_id);
        items = a.getBillItems(bill_id);
        count=0;
        WelcomeLabel.setText(WelcomeLabel.getText() + b.getBillName());
        updateComponents(a);
        a.closeConnection();
    }
    
    private void updateComponents(api a)
    {
        Id.setText(Integer.toString(b.getBillId()));
        Name.setText(b.getBillName());
        PaidBy.setText(a.getUserName(b.getPaidBy()));
        Date.setText(b.getDate().toString());
        ItemName.setText(items.get(count).getItemName());
        ItemCost.setText(Float.toString(items.get(count).getItemCost())+ " $");
        if(a.getShare(this.user_id, this.bill_id, count+1))
            IncludeButton.setText("Don't Include Me In This");
        else
            IncludeButton.setText("Include Me In This");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DateLabel = new javax.swing.JLabel();
        WelcomeLabel = new javax.swing.JLabel();
        Id = new javax.swing.JLabel();
        BillIdLabel = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        BillNameLabel = new javax.swing.JLabel();
        Date = new javax.swing.JLabel();
        MessageBox = new javax.swing.JLabel();
        PaidByLabel = new javax.swing.JLabel();
        PaidBy = new javax.swing.JLabel();
        BackButton = new javax.swing.JButton();
        IncludeButton = new javax.swing.JButton();
        NextButton = new javax.swing.JButton();
        ItemName = new javax.swing.JLabel();
        ItemNameLabel = new javax.swing.JLabel();
        ItemCost = new javax.swing.JLabel();
        ItemCostLabel = new javax.swing.JLabel();
        DoneButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 300));

        DateLabel.setText("Bill Date:");

        WelcomeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        WelcomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        WelcomeLabel.setText("Fill Bill Request for: ");

        BillIdLabel.setText("Bill No:");

        BillNameLabel.setText("Bill Name:");

        MessageBox.setForeground(new java.awt.Color(255, 0, 0));
        MessageBox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        PaidByLabel.setText("Paid By");

        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        IncludeButton.setText("Include Me In This");
        IncludeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IncludeButtonActionPerformed(evt);
            }
        });

        NextButton.setText("Next");
        NextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextButtonActionPerformed(evt);
            }
        });

        ItemNameLabel.setText("Iteml Name:");

        ItemCostLabel.setText("Iteml Name:");

        DoneButton.setText("Done");
        DoneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoneButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(WelcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MessageBox, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BillIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BillNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(DateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ItemNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(109, 109, 109)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(BackButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(IncludeButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(NextButton))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(PaidByLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(PaidBy, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(DoneButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ItemCostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ItemCost, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(WelcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MessageBox, javax.swing.GroupLayout.DEFAULT_SIZE, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BillNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Id, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BillIdLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(PaidByLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PaidBy, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ItemNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ItemCost, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ItemCostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BackButton)
                    .addComponent(IncludeButton)
                    .addComponent(NextButton)
                    .addComponent(DoneButton))
                .addGap(58, 58, 58))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        NextButton.setEnabled(true);
         if(count-1 > -1)
        {
            --count;
            this.currentItem = items.get(count);
            api a = new api();
            updateComponents(a);
            a.closeConnection();
        }
        else
            BackButton.setEnabled(false);
    }//GEN-LAST:event_BackButtonActionPerformed

    private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextButtonActionPerformed
        // TODO add your handling code here:
        BackButton.setEnabled(true);
        if(count+1 < items.size())
        {
            ++count;
            this.currentItem = items.get(count);
            api a = new api();
            updateComponents(a);
            a.closeConnection();
        }
        else
            NextButton.setEnabled(false);
    }//GEN-LAST:event_NextButtonActionPerformed

    private void IncludeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IncludeButtonActionPerformed
        // TODO add your handling code here:
        api a = new api();
        if(IncludeButton.getText().equals("Include Me In This"))
        {
            if(a.addShare(this.user_id, this.bill_id, count+1)==-1)
            {
                MessageBox.setText("You've Already Selected That");
            }
            else
            { 
                if(count+1 == items.size())
                {
                    if(a.getShare(this.user_id, this.bill_id, count+1))
                        IncludeButton.setText("Don't Include Me In This");
                    else
                        IncludeButton.setText("Include Me In This");
                }
                NextButtonActionPerformed(evt);
            }
        }
        else
        {
            if(a.deleteShare(this.user_id, this.bill_id, count+1)==-1)
            {
                MessageBox.setText("Something Went Wrong!");
            }
            else
            {
                if(count+1 == items.size())
                {
                    if(a.getShare(this.user_id, this.bill_id, count+1))
                        IncludeButton.setText("Don't Include Me In This");
                    else
                        IncludeButton.setText("Include Me In This");
                }
                NextButtonActionPerformed(evt);
            }
        }
        a.closeConnection();
    }//GEN-LAST:event_IncludeButtonActionPerformed

    private void DoneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoneButtonActionPerformed
        // TODO add your handling code here:
        api a = new api();
        if(a.deleteRequest(this.bill_id, this.user_id) == -1)
        {
            MessageBox.setText("Something Went Wrong!");
        }
        else
        {
            this.setVisible(false);
            new UserHomepage(user_id).setVisible(true);
        }
        a.closeConnection();
        
    }//GEN-LAST:event_DoneButtonActionPerformed

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
            java.util.logging.Logger.getLogger(FillBillRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FillBillRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FillBillRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FillBillRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FillBillRequest(1, 1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JLabel BillIdLabel;
    private javax.swing.JLabel BillNameLabel;
    private javax.swing.JLabel Date;
    private javax.swing.JLabel DateLabel;
    private javax.swing.JButton DoneButton;
    private javax.swing.JLabel Id;
    private javax.swing.JButton IncludeButton;
    private javax.swing.JLabel ItemCost;
    private javax.swing.JLabel ItemCostLabel;
    private javax.swing.JLabel ItemName;
    private javax.swing.JLabel ItemNameLabel;
    private javax.swing.JLabel MessageBox;
    private javax.swing.JLabel Name;
    private javax.swing.JButton NextButton;
    private javax.swing.JLabel PaidBy;
    private javax.swing.JLabel PaidByLabel;
    private javax.swing.JLabel WelcomeLabel;
    // End of variables declaration//GEN-END:variables
}
