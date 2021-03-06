/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Classes.Ions;
//import Classes.PHModel;
import Procedures.CreateTables;
import Classes.Results;
import Classes.SolverModel;
import Classes.Utilities;
//import Forms.ModelsUI;
import Procedures.ReadFiles;
import Procedures.ShowMessages;
import java.awt.BorderLayout;
import java.awt.Color;
//import java.awt.Dimension;
import java.io.File;
//import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Esteban
 */
public class ResultsUI extends javax.swing.JFrame {

    /**
     * Creates new form ResultsUI
     */
    public ResultsUI() {
        initComponents();
        setTitle("Results");
        this.setLocationRelativeTo(null); // Open ModelsUI GUI in the center of the screen 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rbnDensityProfile = new javax.swing.JRadioButton();
        rbnElectrostaticPotential = new javax.swing.JRadioButton();
        rbnIntegratedCharge = new javax.swing.JRadioButton();
        rbnIonContributions = new javax.swing.JRadioButton();
        chkDisplayData = new javax.swing.JCheckBox();
        pnlPlot = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Select Data", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        rbnDensityProfile.setBackground(new java.awt.Color(255, 255, 255));
        rbnDensityProfile.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rbnDensityProfile.setText("Density Profile");
        rbnDensityProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnDensityProfileActionPerformed(evt);
            }
        });

        rbnElectrostaticPotential.setBackground(new java.awt.Color(255, 255, 255));
        rbnElectrostaticPotential.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rbnElectrostaticPotential.setText("Mean Electrostatic Potential");
        rbnElectrostaticPotential.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnElectrostaticPotentialActionPerformed(evt);
            }
        });

        rbnIntegratedCharge.setBackground(new java.awt.Color(255, 255, 255));
        rbnIntegratedCharge.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rbnIntegratedCharge.setText("Integrated Charge");
        rbnIntegratedCharge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnIntegratedChargeActionPerformed(evt);
            }
        });

        rbnIonContributions.setBackground(new java.awt.Color(255, 255, 255));
        rbnIonContributions.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rbnIonContributions.setText("Ion Contributions");
        rbnIonContributions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnIonContributionsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbnDensityProfile)
                    .addComponent(rbnIntegratedCharge))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbnIonContributions)
                    .addComponent(rbnElectrostaticPotential))
                .addGap(38, 38, 38))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbnDensityProfile)
                    .addComponent(rbnElectrostaticPotential))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbnIntegratedCharge)
                    .addComponent(rbnIonContributions))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        chkDisplayData.setBackground(new java.awt.Color(255, 255, 255));
        chkDisplayData.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        chkDisplayData.setText("Display Data");
        chkDisplayData.setEnabled(false);
        chkDisplayData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkDisplayDataActionPerformed(evt);
            }
        });

        pnlPlot.setBackground(new java.awt.Color(255, 255, 255));
        pnlPlot.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlPlot.setName(""); // NOI18N
        pnlPlot.setPreferredSize(new java.awt.Dimension(920, 400));
        pnlPlot.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlPlot, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(chkDisplayData)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 36, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 118, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(chkDisplayData, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(pnlPlot, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 9, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(459, 459, 459)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbnDensityProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnDensityProfileActionPerformed
   
         rbnElectrostaticPotential.setSelected(false);
          rbnIntegratedCharge.setSelected(false);
        
            rbnIonContributions.setSelected(false);
               
        if (rbnDensityProfile.isSelected()){
          
           File f = new File(Utilities.getAnalysisPath() +
                File.separatorChar + "DensityProfile.dat");
            if(f.exists() && !f.isDirectory()){
                chkDisplayData.setSelected(false);
              //  rbnDensityProfile.setSelected(false);
                CreateTables.dispose_data();
                String type = Utilities.getAnalysisPath() +
                File.separatorChar + "DensityProfile.dat";
                ReadFiles.read_results(type);
                Results.strDensityProfile = new String[Results.getNumLines()][Results.getNumCols()];
                Results.strDensityProfile = Results.reader;
                Results.densityProfile = new double[Results.getNumLines()][Results.getNumCols()];
                Results.densityProfile = ReadFiles.convert_astring2adouble(Results.strDensityProfile, Results.getNumLines(), Results.getNumCols());
                XYSeries[] seriesName_Data = new XYSeries[Results.getNumCols()];
                XYSeriesCollection my_data_series= new XYSeriesCollection();
                if ("NANOPARTICLE".equals(SolverModel.getModel())){
                 Ions.symbol[Results.getNumCols()-2] = "OH" ;
                 Ions.symbol[Results.getNumCols()-3] = "H" ;
                    int pp = 0;
                    int qq = 0;
                 for (int i = 0; i < Ions.getCounter(); i++){
                 if("Na".equals(Ions.symbol[i])){
                     pp = 1;
                 //    System.out.println(pp);
                 }
                 if("Cl".equals(Ions.symbol[i])){
                     qq = 1;
                 //    System.out.println(qq);
                 }
                 }
                 //System.out.println(Results.getNumCols());
                 //if(("0".equals(pp)) && ("1".equals(qq))){
                 if((pp == 0) && (qq == 1)){
                    Ions.symbol[Results.getNumCols()-4] = "NA" ; 
                 }
                 if((pp == 1) && (qq == 0)){
                    Ions.symbol[Results.getNumCols()-4] = "CL" ; 
                 }
                 if((pp == 0) && (qq == 0)){
                    Ions.symbol[Results.getNumCols()-4] = "NA" ; 
                     Ions.symbol[Results.getNumCols()-5] = "CL" ; 
                 }
                }
                for (int i = 1; i < Results.getNumCols(); i++){
                //    System.out.println(Ions.symbol[i-1]);
                    seriesName_Data[i-1] = new XYSeries(Ions.symbol[i-1]);
                    for (int j = 0; j < Results.getNumLines(); j++){
                        seriesName_Data[i-1].add(Results.densityProfile[j][0],
                            Results.densityProfile[j][i]);
                    }
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                    my_data_series.addSeries(seriesName_Data[i-1]);
                }
                if ("NANOPARTICLE".equals(SolverModel.getModel())){
                 Ions.symbol[Results.getNumCols()-2] = null ;
                 Ions.symbol[Results.getNumCols()-3] = null ;
                }
                JFreeChart chart = ChartFactory.createXYLineChart(null, "R [Angs.]",
                    "??(r)/??bulk", my_data_series, PlotOrientation.VERTICAL,
                    true, true, false);
                ChartPanel chartpanel = new ChartPanel(chart);
                XYPlot plot = (XYPlot) chart.getPlot();
                plot.setDomainGridlinesVisible(true);
                plot.setRangeGridlinesVisible(true);
                ValueAxis axis = plot.getDomainAxis();
                axis.setLowerBound(Results.densityProfile[0][0]);
                axis.setUpperBound(Results.densityProfile[Results.getNumLines()-2][0]);
                plot.setRangeGridlinePaint(Color.black);
                plot.setDomainGridlinePaint(Color.black);
                plot.setBackgroundPaint(Color.white);
                pnlPlot.removeAll();
                pnlPlot.add(chartpanel, BorderLayout.CENTER);
                pnlPlot.validate();
                chkDisplayData.setEnabled(true);
               
            }else{
                pnlPlot.removeAll();
                JOptionPane.showMessageDialog(null, ShowMessages.getNotFile(),
                    "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                chkDisplayData.setEnabled(false);
                
            }
        }else {
            pnlPlot.removeAll();
            chkDisplayData.setEnabled(false);
           
        }
          
    }//GEN-LAST:event_rbnDensityProfileActionPerformed

    private void rbnElectrostaticPotentialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnElectrostaticPotentialActionPerformed
       rbnDensityProfile.setSelected(false);
           rbnIntegratedCharge.setSelected(false);
            rbnIonContributions.setSelected(false);
                
        if (rbnElectrostaticPotential.isSelected()){
            File f = new File(Utilities.getAnalysisPath() +
                File.separatorChar + "ElectrostaticPotential.dat");
            if(f.exists() && !f.isDirectory()){
                chkDisplayData.setSelected(false);
              //   rbnElectrostaticPotential.setSelected(false);
                CreateTables.dispose_data();
                String type = Utilities.getAnalysisPath() +
                File.separatorChar + "ElectrostaticPotential.dat";
                ReadFiles.read_results(type);
                Results.strElectrostaticPotential = new String[Results.getNumLines()]
                [Results.getNumCols()];
                Results.strElectrostaticPotential = Results.reader;
                Results.electrostaticPotential = new double[Results.getNumLines()]
                [Results.getNumCols()];
                Results.electrostaticPotential = ReadFiles.convert_astring2adouble(Results.strElectrostaticPotential, Results.getNumLines(), Results.getNumCols());
                XYSeries[] seriesName_Data = new XYSeries[Results.getNumCols()];
                XYSeriesCollection my_data_series = new XYSeriesCollection();
                for (int i = 1; i < Results.getNumCols(); i++){
                    seriesName_Data[i-1] = new XYSeries("Mean Electrostatic Potential");
                    for (int j = 0; j < Results.getNumLines(); j++){
                        seriesName_Data[i-1].add(Results.electrostaticPotential[j][0],
                            Results.electrostaticPotential[j][i]);
                    }
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                    my_data_series.addSeries(seriesName_Data[i-1]);
                }
                JFreeChart chart = ChartFactory.createXYLineChart(null,
                    "R [Angs.]", "Electrostsat Potential [mV]", my_data_series,
                    PlotOrientation.VERTICAL, true, true, false);
                ChartPanel chartpanel = new ChartPanel(chart);
                XYPlot plot = (XYPlot) chart.getPlot();
                plot.setDomainGridlinesVisible(true);
                plot.setRangeGridlinesVisible(true);
                ValueAxis axis = plot.getDomainAxis();
                axis.setLowerBound(Results.electrostaticPotential[0][0]);
                axis.setUpperBound(Results.electrostaticPotential[Results.getNumLines()-2][0]);
                plot.setRangeGridlinePaint(Color.black);
                plot.setDomainGridlinePaint(Color.black);
                plot.setBackgroundPaint(Color.white);
                pnlPlot.removeAll();
                pnlPlot.add(chartpanel, BorderLayout.CENTER);
                pnlPlot.validate();
                chkDisplayData.setEnabled(true);
            }else{
                pnlPlot.removeAll();
                JOptionPane.showMessageDialog(null, ShowMessages.getNotFile(),
                    "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                chkDisplayData.setEnabled(false);
                 
            }
        }else{
            pnlPlot.removeAll();
            chkDisplayData.setEnabled(false);
            
        }
       
    }//GEN-LAST:event_rbnElectrostaticPotentialActionPerformed

    private void rbnIntegratedChargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnIntegratedChargeActionPerformed
        rbnDensityProfile.setSelected(false);
         rbnElectrostaticPotential.setSelected(false);
            rbnIonContributions.setSelected(false);
            
        if (rbnIntegratedCharge.isSelected()){
            File f = new File(Utilities.getAnalysisPath() +
                File.separatorChar + "IntegratedCharge.dat");
            if(f.exists() && !f.isDirectory()){
                chkDisplayData.setSelected(false);
              //  rbnIntegratedCharge.setSelected(false);
                CreateTables.dispose_data();
                String type = Utilities.getAnalysisPath() +
                File.separatorChar + "IntegratedCharge.dat";
                ReadFiles.read_results(type);
                Results.strIntegratedCharge = new String[Results.getNumLines()][Results.getNumCols()];
                Results.strIntegratedCharge = Results.reader;
                Results.integratedCharge = new double[Results.getNumLines()][Results.getNumCols()];
                Results.integratedCharge = ReadFiles.convert_astring2adouble(Results.strIntegratedCharge, Results.getNumLines(), Results.getNumCols());
                XYSeries[] seriesName_Data = new XYSeries[Results.getNumCols()];
                XYSeriesCollection my_data_series = new XYSeriesCollection();
                for (int i = 1; i < Results.getNumCols(); i++){
                    seriesName_Data[i-1] = new XYSeries("Integrated Charge");
                    for (int j = 0; j < Results.getNumLines(); j++){
                        seriesName_Data[i-1].add(Results.integratedCharge[j][0],
                            Results.integratedCharge[j][i]);
                    }
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                    my_data_series.addSeries(seriesName_Data[i-1]);
                }
                JFreeChart chart = ChartFactory.createXYLineChart(null,
                    "R [Angs.]", "Integrated Charge [e]", my_data_series,
                    PlotOrientation.VERTICAL, true, true, false);
                ChartPanel chartpanel = new ChartPanel(chart);
                XYPlot plot = (XYPlot) chart.getPlot();
                plot.setDomainGridlinesVisible(true);
                plot.setRangeGridlinesVisible(true);
                ValueAxis axis = plot.getDomainAxis();
                axis.setLowerBound(Results.integratedCharge[0][0]);
                axis.setUpperBound(Results.integratedCharge[Results.getNumLines()-2][0]);
                plot.setRangeGridlinePaint(Color.black);
                plot.setDomainGridlinePaint(Color.black);
                plot.setBackgroundPaint(Color.white);
                pnlPlot.removeAll();
                pnlPlot.add(chartpanel, BorderLayout.CENTER);
                pnlPlot.validate();
                chkDisplayData.setEnabled(true);
            }else{
                pnlPlot.removeAll();
                JOptionPane.showMessageDialog(null, ShowMessages.getNotFile(),
                    "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                chkDisplayData.setEnabled(false);
                
            }
        }else{
            pnlPlot.removeAll();
            chkDisplayData.setEnabled(false);
            
      
       }
        
    }//GEN-LAST:event_rbnIntegratedChargeActionPerformed

    private void rbnIonContributionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnIonContributionsActionPerformed
         rbnDensityProfile.setSelected(false);
         rbnElectrostaticPotential.setSelected(false);
          rbnIntegratedCharge.setSelected(false);
          
        if (rbnIonContributions.isSelected()){
            File f = new File(Utilities.getAnalysisPath() +
                File.separatorChar + "IonContributions.dat");
            if(f.exists() && !f.isDirectory()){
                chkDisplayData.setSelected(false);
              //  rbnIonContributions.setSelected(false);
                CreateTables.dispose_data();
                String type = Utilities.getAnalysisPath() +
                File.separatorChar + "IonContributions.dat";
                ReadFiles.read_results(type);
                Results.strIonContributions = new String[Results.getNumLines()][Results.getNumCols()];
                Results.strIonContributions = Results.reader;
                Results.ionContributions = new double[Results.getNumLines()][Results.getNumCols()];
                Results.ionContributions = ReadFiles.convert_astring2adouble(Results.strIonContributions, Results.getNumLines(), Results.getNumCols());
                XYSeries[] seriesName_Data = new XYSeries[Results.getNumCols()];
                XYSeriesCollection my_data_series= new XYSeriesCollection();
                int unit = 1; //used to tell what data of the ion is being graphed 
                int ionsGraphed = 0; //counts number of ions graphed for each unit
                String append = ""; //used to append symbols for data of ion
                int ionNumber = 0; //used to count number of ions
                boolean ionCounted = false; //keeps track of whether ions have been counted
                String uniqueName = ""; //keeps names from being repeated and crashing graph-the empty spaces are cut off
                //counts ions
                while(!ionCounted){
                    if(Ions.symbol[ionNumber] != null)
                        ionNumber ++;
                    else ionCounted = true; 
                    
                }
                if ("NANOPARTICLE".equals(SolverModel.getModel())){
                
                    int pp = 0;
                    int qq = 0;
                 for (int i = 0; i < Ions.getCounter(); i++){
                 if("Na".equals(Ions.symbol[i])){
                     pp = 1;
                 }
                 if("Cl".equals(Ions.symbol[i])){
                     qq = 1;
                 }
                 }
                 if(("0".equals(pp)) && ("1".equals(qq))){
                    Ions.symbol[Results.getNumCols()-3] = "NA" ; 
                 }
                 if(("1".equals(pp)) && ("0".equals(qq))){
                    Ions.symbol[Results.getNumCols()-3] = "CL" ; 
                 }
                 if(("0".equals(pp)) && ("0".equals(qq))){
                    Ions.symbol[Results.getNumCols()-3] = "NA" ; 
                     Ions.symbol[Results.getNumCols()-4] = "CL" ; 
                 }
                //    }
                    ionNumber = ionNumber + 4-pp-qq;
                //    for (int i = 1; i < Results.getNumCols(); i++){
                Ions.symbol[ionNumber-1] = "OH" ;
                Ions.symbol[ionNumber-2] = "H" ;
                }
                
                //assigns values and names to graphs
                for (int i = 1; i < Results.getNumCols(); i++){
                    if(ionsGraphed == ionNumber){
                        unit++;
                        ionsGraphed = 0;
                        uniqueName = uniqueName + " ";
                        
                    }
                    ionsGraphed++;
                    if(unit==1)
                       append = "Elec_Pot ";
                    else if(unit==2)
                       append = "Crowding ";
                    else if(unit==3)
                       append = "Ion_Corr ";
                    else if(unit==4)
                       append = "PMF ";                       
                    
                    seriesName_Data[i-1] = new XYSeries(append + Ions.symbol[(i-1)%ionNumber]+uniqueName);
                    for (int j = 0; j < Results.getNumLines(); j++){
                        seriesName_Data[i-1].add(Results.ionContributions[j][0],
                            Results.ionContributions[j][i]);
                    }
                      DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                my_data_series.addSeries(seriesName_Data[i-1]);
            }
                //resets values for next use
                unit = 1;
                ionsGraphed = 0;
                append = "";
                ionNumber = 0;
                ionCounted = false;
                
                JFreeChart chart = ChartFactory.createXYLineChart(null, "R [Angs.]",
                    "Contributions to PMF per thermal energy", my_data_series, 
                    PlotOrientation.VERTICAL, true, true, false);
                ChartPanel chartpanel = new ChartPanel(chart);
                XYPlot plot = (XYPlot) chart.getPlot();
                plot.setDomainGridlinesVisible(true);
                plot.setRangeGridlinesVisible(true);
                ValueAxis axis = plot.getDomainAxis();
                axis.setLowerBound(Results.ionContributions[0][0]);
                axis.setUpperBound(Results.ionContributions[Results.getNumLines()-2][0]);
                plot.setRangeGridlinePaint(Color.black);
                plot.setDomainGridlinePaint(Color.black);
                plot.setBackgroundPaint(Color.white);
                pnlPlot.removeAll();
                pnlPlot.add(chartpanel, BorderLayout.CENTER);
                pnlPlot.validate();
                chkDisplayData.setEnabled(true);
            }else{
                pnlPlot.removeAll();
                JOptionPane.showMessageDialog(null, ShowMessages.getNotFile(),
                    "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                chkDisplayData.setEnabled(false);
                 
            }
        }else{
            pnlPlot.removeAll();
            chkDisplayData.setEnabled(false);
             
        }
       
    }//GEN-LAST:event_rbnIonContributionsActionPerformed

    private void chkDisplayDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkDisplayDataActionPerformed

        if(chkDisplayData.isSelected()){
            if(rbnDensityProfile.isSelected()){
                CreateTables.set_table_item_list(Results.strDensityProfile);
            }
            if(rbnElectrostaticPotential.isSelected()){
                CreateTables.set_table_item_list(Results.strElectrostaticPotential);
            }
            if(rbnIntegratedCharge.isSelected()){
                CreateTables.set_table_item_list(Results.strIntegratedCharge);
            }
            if(rbnIonContributions.isSelected()){
                CreateTables.set_table_item_list(Results.strIonContributions);
            }
           
        }else{
            CreateTables.dispose_data();
        }
    }//GEN-LAST:event_chkDisplayDataActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ResultsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResultsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResultsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResultsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResultsUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox chkDisplayData;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel pnlPlot;
    public static javax.swing.JRadioButton rbnDensityProfile;
    public static javax.swing.JRadioButton rbnElectrostaticPotential;
    public static javax.swing.JRadioButton rbnIntegratedCharge;
    public static javax.swing.JRadioButton rbnIonContributions;
    // End of variables declaration//GEN-END:variables
}
