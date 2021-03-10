/******************************************************************************
 *
 * @author Esteban Valderrama and Marcelo Marucho
 * Description: This class initializes a JInternalDesktop to show the SPM
 *              frame.
 *
 *****************************************************************************/
package Forms;

import Classes.IonLibrary;
import Classes.Ions;
import Classes.LoadImageApp;
import Classes.NumericalScheme;
import Classes.Solute;
import Classes.Solvent;
import Classes.ThermodynamicProperties;
import Classes.Utilities; 
import Classes.PHModel;
import Classes.Results;
import Classes.SolverModel;
import Classes.testenv;
import static Classes.testenv.Linuxenv;
import static Classes.testenv.RAMmemtest;
import Procedures.LoadFiles;
import Procedures.MoveFiles;
//import Procedures.ReadFiles;
import Procedures.RunAnalysis;
import Procedures.SetEnvironment;
import Procedures.ShowMessages;
import Procedures.WriteFiles;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.in;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import Forms.MonitoringCalculations;
import static Procedures.EmailAttachmentSender.sendEmailWithAttachments;
import Procedures.ReadFiles;
import Procedures.WriteFilesSignal;
import Procedures.ZipFiles;
import java.awt.Desktop;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.PrintWriter;
import javax.swing.SwingWorker;
import java.text.SimpleDateFormat;
import java.util.Date;
import jmolapp.Jmolapp;



 @SuppressWarnings("unchecked")
