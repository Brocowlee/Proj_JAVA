import java.util.ArrayList;

public class Concierge implements PapotageListener{
    private ArrayList<PapotageListener> destinataire;
    private ArrayList<PapotageListener> destinataireOFF;

    public Concierge() {
        this.destinataire = new ArrayList<PapotageListener>();
    }

    public void addPapotageListenerConcierge(PapotageListener PL){
        this.destinataire.add(PL);
    }

    public void newBavard(){
        Bavard b = new Bavard();
        b.addPapotageListener(this);
        this.addPapotageListenerConcierge(b);
    }

    public void turnON(Bavard b){
        for(PapotageListener PL  : this.destinataireOFF){
            if(PL==b){
                this.destinataireOFF.remove(b);
                this.destinataire.add(b);
            }
        }
    }

    public void turnOFF(Bavard b){
        for(PapotageListener bavard : this.destinataire){
            if(bavard==b){
                this.destinataire.remove(b);
                this.destinataireOFF.add(b);
            }
        }
    }

    public void newEnvoie(PapotageEvent PE){
        System.out.println("nouveau message recu!");
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
