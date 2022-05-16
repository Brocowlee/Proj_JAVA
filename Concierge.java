import java.util.ArrayList;

public class Concierge implements PapotageListener{
    private ArrayList<Bavard> destinataire;

    public Concierge() {
        this.destinataire = new ArrayList<Bavard>();
    }

    public void addPapotageListenerConcierge(Bavard bavard){
        this.destinataire.add(bavard);
    }

    public void newEnvoie(PapotageEvent PE){
        for(PapotageListener PL : this.destinataire){
            if(PL!=PE.getSource()){
                PL.newEnvoie(PE);
            }
        }
    }

    public PapotageListener getBavard(int i){
        return this.destinataire.get(i);
    }

    public void newEnvoie(PapotageListener concierge,String sujet,String corps){

    }
}