public class BiomoleculesUI extends javax.swing.JFrame implements ActionListener, 
                                        PropertyChangeListener {
    /**
     * Creates new form biomolecules
     */
      private Task task;
       private Task2 task2;
      
    public BiomoleculesUI() {
        initComponents();
        this.setLocationRelativeTo(null); // Open ModelsUI GUI in the center of the screen 
        emailaddress.setVisible(false);
// delete any outpufile previously generated on the working directory
            String src2 = "rm "+ System.getProperty("user.dir")
            +"/" + "input.pdb";
            RunAnalysis runAnalysis = new RunAnalysis(src2);
            String src3 = "rm "+ System.getProperty("user.dir")
            +"/" + "vol.txt";
            RunAnalysis runAnalysis3 = new RunAnalysis(src3); 
            String src4 = "rm "+ System.getProperty("user.dir")
            +"/" + "radiusandcharge.txt";
            RunAnalysis runAnalysis4 = new RunAnalysis(src4);
            String src6 = "rm "+ System.getProperty("user.dir")
            +"/" + "lengthandcharge.txt";
            RunAnalysis runAnalysis6 = new RunAnalysis(src6); 
            String src7 = "rm "+ System.getProperty("user.dir")
            +"/" + "input.pqr";
            RunAnalysis runAnalysis7 = new RunAnalysis(src7); 
            String src8 = "rm "+ System.getProperty("user.dir")
            +"/" + "input.propka";
            RunAnalysis runAnalysis8 = new RunAnalysis(src8); 
            String src9 = "rm "+ System.getProperty("user.dir")
            +"/" + "waitfile.tmp";
            RunAnalysis runAnalysis9 = new RunAnalysis(src9); 
            String src10 = "rm "+ System.getProperty("user.dir")
            +"/" + "inputfile.in";
            RunAnalysis runAnalysis10 = new RunAnalysis(src10); 
            String src11 = "rm "+ System.getProperty("user.dir")
            +"/" + "out.txt";
            RunAnalysis runAnalysis11 = new RunAnalysis(src11); 
//
        if (null != Utilities.getTheoryModel())
            switch (Utilities.getTheoryModel()) {
            case "PB":
                setTitle("Polyelectrolyte Properties");

                pnlSteric.setEnabled(false);
                lblSolventDiameter.setEnabled(false);
                lblSolventAngstroms.setEnabled(false);
                txtSolventDiameter.setEnabled(false);
                txtSolventDiameter.setText("N/A");
                lblSolventConcentration.setEnabled(false);
                lblSolventMolar.setEnabled(false);
                txtSolventConcentration.setEnabled(false);
                txtSolventConcentration.setText("N/A");
                btnSolve1.setVisible(false);
                break;
            case "SPM":
                setTitle("Polyelectrolyte Properties");
                btnSolve1.setVisible(false);
                break;
        }
        if (PHModel.getAnalysisType().equals("CYLINDRICAL_PROTEIN") || (PHModel.getAnalysisType().equals("NANOROD"))){
            lblSoluteChargeType.setText("* e/lambda:");
            lblSoluteChargeUnits.setText("[A]");
        }
        if (PHModel.getAnalysisType().equals("GLOBULAR_PROTEIN") || (PHModel.getAnalysisType().equals("NANOPARTICLE"))){
            lblSoluteChargeType.setText("* Surface Charge:");
            lblSoluteChargeUnits.setText("[C/m2]");
        }

        // Get size of ModelsUI to make sure the internal frame fits
        Dimension desktopSize = ModelsUI.dkpModels.getSize();
        double width = desktopSize.getWidth();
        double height = desktopSize.getHeight();
        setSize((int) width, (int) height);
        setMaximumSize(new Dimension((int) width, (int) height));
        pack();
        NumericalScheme.setMultigrid("NO");
        Ions.setCounter(0);
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        pnlElectrolyteDefinition = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        pnlIonData = new javax.swing.JPanel();
        cmbIon = new javax.swing.JComboBox();
        lblIonValence = new javax.swing.JLabel();
        lblIonConcentration = new javax.swing.JLabel();
        txtIonConcentration = new javax.swing.JTextField();
        lblIonDiameter = new javax.swing.JLabel();
        txtIonDiameter = new javax.swing.JTextField();
        lblIonSymbol = new javax.swing.JLabel();
        cmbValence = new javax.swing.JComboBox();
        lblElectroValue = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblIonData = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblElectroneutrality = new javax.swing.JLabel();
        lblMessage = new javax.swing.JLabel();
        lblIonMolar = new javax.swing.JLabel();
        lblIonAngstroms = new javax.swing.JLabel();
        pnlDiameterType = new javax.swing.JPanel();
        rbnCrystal = new javax.swing.JRadioButton();
        rbnEffective = new javax.swing.JRadioButton();
        rbnHydrated = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        pnlElectrostatic = new javax.swing.JPanel();
        lblDielectricConstant = new javax.swing.JLabel();
        txtDielectricConstant = new javax.swing.JTextField();
        pnlSteric = new javax.swing.JPanel();
        lblSolventConcentration = new javax.swing.JLabel();
        lblSolventMolar = new javax.swing.JLabel();
        lblSolventDiameter = new javax.swing.JLabel();
        txtSolventDiameter = new javax.swing.JTextField();
        lblSolventAngstroms = new javax.swing.JLabel();
        txtSolventConcentration = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtTemperature = new javax.swing.JTextField();
        lblTempUnits = new javax.swing.JLabel();
        pnlNumericalRuntime = new javax.swing.JPanel();
        lblTolerance = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtTolerance = new javax.swing.JTextField();
        lblResolutionAngstroms = new javax.swing.JLabel();
        lblResolution = new javax.swing.JLabel();
        txtResolution = new javax.swing.JTextField();
        lblMixing = new javax.swing.JLabel();
        txtMixing = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        rbn3v = new javax.swing.JRadioButton();
        rbnprovol = new javax.swing.JRadioButton();
        btnSolve = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        pnlpHModel = new javax.swing.JPanel();
        rbnExperimentalData = new javax.swing.JRadioButton();
        rbnTheoreticalPred = new javax.swing.JRadioButton();
        lblSoluteChargeType = new javax.swing.JLabel();
        txtSoluteCharge = new javax.swing.JTextField();
        lblSoluteChargeUnits = new javax.swing.JLabel();
        lblForceField = new javax.swing.JLabel();
        cmbForceField = new javax.swing.JComboBox();
        btnJmol = new javax.swing.JButton();
        lblpHValue = new javax.swing.JLabel();
        txtPh = new javax.swing.JTextField();
        btnPDB2PQR = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        lblSoluteRadius = new javax.swing.JLabel();
        txtSoluteRadius = new javax.swing.JTextField();
        lblSoluteAngstroms = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnSolve1 = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();
        jScrollPane3 = new javax.swing.JScrollPane();
        taskOutput = new javax.swing.JTextArea();
        saveresults = new javax.swing.JButton();
        emailaddress = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1175, 558));
        setResizable(false);
        setSize(new java.awt.Dimension(1175, 716));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        pnlElectrolyteDefinition.setBackground(new java.awt.Color(255, 255, 255));
        pnlElectrolyteDefinition.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Electrolyte Model", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Tahoma", 1, 14), java.awt.Color.blue)); // NOI18N
        pnlElectrolyteDefinition.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ion Model", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 13))); // NOI18N

        pnlIonData.setBackground(new java.awt.Color(255, 255, 255));
        pnlIonData.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ions Considered As Charged Hard Sphere", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        pnlIonData.setEnabled(false);

        cmbIon.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbIon.setEnabled(false);
        cmbIon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cmbIonMouseReleased(evt);
            }
        });
        cmbIon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIonActionPerformed(evt);
            }
        });

        lblIonValence.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblIonValence.setText("*Valence:");
        lblIonValence.setEnabled(false);

        lblIonConcentration.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblIonConcentration.setText("*Concentration:");
        lblIonConcentration.setEnabled(false);

        txtIonConcentration.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtIonConcentration.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIonConcentration.setToolTipText("<html><div style=\\\"text-align: left;\\\"<br>Concentration of the Ions,<br>\ntypical values as 0.01 M  to 1.0 M are used.");
        txtIonConcentration.setEnabled(false);
        txtIonConcentration.setPreferredSize(new java.awt.Dimension(58, 28));
        txtIonConcentration.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIonConcentrationMouseClicked(evt);
            }
        });
        txtIonConcentration.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIonConcentrationKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIonConcentrationKeyReleased(evt);
            }
        });

        lblIonDiameter.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblIonDiameter.setText("*Diameter:");
        lblIonDiameter.setEnabled(false);

        txtIonDiameter.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtIonDiameter.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIonDiameter.setToolTipText("<html><div style=\\\"text-align: left;\\\"<br>Diameter of the Ions.");
        txtIonDiameter.setEnabled(false);
        txtIonDiameter.setPreferredSize(new java.awt.Dimension(58, 28));
        txtIonDiameter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIonDiameterKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIonDiameterKeyReleased(evt);
            }
        });

        lblIonSymbol.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblIonSymbol.setText("*Ions:");
        lblIonSymbol.setEnabled(false);

        cmbValence.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbValence.setEnabled(false);
        cmbValence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbValenceActionPerformed(evt);
            }
        });

        lblElectroValue.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblElectroValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblElectroValue.setText("0.0");
        lblElectroValue.setEnabled(false);

        tblIonData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ion", "Valence, z", "Bulk Concentration [M]", "Diameter, d [A]"
            }
        ));
        tblIonData.setEnabled(false);
        tblIonData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblIonDataMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblIonData);

        btnAdd.setText("Add");
        btnAdd.setEnabled(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lblElectroneutrality.setText("Electroneutrality:");
        lblElectroneutrality.setEnabled(false);

        lblMessage.setForeground(new java.awt.Color(255, 51, 51));

        lblIonMolar.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblIonMolar.setText("[M]");
        lblIonMolar.setEnabled(false);

        lblIonAngstroms.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblIonAngstroms.setText("[A]");
        lblIonAngstroms.setEnabled(false);

        javax.swing.GroupLayout pnlIonDataLayout = new javax.swing.GroupLayout(pnlIonData);
        pnlIonData.setLayout(pnlIonDataLayout);
        pnlIonDataLayout.setHorizontalGroup(
            pnlIonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIonDataLayout.createSequentialGroup()
                .addGroup(pnlIonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlIonDataLayout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete))
                    .addGroup(pnlIonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlIonDataLayout.createSequentialGroup()
                            .addGap(202, 202, 202)
                            .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlIonDataLayout.createSequentialGroup()
                            .addGap(267, 267, 267)
                            .addComponent(lblElectroneutrality)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblElectroValue, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlIonDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlIonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlIonDataLayout.createSequentialGroup()
                        .addComponent(lblIonSymbol)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbIon, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lblIonConcentration)
                        .addGap(0, 0, 0)
                        .addComponent(txtIonConcentration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lblIonMolar)
                        .addGap(18, 18, 18)
                        .addComponent(lblIonValence)
                        .addGap(0, 0, 0)
                        .addComponent(cmbValence, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(lblIonDiameter)
                        .addGap(2, 2, 2)
                        .addComponent(txtIonDiameter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(lblIonAngstroms)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlIonDataLayout.setVerticalGroup(
            pnlIonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIonDataLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlIonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIonSymbol)
                    .addComponent(cmbIon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIonConcentration)
                    .addComponent(txtIonConcentration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbValence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIonValence, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIonMolar)
                    .addComponent(lblIonDiameter)
                    .addComponent(txtIonDiameter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIonAngstroms))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlIonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addGap(1, 1, 1)
                .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlIonDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblElectroValue, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblElectroneutrality)))
        );

        pnlDiameterType.setBackground(new java.awt.Color(255, 255, 255));
        pnlDiameterType.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Diameter Type", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        pnlDiameterType.setToolTipText("<html><div style=\\\"text-align: left;\\\"<br>X-ray crystallography gives the <br>distance between ions which is used <br>to estimate the radius of an atom's ion<br> in ionic crystals structure. They are <br>treated as if they are hard spheres <br>with radii such that the sum of ionic radii<br> of the cation and anion gives the <br>distance between the ions in a crystal lattice. <br> A major review of crystallographic data <br>led to the definition of revised ionic radii <br>because the crystal ionic radius is not a fixed <br>property of a given ion, but varies <br>with coordination number, spin state and other parameters. <br>These effective ionic radii <br>increase on descending a periodic <br>table group. Ionic size (for the same ion) <br>also increases with increasing coordination <br>number, and an ion in a high-spin state <br>will be larger than the same ion<br> in a low-spin state. In general, <br>effective ionic radius decreases with <br>increasing positive charge and increases<br> with increasing negative charge. <br>The concept can be extended to define<br> hydrated ions in liquid solutions taking<br> into consideration the solvation shell. <br> Shannon's Crystal and Effective ionic <br>radii data are tabulated here, <br>but the user can redefine existing ion species<br> and  define new ion species as well.");

        rbnCrystal.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbnCrystal);
        rbnCrystal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rbnCrystal.setText("Crystal");
        rbnCrystal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnCrystalActionPerformed(evt);
            }
        });

        rbnEffective.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbnEffective);
        rbnEffective.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rbnEffective.setText("Effective");
        rbnEffective.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnEffectiveActionPerformed(evt);
            }
        });

        rbnHydrated.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbnHydrated);
        rbnHydrated.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rbnHydrated.setText("Hydrated");
        rbnHydrated.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnHydratedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDiameterTypeLayout = new javax.swing.GroupLayout(pnlDiameterType);
        pnlDiameterType.setLayout(pnlDiameterTypeLayout);
        pnlDiameterTypeLayout.setHorizontalGroup(
            pnlDiameterTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDiameterTypeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rbnCrystal)
                .addGap(51, 51, 51)
                .addComponent(rbnEffective)
                .addGap(47, 47, 47)
                .addComponent(rbnHydrated, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlDiameterTypeLayout.setVerticalGroup(
            pnlDiameterTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDiameterTypeLayout.createSequentialGroup()
                .addGroup(pnlDiameterTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbnCrystal)
                    .addComponent(rbnEffective)
                    .addComponent(rbnHydrated))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(141, Short.MAX_VALUE)
                .addComponent(pnlDiameterType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(182, 182, 182))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(pnlIonData, javax.swing.GroupLayout.PREFERRED_SIZE, 668, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(pnlDiameterType, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlIonData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlElectrolyteDefinition.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 690, 300));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Solvent Model", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 13))); // NOI18N

        pnlElectrostatic.setBackground(new java.awt.Color(255, 255, 255));
        pnlElectrostatic.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Continuum Dielectric Medium To Model Polarization Effects", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        lblDielectricConstant.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDielectricConstant.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDielectricConstant.setText("*Dielectric Constant");
        lblDielectricConstant.setToolTipText("");

        txtDielectricConstant.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDielectricConstant.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDielectricConstant.setText("78.358");
        txtDielectricConstant.setToolTipText("<html><div style=\\\"text-align: left;\\\"<br>The dielectric constant is <br>the ratio of the permittivity of a medium <br>to that of free space,<br> It describes the ease by which a <br>dielectric medium may be polarized.<br> The  value displayed in this box <br>corresponds to water.");
        txtDielectricConstant.setMinimumSize(new java.awt.Dimension(58, 28));
        txtDielectricConstant.setPreferredSize(new java.awt.Dimension(58, 28));
        txtDielectricConstant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDielectricConstantKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout pnlElectrostaticLayout = new javax.swing.GroupLayout(pnlElectrostatic);
        pnlElectrostatic.setLayout(pnlElectrostaticLayout);
        pnlElectrostaticLayout.setHorizontalGroup(
            pnlElectrostaticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlElectrostaticLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(lblDielectricConstant)
                .addGap(10, 10, 10)
                .addComponent(txtDielectricConstant, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlElectrostaticLayout.setVerticalGroup(
            pnlElectrostaticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDielectricConstant, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(txtDielectricConstant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlSteric.setBackground(new java.awt.Color(255, 255, 255));
        pnlSteric.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Molecules Represented as Neutral Spherical Ions To Model Crowding Effects", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10))); // NOI18N

        lblSolventConcentration.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSolventConcentration.setText("*Concentration:");

        lblSolventMolar.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblSolventMolar.setText("[M]");

        lblSolventDiameter.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSolventDiameter.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSolventDiameter.setText("*Diameter:");

        txtSolventDiameter.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSolventDiameter.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSolventDiameter.setText("2.75");
        txtSolventDiameter.setToolTipText("<html><div style=\\\"text-align: left;\\\"<br>The value displayed in this box <br>corresponds to the experimental water molecule size.");
        txtSolventDiameter.setMinimumSize(new java.awt.Dimension(58, 28));
        txtSolventDiameter.setPreferredSize(new java.awt.Dimension(58, 28));
        txtSolventDiameter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSolventDiameterKeyTyped(evt);
            }
        });

        lblSolventAngstroms.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblSolventAngstroms.setText("[A]");

        txtSolventConcentration.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSolventConcentration.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSolventConcentration.setText("55.56");
        txtSolventConcentration.setToolTipText("<html><div style=\\\"text-align: left;\\\"<br>The value displayed in this box <br>corresponds to the experimental water concentration.");
        txtSolventConcentration.setMinimumSize(new java.awt.Dimension(58, 28));
        txtSolventConcentration.setPreferredSize(new java.awt.Dimension(58, 28));
        txtSolventConcentration.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSolventConcentrationKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout pnlStericLayout = new javax.swing.GroupLayout(pnlSteric);
        pnlSteric.setLayout(pnlStericLayout);
        pnlStericLayout.setHorizontalGroup(
            pnlStericLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStericLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblSolventConcentration)
                .addGap(14, 14, 14)
                .addComponent(txtSolventConcentration, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lblSolventMolar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(lblSolventDiameter)
                .addGap(12, 12, 12)
                .addComponent(txtSolventDiameter, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lblSolventAngstroms, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        pnlStericLayout.setVerticalGroup(
            pnlStericLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStericLayout.createSequentialGroup()
                .addGroup(pnlStericLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSolventMolar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlStericLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(pnlStericLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSolventConcentration, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSolventConcentration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblSolventAngstroms, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlStericLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lblSolventDiameter, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlStericLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtSolventDiameter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlSteric, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlElectrostatic, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlElectrostatic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSteric, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlElectrolyteDefinition.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, 470, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Thermodynamic Conditions", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 12))); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("*Temperature:");

        txtTemperature.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTemperature.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTemperature.setText("298.15");
        txtTemperature.setToolTipText("<html><div style=\\\"text-align: left;\\\"<br>The value displayed in this box <br>corresponds to the room temperature.");
        txtTemperature.setMinimumSize(new java.awt.Dimension(58, 28));
        txtTemperature.setPreferredSize(new java.awt.Dimension(58, 28));
        txtTemperature.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTemperatureKeyTyped(evt);
            }
        });

        lblTempUnits.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblTempUnits.setText("[K]");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(138, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(12, 12, 12)
                .addComponent(txtTemperature, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTempUnits)
                .addGap(123, 123, 123))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTemperature, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTempUnits)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlElectrolyteDefinition.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 220, 460, 80));

        pnlNumericalRuntime.setBackground(new java.awt.Color(255, 255, 255));
        pnlNumericalRuntime.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Numerical Scheme & Runtime Options", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Tahoma", 1, 14), java.awt.Color.blue)); // NOI18N
        pnlNumericalRuntime.setToolTipText("");

        lblTolerance.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTolerance.setText("*Tolerance:");

        txtTolerance.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTolerance.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTolerance.setText("0.000001");
        txtTolerance.setToolTipText("<html><div style=\\\"text-align: left;\\\"<br>The tolerance is the numerical error <br>required by the user to obtain <br>the normalized ion density profile solutions,<br> It should be greater than 1.0e-4.");
        txtTolerance.setMinimumSize(new java.awt.Dimension(58, 28));
        txtTolerance.setName(""); // NOI18N
        txtTolerance.setPreferredSize(new java.awt.Dimension(58, 28));
        txtTolerance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtToleranceKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtToleranceKeyReleased(evt);
            }
        });

        lblResolutionAngstroms.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblResolutionAngstroms.setText("[A]");

        lblResolution.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblResolution.setText("*Resolution:");

        txtResolution.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtResolution.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtResolution.setText("0.15");
        txtResolution.setToolTipText("<html><div style=\\\"text-align: left;\\\"<br>The resolution represents the regular <br>separation distance between<br> two consecutive points in the domain discretized <br>of the radial distance to solve the <br>master equations numerically. <br>This domain, ranging from the <br>macroions radius to the cutoff, is <br>determined by CSDFTS automatically <br>to reach the required resolution and tolerance<br> Typical values for this parameter <br>should be smaller than 0.5 A.");
        txtResolution.setMinimumSize(new java.awt.Dimension(58, 28));
        txtResolution.setPreferredSize(new java.awt.Dimension(58, 28));
        txtResolution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtResolutionActionPerformed(evt);
            }
        });
        txtResolution.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtResolutionKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtResolutionKeyReleased(evt);
            }
        });

        lblMixing.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblMixing.setText("*Mixing Parameter:");

        txtMixing.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMixing.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMixing.setText("0.35");
        txtMixing.setToolTipText("<html><div style=\\\"text-align: left;\\\"<br>The Mixing Parameter is a number <br>between 0 and 1 that helps the <br>solver to reach stability and convergence <br>in the iteration to get the solution iteratively.<br> As a thumb rule, the smaller <br>the value of this parameter the higher<br> the stability and the lower the rate of convergence.");
        txtMixing.setMinimumSize(new java.awt.Dimension(58, 28));
        txtMixing.setName(""); // NOI18N
        txtMixing.setPreferredSize(new java.awt.Dimension(58, 28));
        txtMixing.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMixingKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMixingKeyReleased(evt);
            }
        });

        jPanel7.setBackground(java.awt.Color.white);
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Protein volume", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 12))); // NOI18N
        jPanel7.setForeground(java.awt.Color.white);
        jPanel7.setToolTipText("<html><div style=\\\"text-align: left;\\\" <br>3v application (http://3vee.molmovdb.org/volumeCalc.php) <br> calculates the volume of your macromolecule of interest.  <br>By rolling a virtual probe of radius 1.4A (water) on the  <br>surface of your macromolecule a total solvent exclude volume  <br>is calculated. To select this option the usser's computer must  <br>have installed the text interpreter gawk  <br>(https://www.gnu.org/software/gawk/). <br> Provol (http://gmlab.bio.rpi.edu/index.php) is a Java program  <br>that calculates the components of the solvent-excluded (geometric)  <br>volume of a protein. As a tumb rule, 3v runs faster and  <br>requires less allocated RAM memory than Provol.  <br>On the other hand, Provol does not requires any application installation.  <br>Both applications provide similar even not the same results. ");

        buttonGroup3.add(rbn3v);
        rbn3v.setText("3v (Voss Volume Voxelator)");
        rbn3v.setToolTipText("");
        rbn3v.setEnabled(false);
        rbn3v.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbn3vActionPerformed(evt);
            }
        });

        buttonGroup3.add(rbnprovol);
        rbnprovol.setSelected(true);
        rbnprovol.setText("Provol");
        rbnprovol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnprovolActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 223, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(rbn3v, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(rbnprovol, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(103, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                    .addContainerGap(41, Short.MAX_VALUE)
                    .addComponent(rbn3v)
                    .addGap(1, 1, 1)))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(rbnprovol)
                    .addContainerGap(30, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout pnlNumericalRuntimeLayout = new javax.swing.GroupLayout(pnlNumericalRuntime);
        pnlNumericalRuntime.setLayout(pnlNumericalRuntimeLayout);
        pnlNumericalRuntimeLayout.setHorizontalGroup(
            pnlNumericalRuntimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNumericalRuntimeLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlNumericalRuntimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNumericalRuntimeLayout.createSequentialGroup()
                        .addComponent(lblTolerance)
                        .addGap(19, 19, 19)
                        .addComponent(txtTolerance, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlNumericalRuntimeLayout.createSequentialGroup()
                        .addGroup(pnlNumericalRuntimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblResolution)
                            .addComponent(lblMixing))
                        .addGap(1, 1, 1)
                        .addGroup(pnlNumericalRuntimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMixing, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlNumericalRuntimeLayout.createSequentialGroup()
                                .addComponent(txtResolution, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblResolutionAngstroms, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlNumericalRuntimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNumericalRuntimeLayout.createSequentialGroup()
                    .addContainerGap(241, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(16, 16, 16)))
        );
        pnlNumericalRuntimeLayout.setVerticalGroup(
            pnlNumericalRuntimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNumericalRuntimeLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlNumericalRuntimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblResolution, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlNumericalRuntimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtResolution, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblResolutionAngstroms, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlNumericalRuntimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTolerance, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTolerance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlNumericalRuntimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMixing, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMixing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(pnlNumericalRuntimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlNumericalRuntimeLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(68, Short.MAX_VALUE)))
        );

        btnSolve.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSolve.setForeground(java.awt.Color.red);
        btnSolve.setText("Run JACFC");
        btnSolve.setActionCommand("Run");
        btnSolve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolveActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Cytoskeleton FIlament Model", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Tahoma", 1, 14), java.awt.Color.blue), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), java.awt.Color.black)); // NOI18N

        pnlpHModel.setBackground(new java.awt.Color(255, 255, 255));
        pnlpHModel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Surface Charge and Radius Characterization", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 13))); // NOI18N
        pnlpHModel.setPreferredSize(new java.awt.Dimension(448, 46));

        rbnExperimentalData.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(rbnExperimentalData);
        rbnExperimentalData.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rbnExperimentalData.setText("Experimental Data");
        rbnExperimentalData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnExperimentalDataActionPerformed(evt);
            }
        });

        rbnTheoreticalPred.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(rbnTheoreticalPred);
        rbnTheoreticalPred.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rbnTheoreticalPred.setText("Molecular Structure");
        rbnTheoreticalPred.setToolTipText("<html><div style=\\\"text-align: left;\\\"<br>In this mode, <br>the user has to provide: <br>1) the filament   <br>molecular structure (pdb file); <br>2) A force field to obtain information <br>on atomic charges, sizes and positions  <br>comprising the molecular structure;  <br>3) the pH level to calculate the changes  <br>on the residue charges due to the  <br>protonation/deprotonation reactions. <br>This information is used to estimate the  <br>total charge of the macroion at the given  <br>pH and the total macroion volume. <br>Finally, these two parameters are used  <br>to estimate the effective uniform  <br>surface charge density and radius  <br>characterizing the symmetric like- macroion. ");
        rbnTheoreticalPred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnTheoreticalPredActionPerformed(evt);
            }
        });
        javax.swing.ToolTipManager.sharedInstance().setDismissDelay(10000);

        lblSoluteChargeType.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSoluteChargeType.setText("*Surface Charge:");
        lblSoluteChargeType.setEnabled(false);

        txtSoluteCharge.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSoluteCharge.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSoluteCharge.setText("-2.74");
        txtSoluteCharge.setToolTipText("<html><div style=\\\"text-align: left;\\\"<br>Define in Angstrom units the electron charge / axial charge density  <br>");
        txtSoluteCharge.setEnabled(false);
        txtSoluteCharge.setPreferredSize(new java.awt.Dimension(58, 28));
        txtSoluteCharge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoluteChargeActionPerformed(evt);
            }
        });
        txtSoluteCharge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSoluteChargeKeyTyped(evt);
            }
        });

        lblSoluteChargeUnits.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblSoluteChargeUnits.setText("[C/m2]");
        lblSoluteChargeUnits.setEnabled(false);

        lblForceField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblForceField.setText("*Select Force Field:");
        lblForceField.setEnabled(false);

        cmbForceField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbForceField.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AMBER", "PARSE", "SWANSON", "CHARMM", "PEOEPB", "TYL06" }));
        cmbForceField.setEnabled(false);
        cmbForceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbForceFieldActionPerformed(evt);
            }
        });

        btnJmol.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnJmol.setText("Molecular Visualization");
        btnJmol.setEnabled(false);
        btnJmol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJmolActionPerformed(evt);
            }
        });

        lblpHValue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblpHValue.setText("*pH Value:");
        lblpHValue.setEnabled(false);

        txtPh.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPh.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPh.setToolTipText("");
        txtPh.setEnabled(false);
        txtPh.setMinimumSize(new java.awt.Dimension(58, 28));
        txtPh.setPreferredSize(new java.awt.Dimension(58, 28));
        txtPh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPhKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPhKeyReleased(evt);
            }
        });

        btnPDB2PQR.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnPDB2PQR.setText("Load PDB File");
        btnPDB2PQR.setEnabled(false);
        btnPDB2PQR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDB2PQRActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(null);

        lblSoluteRadius.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSoluteRadius.setText("*Radius:");
        lblSoluteRadius.setEnabled(false);

        txtSoluteRadius.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSoluteRadius.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSoluteRadius.setText("23.83");
        txtSoluteRadius.setToolTipText("<html><div style=\\\"text-align: left;\\\"<br>Define the effective radius to characterize the filament size <br>");
        txtSoluteRadius.setEnabled(false);
        txtSoluteRadius.setPreferredSize(new java.awt.Dimension(58, 28));
        txtSoluteRadius.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoluteRadiusActionPerformed(evt);
            }
        });
        txtSoluteRadius.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSoluteRadiusKeyTyped(evt);
            }
        });

        lblSoluteAngstroms.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblSoluteAngstroms.setText("[A]");
        lblSoluteAngstroms.setEnabled(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(lblSoluteRadius)
                .addGap(6, 6, 6)
                .addComponent(txtSoluteRadius, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(lblSoluteAngstroms))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSoluteRadius, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoluteRadius, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSoluteAngstroms, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblSoluteRadius.getAccessibleContext().setAccessibleParent(pnlpHModel);
        txtSoluteRadius.getAccessibleContext().setAccessibleParent(pnlpHModel);
        lblSoluteAngstroms.getAccessibleContext().setAccessibleParent(pnlpHModel);

        jButton1.setText("Illustration");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                molecstrucActionPerformed(evt);
            }
        });

        jButton2.setText("Illustration");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expdataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlpHModelLayout = new javax.swing.GroupLayout(pnlpHModel);
        pnlpHModel.setLayout(pnlpHModelLayout);
        pnlpHModelLayout.setHorizontalGroup(
            pnlpHModelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlpHModelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlpHModelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbnExperimentalData)
                    .addGroup(pnlpHModelLayout.createSequentialGroup()
                        .addComponent(lblSoluteChargeType)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoluteCharge, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(lblSoluteChargeUnits, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(pnlpHModelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlpHModelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnlpHModelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlpHModelLayout.createSequentialGroup()
                                .addComponent(lblpHValue)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnJmol, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44))
                            .addGroup(pnlpHModelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblForceField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbForceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnPDB2PQR)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(pnlpHModelLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(rbnTheoreticalPred, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(pnlpHModelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlpHModelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(482, Short.MAX_VALUE)))
            .addGroup(pnlpHModelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlpHModelLayout.createSequentialGroup()
                    .addContainerGap(493, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(53, Short.MAX_VALUE)))
            .addGroup(pnlpHModelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlpHModelLayout.createSequentialGroup()
                    .addGap(169, 169, 169)
                    .addComponent(jButton2)
                    .addContainerGap(408, Short.MAX_VALUE)))
        );
        pnlpHModelLayout.setVerticalGroup(
            pnlpHModelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlpHModelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlpHModelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbnExperimentalData)
                    .addComponent(rbnTheoreticalPred))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlpHModelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSoluteChargeType, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoluteCharge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSoluteChargeUnits, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblForceField)
                    .addComponent(cmbForceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPDB2PQR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlpHModelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblpHValue)
                    .addComponent(txtPh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnJmol))
                .addGap(34, 34, 34))
            .addGroup(pnlpHModelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlpHModelLayout.createSequentialGroup()
                    .addContainerGap(72, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(pnlpHModelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlpHModelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jButton1)
                    .addContainerGap(99, Short.MAX_VALUE)))
            .addGroup(pnlpHModelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlpHModelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jButton2)
                    .addContainerGap(99, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(pnlpHModel, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlpHModel, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlpHModel.getAccessibleContext().setAccessibleName("");

        btnSolve1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSolve1.setText("<html><div style=\\\"text-align: center;\\\"<br>Generate Input File");
        btnSolve1.setToolTipText("");
        btnSolve1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolve1ActionPerformed(evt);
            }
        });

        progressBar.setStringPainted(true);

        taskOutput.setBackground(java.awt.Color.white);
        taskOutput.setColumns(20);
        taskOutput.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        taskOutput.setRows(5);
        taskOutput.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Progress Update", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jScrollPane3.setViewportView(taskOutput);

        saveresults.setText("Download Results");
        saveresults.setEnabled(false);
        saveresults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveresultsActionPerformed(evt);
            }
        });

        emailaddress.setText("write your email here !");
        emailaddress.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnlElectrolyteDefinition, javax.swing.GroupLayout.PREFERRED_SIZE, 1175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlNumericalRuntime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSolve, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(246, 246, 246))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(emailaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(673, Short.MAX_VALUE)
                    .addComponent(btnSolve1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(439, 439, 439)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(808, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(393, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(525, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(988, Short.MAX_VALUE)
                    .addComponent(saveresults)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlElectrolyteDefinition, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(pnlNumericalRuntime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSolve, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(emailaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(587, Short.MAX_VALUE)
                    .addComponent(btnSolve1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(43, 43, 43)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(596, Short.MAX_VALUE)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(59, 59, 59)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(580, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(32, 32, 32)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(604, Short.MAX_VALUE)
                    .addComponent(saveresults)
                    .addGap(59, 59, 59)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSolve1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolve1ActionPerformed
        /* This button correspond to "SOLVE" button, once the user hits this button the
        * program will create and save the input file, then the program will call
        * the fortran executable to start the computations. When the calculation are
        * finished a new window will pops up to select the plot type.
        */
        // this button is not used in the current version of the program
        // Get ion data
        progressBar.setString("CSDFT is running.... !!");
        int i=0;
        if (tblIonData.getRowCount()==0){
            JOptionPane.showMessageDialog(null, "Please add ions to the electrolyte and try again.",
                "ERROR", JOptionPane.ERROR_MESSAGE);
        }else{
            for (i = 0; i < tblIonData.getRowCount(); i++){
                Ions.symbol[i] = tblIonData.getValueAt(i, 0).toString();
                Ions.valence[i] = tblIonData.getValueAt(i, 1).toString();
                Ions.concentration[i] = tblIonData.getValueAt(i, 2).toString();
                if(null != Utilities.getTheoryModel())
                switch (Utilities.getTheoryModel()) {
                    case "PB":
                    Ions.strDiameter[i] = "1.0";
                    break;
                    case "SPM":
                    Ions.strDiameter[i] = tblIonData.getValueAt(i, 3).toString();
                    break;
                }
            }
        }
        // Get Solvent data
        Solvent.setDielectric(txtDielectricConstant.getText());
        if("SPM".equals(Utilities.getTheoryModel())){
            if (tblIonData.getRowCount() > 0) {
                // Solvent.setDielectric(txtDielectricConstant.getText());
                Solvent.setValence("0.0");
                Solvent.setConcentration(txtSolventConcentration.getText());
                Solvent.setDiameter(txtSolventDiameter.getText());
                Ions.symbol[i] = "H2O";
                Ions.valence[i] = Solvent.getValence();
                Ions.concentration[i] = Solvent.getConcentration();
                Ions.strDiameter[i] = Solvent.getDiameter();
                Ions.setCounter(tblIonData.getRowCount() + 1);
            }else{
                return;
            }
        }else{
            Solvent.setValence("0.0");
            Solvent.setConcentration(txtSolventConcentration.getText());
            Solvent.setDiameter(txtSolventDiameter.getText());
            Ions.symbol[i] = "H2O";
            Ions.valence[i] = Solvent.getValence();
            Ions.concentration[i] = "55.56";
            Ions.strDiameter[i] = "2.75";
            Ions.setCounter(tblIonData.getRowCount() + 1);
        }
        ThermodynamicProperties.setTemperature(txtTemperature.getText());
        // Get numerical definition
        NumericalScheme.setResolution(txtResolution.getText());
        NumericalScheme.setTolerance(txtTolerance.getText());
        NumericalScheme.setMixing(txtMixing.getText());
        // get solute data
        //Solute.setRadius(txtSoluteRadius.getText());
        //Solute.setCharge(txtSoluteCharge.getText());
        if (null != SolverModel.getModel())switch (SolverModel.getModel()) {
            case "PROTEIN":
            PHModel.setpH(txtPh.getText());
            //PHModel.setpH("7.0");
            break;
            case "OTHER":
            PHModel.setpH("0.0");
            Solute.setRadius(txtSoluteRadius.getText());
            Solute.setCharge(txtSoluteCharge.getText());
            break;
        }
        /* Check if electroneutrality condiction is not satisfied, erase all the
        * array values, restart ion counter, electroneutrality and temporal elec.
        * When the electroneutrality is satisfied, create-save the input file and
        * call the fortran executable.
        */
        if (0.0 != Ions.getNeutrality()
            || !"0.0".equals(lblElectroValue.getText())){
            Arrays.fill(Ions.symbol, null );
            Arrays.fill(Ions.valence, null);
            Arrays.fill(Ions.concentration, null);
            Arrays.fill(Ions.strDiameter, null);
            Ions.setNeutrality(0.0);
            Ions.tempNeutrality = 0.0;
            Ions.setCounter(0);
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, ShowMessages.getElectroneutralityNotSatisfied(),
                "ERROR", JOptionPane.ERROR_MESSAGE);
        } else{
            SetEnvironment.create_subdirectories();
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            // timer
            long lStartTime = System.nanoTime();
            File f2 = new File("waitfile.tmp");
            switch (Solute.getType()){
                case "SPHERE":
                WriteFiles.write_sphere();
                {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(BiomoleculesUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                while(f2.exists() && !f2.isDirectory()) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(RunAnalysis.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case "CYLINDER":
                WriteFiles.write_cylinder();
                {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(BiomoleculesUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                while(f2.exists() && !f2.isDirectory()) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(RunAnalysis.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            }

            String dst3 = Utilities.getAnalysisPath()
            +"/" + "vol.txt";
            String src3 = "vol.txt";
            MoveFiles.move_Files(src3, dst3);
            String dst4 = Utilities.getAnalysisPath()
            +"/" + "radiusandcharge.txt";
            String src4 = "radiusandcharge.txt";
            MoveFiles.move_Files(src4, dst4);
            String dst6 = Utilities.getAnalysisPath()
            +"/" + "lengthandcharge.txt";
            String src6 = "lengthandcharge.txt";
            MoveFiles.move_Files(src6, dst6);

            String dst7 = Utilities.getAnalysisPath()
            +"/" + "input.pqr";
            String src7 = "input.pqr";
            MoveFiles.move_Files(src7, dst7);

            String dst8 = Utilities.getAnalysisPath()
            +"/" + "input.propka";
            String src8 = "input.propka";
            MoveFiles.move_Files(src8, dst8);

            if (!rbnprovol.isSelected()){
                // move text files to the output directory
                String dst2 = Utilities.getAnalysisPath()
                +"/" + "input.pdb";
                String src2 = "input.pdb";
                MoveFiles.move_Files(src2, dst2);
                String dst = Utilities.getAnalysisPath()
                +"/" + "out.pdb";
                String src = "out.pdb";
                MoveFiles.move_Files(src, dst);
                String dst5 = Utilities.getAnalysisPath()
                +"/" + "out.xyzr";
                String src5 = "out.xyzr";
                MoveFiles.move_Files(src5, dst5);
            }
            // timer
            long lEndTime = System.nanoTime();
            long output = lEndTime - lStartTime;
            System.out.println("Elapsed time in seconds: " + output / 1000000000);
        }
        setCursor(null);
        rbnprovol.setEnabled(true);
        rbn3v.setEnabled(true);
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSolve1ActionPerformed

    private void expdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expdataActionPerformed
        // TODO add your handling code here:
        //show image
        String filename = "build/classes/Images/experimentalmodel.png";
        //if (args.length>0) filename = args[0];
        JFrame f1 = new JFrame("Experimental Biomolecule Model");
        //f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.add(new LoadImageApp(filename));
        f1.pack();
        f1.setLocationRelativeTo(null);
        f1.setVisible(true);
    }//GEN-LAST:event_expdataActionPerformed

    private void molecstrucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_molecstrucActionPerformed
          // TODO add your handling code here:

//                  String[] model = new String[1];
//                  model[0] = "/home/mdmlab5/Downloads/3B5U.pdb";
//                  Integration.main(model);
//            Integration molview = new Integration(); 
//            molview.setVisible(true);
        //show image
        String filename = "build/classes/Images/biomoleculemodel.png";
        //if (args.length>0) filename = args[0];
        JFrame f1 = new JFrame("Biomolecule and Molecular Structure Model");
        //f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.add(new LoadImageApp(filename));
        f1.pack();
        f1.setLocationRelativeTo(null);
        f1.setVisible(true);
    }//GEN-LAST:event_molecstrucActionPerformed

    private void txtSoluteRadiusKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoluteRadiusKeyTyped
        // Validate only numbers
        char c = evt.getKeyChar();
        if (c == KeyEvent.VK_PERIOD && txtSoluteRadius.getText().contains(".")){
            getToolkit().beep();
            evt.consume();
        }
        if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE
            && c != KeyEvent.VK_DELETE && c != KeyEvent.VK_PERIOD){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtSoluteRadiusKeyTyped

    private void txtSoluteRadiusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoluteRadiusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoluteRadiusActionPerformed

    private void btnPDB2PQRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDB2PQRActionPerformed
    // initizialization of the molecular structure worker to run in background
        task = new Task();
        task.addPropertyChangeListener(this);
        task.execute();                  
    }//GEN-LAST:event_btnPDB2PQRActionPerformed

    private void txtPhKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhKeyReleased

    private void txtPhKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhKeyTyped

    private void btnJmolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJmolActionPerformed
        // For visualization or computations, open Jmol.
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

            Jmolapp jmolapp = new Jmolapp();
            jmolapp.setVisible(true);                
            setCursor(null);
    }//GEN-LAST:event_btnJmolActionPerformed

    private void cmbForceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbForceFieldActionPerformed
        // Save selected forcefield
        Object SelectedItem = cmbForceField.getSelectedItem();
        PHModel.get_force_field((String) SelectedItem);
    }//GEN-LAST:event_cmbForceFieldActionPerformed

    private void txtSoluteChargeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoluteChargeKeyTyped
        // Validate only numbers
        char c = evt.getKeyChar();
        if (c == KeyEvent.VK_PERIOD && txtSoluteCharge.getText().contains(".")){
            getToolkit().beep();
            evt.consume();
        }
        //    if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE
            //        && c != KeyEvent.VK_DELETE && c != KeyEvent.VK_PERIOD){
            //        getToolkit().beep();
            //        evt.consume();
            //    }
        if (c != KeyEvent.VK_MINUS && !Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE
            && c != KeyEvent.VK_DELETE && c != KeyEvent.VK_PERIOD){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtSoluteChargeKeyTyped

    private void txtSoluteChargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoluteChargeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoluteChargeActionPerformed

    private void rbnTheoreticalPredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnTheoreticalPredActionPerformed
        // If pH approach is selected for Proteins using theoretical model
        // proceed with the following statement
        if(rbnTheoreticalPred.isSelected()){
            set_enabled_ESoluteData_false();
            set_enabled_TSoluteData_true();
            btnSolve.setEnabled(false);
            btnSolve1.setEnabled(false);
            btnJmol.setEnabled(false);
            rbnprovol.setEnabled(false);
            rbn3v.setEnabled(false);
            PHModel.setusepH("YES");
            SolverModel.setModel("PROTEIN");
            lblpHValue.setEnabled(true);
            txtPh.setEnabled(true);
            txtPh.setText("7.0");
            txtPh.setBackground(Color.WHITE);
            cmbForceField.setEnabled(true);
        }else {
            set_enabled_TSoluteData_false();
            set_enabled_ESoluteData_false();
            buttonGroup3.clearSelection();
        }
    }//GEN-LAST:event_rbnTheoreticalPredActionPerformed

    private void rbnExperimentalDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnExperimentalDataActionPerformed
        // If pH approach is selected for Proteins using experimental model
        // proceed with the following statement
        if (rbnExperimentalData.isSelected()){
          progressBar.setString("CSDFT may take several minutes !!");
           btnSolve.setEnabled(true);
            SolverModel.setModel("OTHER");
            set_enabled_TSoluteData_false();
            set_enabled_ESoluteData_true();
            //Toolkit.getDefaultToolkit().beep();
            //    JOptionPane.showMessageDialog(null, ShowMessages.getaddPH(),
                //       "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
            // calculate_new_concentration();
        }else{
            set_enabled_TSoluteData_false();
            set_enabled_ESoluteData_false();
            buttonGroup3.clearSelection();
        }


    }//GEN-LAST:event_rbnExperimentalDataActionPerformed

    private void btnSolveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolveActionPerformed
        //    try {
            /* This button correspond to "SOLVE" button, once the user hits this button the
            * program will create and save the input file, then the program will call
            * the fortran executable to start the computations. When the calculation are
            * finished a new window will pops up to select the plot type.
            */
        // read all parameters to generate the input file
        int i=0;
        if (tblIonData.getRowCount()==0){
            JOptionPane.showMessageDialog(null, "Please add ions to the electrolyte and try again.",
                "ERROR", JOptionPane.ERROR_MESSAGE);
        }else{
            for (i = 0; i < tblIonData.getRowCount(); i++){
                Ions.symbol[i] = tblIonData.getValueAt(i, 0).toString();
                Ions.valence[i] = tblIonData.getValueAt(i, 1).toString();
                Ions.concentration[i] = tblIonData.getValueAt(i, 2).toString();
                if(null != Utilities.getTheoryModel())
                switch (Utilities.getTheoryModel()) {
                    case "PB":
                    Ions.strDiameter[i] = "1.0";
                    break;
                    case "SPM":
                    Ions.strDiameter[i] = tblIonData.getValueAt(i, 3).toString();
                    break;
                }
            }
        }
        // Get Solvent data
        Solvent.setDielectric(txtDielectricConstant.getText());
        if("SPM".equals(Utilities.getTheoryModel())){
            if (tblIonData.getRowCount() > 0) {
                // Solvent.setDielectric(txtDielectricConstant.getText());
                Solvent.setValence("0.0");
                Solvent.setConcentration(txtSolventConcentration.getText());
                Solvent.setDiameter(txtSolventDiameter.getText());
                Ions.symbol[i] = "H2O";
                Ions.valence[i] = Solvent.getValence();
                Ions.concentration[i] = Solvent.getConcentration();
                Ions.strDiameter[i] = Solvent.getDiameter();
                Ions.setCounter(tblIonData.getRowCount() + 1);
            }else{
                return;
            }
        }else{
            Solvent.setValence("0.0");
            Solvent.setConcentration(txtSolventConcentration.getText());
            Solvent.setDiameter(txtSolventDiameter.getText());
            Ions.symbol[i] = "H2O";
            Ions.valence[i] = Solvent.getValence();
            Ions.concentration[i] = "55.56";
            Ions.strDiameter[i] = "2.75";
            Ions.setCounter(tblIonData.getRowCount() + 1);
        }
        // get solver configuration
        ThermodynamicProperties.setTemperature(txtTemperature.getText());
        NumericalScheme.setResolution(txtResolution.getText());
        NumericalScheme.setTolerance(txtTolerance.getText());
        NumericalScheme.setMixing(txtMixing.getText());
        // get solute data
        //Solute.setRadius(txtSoluteRadius.getText());
        //Solute.setCharge(txtSoluteCharge.getText());
        if (null != SolverModel.getModel())switch (SolverModel.getModel()) {
            case "PROTEIN":
            PHModel.setpH(txtPh.getText());
            //PHModel.setpH("7.0");
            break;
            case "OTHER":
            PHModel.setpH("0.0");
            Solute.setRadius(txtSoluteRadius.getText());
            Solute.setCharge(txtSoluteCharge.getText());
            break;
        }
        /* Check if electroneutrality condiction is not satisfied, erase all the
        * array values, restart ion counter, electroneutrality and temporal elec.
        * When the electroneutrality is satisfied, create-save the input file and
        * call the fortran executable.
        */
        if (0.0 != Ions.getNeutrality()
            || !"0.0".equals(lblElectroValue.getText())){
            Arrays.fill(Ions.symbol, null );
            Arrays.fill(Ions.valence, null);
            Arrays.fill(Ions.concentration, null);
            Arrays.fill(Ions.strDiameter, null);
            Ions.setNeutrality(0.0);
            Ions.tempNeutrality = 0.0;
            Ions.setCounter(0);
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, ShowMessages.getElectroneutralityNotSatisfied(),
                "ERROR", JOptionPane.ERROR_MESSAGE);
        } else{
             if(rbnTheoreticalPred.isSelected()){
             } else {
                 SetEnvironment.create_subdirectories();
            }
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            // timer
            long lStartTime = System.nanoTime();
            File f2 = new File("waitfile.tmp");
            switch (Solute.getType()){
                case "SPHERE":
                // this case is not used in this version of the program

                        WriteFiles.write_sphere();
                        {
                            try {
                                RunAnalysis.run_sphere();
                            } catch (IOException ex) {
                                Logger.getLogger(BiomoleculesUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                //
                {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(BiomoleculesUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                while(f2.exists() && !f2.isDirectory()) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(RunAnalysis.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                String exe3 = "pkill -n watch ";
                RunAnalysis executable3 = new RunAnalysis(exe3);
                String exe5 = "pkill -f gnome-system-monitor ";
                RunAnalysis executable5 = new RunAnalysis(exe5);
                break;
                case "CYLINDER":
// initialize the worker to run the cylidrical CSDFT
        btnSolve.setEnabled(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
//        task.cancel(true);
        task2 = new Task2();
        task2.addPropertyChangeListener(this);
        task2.execute();           
            }

            // timer
            long lEndTime = System.nanoTime();
            long output = lEndTime - lStartTime;
            System.out.println("Elapsed time in seconds: " + output / 1000000000);
        }
    }//GEN-LAST:event_btnSolveActionPerformed

    private void rbnprovolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnprovolActionPerformed
        if (rbnprovol.isSelected()){
            rbn3v.setSelected(false);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_rbnprovolActionPerformed

    private void rbn3vActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbn3vActionPerformed
        // TODO add your handling code here:
        String openterm = Linuxenv();
        if (rbn3v.isSelected()){
            rbnprovol.setSelected(false);
            String exe3 = openterm + "./Linux/testgawk.sh";
            RunAnalysis executable3 = new RunAnalysis(exe3);
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(BiomoleculesUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            try{
                BufferedReader br = new BufferedReader(new FileReader("testgawk.tmp"));
                String strLine;
                if (br.readLine() == null) {
                    //System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    //System.out.println("It seems you don't have installed gawk. Please check it and try again!!");
                    //System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    rbnprovol.setSelected(true);
                    rbn3v.setSelected(false);
                    JOptionPane.showMessageDialog(null, "It seems that you don't have installed gawk on your computer. Please check it and try again!!",
                        "WARNING", JOptionPane.ERROR_MESSAGE);
                    String exe4 = openterm + "rm testgawk.tmp ";
                    RunAnalysis executable4 = new RunAnalysis(exe4);
                }
                String exe4 = openterm + "rm testgawk.tmp ";
                RunAnalysis executable4 = new RunAnalysis(exe4);
                //Read File Line By Line
                //while ((strLine = br.readLine()) != null)   {
                    // Print the content on the console

                    //  System.out.println (Solute.getCharge());
                    //}
                //Close the input stream
                in.close();
            }catch (Exception e){//Catch exception if any
                System.err.println("Error: " + e.getMessage());
            }
        }

    }//GEN-LAST:event_rbn3vActionPerformed

    private void txtMixingKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMixingKeyReleased
        // Validate txtMixing field only for values different than zero.
        if ("0.000000000000".equals(txtMixing.getText())){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, ShowMessages.getZeroResolution(),
                "ERROR", JOptionPane.ERROR_MESSAGE);
            txtMixing.setText("");
            txtMixing.requestFocus();
        }
    }//GEN-LAST:event_txtMixingKeyReleased

    private void txtMixingKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMixingKeyTyped
        // Validate only numbers
        char c = evt.getKeyChar();
        if (c == KeyEvent.VK_PERIOD && txtMixing.getText().contains(".")){
            getToolkit().beep();
            evt.consume();
        }
        if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE
            && c != KeyEvent.VK_DELETE && c != KeyEvent.VK_PERIOD){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtMixingKeyTyped

    private void txtResolutionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtResolutionKeyReleased
        // Validate txtResolution field only for values different than zero.
        if ("0.000000000000".equals(txtResolution.getText())){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, ShowMessages.getZeroResolution(),
                "ERROR", JOptionPane.ERROR_MESSAGE);
            txtResolution.setText("");
            txtResolution.requestFocus();
        }
    }//GEN-LAST:event_txtResolutionKeyReleased

    private void txtResolutionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtResolutionKeyTyped
        // Validate only numbers
        char c = evt.getKeyChar();
        if (c == KeyEvent.VK_PERIOD && txtResolution.getText().contains(".")){
            getToolkit().beep();
            evt.consume();
        }
        if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE
            && c != KeyEvent.VK_DELETE && c != KeyEvent.VK_PERIOD){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtResolutionKeyTyped

    private void txtResolutionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtResolutionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtResolutionActionPerformed

    private void txtToleranceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtToleranceKeyReleased
        // Validate txtResolution field only for values different than zero.
        if ("0.000000000000".equals(txtTolerance.getText())){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, ShowMessages.getZeroResolution(),
                "ERROR", JOptionPane.ERROR_MESSAGE);
            txtTolerance.setText("");
            txtTolerance.requestFocus();
        }
    }//GEN-LAST:event_txtToleranceKeyReleased

    private void txtToleranceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtToleranceKeyTyped
        // Validate only numbers
        char c = evt.getKeyChar();
        if (c == KeyEvent.VK_PERIOD && txtTolerance.getText().contains(".")){
            getToolkit().beep();
            evt.consume();
        }
        if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE
            && c != KeyEvent.VK_DELETE && c != KeyEvent.VK_PERIOD){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtToleranceKeyTyped

    private void txtTemperatureKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTemperatureKeyTyped
        // Validate only numbers
        char c = evt.getKeyChar();
        if (c == KeyEvent.VK_PERIOD && txtTemperature.getText().contains(".")){
            getToolkit().beep();
            evt.consume();
        }
        if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE
            && c != KeyEvent.VK_DELETE && c != KeyEvent.VK_PERIOD){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtTemperatureKeyTyped

    private void txtSolventConcentrationKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSolventConcentrationKeyTyped
        // Validate only numbers
        char c = evt.getKeyChar();
        if (c == KeyEvent.VK_PERIOD && txtSolventConcentration.getText().contains(".")){
            getToolkit().beep();
            evt.consume();
        }
        if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE
            && c != KeyEvent.VK_DELETE && c != KeyEvent.VK_PERIOD){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtSolventConcentrationKeyTyped

    private void txtSolventDiameterKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSolventDiameterKeyTyped
        // Validate only numbers
        char c = evt.getKeyChar();
        if (c == KeyEvent.VK_PERIOD && txtSolventDiameter.getText().contains(".")){
            getToolkit().beep();
            evt.consume();
        }
        if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE
            && c != KeyEvent.VK_DELETE && c != KeyEvent.VK_PERIOD){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtSolventDiameterKeyTyped

    private void txtDielectricConstantKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDielectricConstantKeyTyped
        // Validate only numbers
        char c = evt.getKeyChar();
        if (c == KeyEvent.VK_PERIOD && txtDielectricConstant.getText().contains(".")){
            getToolkit().beep();
            evt.consume();
        }
        if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE
            && c != KeyEvent.VK_DELETE && c != KeyEvent.VK_PERIOD){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtDielectricConstantKeyTyped

    private void rbnHydratedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnHydratedActionPerformed
        // TODO add your handling code here:
        if (rbnHydrated.isSelected()){
            String path = "HydratedIonLibrary.txt";
            Procedures.ReadFiles.read_libraries(path);
            pnlIonData.setEnabled(true);
            lblElectroValue.setText("0.0");
            lblElectroneutrality.setEnabled(true);
            cmbIon.setModel(new DefaultComboBoxModel());
            cmbIon.addItem("");
            txtIonDiameter.setText("");
            DefaultComboBoxModel dcm = new DefaultComboBoxModel();
            cmbValence.setModel(dcm);
            dcm.removeAllElements();
            for (int ii = 0; ii < IonLibrary.getNumLines(); ii++){
                cmbIon.addItem(IonLibrary.symbol[ii]);
            }
            cmbIon.setEnabled(true);
            lblIonSymbol.setEnabled(true);
            Ions.setCounter(Ions.getCounter() + 1);
            btnAdd.setEnabled(true);
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
            tblIonData.setEnabled(true);
        }else{
            pnlIonData.setEnabled(false);
        }
    }//GEN-LAST:event_rbnHydratedActionPerformed

    private void rbnEffectiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnEffectiveActionPerformed
        /* This radiobutton correspond to "EFFECTIVE DIAMETER", once the user selects
        * this option the peogram will read Shannon Effective Library.
        */
        if (rbnEffective.isSelected()){
            String path = "ShannonEffectiveIonLibrary.txt";
            Procedures.ReadFiles.read_libraries(path);
            pnlIonData.setEnabled(true);
            lblElectroValue.setText("0.0");
            lblElectroneutrality.setEnabled(true);
            cmbIon.setModel(new DefaultComboBoxModel());
            cmbIon.addItem("");
            txtIonDiameter.setText("");
            DefaultComboBoxModel dcm = new DefaultComboBoxModel();
            cmbValence.setModel(dcm);
            dcm.removeAllElements();
            for (int ii = 0; ii < IonLibrary.getNumLines(); ii++){
                cmbIon.addItem(IonLibrary.symbol[ii]);
            }
            cmbIon.setEnabled(true);
            lblIonSymbol.setEnabled(true);
            Ions.setCounter(Ions.getCounter() + 1);
            btnAdd.setEnabled(true);
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
            tblIonData.setEnabled(true);
        }else{
            pnlIonData.setEnabled(false);
        }
    }//GEN-LAST:event_rbnEffectiveActionPerformed

    private void rbnCrystalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnCrystalActionPerformed
        /* This radiobutton correspond to "CRYSTAL DIAMETER", once the user selects
        * this option the peogram will read Shannon Crystal Library.
        */
        if (rbnCrystal.isSelected()){
            String path = "ShannonCrystalIonLibrary.txt";
            Procedures.ReadFiles.read_libraries(path);
            pnlIonData.setEnabled(true);
            lblElectroValue.setText("0.0");
            lblElectroneutrality.setEnabled(true);
            cmbIon.setModel(new DefaultComboBoxModel());
            cmbIon.addItem("");
            txtIonDiameter.setText("");
            DefaultComboBoxModel dcm = new DefaultComboBoxModel();
            cmbValence.setModel(dcm);
            dcm.removeAllElements();
            for (int ii = 0; ii < IonLibrary.getNumLines(); ii++){
                cmbIon.addItem(IonLibrary.symbol[ii]);
            }
            cmbIon.setEnabled(true);
            lblIonSymbol.setEnabled(true);
            Ions.setCounter(Ions.getCounter() + 1);
            btnAdd.setEnabled(true);
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
            tblIonData.setEnabled(true);
        }else{
            pnlIonData.setEnabled(false);
        }
    }//GEN-LAST:event_rbnCrystalActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblIonData.getModel();
        if(tblIonData.getSelectedRow()==-1){
            if(tblIonData.getRowCount()==0){
                lblMessage.setText("Table is empty");
            }else{
                lblMessage.setText("You must select an ion");
            }
        }else{
            String rho_del;
            String z_del;
            double prev, prev2;
            z_del = model.getValueAt(tblIonData.getSelectedRow(), 1).toString();
            rho_del = model.getValueAt(tblIonData.getSelectedRow(), 2).toString();
            prev = Double.parseDouble(z_del)*Double.parseDouble(rho_del);
            prev2 = Double.parseDouble(lblElectroValue.getText()) - prev;
            lblElectroValue.setText(String.valueOf(prev2));

            model.removeRow(tblIonData.getSelectedRow());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        lblMessage.setText("");
        DefaultTableModel model = (DefaultTableModel) tblIonData.getModel();
        if(tblIonData.getSelectedRow()==-1){
            if(tblIonData.getRowCount()==0){
                lblMessage.setText("Table is empty");
            }else{
                lblMessage.setText("You must select an ion");
            }
        }else{
            double rho;
            double z;
            String rho_del;
            String z_del;
            double prev, prev2;
            z_del = model.getValueAt(tblIonData.getSelectedRow(), 1).toString();
            rho_del = model.getValueAt(tblIonData.getSelectedRow(), 2).toString();
            prev = Double.parseDouble(z_del)*Double.parseDouble(rho_del);
            prev2 = Double.parseDouble(lblElectroValue.getText()) - prev;
            lblElectroValue.setText(String.valueOf(prev2));

            model.setValueAt(cmbIon.getSelectedItem().toString(), tblIonData.getSelectedRow(),0);
            model.setValueAt(cmbValence.getSelectedItem().toString(), tblIonData.getSelectedRow(),1);
            model.setValueAt(txtIonConcentration.getText(), tblIonData.getSelectedRow(),2);
            model.setValueAt(txtIonDiameter.getText(), tblIonData.getSelectedRow(),3);

            prev = Double.parseDouble(lblElectroValue.getText());
            z = Double.parseDouble(cmbValence.getSelectedItem().toString());
            rho = Double.parseDouble(txtIonConcentration.getText());
            Ions.get_electroneutrality(prev, z, rho);
            lblElectroValue.setText(String.valueOf(Ions.getNeutrality()));
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        lblMessage.setText("");
        DefaultTableModel model = (DefaultTableModel) tblIonData.getModel();
        if(!txtIonConcentration.getText().trim().equals("") && !txtIonDiameter.getText().trim().equals("")){
            model.addRow(new Object[]{cmbIon.getSelectedItem().toString(),cmbValence.getSelectedItem().toString(),txtIonConcentration.getText(),txtIonDiameter.getText()});
            double rho;
            double z;
            double prev;
            prev = Double.parseDouble(lblElectroValue.getText());
            z = Double.parseDouble(cmbValence.getSelectedItem().toString());
            rho = Double.parseDouble(txtIonConcentration.getText());
            Ions.get_electroneutrality(prev, z, rho);
            lblElectroValue.setText(String.valueOf(Ions.getNeutrality()));
        }else if(txtIonConcentration.getText().trim().equals("")){
            lblMessage.setText("Ion concentration should not be left in blank");
        }else if(txtIonDiameter.getText().trim().equals("")){
            lblMessage.setText("Ion diameter should not be left in blank");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblIonDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblIonDataMouseClicked
        DefaultTableModel model = (DefaultTableModel) tblIonData.getModel();
        cmbIon.setSelectedItem(model.getValueAt(tblIonData.getSelectedRow(),0).toString());
        cmbValence.setSelectedItem(model.getValueAt(tblIonData.getSelectedRow(),1).toString());
        txtIonConcentration.setText(model.getValueAt(tblIonData.getSelectedRow(),2).toString());
        txtIonDiameter.setText(model.getValueAt(tblIonData.getSelectedRow(),3).toString());
    }//GEN-LAST:event_tblIonDataMouseClicked

    private void cmbValenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbValenceActionPerformed
        // This button correspond to "COMBOBOX" to select the valence.
        //cmbValence.setEditable(cmbIon.`);
        Object SelectedItem = cmbValence.getSelectedItem();
        get_valence_change((String) SelectedItem, txtIonDiameter);
    }//GEN-LAST:event_cmbValenceActionPerformed

    private void txtIonDiameterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIonDiameterKeyReleased
        if ("0.0000000000000".equals(txtIonDiameter.getText())){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, ShowMessages.getZeroIonDiameter(),
                "ERROR", JOptionPane.ERROR_MESSAGE);
            txtIonDiameter.setText("");
            txtIonDiameter.requestFocus();
        }
    }//GEN-LAST:event_txtIonDiameterKeyReleased

    private void txtIonDiameterKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIonDiameterKeyTyped
        // Validate only numbers
        char c = evt.getKeyChar();
        if (c == KeyEvent.VK_PERIOD && txtIonDiameter.getText().contains(".")){
            getToolkit().beep();
            evt.consume();
        }
        if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE
            && c != KeyEvent.VK_DELETE && c != KeyEvent.VK_PERIOD){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtIonDiameterKeyTyped

    private void txtIonConcentrationKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIonConcentrationKeyReleased
        if ("0.0000000000000".equals(txtIonConcentration.getText())){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, ShowMessages.getZeroIonConcentration(),
                "ERROR", JOptionPane.ERROR_MESSAGE);
            txtIonConcentration.setText("");
            txtIonConcentration.requestFocus();
        }
    }//GEN-LAST:event_txtIonConcentrationKeyReleased

    private void txtIonConcentrationKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIonConcentrationKeyTyped
        // Validate only numbers
        txtIonConcentration.setBackground(Color.WHITE);
        char c = evt.getKeyChar();
        if (c == KeyEvent.VK_PERIOD && txtIonConcentration.getText().contains(".")){
            getToolkit().beep();
            evt.consume();
        }
        if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE
            && c != KeyEvent.VK_DELETE && c != KeyEvent.VK_PERIOD){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtIonConcentrationKeyTyped

    private void txtIonConcentrationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIonConcentrationMouseClicked
        // Clear contents
        txtIonConcentration.setText("");
    }//GEN-LAST:event_txtIonConcentrationMouseClicked

    private void cmbIonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbIonActionPerformed
        DefaultComboBoxModel dcm = new DefaultComboBoxModel();
        cmbValence.setModel(dcm);
        dcm.removeAllElements();
        Object SelectedItem = cmbIon.getSelectedItem();
        IonLibrary.get_selected_ion(SelectedItem);
        /* Call function to show in the GUI what are the options of the selected
        Ion for the valence.                                               */
        get_valence_diameter(cmbValence, txtIonDiameter);
        cmbIon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                // Get the source of the component, which is our combo box.
                JComboBox comboBox = (JComboBox) event.getSource();
                Object selected = comboBox.getSelectedItem();
                if (selected != null){
                    lblIonValence.setEnabled(true);
                    lblIonConcentration.setEnabled(true);
                    cmbValence.setEnabled(true);
                    txtIonConcentration.setEnabled(true);
                    if (null != Utilities.getTheoryModel())
                    switch (Utilities.getTheoryModel()) {
                        case "PB":
                        lblIonDiameter.setEnabled(false);
                        txtIonDiameter.setEnabled(false);
                        break;
                    }else {
                        lblIonDiameter.setEnabled(true);
                        txtIonDiameter.setEnabled(true);
                    }
                }else{
                    lblIonValence.setEnabled(false);
                    lblIonConcentration.setEnabled(false);
                    lblIonDiameter.setEnabled(false);
                    cmbValence.setEnabled(false);
                    txtIonConcentration.setEnabled(false);
                    txtIonDiameter.setEnabled(false);
                }
            }
        });
    }//GEN-LAST:event_cmbIonActionPerformed

    private void cmbIonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbIonMouseReleased
        // NOT VALID
    }//GEN-LAST:event_cmbIonMouseReleased

    private void saveresultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveresultsActionPerformed
