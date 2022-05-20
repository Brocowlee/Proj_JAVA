//PROJET Arthur GONAY/Emma ORSET IDU3


public class Main {
    public static void main(String[] args) throws Exception {
        batiment bat1 = new batiment();
        bat1.newBavard("b1","azert");
        bat1.newBavard("b2","azert");
        bat1.newBavard("b3","azert");
        bat1.newBavard("b4","azert");
        bat1.getBavard("b2").setConnected(true);
        bat1.newConcierges("bricolage");
        bat1.newConcierges("jardinage");
        bat1.subscribe("b1", "bricolage");
        bat1.subscribe("b2", "bricolage");
        bat1.subscribe("b3", "bricolage");
        //bat1.getBavard("b1").newEnvoie(bat1.getConcierge("bricolage"), "sujetici", "corpsici");
        //concierge.getBavard(0).newEnvoie(concierge,"sujet","petit message");
        new InterfaceConnexionInscription(bat1);
        
        }

    }
