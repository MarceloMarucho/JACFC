/******************************************************************************
 *
 * Original Author: Esteban Valderrama
 * Description: This Class contains the splash screen JFrame design.
 *
 *****************************************************************************/

package Splash;

import Forms.ModelsUI;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SplashScreenUI extends javax.swing.JFrame {

    private final SplashScreenUI splashFrame = this;
    
    public SplashScreenUI() {
   
        initComponents(); //  Initialize Splash screen JFrame components
        try{
            SplashScreenUI.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(ClassNotFoundException | InstantiationException | 
                IllegalAccessException | UnsupportedLookAndFeelException e){
        }
        this.setLocationRelativeTo(null);
        startThread();      
    }

    private void startThread() {
        Thread thread = new Thread (new Runnable(){
            @Override
            public void run() {
                // Open ModelsUI JFrame
                ModelsUI applicationFrame = null;
                try {
                    applicationFrame = new ModelsUI(splashFrame);
                } catch (IOException ex) {
                    Logger.getLogger(SplashScreenUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                // Locate the new window in the center of the screen
                applicationFrame.setLocationRelativeTo(null);
                applicationFrame.setVisible(true);
                dispose(); // dispose Splash Screen JFrame
            }  
        });
        thread.start();
    }
    
// This constructor gets the progress 
    public JProgressBar getProgressBar(){
        progressBar.setStringPainted(true);
        return progressBar;
    }

// This constructor gets the label messages
    public JLabel getLabel(){
        return label;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progressBar = new javax.swing.JProgressBar();
        jcMousePanel1 = new jcMousePanel.jcMousePanel();
        jLabel2 = new javax.swing.JLabel();
        label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(544, 420));
        setName("frSplashScreen"); // NOI18N
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        progressBar.setBackground(new java.awt.Color(255, 255, 255));
        progressBar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        getContentPane().add(progressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 760, 620, 40));

        jcMousePanel1.setBackground(new java.awt.Color(255, 255, 255));
        jcMousePanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(39, 40, 139), 3, true));
        jcMousePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/screensplash.png"))); // NOI18N
        jcMousePanel1.setMaximumSize(new java.awt.Dimension(801, 619));
        jcMousePanel1.setMinimumSize(new java.awt.Dimension(801, 619));
        jcMousePanel1.setPreferredSize(new java.awt.Dimension(801, 619));
        jcMousePanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(java.awt.Color.white);
        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel2.setForeground(java.awt.Color.blue);
        jLabel2.setText("<html><div style=\\\"text-align: center;\\\"> <br>Java Application for Cytoskeleton FIlaments Characterization (JACFC) <br>Supported by NIH and UTSA. ");
        jcMousePanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, -10, 540, 50));

        label.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        label.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        label.setForeground(java.awt.Color.black);
        label.setText("       Starting");
        jcMousePanel1.add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 740, 190, 20));

        getContentPane().add(jcMousePanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(ModelsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModelsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModelsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModelsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4500);
                } catch (Exception e) {
                }
                SplashScreenUI splashScreen = new SplashScreenUI();
                splashScreen.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private jcMousePanel.jcMousePanel jcMousePanel1;
    private javax.swing.JLabel label;
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables
}
