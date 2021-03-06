/*
 * Copyright (C) 2020 mdmlab5
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package Forms;

/**
 *
 * @author mdmlab5
 */
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jmol.adapter.smarter.SmarterJmolAdapter;
import org.jmol.api.JmolViewer;
import org.jmol.util.Logger;
import org.openscience.jmol.app.jmolpanel.console.AppConsole;

public class Integration {
  
    /*
   * Demonstrates a simple way to include an optional console along with the applet.
   * 
    
   */
  public static void main(String[] argv) {
    System.out.println("inside JFrame");
    JFrame frame = new javax.swing.JFrame("Molecular Structure");
    frame.addWindowListener(new ApplicationCloser());
    frame.setSize(410, 700);
    Container contentPane = frame.getContentPane();
    JmolPanel jmolPanel = new JmolPanel();
    jmolPanel.setPreferredSize(new Dimension(400, 400));

    // main panel -- Jmol panel on top
     System.out.println("inside Jpanel 1");
    JPanel panel = new javax.swing.JPanel();
    panel.setLayout(new BorderLayout());
    panel.add(jmolPanel);
    
    // main panel -- console panel on bottom
     System.out.println("inside Jpanel 2");
    JPanel panel2 = new javax.swing.JPanel();
    panel2.setLayout(new BorderLayout());
    panel2.setPreferredSize(new Dimension(400, 300));
    AppConsole console = new AppConsole(jmolPanel.viewer, panel2,
        "History State Clear");
    
    // You can use a different JmolStatusListener or JmolCallbackListener interface
    // if you want to, but AppConsole itself should take care of any console-related callbacks
    jmolPanel.viewer.setJmolCallbackListener(console);
    
    panel.add("South", panel2);
    
    contentPane.add(panel);
    frame.setVisible(true);

    // sample start-up script
     System.out.println("inside script");
    String strError = jmolPanel.viewer
        .openFile("/home/mdmlab5/Downloads/3B5U.pdb");
    //viewer.openStringInline(strXyzHOH);
    if (strError == null)
      jmolPanel.viewer.evalString(strScript);
    else
      Logger.error(strError);
  }

  final static String strXyzHOH = "3\n" 
    + "water\n" 
    + "O  0.0 0.0 0.0\n"
    + "H  0.76923955 -0.59357141 0.0\n" 
    + "H -0.76923955 -0.59357141 0.0\n";

  final static String strScript = "delay; move 360 0 0 0 0 0 0 0 4;";

  static class ApplicationCloser extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
      System.exit(0);
    }
  }

  static class JmolPanel extends JPanel {

    JmolViewer viewer;
    
    private final Dimension currentSize = new Dimension();
    
    JmolPanel() {
      viewer = JmolViewer.allocateViewer(this, new SmarterJmolAdapter(), 
          null, null, null, null, null);
    }

    @Override
    public void paint(Graphics g) {
      getSize(currentSize);
      viewer.renderScreenImage(g, currentSize.width, currentSize.height);
    }
  }

    
}