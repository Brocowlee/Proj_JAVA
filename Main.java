//PROJET Arthur GONAY/Emma ORSET IDU3


public class Main {
    public static void main(String[] args) throws Exception {
        batiment bat1 = new batiment();
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
        bat1.getBavard("b1").newEnvoie(bat1.getConcierge("bricolage"), "sujetici", "corpsiciggggggggggggggggggggg");
        bat1.getBavard("b1").newEnvoie(bat1.getConcierge("bricolage"), "sujetici", "corpsicigggggggggggggggg2ggggggggggggggggggggggggggg");
        bat1.getBavard("b1").newEnvoie(bat1.getConcierge("bricolage"), "sujetici", "corpsicigggggggggggggggg2gggggg3gggggggggggggggggggg");
        bat1.getBavard("b1").newEnvoie(bat1.getConcierge("bricolage"), "sujetici", "corpsicigggggggggggggggg2gggggg3gggggggggggggggggggg");
        
        //concierge.getBavard(0).newEnvoie(concierge,"sujet","petit message");
        new InterfaceConnexionInscription(bat1);
        
        }

    }
