import java.util.ArrayList;

public class Concierge implements PapotageListener{
    private String name;
    private ArrayList<Bavard> destinataire;

    public Concierge(String name) {
        this.destinataire = new ArrayList<Bavard>();
        this.name=name;
    }

    public void addBavard(Bavard bavard){
        this.destinataire.add(bavard);
    }

    public void newEnvoie(PapotageEvent PE){
        for(PapotageListener PL : this.destinataire){
            if(PL!=PE.getSource()){
                PL.newEnvoie(PE);
            }
        }
    }

    public String getName(){
        return this.name;
    }

    public Bavard getBavard(int i){
        return this.destinataire.get(i);
    }

    public void newEnvoie(PapotageListener concierge,String sujet,String corps){

    }

    public void removeBavard(Bavard bavard) {
        this.destinataire.remove(bavard);
    }
}
