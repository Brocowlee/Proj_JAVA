
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import java.awt.event.*;


public class interfaceBavard {
    JFrame frame;

    public interfaceBavard(Bavard bavard,batiment bat) {
        JFrame frame = new JFrame("Bavardage");
        this.frame=frame;
        this.frame.pack();
        this.frame.setLocationRelativeTo(null);
        this.frame.setSize(500, 500);
        this.frame.setLayout(null);
        this.frame = settingMenuBar(bavard,bat);
        this.frame.setVisible(true);
    }

    public JFrame settingMenuBar(Bavard bavard,batiment bat){
        JMenuBar menuBar = new JMenuBar();
        JMenu menu=new JMenu("mes Topics");
        JMenu allTopics=new JMenu("Tous les topics");
        for(Concierge concierge : bavard.getConcierges()){
            JMenuItem conciergeMenu=new JMenuItem(concierge.getName());  
            menu.add(conciergeMenu);
            conciergeMenu.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    JTextField messageTextField = new JTextField();
                    messageTextField.setBounds(50,100,150,20);
                    frame.add(messageTextField);
                    frame.repaint();
                }
             });
        }
        for (Concierge allConcierges : bat.getConciergesNonsubscribe(bavard)){
            JMenuItem conciergeNonSubMenu=new JMenuItem(allConcierges.getName());
            allTopics.add(conciergeNonSubMenu);
            conciergeNonSubMenu.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    bavard.addConcierge(allConcierges);
                    frame.repaint();
                }
             });

        }

        menuBar.add(menu);
        menuBar.add(allTopics);
        frame.setJMenuBar(menuBar);
        return frame;
    }


    
}
