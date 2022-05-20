
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
        this.frame = settingMenuBar(bavard,bat,bavard.getConcierges().get(0));
        this.frame.setVisible(true);
        
    }


 
    public JFrame settingMenuBar(Bavard bavard,batiment bat,Concierge currentConcierge){
        JMenuBar menuBar = new JMenuBar();
        JMenu menu=new JMenu("mes Topics");
        JMenu allTopics=new JMenu("Tous les topics");
        for(Concierge concierge : bavard.getConcierges()){
            JMenuItem conciergeMenu=new JMenuItem(concierge.getName());  
            menu.add(conciergeMenu);

            conciergeMenu.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    JTextField messageTextField = new JTextField();
                    messageTextField.setBounds(25,400,350,25);
                    frame.add(messageTextField);
                    JButton sendButton = new JButton("Envoyer");
                    sendButton.setBounds(375,400,100,25);
                    frame.add(sendButton);

                    //JLabel contenant l'information du currentConcierge
                    JLabel currentConciergeLabel = new JLabel(concierge.getName());
                    currentConciergeLabel.setBounds(275,10,125,25);
                    frame.add(currentConciergeLabel);
                    

                    sendButton.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent ae){
                            //bavard.newEnvoie(concierge, sujet, corps);
                        }
                     });

                    JButton unsubscribeButton = new JButton("Se desabonner");
                    unsubscribeButton.setBounds(350,10,125,25);
                    frame.add(unsubscribeButton);

                    unsubscribeButton.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent ae){
                            bat.unSubscribe(bavard.getName(), currentConcierge.getName());
                            frame = settingMenuBar(bavard,bat,currentConcierge);
                            frame.setVisible(true);
                        }
                     });

                    frame.repaint();
                }
             });
        }
        //Setting menuBar
        for (Concierge allConcierges : bat.getConciergesNonsubscribe(bavard)){
            JMenuItem conciergeNonSubMenu=new JMenuItem(allConcierges.getName());
            allTopics.add(conciergeNonSubMenu);
            conciergeNonSubMenu.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    bat.subscribe(bavard.getName(),allConcierges.getName());
                    frame = settingMenuBar(bavard,bat,allConcierges);
                    frame.setVisible(true);
                }
             });

        }

        menuBar.add(menu);
        menuBar.add(allTopics);
        frame.setJMenuBar(menuBar);
        return frame;
    }

    
    
}
