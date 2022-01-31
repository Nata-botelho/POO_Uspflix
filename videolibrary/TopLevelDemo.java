package videolibrary;
import java.awt.*;
import javax.swing.*;

public class TopLevelDemo {
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("TopLevelDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
        //Create a yellow label to put in the content pane.
        JLabel yellowLabel = new JLabel();        
        yellowLabel.setOpaque(true);        
        yellowLabel.setBackground(new Color(248, 213, 0));        
        yellowLabel.setPreferredSize(new Dimension(200, 180));
     
        frame.getContentPane().add(yellowLabel, BorderLayout.CENTER);

        //Display the window.        
        frame.pack();        
        frame.setVisible(true);    
    }

    public static void teste() {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
