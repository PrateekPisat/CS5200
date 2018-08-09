package splitwise;

import java.util.*;

public class ShowBills extends javax.swing.JFrame {

    int user_id;
    List<Bill> createdBills;
    List<Bill> participatedBills;
    public ShowBills() {
        initComponents();
    }
    
    public ShowBills(int user_id) {
        initComponents();
        this.user_id = user_id;
        api a = new api();
        WelcomeBanner.setText("All Bills for "+a.getUserName(user_id));
        MessageBox.setVisible(false);
        createdBills = a.getCreatedBills(this.user_id);
        participatedBills = a.getParticipatedBills(this.user_id);
        System.out.println(createdBills.size());
        if(createdBills == null)
                ShowCreatedBillsButton.setEnabled(false);
        else
        {
             if(createdBills.size() <= 0)
                 ShowCreatedBillsButton.setEnabled(false);
            else
                 ShowCreatedBillsButton.setEnabled(true);
        }
        if(participatedBills == null)
            ShowParticipatedBillsButton.setEnabled(false);
        else
        {
            if(participatedBills.size() <= 0)
                 ShowParticipatedBillsButton.setEnabled(false);
            else
                ShowParticipatedBillsButton.setEnabled(true);
        }
        a.closeConnection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MessageBox = new javax.swing.JLabel();
        WelcomeBanner = new javax.swing.JLabel();
        ShowCreatedBillsButton = new javax.swing.JButton();
        ShowParticipatedBillsButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(450, 520));

        MessageBox.setForeground(new java.awt.Color(255, 0, 0));
        MessageBox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        WelcomeBanner.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        WelcomeBanner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        ShowCreatedBillsButton.setText("Show Created Bills");
        ShowCreatedBillsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowCreatedBillsButtonActionPerformed(evt);
            }
        });

        ShowParticipatedBillsButton.setText("Show Participated Bills");
        ShowParticipatedBillsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowParticipatedBillsButtonActionPerformed(evt);
            }
        });

        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(WelcomeBanner, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                    .addComponent(MessageBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BackButton)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ShowCreatedBillsButton)
                        .addGap(56, 56, 56)
                        .addComponent(ShowParticipatedBillsButton)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(WelcomeBanner, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(MessageBox, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ShowCreatedBillsButton)
                    .addComponent(ShowParticipatedBillsButton))
                .addGap(35, 35, 35)
                .addComponent(BackButton)
                .addGap(282, 282, 282))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new UserHomepage(this.user_id).setVisible(true);
    }//GEN-LAST:event_BackButtonActionPerformed

    private void ShowParticipatedBillsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowParticipatedBillsButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new ShowMyBills(this.user_id).setVisible(true);
    }//GEN-LAST:event_ShowParticipatedBillsButtonActionPerformed

    private void ShowCreatedBillsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowCreatedBillsButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new ShowCreatedBills(this.user_id).setVisible(true);
    }//GEN-LAST:event_ShowCreatedBillsButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ShowBills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowBills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowBills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowBills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowBills(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JLabel MessageBox;
    private javax.swing.JButton ShowCreatedBillsButton;
    private javax.swing.JButton ShowParticipatedBillsButton;
    private javax.swing.JLabel WelcomeBanner;
    // End of variables declaration//GEN-END:variables
}