//        new EmailUI().setVisible(true);
           String todayAsString = 
                    new SimpleDateFormat("MM-dd-yyyy__HH-mm-ss").
                            format(new Date());
        String exe24 = Utilities.getAnalysisPath();
        File dir = new File(exe24);
        String zipDir = Utilities.getAnalysisPath()+
        File.separatorChar +todayAsString +"_"+ "simulationresults.zip";
        ZipFiles.zipDirectory(dir, zipDir);
        if (Desktop.isDesktopSupported()) {
            try {
                //               ZipFiles zipFiles = new ZipFiles();
                String zipDirName = Utilities.getAnalysisPath()+
                File.separatorChar +todayAsString +"_"+ "simulationresults.zip";
                File f = new File(zipDirName);
                // System.out.println(f.getAbsolutePath());//
                if(f.exists() && !f.isDirectory()){
                    File myFile = new File(zipDirName);
                    Desktop.getDesktop().open(myFile);
                }else{
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null,
                        ShowMessages.getOpenUserManual(), null,
                        JOptionPane.WARNING_MESSAGE);
                }
            } catch (IOException ex) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null,
                    ShowMessages.getNoPDFSoftware(), null,
                    JOptionPane.ERROR_MESSAGE);
            }
        }
        //          String exe2 = "rm "+zipDir;
        //          RunAnalysis executable2 = new RunAnalysis(exe2);
        // SMTP info

