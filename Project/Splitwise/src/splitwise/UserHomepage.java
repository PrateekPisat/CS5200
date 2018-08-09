package splitwise;

import java.awt.Color;
import java.util.*;

public class UserHomepage extends javax.swing.JFrame {
    
    int user_id, count = 0;
    String name;
    float credit=0.0f,debit=0.0f,total_bal, budget;
    List<User> userBalances;
    int creditor1, creditor2, creditor3;
    public UserHomepage() {
        initComponents();
    }
    
    public UserHomepage(int userid)
    {
        initComponents();
        hideBalances();
        user_id = userid;
        api a = new api();
        name = a.getUserName(user_id);
        WelcomeBanner.setText("Welcome "+name);
        credit = a.getCredit(user_id);
        debit = a.getDebit(user_id);
        total_bal = credit - debit;
        CreditValue.setText(Float.toString(credit));
        DebitValue.setText(Float.toString(debit));
        TotalValue.setText(Float.toString(total_bal));
        PendingRequests.setText(Integer.toString(a.getPendingRequests(user_id)));
        HandleRequests.setEnabled((a.getPendingRequests(this.user_id) <= 0 ) ? false : true);
        budget = a.getUserBudget(user_id);
        MyBillsButton.setEnabled((a.getParticipatedBills(user_id).size() + a.getCreatedBills(user_id).size() <= 0)? false : true);
        if(debit>budget && budget != -1.f)
            MessageBox.setText("Your Spending are over you budget");
        userBalances = a.getAllUsers(this.user_id);
        if(userBalances.size() > 0)
            updateBalances(a);
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
        BalancesBanner = new javax.swing.JLabel();
        MyBillsButton = new javax.swing.JButton();
        BudgetButton = new javax.swing.JButton();
        LogoutButton = new javax.swing.JButton();
        MessageBox = new javax.swing.JLabel();
        BalanceCostLabel1 = new javax.swing.JLabel();
        BalanceName1 = new javax.swing.JLabel();
        BalanceNameLabel1 = new javax.swing.JLabel();
        BalanceCost1 = new javax.swing.JLabel();
        ClearDebtButton1 = new javax.swing.JButton();
        BalanceCostLabel2 = new javax.swing.JLabel();
        BalanceName2 = new javax.swing.JLabel();
        BalanceNameLabel2 = new javax.swing.JLabel();
        BalanceCost2 = new javax.swing.JLabel();
        ClearDebtButton2 = new javax.swing.JButton();
        BalanceCostLabel3 = new javax.swing.JLabel();
        BalanceName3 = new javax.swing.JLabel();
        BalanceNameLabel3 = new javax.swing.JLabel();
        BalanceCost3 = new javax.swing.JLabel();
        ClearDebtButton3 = new javax.swing.JButton();
        LoadNextButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        LoadPreviousButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(850, 600));
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

        BalancesBanner.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BalancesBanner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BalancesBanner.setText("Balances");

