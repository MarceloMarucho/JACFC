/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.awt.Button;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author mdmlab5
 */
public class AwtControlDemo {
private Frame mainFrame;
   private Label headerLabel;
   private Label statusLabel;
   private Panel controlPanel;

   public AwtControlDemo(){
      prepareGUI();
   }

   public static void main(String[] args){
      AwtControlDemo  awtControlDemo = new AwtControlDemo();
      awtControlDemo.showFileDialogDemo();
   }

   private void prepareGUI(){
      mainFrame = new Frame("Download Results");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      headerLabel = new Label();
      headerLabel.setAlignment(Label.CENTER);
      statusLabel = new Label();        
      statusLabel.setAlignment(Label.CENTER);
      statusLabel.setSize(350,100);

      controlPanel = new Panel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }

   public void showFileDialogDemo(){
//      headerLabel.setText("Control in action: FileDialog"); 

      final FileDialog fileDialog = new FileDialog(mainFrame,"Select file");
      Button showFileDialogButton = new Button("Download");
      showFileDialogButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             fileDialog.setMode(FileDialog.SAVE);
             fileDialog.setFilenameFilter(new ExtensionFilter("zip"));
             String zipDir = Utilities.getAnalysisPath()+
                File.separatorChar + "simulationresults.zip"; 
                String exe24 = System.getProperty("user.home");
            fileDialog.setDirectory(exe24); 
            fileDialog.setFile(zipDir); 
            fileDialog.setVisible(true);
//            statusLabel.setText("File Selected :" 
//            + fileDialog.getDirectory() + fileDialog.getFile());
         }
      });

      controlPanel.add(showFileDialogButton);
      mainFrame.setVisible(true);  
   }

    private static class ExtensionFilter implements FilenameFilter {
     String extension;
         public ExtensionFilter(String extension) {
    this.extension = "." + extension;
  }

  public boolean accept(File dir, String name) {
    return name.endsWith(extension);
  }
    }
}