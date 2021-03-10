/**
 * Results is the class for all the output data which allow the software to 
 * make plots and generate tables.
 * 
 @author Marcelo Marucho
 */

package Classes;

import java.awt.*;
//import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

/**
 * This class demonstrates how to load an Image from an external file
 */
public class LoadImageApp extends JPanel {
          
    BufferedImage img;

    @Override
    public void paintComponent(Graphics g) {
	super.paintComponent(g);
        g.drawImage(img, 0, 0, null);
    }

    public LoadImageApp(String filename) {
       try {
           img = ImageIO.read(new File(filename));
       } catch (IOException e) {
		//System.out.println(e); // e.getMessage());
		System.out.println(filename + " not found");
		System.exit(-1);
       }

    }

    @Override
    public Dimension getPreferredSize() {
        if (img == null) {
             return new Dimension(100,100);
        } else {
           return new Dimension(img.getWidth(null), img.getHeight(null));
       }
    }
}