        MyBillsButton.setText("My Bills");
        MyBillsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MyBillsButtonActionPerformed(evt);
            }
        });

        BudgetButton.setText("Set Budget");
        BudgetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BudgetButtonActionPerformed(evt);
            }
        });

        LogoutButton.setText("Logout");
        LogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutButtonActionPerformed(evt);
            }
        });

        MessageBox.setForeground(new java.awt.Color(255, 0, 0));
        MessageBox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        BalanceCostLabel1.setText("How Much");

        BalanceNameLabel1.setText("Name");

        ClearDebtButton1.setText("Pay Debt");
        ClearDebtButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearDebtButton1ActionPerformed(evt);
            }
        });

        BalanceCostLabel2.setText("How Much");

        BalanceNameLabel2.setText("Name");

        ClearDebtButton2.setText("Pay Debt");
        ClearDebtButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearDebtButton2ActionPerformed(evt);
            }
        });

        BalanceCostLabel3.setText("How Much");

        BalanceNameLabel3.setText("Name");

        ClearDebtButton3.setText("Pay Debt");
        ClearDebtButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearDebtButton3ActionPerformed(evt);
            }
        });

        LoadNextButton.setText("Next");
        LoadNextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadNextButtonActionPerformed(evt);
            }
        });

        LoadPreviousButton.setText("Previous");
        LoadPreviousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadPreviousButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MessageBox, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(WelcomeBanner, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(CreditValue, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TotalValue, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(Credit, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(78, 78, 78)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Debit, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(DebitValue, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BalancesBanner, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(BalanceNameLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(BalanceCostLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(BalanceCost1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BalanceName1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(BalanceNameLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(BalanceCostLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(LoadPreviousButton)
                                                .addGap(36, 36, 36)
                                                .addComponent(LoadNextButton))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(96, 96, 96)
                                                .addComponent(BalanceName3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(BalanceNameLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(BalanceCostLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(BalanceName2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BalanceCost2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(BalanceCost3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ClearDebtButton1)
                                    .addComponent(ClearDebtButton2)
                                    .addComponent(ClearDebtButton3))
                                .addGap(81, 81, 81))
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator2))
                        .addGap(83, 83, 83)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HandleRequests)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(NewBillButton)
                        .addGap(18, 18, 18)
                        .addComponent(PendingRequestsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PendingRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MyBillsButton)
                        .addGap(55, 55, 55)
                        .addComponent(BudgetButton))
                    .addComponent(LogoutButton))
                .addGap(73, 73, 73))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(WelcomeBanner, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(MessageBox, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Credit, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Debit, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TotalValue, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DebitValue, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreditValue, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(BalancesBanner, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BalanceName1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ClearDebtButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BalanceCost1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BalanceNameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BalanceCostLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ClearDebtButton2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BalanceName2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BalanceNameLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(BalanceCostLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))
                            .addComponent(BalanceCost2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(BalanceName3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BalanceCost3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BalanceNameLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BalanceCostLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ClearDebtButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LoadNextButton)
                            .addComponent(LoadPreviousButton))
                        .addContainerGap(40, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(NewBillButton)
                                    .addComponent(PendingRequestsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(HandleRequests))
                            .addComponent(PendingRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MyBillsButton)
                            .addComponent(BudgetButton))
                        .addGap(27, 27, 27)
                        .addComponent(LogoutButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
        this.setVisible(false);
        new ShowBillRequests(this.user_id).setVisible(true);
    }//GEN-LAST:event_HandleRequestsActionPerformed

    private void LogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new LoginPage().setVisible(true);
    }//GEN-LAST:event_LogoutButtonActionPerformed

    private void MyBillsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MyBillsButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new ShowBills(this.user_id).setVisible(true);
    }//GEN-LAST:event_MyBillsButtonActionPerformed

    private void BudgetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BudgetButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new SetBudget(this.user_id).setVisible(true);
    }//GEN-LAST:event_BudgetButtonActionPerformed

    private void ClearDebtButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearDebtButton1ActionPerformed
        // TODO add your handling code here:
        api a = new api();
        if(a.yetToAnswerRequests(creditor1) > 0)
        {
            MessageBox.setForeground(Color.RED);
            MessageBox.setText("People Still Have To Fill Some Bills by That User");
            return;
        }
        if(a.clearDebt(user_id, creditor1) == -1)
            MessageBox.setText("Something Went Wrong");
        else
        {
            MessageBox.setText("Debt Paid!");
            debit = a.getDebit(user_id);
            DebitValue.setText(Float.toString(debit));
            total_bal = credit - debit;
            TotalValue.setText(Float.toString(total_bal));
            BalanceCost1.setText(Float.toString(0));
            ClearDebtButton1.setVisible(false);
        }
        a.closeConnection();
    }//GEN-LAST:event_ClearDebtButton1ActionPerformed

    private void ClearDebtButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearDebtButton2ActionPerformed
        // TODO add your handling code here:
         api a = new api();
         if(a.yetToAnswerRequests(creditor1) > 0)
        {
            MessageBox.setForeground(Color.RED);
            MessageBox.setText("People Still Have To Fill Some Bills by That User");
            return;
        }
        if(a.clearDebt(user_id, creditor1) == -1)
            MessageBox.setText("Something Went Wrong");
        else
        {
            MessageBox.setText("Debt Paid!");
            debit = a.getDebit(user_id);
            DebitValue.setText(Float.toString(debit));
            total_bal = credit - debit;
            TotalValue.setText(Float.toString(total_bal));
            BalanceCost2.setText(Float.toString(0));
            ClearDebtButton2.setVisible(false);
        }
        a.closeConnection();
    }//GEN-LAST:event_ClearDebtButton2ActionPerformed

    private void ClearDebtButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearDebtButton3ActionPerformed
        // TODO add your handling code here:
         api a = new api();
         if(a.yetToAnswerRequests(creditor1) > 0)
        {
            MessageBox.setForeground(Color.RED);
            MessageBox.setText("People Still Have To Fill Some Bills by That User");
            return;
        }
        if(a.clearDebt(user_id, creditor1) == -1)
        {
            MessageBox.setForeground(Color.RED);
            MessageBox.setText("Something Went Wrong");
        }
        else
        {
            MessageBox.setForeground(Color.GREEN);
            MessageBox.setText("Debt Paid!");
            debit = a.getDebit(user_id);
            DebitValue.setText(Float.toString(debit));
            total_bal = credit - debit;
            TotalValue.setText(Float.toString(total_bal));
            BalanceCost2.setText(Float.toString(0));
            ClearDebtButton2.setVisible(false);
        }
        a.closeConnection();
    }//GEN-LAST:event_ClearDebtButton3ActionPerformed

    private void LoadNextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadNextButtonActionPerformed
        // TODO add your handling code here:
        if(count+1 < userBalances.size())
        {
            count++;
            hideBalances();
            api a = new api();
            updateBalances(a);
            a.closeConnection();
        }
        
    }//GEN-LAST:event_LoadNextButtonActionPerformed

    private void LoadPreviousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadPreviousButtonActionPerformed
        // TODO add your handling code here:
        api a = new api();
        if(count-5 > -1)
        {
            count-=5;
            hideBalances();
            updateBalances(a);
        }
        else
        {
            count = 0;
            hideBalances();
            updateBalances(a);
        }
        a.closeConnection();
    }//GEN-LAST:event_LoadPreviousButtonActionPerformed

    private void updateBalances(api a)
    {
        BalanceNameLabel1.setVisible(true);
        BalanceCostLabel1.setVisible(true);
        BalanceName1.setVisible(true);
        BalanceCost1.setVisible(true);
        BalanceName1.setText(userBalances.get(count).getUserName());
        if(a.andTheyOweMe(user_id, userBalances.get(count).getUserId()) 
                >= a.andTheyOweMe(userBalances.get(count).getUserId(), user_id))
        {
            ClearDebtButton1.setVisible(false);
            BalanceCostLabel1.setText("You Are Owed:");
            BalanceCost1.setText(
                    Float.toString(
                            a.andTheyOweMe(user_id, userBalances.get(count).getUserId()) 
                            - a.andTheyOweMe(userBalances.get(count).getUserId(), user_id)
                    )
            );
        }
        else
        {
            ClearDebtButton1.setVisible(true);
            BalanceCostLabel1.setText("You Owe:");
            BalanceCost1.setText(
                    Float.toString(
                            a.andTheyOweMe(userBalances.get(count).getUserId(), user_id) 
                            - a.andTheyOweMe(user_id, userBalances.get(count).getUserId())
                    )
            );
        }
        creditor1 = userBalances.get(count).getUserId();
        ++count;
        if(userBalances.size() < count+1)
            return;
        BalanceNameLabel2.setVisible(true);
        BalanceCostLabel2.setVisible(true);
        BalanceName2.setVisible(true);
        BalanceCost2.setVisible(true);
        BalanceName2.setText(userBalances.get(count).getUserName());
        creditor2 = userBalances.get(count).getUserId();
        if(a.andTheyOweMe(user_id, userBalances.get(count).getUserId()) 
                >= a.andTheyOweMe(userBalances.get(count).getUserId(), user_id))
        {
            ClearDebtButton2.setVisible(false);
            BalanceCostLabel2.setText("You Are Owed:");
            BalanceCost2.setText(
                    Float.toString(
                            a.andTheyOweMe(user_id, userBalances.get(count).getUserId()) 
                            - a.andTheyOweMe(userBalances.get(count).getUserId(), user_id)
                    )
            );
        }
        else
        {
            ClearDebtButton2.setVisible(true);
            BalanceCostLabel2.setText("You Owe:");
            BalanceCost2.setText(
                    Float.toString(
                            a.andTheyOweMe(userBalances.get(count).getUserId(), user_id) 
                            - a.andTheyOweMe(user_id, userBalances.get(count).getUserId())
                    )
            );
        }
        ++count;
        if(userBalances.size() < count+1)
            return;
        BalanceNameLabel3.setVisible(true);
        BalanceCostLabel3.setVisible(true);
        BalanceName3.setVisible(true);
        BalanceCost3.setVisible(true);
        BalanceName3.setText(userBalances.get(count).getUserName());
        creditor3 = userBalances.get(count).getUserId();
        if(a.andTheyOweMe(user_id, userBalances.get(count).getUserId()) 
                >= a.andTheyOweMe(userBalances.get(count).getUserId(), user_id))
        {
            ClearDebtButton3.setVisible(false);
            BalanceCostLabel3.setText("You Are Owed:");
            BalanceCost3.setText(
                    Float.toString(
                            a.andTheyOweMe(user_id, userBalances.get(count).getUserId()) 
                            - a.andTheyOweMe(userBalances.get(count).getUserId(), user_id)
                    )
            );
        }
        else
        {
            ClearDebtButton3.setVisible(true);
            BalanceCostLabel3.setText("You Owe:");
            BalanceCost3.setText(
                    Float.toString(
                            a.andTheyOweMe(userBalances.get(count).getUserId(), user_id) 
                            - a.andTheyOweMe(user_id, userBalances.get(count).getUserId())
                    )
            );
        }
        LoadNextButton.setVisible(true);
    }
    private void hideBalances()
    {
        BalanceName1.setVisible(false);
        BalanceCost1.setVisible(false);
        BalanceName2.setVisible(false);
        BalanceCost2.setVisible(false);
        BalanceName3.setVisible(false);
        BalanceCost3.setVisible(false);
        BalanceNameLabel1.setVisible(false);
        BalanceCostLabel1.setVisible(false);
        BalanceNameLabel2.setVisible(false);
        BalanceCostLabel2.setVisible(false);
        BalanceNameLabel3.setVisible(false);
        BalanceCostLabel3.setVisible(false);
        ClearDebtButton1.setVisible(false);
        ClearDebtButton2.setVisible(false);
        ClearDebtButton3.setVisible(false);
        LoadNextButton.setVisible(false);
    }
    
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
                new UserHomepage(3).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BalanceCost1;
    private javax.swing.JLabel BalanceCost2;
    private javax.swing.JLabel BalanceCost3;
    private javax.swing.JLabel BalanceCostLabel1;
    private javax.swing.JLabel BalanceCostLabel2;
    private javax.swing.JLabel BalanceCostLabel3;
    private javax.swing.JLabel BalanceName1;
    private javax.swing.JLabel BalanceName2;
    private javax.swing.JLabel BalanceName3;
    private javax.swing.JLabel BalanceNameLabel1;
    private javax.swing.JLabel BalanceNameLabel2;
    private javax.swing.JLabel BalanceNameLabel3;
    private javax.swing.JLabel BalancesBanner;
    private javax.swing.JButton BudgetButton;
    private javax.swing.JButton ClearDebtButton1;
    private javax.swing.JButton ClearDebtButton2;
    private javax.swing.JButton ClearDebtButton3;
    private javax.swing.JLabel Credit;
    private javax.swing.JLabel CreditValue;
    private javax.swing.JLabel Debit;
    private javax.swing.JLabel DebitValue;
    private javax.swing.JButton HandleRequests;
    private javax.swing.JButton LoadNextButton;
    private javax.swing.JButton LoadPreviousButton;
    private javax.swing.JButton LogoutButton;
    private javax.swing.JLabel MessageBox;
    private javax.swing.JButton MyBillsButton;
    private javax.swing.JButton NewBillButton;
    private javax.swing.JLabel PendingRequests;
    private javax.swing.JLabel PendingRequestsLabel;
    private javax.swing.JLabel Total;
    private javax.swing.JLabel TotalValue;
    private javax.swing.JLabel WelcomeBanner;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
