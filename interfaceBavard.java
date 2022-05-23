
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import java.awt.event.*;


public class interfaceBavard {
    JFrame frame=new JFrame("Bavardage");
    Concierge currentConcierge = null;
    private static JLabel currentConciergeLabel = new JLabel("");
    private Bavard currentBavard;
    private batiment bat; 


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
        //JLabel contenant l'information du currentConcierge
        //JLabel currentConciergeLabel = new JLabel(getCurrentConcierge().getName());
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
        JTextField corpTextField = new JTextField();
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
            }
            });

        frame.revalidate();
        frame.repaint();
}
    private void showAllMessages(){
        if(getCurrentConcierge().getLastMessages().size()<3){
            for(int i = 0 ; i<getCurrentConcierge().getLastMessages().size() ; i++){
                showMessage(i, getCurrentConcierge().getLastMessages().get(getCurrentConcierge().getLastMessages().size()-i-1));
            }
    }
    else{
        for(int i = 0 ; i<3 ; i++){
            showMessage(i, getCurrentConcierge().getLastMessages().get(getCurrentConcierge().getLastMessages().size()-i-1));
        }
    }
    }

    private void showMessage(int num,PapotageEvent PE){
        JLabel message=new JLabel("<html><body>From: "+PE.getSource()+"<br>Sujet: "+PE.getSujet()+"<br>Corps: "+PE.getCorps()+"</html></body>");
        message.setBounds(25,200-(num*75),450,100);
        System.out.println(PE.getCorps());
        frame.add(message);
    }

}
