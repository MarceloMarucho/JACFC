/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

/**
 *
 * @author mdmlab5
 */
import Classes.Solute;
import Classes.Utilities;
import Procedures.RunAnalysis;
import Procedures.WriteFilesSignal;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.beans.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProgressBarDemo extends JPanel
                                    implements ActionListener, 
                                        PropertyChangeListener {

//    private JProgressBar progressBar;
//    private JButton startButton;
//    private JTextArea taskOutput;
    private Task task;
    
        class Task extends SwingWorker<Void, Void> {
        /*
         * Main task. Executed in background thread.
         */
        @Override
        public Void doInBackground() {
//            Random random = new Random();
//            int progress = 0;
            //Initialize progress property.
//            setProgress(0);
//            while (progress < 100) {
                //Sleep for up to one second.
//                try {
//                    Thread.sleep(random.nextInt(1000));
//                } catch (InterruptedException ignore) {}
                //Make random progress.

                
//                progress += random.nextInt(10);
//                setProgress(Math.min(progress, 100));
//            }
    //new code to generate capacitance and parameter b
                String[] strArray6 = new String[12];
                strArray6[0] = "0.684279";
                strArray6[1] = "0.752585";
                strArray6[2] = "1.42635";
                strArray6[3] = "18.3565";
                strArray6[4] = "-5.14878";
                strArray6[5] = "-2.74156";
                strArray6[6] = "-2.29457";
                strArray6[7] = "-1.9018";
                strArray6[8] = "-1.56952";
                strArray6[9] = "-0.977315";
                strArray6[10] = "-0.886975";
                strArray6[11] = "-0.841036";
                String[] strlabel = new String[12];
                strlabel[0] = "Preliminary set up..";
                strlabel[1] = "stage 1 completed..";
                strlabel[2] = "stage 2 completed..";
                strlabel[3] = "stage 3 completed..";
                strlabel[4] = "stage 4 completed..";
                strlabel[5] = "stage 5 completed..";
                strlabel[6] = "stage 6 completed..";
                strlabel[7] = "stage 7 completed..";
                strlabel[8] = "stage 8 completed..";
                strlabel[9] = "stage 9 completed..";
                strlabel[10] = "stage 10 completed..";
                strlabel[11] = "compiling results...";                
                int[] porc = new int[12];
                 porc[0]=8;
                 porc[1]=16;
                 porc[2]=25;
                 porc[3]=32;
                 porc[4]=40;
                 porc[5]=48;
                 porc[6]=55;
                 porc[7]=64;
                 porc[8]=72;
                 porc[9]=80;
                 porc[10]=90;
                 porc[11]=100;
               for (int j = 1; j < 13; j++){
               setProgress(porc[j-1]);
               Solute.setCharge(strArray6[j-1]);           
               WriteFilesSignal.write_cylinder();
            {
                try {
                    RunAnalysis.run_cylinder();
                } catch (IOException ex) {
                    Logger.getLogger(ProgressBarDemo.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
            {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ProgressBarDemo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            File f = new File("waitfile.tmp");
            while(f.exists() && !f.isDirectory()) {         
                                try { 
                                    Thread.sleep(1000);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(RunAnalysis.class.getName()).log(Level.SEVERE, null, ex);
                                }
            }
//         String exe4 = "rm "+dir3;
        //String exe4 = "rm filepaths.txt ";
//        RunAnalysis executable4 = new RunAnalysis(exe4);
//        System.out.println("before zp");  
        String exe1 =  "./Linux/zp.sh ";
        RunAnalysis executable1 = new RunAnalysis(exe1);
//         System.out.println("after zp");
            {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ProgressBarDemo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
//            File f = new File("waitfile.tmp");
            while(f.exists() && !f.isDirectory()) {         
                                try { 
                                    Thread.sleep(1000);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(RunAnalysis.class.getName()).log(Level.SEVERE, null, ex);
                                }
            }
//            find /netapp/ -type f -iname "*.bak" -delete
//        String exe9 = "find "+Utilities.getAnalysisPath()+File.separatorChar+ " -type f -iname " + 
//                '"'+"*.dat"+'"'+" -delete";
         
//        String exe9 = "rm "+Utilities.getAnalysisPath()+
//                File.separatorChar+"*.dat";
//        System.out.println(exe9);  
//        RunAnalysis executable9 = new RunAnalysis(exe9);

// end j iteration
               }
        String exe8 = "rm "+Utilities.getAnalysisPath()+"/DensityProfile.dat";
        RunAnalysis executable8 = new RunAnalysis(exe8);
        String exe9 = "rm "+Utilities.getAnalysisPath()+"/ElectrostaticPotential.dat";
        RunAnalysis executable9 = new RunAnalysis(exe9);
        String exe7 = "rm "+Utilities.getAnalysisPath()+"/FMT_cyl_int_tab.dat";
        RunAnalysis executable7 = new RunAnalysis(exe7);
        String exe12 = "rm "+Utilities.getAnalysisPath()+"/IntegratedCharge.dat";
        RunAnalysis executable12 = new RunAnalysis(exe12);
        String exe10 = "rm "+Utilities.getAnalysisPath()+"/IonContributions.dat";
        RunAnalysis executable10 = new RunAnalysis(exe10);
        
//capacitance and b parameter 
//                System.out.println("before pfit");  
        String exe11 =  "./Linux/pfit.sh";
        RunAnalysis executable11 = new RunAnalysis(exe11);
//        System.out.println("after pfit"); 
            return null;
        }

        /*
         * Executed in event dispatching thread
         */
        @Override
        public void done() {
            Toolkit.getDefaultToolkit().beep();
            startButton.setEnabled(true);
            setCursor(null); //turn off the wait cursor
            taskOutput.append("Done!\n");
        }
    }
    /**
     * Creates new form ProgressBarDemo
     */
    public ProgressBarDemo() {
        initComponents();
//       super(new BorderLayout());

        //Create the demo's UI.
//        startButton = new JButton("Start");
//        startButton.setActionCommand("start");
//          startButton.addActionListener(this);

//        progressBar = new JProgressBar(0, 100);
//        progressBar.setValue(0);
//        progressBar.setStringPainted(true);

//        taskOutput = new JTextArea(5, 20);
//        taskOutput.setMargin(new Insets(5,5,5,5));
//        taskOutput.setEditable(false);

//        JPanel panel = new JPanel();
//        panel.add(startButton);
//        panel.add(progressBar);

//        add(panel, BorderLayout.PAGE_START);
//        add(new JScrollPane(taskOutput), BorderLayout.CENTER);
//        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    public void actionPerformed(ActionEvent evt) {
        startButton.setEnabled(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        //Instances of javax.swing.SwingWorker are not reusuable, so
        //we create new instances as needed.
        task = new Task();
//        task.addPropertyChangeListener(this);
        task.execute();
    }
    
    public void propertyChange(PropertyChangeEvent evt) {
        if ("progress" == evt.getPropertyName()) {
            int progress = (Integer) evt.getNewValue();
            progressBar.setValue(progress);
            taskOutput.append(String.format(
                    "Completed %d%% of task.\n", task.getProgress()));
        } 
    }
    
     private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("ProgressBarDemo2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new ProgressBarDemo();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
     
     public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
    /**
     *
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startButton = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        taskOutput = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        startButton.setText("Start");
        startButton.setActionCommand("start");

        progressBar.setStringPainted(true);

        taskOutput.setColumns(20);
        taskOutput.setRows(5);
        jScrollPane1.setViewportView(taskOutput);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("<html><center>Please WAIT ! the software is performing calculations. It may take just a few minutes until an hour depending the simulation requirements. Once the calculations are finished, this window will close automatically. </html>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(startButton)
                        .addGap(34, 34, 34)
                        .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JButton startButton;
    private javax.swing.JTextArea taskOutput;
    // End of variables declaration//GEN-END:variables
}
