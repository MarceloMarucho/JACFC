/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Procedures.RunAnalysis;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.swing.ToolTipManager;

/**
 *
 * @author mardanmar
 */
public class testenv {
    
   public static String Linuxenv() {
       String output = null;
            String exe3 = "./Linux/testlinuxenv.sh";
            RunAnalysis executable3 = new RunAnalysis(exe3);
       try {
           Thread.sleep(200);
       } catch (InterruptedException ex) {
           Logger.getLogger(testenv.class.getName()).log(Level.SEVERE, null, ex);
       }
     try{
    BufferedReader br = new BufferedReader(new FileReader("terminalsys.tmp"));
    String strLine;
    if (br.readLine() == null) {
        output = "xterm ";
        //System.out.println(output);
    }else{
        output = "gnome-terminal -x ";
    //System.out.println(output);
    }
    //System.out.println(output);
    }catch (Exception e){//Catch exception if any
      System.err.println("Error: " + e.getMessage());
        }
     String exe4 = "rm terminalsys.tmp ";
     RunAnalysis executable4 = new RunAnalysis(exe4);
     return output;
    }
   
   public static void RAMmemtest() throws IOException {
            // monitor free RAM memory
        String openterm = Linuxenv();
        if ("xterm ".equals(openterm)){
            Process p = new ProcessBuilder(
                    "xterm","-geometry","125x5+900+0","-title","'Free RAM memory check every 5 seconds'",
                    "-e",
                   "watch -n 5 free -m").start();
             }else{
            //Process p = new ProcessBuilder(
            //        "gnome-terminal","--geometry","90x5+900+0","--title='Free RAM memory check every 5 seconds'",
            //        "-e",
            //       "watch -n 5 free -m").start();
            Process p = new ProcessBuilder(
                    "gnome-system-monitor").start();
             }
   }
   


  //public static void visibletime(String[] argv) throws Exception {

    // Get current delay
  //  int dismissDelay = ToolTipManager.sharedInstance().getDismissDelay();

    // Keep the tool tip showing
  //  dismissDelay = Integer.MAX_VALUE;
   // ToolTipManager.sharedInstance().setDismissDelay(dismissDelay);

  //}
}