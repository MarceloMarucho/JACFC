/******************************************************************************
 *
 * @author Esteban Valderrama
 * Description: This class contains the method to create the plots when
 *              the user opens a output file.
 *
 *****************************************************************************/

package Procedures;

import Classes.Ions;
import Classes.Results;
import Classes.Utilities;
import static Forms.OpenOutputUI.chkDisplayData;
import static Forms.OpenOutputUI.pnlPlot;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.io.File;
//import java.time.Clock;
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


public class CreatePlots {
/******************************************************************************
 *
 * Procedure Name: create_plots
 * Original Author: Esteban Valderrama
 * Description: This method creates the plots when the user opens an output file
 * 
 * Calling Arguments:
 *     Name         -> N/A
 *     Input/Output -> N/A
 *     Type         -> N/A
 *     Description  -> N/A
 * 
 * Return Value:
 *     Name         -> N/A                
 *     Type         -> N/A
 *     Description  -> N/A
 * 
 * Local Variables:
 *     Name         -> f      
 *     Type         -> File
 *     Description  -> Contains the filename.
 * 
 *     Name         -> retval      
 *     Type         -> boolean
 *     Description  -> TRUE is the file selected contains the keyword, otherwise FALSE.
 * 
 *     Name         -> type     
 *     Type         -> String
 *     Description  -> Contains the type of file to be read.
 * 
 *     Name         -> seriesName_Data    
 *     Type         -> XYSeries[]
 *     Description  -> Series Names.
 * 
 *     Name         -> my_data_series    
 *     Type         -> XYSeriesCollection
 *     Description  -> Series data.
 * 
 *     Name         -> i, j
 *     Type         -> Integer
 *     Description  -> Loop control.
 * 
 *     Name         -> chart
 *     Type         -> JFreeChart
 *     Description  -> Chart type.
 * 
 *     Name         -> chartpanel
 *     Type         -> ChartPanel
 *     Description  -> Panel to show the plot.
 * 
 *     Name         -> plot
 *     Type         -> XYPlot
 *     Description  -> Plot with lines.
 * 
 *     Name         -> axis
 *     Type         -> ValueAxis 
 *     Description  -> Axis avlues.
 *
 * Global Variables:
 *     Name         -> analysisPath
 *     Type         -> String    
 *     Origin       -> Utilities
     Description  -> Contains the path of the file to read.
 * 
 *     Name         -> numCols
 *     Type         -> Integer   
 *     Origin       -> Results
 *     Description  -> Contains the number of columns in the file.
 * 
 * Modification History:
 *     Date         ->     
 *     Developer    ->
 *     Description  ->
 * 
 *
 *****************************************************************************/
    public static void create_plots(){
        File f = new File(Utilities.getAnalysisPath());
        if(f.exists() && !f.isDirectory()){
            chkDisplayData.setSelected(false);
            CreateTables.dispose_data();
            
////            if (Utilities.getAnalysisPath().contains("pH")){
////                String type = Utilities.getAnalysisPath();
////                ReadFiles.read_ph(type);
////                XYSeries[] seriesName_Data = new XYSeries[Results.getNumCols()];
////                XYSeriesCollection my_data_series = new XYSeriesCollection();
////                for (int i = 1; i < Results.getNumCols(); i++){
////                    seriesName_Data[i-1] = new XYSeries("pH");
////                    for (int j = 0; j < Results.getNumLines(); j++){
////                        seriesName_Data[i-1].add(Results.ph[j][0],Results.ph[j][i]);
////                    }
////                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
////                    my_data_series.addSeries(seriesName_Data[i-1]);
////                }
////                JFreeChart chart = ChartFactory.createXYLineChart(null, "R [Angs.]", 
////                        "pH", my_data_series, PlotOrientation.VERTICAL, true, 
////                        true, false);
////                ChartPanel chartpanel = new ChartPanel(chart);
////                XYPlot plot = (XYPlot) chart.getPlot();
////                plot.setDomainGridlinesVisible(true);
////                plot.setRangeGridlinesVisible(true);
////                ValueAxis axis = plot.getDomainAxis();
////                axis.setLowerBound(Results.ph[0][0]);
////                axis.setUpperBound(Results.ph[Results.getNumLines()-1][0]);
////                plot.setRangeGridlinePaint(Color.black);
////                plot.setDomainGridlinePaint(Color.black);
////                plot.setBackgroundPaint(Color.white);
////                pnlPlot.removeAll();
////                pnlPlot.add(chartpanel, BorderLayout.CENTER);
////                pnlPlot.validate();
////                chkDisplayData.setEnabled(true);
////            }else 
            if (Utilities.getAnalysisPath().contains("Pressure")){
                String type = Utilities.getAnalysisPath();
                ReadFiles.read_results(type);
                Results.strPressure = new String[Results.getNumLines()][Results.getNumCols()];
                Results.strPressure = Results.reader;
                Results.pressure = new double[Results.getNumLines()][Results.getNumCols()];
                Results.pressure = ReadFiles.convert_astring2adouble(Results.strPressure, Results.getNumLines(), Results.getNumCols());
                XYSeries[] seriesName_Data = new XYSeries[Results.getNumCols()];
                XYSeriesCollection my_data_series = new XYSeriesCollection();
                for (int i = 1; i < Results.getNumCols(); i++){
                    seriesName_Data[i-1] = new XYSeries("Pressure");
                    for (int j = 0; j < Results.getNumLines(); j++){
                        seriesName_Data[i-1].add(Results.pressure[j][0],
                                Results.pressure[j][i]);
                    }
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                    my_data_series.addSeries(seriesName_Data[i-1]);
                }
                JFreeChart chart = ChartFactory.createXYLineChart(null, 
                        "R [Angs.]", "P(r)", my_data_series, 
                        PlotOrientation.VERTICAL, true, true, false);
                ChartPanel chartpanel = new ChartPanel(chart);
                XYPlot plot = (XYPlot) chart.getPlot();
                plot.setDomainGridlinesVisible(true);
                plot.setRangeGridlinesVisible(true);
                ValueAxis axis = plot.getDomainAxis();
                axis.setLowerBound(Results.pressure[0][0]);
                axis.setUpperBound(Results.pressure[Results.getNumLines()-2][0]);
                plot.setRangeGridlinePaint(Color.black);
                plot.setDomainGridlinePaint(Color.black);
                plot.setBackgroundPaint(Color.white);
                pnlPlot.removeAll();
                pnlPlot.add(chartpanel, BorderLayout.CENTER);
                pnlPlot.validate();
                chkDisplayData.setEnabled(true);
            }else if (Utilities.getAnalysisPath().contains("IonContributions")){
                String type = Utilities.getAnalysisPath();
                ReadFiles.read_results(type);
                System.out.println("Marcelo");
                Results.strIonContributions = new String[Results.getNumLines()][Results.getNumCols()];
                Results.strIonContributions = Results.reader;
                Results.ionContributions = new double[Results.getNumLines()][Results.getNumCols()];
                Results.ionContributions = ReadFiles.convert_astring2adouble(Results.strIonContributions, Results.getNumLines(), Results.getNumCols());
                XYSeries[] seriesName_Data = new XYSeries[Results.getNumCols()];
                XYSeriesCollection my_data_series= new XYSeriesCollection();
                String columnNames[] = new String[Results.getNumCols()-1];
                Ions.setCounter((Results.getNumCols() - 1) / 4);
                int k = 0;
                for (int j = 0; j < Ions.getCounter(); j++){
                    columnNames[k] = "ψ (r ;{ ρ (r) } ) - " + "Ion " + (j+1);         
                    k++;
                }
                for (int j = 0; j < Ions.getCounter(); j++){
                    columnNames[k] = "C1hs (r ;{ ρ (r) } ) - " + "Ion " + (j+1);        
                    k++;
                }
                for (int j = 0; j < Ions.getCounter(); j++){
                    columnNames[k] = "c1res (r ;{ ρ (r) } ) - " + "Ion " + (j+1);        
                    k++;
                }
                for (int j = 0; j < Ions.getCounter(); j++){
                    columnNames[k] = "T.C (r ;{ ρ (r) } ) - " + "Ion " + (j+1);        
                    k++;
                }
                for (int i = 1; i < Results.getNumCols(); i++){
                    seriesName_Data[i-1] = new XYSeries(columnNames[i-1]);
                    for (int j = 0; j < Results.getNumLines(); j++){
                        seriesName_Data[i-1].add(Results.ionContributions[j][0],
                                Results.ionContributions[j][i]);
                    }
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                    my_data_series.addSeries(seriesName_Data[i-1]);
                }
                JFreeChart chart = ChartFactory.createXYLineChart(null, 
                        "R [Angs.]", " ", my_data_series, 
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
            }else if (Utilities.getAnalysisPath().contains("IntegratedCharge")){
                 String type = Utilities.getAnalysisPath();
                ReadFiles.read_results(type);
                Results.strIntegratedCharge = new String[Results.getNumLines()][Results.getNumCols()];
                Results.strIntegratedCharge = Results.reader;
                Results.integratedCharge = new double[Results.getNumLines()][Results.getNumCols()];
                Results.integratedCharge = ReadFiles.convert_astring2adouble(Results.strIntegratedCharge, Results.getNumLines(), Results.getNumCols());
                XYSeries[] seriesName_Data = new XYSeries[Results.getNumCols()];
                XYSeriesCollection my_data_series = new XYSeriesCollection();
                for (int i = 1; i < Results.getNumCols(); i++){
                    seriesName_Data[i-1] = new XYSeries("Integrated Charge"); //GlobalVariables.ionSymbol[0]);
                    for (int j = 0; j < Results.getNumLines(); j++){
                        seriesName_Data[i-1].add(Results.integratedCharge[j][0],
                                Results.integratedCharge[j][i]);
                }
                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                my_data_series.addSeries(seriesName_Data[i-1]);
            }
                JFreeChart chart = ChartFactory.createXYLineChart(null, "R [Angs.]",
                    "Integrated Charge", my_data_series, 
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
            }else if (Utilities.getAnalysisPath().contains("ElectrostaticPotential")){
                String type = Utilities.getAnalysisPath();
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
                        "R [Angs.]", "ψ(r)", my_data_series, 
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
            }else if (Utilities.getAnalysisPath().contains("DensityProfile")){
                String type = Utilities.getAnalysisPath();
                ReadFiles.read_results(type);
                Results.strDensityProfile = new String[Results.getNumLines()][Results.getNumCols()];
                Results.strDensityProfile = Results.reader;
                Results.densityProfile = new double[Results.getNumLines()][Results.getNumCols()];
                Results.densityProfile = ReadFiles.convert_astring2adouble(Results.strDensityProfile, Results.getNumLines(), Results.getNumCols());
                XYSeries[] seriesName_Data = new XYSeries[Results.getNumCols()];
                XYSeriesCollection my_data_series= new XYSeriesCollection();
                for (int i = 1; i < Results.getNumCols(); i++){
                    seriesName_Data[i-1] = new XYSeries("Ion " + i); //GlobalVariables.ionSymbol[0]);
                    for (int j = 0; j < Results.getNumLines(); j++){
                        seriesName_Data[i-1].add(Results.densityProfile[j][0],
                            Results.densityProfile[j][i]);
                    }
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                    my_data_series.addSeries(seriesName_Data[i-1]);
                }
                JFreeChart chart = ChartFactory.createXYLineChart(null, "R [Angs.]",
                        "ρ(r)/ρbulk", my_data_series, PlotOrientation.VERTICAL, 
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
            } else{
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "This file is not a CSDFTS "
                        + "output file. Please upload the correct file.", "ERROR", 
                    JOptionPane.CLOSED_OPTION);
                Results.setOpeningOutput(false); 
            }
        }else{
                pnlPlot.removeAll();
                JOptionPane.showMessageDialog(null,"The File selected does not"
                        + " exist.","ERROR",JOptionPane.ERROR_MESSAGE);
                chkDisplayData.setEnabled(false);
        }
    }
}