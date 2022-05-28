//PROJET Arthur GONAY/Emma ORSET IDU3


public class Main {
    public static void main(String[] args) throws Exception {
        Batiment bat1 = new Batiment();
        bat1.newBavard("b1","azert");
        bat1.newBavard("b2","azert");
        bat1.newBavard("b3","azert");
        bat1.newBavard("b4","azert");
        bat1.newConcierges("bricolage");
        bat1.newConcierges("jardinage");
        bat1.newConcierges("jeux video");
        bat1.newConcierges("film");
        bat1.newConcierges("livre");
        //bat1.subscribe("b1", "bricolage");
        bat1.subscribe("b2", "bricolage");
        bat1.subscribe("b3", "bricolage");
        bat1.getBavard("b1").newEnvoie(bat1.getConcierge("bricolage"), "sujetici1", "exemple1");
        bat1.getBavard("b1").newEnvoie(bat1.getConcierge("bricolage"), "sujetici2", "exemple2");
        bat1.getBavard("b1").newEnvoie(bat1.getConcierge("bricolage"), "sujetici3", "exemple3");
        bat1.getBavard("b1").newEnvoie(bat1.getConcierge("bricolage"), "sujetici4", "exemple4");
        new InterfaceConnexionInscription(bat1);
        
        }

    }
