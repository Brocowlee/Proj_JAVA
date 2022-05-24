
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class interfaceBavard {
    JFrame frame=new JFrame("Bavardage");
    Concierge currentConcierge = null;
    private static JLabel currentConciergeLabel = new JLabel("");
    private Bavard currentBavard;
    private batiment bat;
    private static JScrollPane scrollPane = null;
    private DefaultListModel<String> liste = new DefaultListModel<>(); 


    public JFrame getFrame() {
        return this.frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public Concierge getCurrentConcierge() {
        return this.currentConcierge;
    }

    public void setCurrentConcierge(Concierge currentConcierge) {
        this.currentConcierge = currentConcierge;
    }

    public void setCurrentConciergeLabel(JLabel JL){
        this.currentConciergeLabel=JL;
    }


    public Bavard getCurrentBavard() {
        return this.currentBavard;
    }

    public void setCurrentBavard(Bavard currentBavard) {
        this.currentBavard = currentBavard;
    }

    public batiment getBat() {
        return this.bat;
    }

    public void setBat(batiment bat) {
        this.bat = bat;
    }



    public interfaceBavard(Bavard bavard,batiment bat) {
        this.frame.pack();
        this.currentBavard=bavard;
        this.bat=bat;
        this.frame.setLocationRelativeTo(null);
        this.frame.setSize(500, 500);
        this.frame.setLayout(null);
        this.frame = settingMenuBar();
        this.frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                exitProcedure();
                }

            private void exitProcedure() {
                currentBavard.setConnected(false);
                frame.dispose();
            }
            });
            
    }


 
    public JFrame settingMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        JMenu menu=new JMenu("mes Topics");
        JMenu allTopics=new JMenu("Tous les topics");
        for(Concierge concierge : getCurrentBavard().getConcierges()){
            JMenuItem conciergeMenu=new JMenuItem(concierge.getName());  
            menu.add(conciergeMenu);

            conciergeMenu.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    setCurrentConcierge(concierge);
                    setFenetreEnvoie();
                    refreshMessage();
                }
             });
        }
        //Setting menuBar
        for (Concierge allConcierges : getBat().getConciergesNonsubscribe(getCurrentBavard())){
            JMenuItem conciergeNonSubMenu=new JMenuItem(allConcierges.getName());
            allTopics.add(conciergeNonSubMenu);
            conciergeNonSubMenu.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    getBat().subscribe(getCurrentBavard().getName(),allConcierges.getName());
                    frame = settingMenuBar();
                    frame.setVisible(true);
                }
             });

        }

        menuBar.add(menu);
        menuBar.add(allTopics);
        frame.setJMenuBar(menuBar);
        return frame;
    }

    private void setJLabel(){
        setCurrentConciergeLabel(new JLabel(getCurrentConcierge().getName()));
        currentConciergeLabel.setBounds(275,10,125,25);
        frame.add(currentConciergeLabel);
    }

    private void refreshJLabel(){
        frame.remove(currentConciergeLabel);
        setJLabel();
        frame.revalidate();
        frame.repaint();
    }

    private void setFenetreEnvoie(){
        JTextArea corpTextField = new JTextArea();
        corpTextField.setBounds(25,325,450,75);
        frame.add(corpTextField);
        JTextField sujetTextField = new JTextField();
        sujetTextField.setBounds(25,300,450,25);
        frame.add(sujetTextField);
        JButton sendButton = new JButton("Envoyer");
        sendButton.setBounds(375,400,100,25);
        frame.add(sendButton);
        System.out.println(currentConcierge.getLastMessages().size()!=0);
        if(currentConcierge.getLastMessages().size()!=0){
            showAllMessages();
        }
        frame.repaint();
        refreshJLabel();
        

        sendButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                getCurrentBavard().newEnvoie(getCurrentConcierge(), sujetTextField.getText(), corpTextField.getText());
                refreshMessage();
            }
            });

        JButton unsubscribeButton = new JButton("Se desabonner");
        unsubscribeButton.setBounds(350,10,125,25);
        frame.add(unsubscribeButton);

        unsubscribeButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                getBat().unSubscribe(getCurrentBavard().getName(), currentConcierge.getName());
                getCurrentBavard().setConnected(false);
                setCurrentConcierge(null);
                currentConciergeLabel.setText("");
                frame = settingMenuBar();
                frame.revalidate();
                frame.repaint();
                frame.setVisible(true);
                refreshMessage();
            }
            });

        frame.revalidate();
        frame.repaint();
}
    private void showAllMessages(){
        liste.clear();
        for(int i=0;i<currentConcierge.getLastMessages().size() && i<15;i++){
            liste.addElement("From: "+currentConcierge.getLastMessages().get(i).getSource());
            liste.addElement("Sujet: "+currentConcierge.getLastMessages().get(i).getSujet());
            liste.addElement("Corps: "+currentConcierge.getLastMessages().get(i).getCorps());
            liste.addElement(" ");
    }
        JList list = new JList(liste);
        JPanel panel = new JPanel();
        panel.add(list);
        scrollPane = new JScrollPane(panel);
        scrollPane.repaint();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(25, 50, 450, 225);
        frame.add(scrollPane);
    }

    private void refreshMessage(){
        frame.remove(scrollPane);
        showAllMessages();
        frame.revalidate();
        frame.repaint();
    }

}