//        String host = "smtp.gmail.com";
//        String port = "587";
//        String mailFrom = "falseemail";
//        String password = "falsepass";     
// 
//        // message info
//        String mailTo = emailaddress.getText();
//        String subject = "JACFC simulation results";
//        String message = "Thanks for using JACFC. Replay to this email if you have any question";
// 
//        // attachments
//        
//        String[] attachFiles = new String[1];
//       // attachFiles[0] =  Utilities.getAnalysisPath()+ File.separatorChar + "simulationresults.zip";
//        attachFiles[0] = zipDir;
//        Thread t = new Thread(new Runnable(){
//        public void run(){
//            JOptionPane.showMessageDialog(null, "Email Sent. Thanks !!", "WAIT ! sending email...",
//    JOptionPane.PLAIN_MESSAGE);
//        }
//    });
//  t.start();
//        try {
//            sendEmailWithAttachments(host, port, mailFrom, password, mailTo,
//            subject, message, attachFiles);
//            System.out.println("Email sent.");
//            emailaddress.setText("Email sent !.");
//        } catch (Exception ex) {
//            System.out.println("Could not send email.");
//            emailaddress.setText("Could not send email.");
//            ex.printStackTrace();
//        }
    }//GEN-LAST:event_saveresultsActionPerformed
