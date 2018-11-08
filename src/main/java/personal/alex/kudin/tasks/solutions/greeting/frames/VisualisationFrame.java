package personal.alex.kudin.tasks.solutions.greeting.frames;

import javax.swing.*;
import java.awt.*;


/**
 * The purpose of this class is to create and visualise
 * a frame with a greeting message in it.
 */
public class VisualisationFrame extends JFrame {

    public VisualisationFrame(){}

    public VisualisationFrame(String message){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JLabel aSign = new JLabel(message);
        aSign.setBackground(new Color(184,184,184));
        aSign.setFont(new Font("Lucida Console", 1, 50));

        this.add(aSign);
        this.pack();
        this.setVisible(true);
    }
}