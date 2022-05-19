
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;


public class interfaceBavard {
    JFrame frame;

    public interfaceBavard(Bavard bavard) {
        JFrame frame = new JFrame("Bavardage");
        this.frame=frame;
        this.frame.pack();
        this.frame.setLocationRelativeTo(null);
        this.frame.setSize(500, 500);
        this.frame.setLayout(null);
        this.frame = settingMenuBar(bavard);
        this.frame.setVisible(true);
    }

    public JFrame settingMenuBar(Bavard bavard){
        JMenuBar menuBar = new JMenuBar();
        JMenu menu=new JMenu("mes Topics");
        for(Concierge concierge : bavard.getConcierges()){
            JMenuItem conciergeMenu=new JMenuItem(concierge.getName());  
            menu.add(conciergeMenu);
            System.out.println("ici");
            conciergeMenu.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    JTextField messageTextField = new JTextField();
                    messageTextField.setBounds(50,100,150,20);
                    frame.add(messageTextField);
                    frame.repaint();
                }
             });
        }

        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
        return frame;
    }

    
}