public void propertyChange(PropertyChangeEvent evt) {
        
        if ("progress" == evt.getPropertyName()) {
            int progress = (Integer) evt.getNewValue();
            progressBar.setValue(progress);
             taskOutput.append(String.format(
                    "Completed %d%% of the Calculations.\n", progress));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

class Task extends SwingWorker<Void, Void> {
        /*
         * Main task. Executed in background thread.
         */
    // this worker calculate the Molecular structure calculations and 
    // generate the filament surface charge density and radius
        @Override
        public Void doInBackground() {

    //new code to generate capacitance and parameter b
                String[] strlabel = new String[5];
                strlabel[0] = "Loading the Uncharged Molecular Structure File..";
                strlabel[1] = "Adding Atomic Charge to the Molecular Structure..";
                strlabel[2] = "Calculating Filament Surface Charge and Radius..";
                strlabel[3] = "Calculating Filament Surface Charge and Radius..";
                strlabel[4] = "Final Calculations..";      
                int[] porc = new int[4];
                 porc[0]=15;
                 porc[1]=45;
                 porc[2]=75;
                 porc[3]=95;
          SetEnvironment.create_subdirectories();

// new for biomolecules (pdb2pqr btn)
               setProgress(porc[0]);
               progressBar.setString(strlabel[0]);
       LoadFiles.load_pdb_file();
       try {
        Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(BiomoleculesUI.class.getName()).log(Level.SEVERE, null, ex);
        }
                      setProgress(porc[1]);
               progressBar.setString(strlabel[1]);
        if(!"".equals(PHModel.pathPDB)
            && PHModel.getPathPDB().length() > 55){
            //lblPDBPath.setText(PHModel.getPathPDB().substring(0,55)
                //+ "...");
        }else if (!"".equals(PHModel.pathPDB)){
            //lblPDBPath.setText(PHModel.getPathPDB());
        }
        PHModel.setpH(txtPh.getText());
        Object SelectedItem = cmbForceField.getSelectedItem();
        PHModel.setForceField(String.valueOf(SelectedItem));
        //PHModel.setPathPQR(PHModel.getPathPDB2PQR().replace(ext, TargetExt));
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
         String ddir = Utilities.getAnalysisPath()+ File.separator +"waitfile.tmp";
        File f = new File(ddir);
        try {
            boolean fvar = f.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(BiomoleculesUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            RunAnalysis.run_pdb2pqr();
        } catch (IOException ex) {
            Logger.getLogger(BiomoleculesUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        while(f.exists() && !f.isDirectory()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(BiomoleculesUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        setProgress(porc[2]);
        if (rbnprovol.isSelected()){
               progressBar.setString(strlabel[2]);
            RunAnalysis.run_volume();
        }else{
            try {
                progressBar.setString(strlabel[3]);
                RunAnalysis.run_pdb2xyzr();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(BiomoleculesUI.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        try {
        Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(BiomoleculesUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        while(f.exists() && !f.isDirectory()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(BiomoleculesUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        setProgress(porc[3]);
         progressBar.setString(strlabel[4]);
        try{
            String radiuscharge = "radiusandcharge_"+PHModel.getUserTime()+".txt";
            BufferedReader br = new BufferedReader(new FileReader(radiuscharge));
            String strLine;
            //Read File Line By Line
            //while ((strLine = br.readLine()) != null)   {
                // Print the content on the console
                strLine = br.readLine();
                Solute.setRadius(strLine);
                //  System.out.println (Solute.getRadius());
                strLine = br.readLine();
                Solute.setCharge(strLine);
                //  System.out.println (Solute.getCharge());
                //}
            //Close the input stream
            in.close();
        }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }finally{
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(BiomoleculesUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        setCursor(null);
        btnJmol.setEnabled(true);
        btnSolve.setEnabled(true);
        btnSolve1.setEnabled(true);
       
// result visualization
//            Solute.setCharge("Thanks !!");
            return null;
        }

        /*
         * Executed in event dispatching thread
         */
        @Override
        public void done() {
//Tell progress listener to stop updating progress bar.
            boolean done = true;
    Toolkit.getDefaultToolkit().beep();
//    btnSolve.setEnabled(true);
    setCursor(null); //turn off the wait cursor
    progressBar.setValue(progressBar.getMinimum());
    progressBar.setString("PreCalculations Done. Ready to run JACFC !!");
    taskOutput.append("Done!\n");
//    saveresults.setEnabled(true);
        }
    }
    /**
     * @param args the command line arguments
     */
class Task2 extends SwingWorker<Void, Void> {
        /*
         * Main task. Executed in background thread.
         */
    // this worker use the filament surface charge density and radius to 
    // generate input file and run the cylindrical CSDFT
        @Override
        public Void doInBackground() {
//                  
    //new code to generate capacitance and parameter b
                String[] strlabel = new String[5];
                strlabel[0] = "Writing input file..";
                strlabel[1] = "Running Solver..";
                strlabel[2] = "Compiling results.....";
                strlabel[3] = "Generating output files..";
                strlabel[4] = "Generating plots...";             
                int[] porc = new int[5];
                 porc[0]=15;
                 porc[1]=35;
                 porc[2]=70;
                 porc[3]=85;
                 porc[4]=95;

                  String ddir = Utilities.getAnalysisPath()+ File.separator +"waitfile.tmp";
                  File f2 = new File(ddir);
// write input file
               setProgress(porc[0]);
               progressBar.setString(strlabel[0]);
               try {
                        Thread.sleep(3000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(BiomoleculesUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        WriteFiles.write_cylinder();
    // run the cylindrical CSDFT
                        {
                            try {
               setProgress(porc[1]);
               progressBar.setString(strlabel[1]);
                                RunAnalysis.run_cylinder();
                            } catch (IOException ex) {
                                Logger.getLogger(BiomoleculesUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(BiomoleculesUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                while(f2.exists() && !f2.isDirectory()) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(RunAnalysis.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
//                break;
//            }
               setProgress(porc[2]);
               progressBar.setString(strlabel[2]);
                              try {
                        Thread.sleep(3000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(BiomoleculesUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                           setProgress(porc[3]);
               progressBar.setString(strlabel[3]);
            try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(BiomoleculesUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
               setProgress(porc[4]);
               progressBar.setString(strlabel[4]);
            try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(BiomoleculesUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
            // move text files to the output directory
            String dst2 = Utilities.getAnalysisPath()
            +"/" + "input.pdb";
            String src2 = "input_"+PHModel.getUserTime()+".pdb";
            MoveFiles.move_Files(src2, dst2);
            String dst3 = Utilities.getAnalysisPath()
            +"/" + "vol.txt";
            String src3 = "vol_"+PHModel.getUserTime()+".txt";
            MoveFiles.move_Files(src3, dst3);
            String dst4 = Utilities.getAnalysisPath()
            +"/" + "radiusandcharge.txt";
            String src4 = "radiusandcharge_"+PHModel.getUserTime()+".txt";
            MoveFiles.move_Files(src4, dst4);
            String dst6 = Utilities.getAnalysisPath()
            +"/" + "lengthandcharge.txt";
            String src6 = "lengthandcharge_"+PHModel.getUserTime()+".txt";
            MoveFiles.move_Files(src6, dst6);
            String dst7 = Utilities.getAnalysisPath()
            +"/" + "input.pqr";
            String src7 = "input_"+PHModel.getUserTime()+".pqr";
            MoveFiles.move_Files(src7, dst7);
            String dst8 = Utilities.getAnalysisPath()
            +"/" + "input.propka";
            String src8 = "input_"+PHModel.getUserTime()+".propka";
            MoveFiles.move_Files(src8, dst8);

            if (!rbnprovol.isSelected()){
                // move text files to the output directory
                String dst = Utilities.getAnalysisPath()
                +"/" + "out.pdb";
                String src = "out.pdb";
                MoveFiles.move_Files(src, dst);
                String dst5 = Utilities.getAnalysisPath()
                +"/" + "out.xyzr";
                String src5 = "out.xyzr";
                MoveFiles.move_Files(src5, dst5);
            }
// result visualization
            ResultsUI Results = new ResultsUI();
            Results.setVisible(true);
            Results.requestFocus();
            Results.toFront();
//
        setCursor(null);
        rbnprovol.setEnabled(true);
        rbn3v.setEnabled(true);
        rbnTheoreticalPred.setSelected(false);
        btnSolve.setEnabled(true);
        saveresults.setEnabled(true);
//        emailaddress.setEnabled(true);
//            Solute.setCharge("Thanks !!");
            String todayAsString = 
                    new SimpleDateFormat("MM-dd-yyyy__HH-mm-ss").
                            format(new Date());
             PHModel.setUserTime(todayAsString);
            return null;
        }

        /*
         * Used by Task and Taks2. Executed in event dispatching thread
         */
        @Override
        public void done() {
//Tell progress listener to stop updating progress bar.
            boolean done = true;
    Toolkit.getDefaultToolkit().beep();
    setCursor(null); //turn off the wait cursor
    progressBar.setValue(progressBar.getMinimum());
    progressBar.setString("Thanks !!");
    taskOutput.append("Done!\n");
        }
    }

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
            java.util.logging.Logger.getLogger(BiomoleculesUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BiomoleculesUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BiomoleculesUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BiomoleculesUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BiomoleculesUI().setVisible(true);
            }
        });
    }
    
        public void get_valence_diameter(JComboBox cmb, JTextField textbox){
    /* This function writes the valence in the field, depending on the selected
      *  ion and saves the ion diameter into a variable. If an ion diameter 
      *  equal to zero is found, set corresponding radiobutton as enabled.
      */
        // Check if the ion diameter is different than zero         
        if (!IonLibrary.valN3[IonLibrary.getValPosition()].equals("0")){
            cmb.addItem("-3.0");
            cmb.setSelectedItem("-3.0");
            Ions.setDiameter((Double.parseDouble(IonLibrary.valN3[IonLibrary.getValPosition()])
                    *0.01)*2);
        }
        if (!IonLibrary.valN2[IonLibrary.getValPosition()].equals("0")){
            cmb.addItem("-2.0");
            cmb.setSelectedItem("-2.0");
            Ions.setDiameter((Double.parseDouble(IonLibrary.valN2[IonLibrary.getValPosition()])
                    *0.01)*2);
        }
        if (!IonLibrary.valN1[IonLibrary.getValPosition()].equals("0")){
            cmb.addItem("-1.0");
            cmb.setSelectedItem("-1.0");
            Ions.setDiameter((Double.parseDouble(IonLibrary.valN1[IonLibrary.getValPosition()])
                    *0.01)*2);
        }
        if (!IonLibrary.valP1[IonLibrary.getValPosition()].equals("0")){
            cmb.addItem("1.0");
            cmb.setSelectedItem("1.0");
            Ions.setDiameter((Double.parseDouble(IonLibrary.valP1[IonLibrary.getValPosition()])
                    *0.01)*2);
        }
        if (!IonLibrary.valP2[IonLibrary.getValPosition()].equals("0")){
            cmb.addItem("2.0");
            cmb.setSelectedItem("2.0");
            Ions.setDiameter((Double.parseDouble(IonLibrary.valP2[IonLibrary.getValPosition()])
                    *0.01)*2);
        }
        if (!IonLibrary.valP3[IonLibrary.getValPosition()].equals("0")){
            cmb.addItem("3.0");
            cmb.setSelectedItem("3.0");
            Ions.setDiameter((Double.parseDouble(IonLibrary.valP3[IonLibrary.getValPosition()])
                    *0.01)*2);
        }
        if (!IonLibrary.valP4[IonLibrary.getValPosition()].equals("0")){
            cmb.addItem("4.0");
            cmb.setSelectedItem("4.0");
            Ions.setDiameter((Double.parseDouble(IonLibrary.valP4[IonLibrary.getValPosition()])
                    *0.01)*2);
        }
        if (!IonLibrary.valP5[IonLibrary.getValPosition()].equals("0")){
            cmb.addItem("5.0");
            cmb.setSelectedItem("5.0");
            Ions.setDiameter((Double.parseDouble(IonLibrary.valP5[IonLibrary.getValPosition()])
                    *0.01)*2);
        }
        if (!IonLibrary.valP6[IonLibrary.getValPosition()].equals("0")){
            cmb.addItem("6.0");
            cmb.setSelectedItem("6.0");
            Ions.setDiameter((Double.parseDouble(IonLibrary.valP6[IonLibrary.getValPosition()])
                    *0.01)*2);
        }
        if (!IonLibrary.valP7[IonLibrary.getValPosition()].equals("0")){
            cmb.addItem("7.0");
            cmb.setSelectedItem("7.0");
            Ions.setDiameter((Double.parseDouble(IonLibrary.valP7[IonLibrary.getValPosition()])
                    *0.01)*2);
        }        
        if (!IonLibrary.valP8[IonLibrary.getValPosition()].equals("0")){
            cmb.addItem("8.0");
            cmb.setSelectedItem("8.0");
            Ions.setDiameter((Double.parseDouble(IonLibrary.valP8[IonLibrary.getValPosition()])
                    *0.01)*2);
        }
        // Save ion diameter
        int digitsAfterDecimal = 3;
        BigDecimal bigDecimal = BigDecimal.valueOf(Ions.getDiameter());
        // BigDecimal.ROUND_FLOOR is Rounding Mode..denote how your value is rounded off
        // Other ways are:- "ROUND_CEILING", "ROUND_DOWN", etc..
        bigDecimal = bigDecimal.setScale(digitsAfterDecimal, 
                BigDecimal.ROUND_FLOOR);
        Ions.setDiameter(Double.parseDouble(String.valueOf(bigDecimal)));
        if (null != Utilities.getTheoryModel()){
            if ("PB".equals(Utilities.getTheoryModel())){
                textbox.setText("1.0");
            }else {
                textbox.setText(String.valueOf(Ions.getDiameter()));
            } 
        }
    }
    
    public void get_valence_change(String SelectedItem, JTextField textbox){
    /* This function writes the valence in the field, depending on the selected
      * ion.
      */      
        if (SelectedItem.equals("-3.0")){
            // Save ion diameter
            Ions.setDiameter(Double.parseDouble(IonLibrary.valN3[IonLibrary.getValPosition()])
                    *0.01*2);
        }
        if (SelectedItem.equals("-2.0")){
            // Save ion diameter
            Ions.setDiameter(Double.parseDouble(IonLibrary.valN2[IonLibrary.getValPosition()])
                    *0.01*2);
        }
        if (SelectedItem.equals("-1.0")){
            // Save ion diameter
            Ions.setDiameter(Double.parseDouble(IonLibrary.valN1[IonLibrary.getValPosition()])
                    *0.01*2);
        }
        if (SelectedItem.equals("1.0")){
            // Save ion diameter
            Ions.setDiameter(Double.parseDouble(IonLibrary.valP1[IonLibrary.getValPosition()])
                    *0.01*2);
        }
        if (SelectedItem.equals("2.0")){
            // Save ion diameter
            Ions.setDiameter(Double.parseDouble(IonLibrary.valP2[IonLibrary.getValPosition()])
                    *0.01*2);
        }
        if (SelectedItem.equals("3.0")){
            // Save ion diameter
            Ions.setDiameter(Double.parseDouble(IonLibrary.valP3[IonLibrary.getValPosition()])
                    *0.01*2);
        }
        if (SelectedItem.equals("4.0")){
            // Save ion diameter
            Ions.setDiameter(Double.parseDouble(IonLibrary.valP4[IonLibrary.getValPosition()])
                    *0.01*2);
        }
        if (SelectedItem.equals("5.0")){
            // Save ion diameter
            Ions.setDiameter(Double.parseDouble(IonLibrary.valP5[IonLibrary.getValPosition()])
                    *0.01*2);
        }
        if (SelectedItem.equals("6.0")){
            // Save ion diameter
            Ions.setDiameter(Double.parseDouble(IonLibrary.valP6[IonLibrary.getValPosition()])
                    *0.01*2);
        }
        if (SelectedItem.equals("7.0")){
            // Save ion diameter
            Ions.setDiameter(Double.parseDouble(IonLibrary.valP7[IonLibrary.getValPosition()])
                    *0.01*2);
        }
        if (SelectedItem.equals("8.0")){
            // Save ion diameter
            Ions.setDiameter(Double.parseDouble(IonLibrary.valP8[IonLibrary.getValPosition()])
                    *0.01*2);
        }
        int digitsAfterDecimal = 3;
        BigDecimal bigDecimal = BigDecimal.valueOf(Ions.getDiameter());
        // BigDecimal.ROUND_FLOOR is Rounding Mode..denote how your value is rounded off
        // Other ways are:- "ROUND_CEILING", "ROUND_DOWN", etc..
        bigDecimal = bigDecimal.setScale(digitsAfterDecimal,
                BigDecimal.ROUND_FLOOR);
        Ions.setDiameter(Double.parseDouble(String.valueOf(bigDecimal)));
        if (null != Utilities.getTheoryModel()){
            if ("PB".equals(Utilities.getTheoryModel())){
                textbox.setText("1.0");
            }else {
                textbox.setText(String.valueOf(Ions.getDiameter()));
            } 
        }
    }

    public void set_enabled_TSoluteData_true(){
        // Set this information enabled
        lblForceField.setEnabled(true);
        cmbForceField.setEnabled(true);
        btnJmol.setEnabled(true);
        btnPDB2PQR.setEnabled(true);
    }

    public void set_enabled_TSoluteData_false(){
        // Set this information disabled
        lblForceField.setEnabled(false);
        cmbForceField.setEnabled(false);
        btnJmol.setEnabled(false);
        btnPDB2PQR.setEnabled(false);
    }
    
    public void set_enabled_ESoluteData_true(){
        // Set this information enabled
        lblSoluteChargeType.setEnabled(true);
        txtSoluteCharge.setEnabled(true);
        lblSoluteChargeUnits.setEnabled(true);
        txtSoluteRadius.setEnabled(true);
    }

    public void set_enabled_ESoluteData_false(){
        // Set this information disabled
        lblSoluteChargeType.setEnabled(true);
        txtSoluteCharge.setEnabled(true);
        lblSoluteChargeUnits.setEnabled(true);
        txtSoluteRadius.setEnabled(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnJmol;
    private javax.swing.JButton btnPDB2PQR;
    private javax.swing.JButton btnSolve;
    private javax.swing.JButton btnSolve1;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox cmbForceField;
    private javax.swing.JComboBox cmbIon;
    private javax.swing.JComboBox cmbValence;
    private javax.swing.JTextField emailaddress;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblDielectricConstant;
    private javax.swing.JLabel lblElectroValue;
    private javax.swing.JLabel lblElectroneutrality;
    private javax.swing.JLabel lblForceField;
    private javax.swing.JLabel lblIonAngstroms;
    private javax.swing.JLabel lblIonConcentration;
    private javax.swing.JLabel lblIonDiameter;
    private javax.swing.JLabel lblIonMolar;
    private javax.swing.JLabel lblIonSymbol;
    private javax.swing.JLabel lblIonValence;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblMixing;
    private javax.swing.JLabel lblResolution;
    private javax.swing.JLabel lblResolutionAngstroms;
    private javax.swing.JLabel lblSoluteAngstroms;
    private javax.swing.JLabel lblSoluteChargeType;
    private javax.swing.JLabel lblSoluteChargeUnits;
    private javax.swing.JLabel lblSoluteRadius;
    private javax.swing.JLabel lblSolventAngstroms;
    private javax.swing.JLabel lblSolventConcentration;
    private javax.swing.JLabel lblSolventDiameter;
    private javax.swing.JLabel lblSolventMolar;
    private javax.swing.JLabel lblTempUnits;
    private javax.swing.JLabel lblTolerance;
    private javax.swing.JLabel lblpHValue;
    private javax.swing.JPanel pnlDiameterType;
    private javax.swing.JPanel pnlElectrolyteDefinition;
    private javax.swing.JPanel pnlElectrostatic;
    private javax.swing.JPanel pnlIonData;
    private javax.swing.JPanel pnlNumericalRuntime;
    private javax.swing.JPanel pnlSteric;
    private javax.swing.JPanel pnlpHModel;
    public javax.swing.JProgressBar progressBar;
    private javax.swing.JRadioButton rbn3v;
    private javax.swing.JRadioButton rbnCrystal;
    private javax.swing.JRadioButton rbnEffective;
    private javax.swing.JRadioButton rbnExperimentalData;
    private javax.swing.JRadioButton rbnHydrated;
    private javax.swing.JRadioButton rbnTheoreticalPred;
    private javax.swing.JRadioButton rbnprovol;
    private javax.swing.JButton saveresults;
    private javax.swing.JTextArea taskOutput;
    private javax.swing.JTable tblIonData;
    private javax.swing.JTextField txtDielectricConstant;
    private javax.swing.JTextField txtIonConcentration;
    private javax.swing.JTextField txtIonDiameter;
    private javax.swing.JTextField txtMixing;
    private javax.swing.JTextField txtPh;
    private javax.swing.JTextField txtResolution;
    public static javax.swing.JTextField txtSoluteCharge;
    public static javax.swing.JTextField txtSoluteRadius;
    private javax.swing.JTextField txtSolventConcentration;
    private javax.swing.JTextField txtSolventDiameter;
    private javax.swing.JTextField txtTemperature;
    private javax.swing.JTextField txtTolerance;
    // End of variables declaration//GEN-END:variables
}
