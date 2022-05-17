import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;

public class interfaceBavard {

    public interfaceBavard(Bavard bavard) {
        JFrame frame = new JFrame("Bavardage");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
}
