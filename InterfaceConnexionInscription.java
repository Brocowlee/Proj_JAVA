import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class InterfaceConnexionInscription{
   
    private DefaultListModel<String> liste = new DefaultListModel<>();
    private static JScrollPane scrollPane = null;
    private JFrame frame = new JFrame("connexion");

    public InterfaceConnexionInscription(batiment bat1){
        frame.pack();
        //récuperer la taille de l'écran
        Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
        int height = tailleEcran.height;
        int width = tailleEcran.width;
        //taille est un demi la longueur et l'hauteur
        frame.setSize(width/2, height/2);

        //ici on centre notre fenetre 
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 270);

        JLabel connexion = new JLabel("Connexion");
        connexion.setBounds(90,0,100,20);
        frame.add(connexion);

        JLabel nameLabel = new JLabel("nom d'utilisateur:");
        nameLabel.setBounds(50,25,150,20);
        frame.add(nameLabel);

        JTextField name = new JTextField();
        name.setBounds(50,50,150,20);
        frame.add(name);

        JLabel mdpLabel = new JLabel("mot de passe:");
        mdpLabel.setBounds(50,75,150,20);
        frame.add(mdpLabel);

        JTextField mdp = new JPasswordField();
        mdp.setBounds(50,100,150,20);
        frame.add(mdp);

        JButton btnConnexion = new JButton("Se connecter");
        btnConnexion.setBounds(50,150,150,30);
        frame.add(btnConnexion);

        JLabel compteInexistantlabel = new JLabel("");
        btnConnexion.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String nameText = name.getText();
                System.out.println("nom connexion:"+nameText);
                String mdpText = mdp.getText();
                System.out.println("mdp connexion:"+mdpText);
                name.setText("");
                mdp.setText("");
                
                try{
                    if(bat1.getBavard(nameText).getMdp().equals(mdpText)){
                        new interfaceBavard(bat1.getBavard(nameText),bat1);
                        bat1.getBavard(nameText).setConnected(true);
                        refresh(bat1);
                        SwingUtilities.updateComponentTreeUI(frame);
                        frame.setVisible(true);
                    }
                    else{
                        compteInexistantlabel.setText("mot de passe incorrect");
                        compteInexistantlabel.setBounds(50,125,150,20);

                        frame.add(compteInexistantlabel);
                        frame.repaint();
                    
                    }
                }
                catch(Exception e){
                    
                    compteInexistantlabel.setText("nom d'utilisateur incorrect");
                    compteInexistantlabel.setBounds(50,125,150,20);
                    
                    frame.add(compteInexistantlabel);
                    frame.repaint();
                }
            }
         });

        compteInexistantlabel.setText("");

        JButton btnInscription = new JButton("S'inscrire");
        btnInscription.setBounds(50,185,150,30);
        frame.add(btnInscription);

        btnInscription.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
               String nameText = name.getText();
               System.out.println("nom inscription:"+nameText);
               String mdpText = mdp.getText();
               System.out.println("mdp inscription:"+mdpText);
               System.out.println(bat1.getAllBavard());
               bat1.newBavard(nameText,mdpText);
               System.out.println(bat1.getAllBavard());
               name.setText("");
               mdp.setText("");
            }
        });

        Runnable helloRunnable = new Runnable() {
            public void run() {
                refresh(bat1);
            }
        };
        
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(helloRunnable, 0, 3, TimeUnit.SECONDS);

        showList(bat1); 
        frame.setLayout(null);
        frame.setVisible(true);

    }

    private void showList(batiment bat){
        liste.clear();
        for(Bavard bavard : bat.getAllBavard()){
            if(bavard.getConnected()){
               liste.addElement(bavard.getName());
            }
        }
        JList list = new JList(liste);
        

       JPanel panel = new JPanel();
       panel.add(list);
       scrollPane = new JScrollPane(panel);
       scrollPane.repaint();
       scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
       scrollPane.setBounds(300, 20, 150, 200);
       frame.add(scrollPane);
    }

     public void refresh(batiment bat){
         if(scrollPane != null){
             frame.remove(scrollPane);
         }
         showList(bat);
         frame.revalidate();
         frame.repaint();
     }


}

