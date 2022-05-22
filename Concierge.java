import java.util.ArrayList;

public class Concierge implements PapotageListener{
    private String name;
    private ArrayList<Bavard> destinataire;
    private ArrayList<PapotageEvent> lastMessages;

    public Concierge(String name) {
        this.destinataire = new ArrayList<Bavard>();
        this.lastMessages= new ArrayList<PapotageEvent>();
        this.name=name;
    }

    public void addLastMessage(PapotageEvent PE){
        this.lastMessages.add(PE);
    }

    public void addBavard(Bavard bavard){
        this.destinataire.add(bavard);
    }
    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Bavard> getDestinataire() {
        return this.destinataire;
    }

    public void setDestinataire(ArrayList<Bavard> destinataire) {
        this.destinataire = destinataire;
    }

    public ArrayList<PapotageEvent> getLastMessages() {
        return this.lastMessages;
    }

    public void setLastMessages(ArrayList<PapotageEvent> lastMessages) {
        this.lastMessages = lastMessages;
    }

    public void newEnvoie(PapotageEvent PE){
        addLastMessage(PE);
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
