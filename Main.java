//PROJET Arthur GONAY/Emma ORSET IDU3

public class Main {
    public static void main(String[] args) throws Exception {
        Concierge concierge=new Concierge();
        concierge.newBavard();
        concierge.newBavard();
        concierge.newBavard();
        concierge.newBavard();
        
        concierge.getBavard(0).newEnvoie(concierge,"sujet","petit message");
        
        }

    }
