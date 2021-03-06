/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.mainpage;

import controller.helper.Helper;
import controller.statistics.StatisticHelper;
import model.user.User;
import view.explore.Explore;
import view.login.LoginFrame;
import view.profile.Profile;
import view.statistics.Statistics;

import javax.swing.*;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author tamer
 */
public class Homepage extends javax.swing.JFrame {
    private User user;
    /**
     * Creates new form Homepage
     */
    public Homepage(User user) {
        this.user= user;

        initComponents(user);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(User user) {

        app = new javax.swing.JTabbedPane();
        explore = new Explore(user);
        profile = new Profile(user);
        statistic = new Statistics();
        logOut = new javax.swing.JPanel();
        exitButton = new javax.swing.JButton();
        exitText = new javax.swing.JLabel();

        app.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt){
                mouseButtonClicked(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


        app.addTab("Home", explore);



        app.addTab("Profile", profile);

        app.addTab("Statistic", statistic);

        exitButton.setText("Exit");
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitButtonMouseClicked(evt);
            }
        });

        exitText.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        exitText.setText("Are You Sure to Exit ?");

        javax.swing.GroupLayout logOutLayout = new javax.swing.GroupLayout(logOut);
        logOut.setLayout(logOutLayout);
        logOutLayout.setHorizontalGroup(
            logOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logOutLayout.createSequentialGroup()
                .addGroup(logOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(logOutLayout.createSequentialGroup()
                        .addGap(368, 368, 368)
                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(logOutLayout.createSequentialGroup()
                        .addGap(317, 317, 317)
                        .addComponent(exitText)))
                .addContainerGap(332, Short.MAX_VALUE))
        );
        logOutLayout.setVerticalGroup(
            logOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logOutLayout.createSequentialGroup()
                .addContainerGap(202, Short.MAX_VALUE)
                .addComponent(exitText)
                .addGap(143, 143, 143)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
        );

        app.addTab("LogOut", logOut);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(app)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(app, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseClicked
        LoginFrame loginFrame = new LoginFrame();
        this.setVisible(false);
        loginFrame.setVisible(true);
    }//GEN-LAST:event_exitButtonMouseClicked


    public void mouseButtonClicked(java.awt.event.MouseEvent evt){
        profile.userInfo.setText(user.toString());
        statistic.jTextField1.setText(StatisticHelper.mostLikedOutfit().getName());
        statistic.jTextField2.setText(StatisticHelper.mostDislikedOutfit().getName());
        statistic.jTextField3.setText(StatisticHelper.mostFollowerUser().getUserName());
        explore.outfits.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = Helper.outfitNameArray();
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel exitText;
    private Explore explore;
    private Profile profile;
    private Statistics statistic;
    private javax.swing.JPanel logOut;
    public javax.swing.JTabbedPane app;
    // End of variables declaration//GEN-END:variables
}
