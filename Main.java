//PROJET Arthur GONAY/Emma ORSET IDU3

public class Main {
    public static void main(String[] args) throws Exception {
        batiment bat1 = new batiment();
        Concierge concierge=new Concierge();
        bat1.newBavard("b1");
        bat1.newBavard("b2");
        bat1.newBavard("b3");
        bat1.newBavard("b4");
        concierge.getBavard(0).newEnvoie(concierge,"sujet","petit message");
        
        }

    }
