import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;

public class InterfaceConnexionInscription{
    public InterfaceConnexionInscription(batiment bat1){
        JFrame frame = new JFrame("connexion");
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
        frame.setSize(500, 250);
        JLabel connexion = new JLabel("Connexion");
        connexion.setBounds(90,0,60,20);
        frame.add(connexion);
        JLabel nameLabelConnexion = new JLabel("nom d'utilisateur:");
        nameLabelConnexion.setBounds(50,25,150,20);
        frame.add(nameLabelConnexion);
        JTextField nameconnexion = new JTextField();
        nameconnexion.setBounds(50,50,150,20);
        frame.add(nameconnexion);
        JLabel mdpLabelConnexion = new JLabel("mot de passe:");
        mdpLabelConnexion.setBounds(50,75,150,20);
        frame.add(mdpLabelConnexion);
        JTextField mdpconnexion = new JPasswordField();
        mdpconnexion.setBounds(50,100,150,20);
        frame.add(mdpconnexion);
        JButton btnConnexion = new JButton("Se connecter");
        btnConnexion.setBounds(50,150,150,30);
        frame.add(btnConnexion);
        JLabel compteInexistantlabel = new JLabel("");
        btnConnexion.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String nameconnexionText = nameconnexion.getText();
                System.out.println("nom connexion:"+nameconnexionText);
                String mdpconnexionText = mdpconnexion.getText();
                System.out.println("mdp connexion:"+mdpconnexionText);
                
                try{
                    Bavard bavard=bat1.getBavard(nameconnexionText);
                    if(bavard.getMdp().equals(mdpconnexionText)){
                        new interfaceBavard(bavard);
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
        JLabel inscription = new JLabel("Inscription");
        inscription.setBounds(345,0,60,20);
        frame.add(inscription);
        JLabel nameLabelInscription = new JLabel("nom d'utilisateur:");
        nameLabelInscription.setBounds(300,25,150,20);
        frame.add(nameLabelInscription);
        JTextField nameInscription = new JTextField();
        nameInscription.setBounds(300,50,150,20);
        frame.add(nameInscription);
        JLabel mdpLabelInscription = new JLabel("mot de passe:");
        mdpLabelInscription.setBounds(300,75,150,20);
        frame.add(mdpLabelInscription);
        JTextField mdInscription = new JPasswordField();
        mdInscription.setBounds(300,100,150,20);
        frame.add(mdInscription);
        JButton btnInscription = new JButton("S'inscrire");
        btnInscription.setBounds(300,150,150,30);
        frame.add(btnInscription);
        btnInscription.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
               String nameInscriptionText = nameInscription.getText();
               System.out.println("nom inscription:"+nameInscriptionText);
               String mdInscriptionText = mdInscription.getText();
               System.out.println("mdp inscription:"+mdInscriptionText);
               bat1.newBavard(nameInscriptionText,mdInscriptionText);
               nameInscription.setText("");
               mdInscription.setText("");
            }
         });

        
        frame.setLayout(null);
        frame.setVisible(true);
    }



}

