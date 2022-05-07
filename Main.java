//TP2 Arthur GONAY IDU3

public class Main {
    public static void main(String[] args) throws Exception {
        Concierge concierge=new Concierge();
        concierge.newBavard();
        concierge.newBavard();
        concierge.newBavard();
        concierge.newBavard();
        
        concierge.getBavard(0).envoyerUnMessage(concierge,"sujet","petit message tmtc");
        
        }

    }
