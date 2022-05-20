import java.util.ArrayList;

public class Bavard implements PapotageListener{
    private ArrayList<Concierge> concierges;
    String name;
    String mdp;
    boolean connected;

    public Bavard(String name,String mdp) {
        this.name=name;
        this.mdp=mdp;
        this.concierges = new ArrayList<Concierge>();
    }

    public String getName(){
        return this.name;
    }

    public String getMdp(){
        return this.mdp;
    }

    public boolean getConnected(){
        return this.connected;
    }

    public void setConnected(boolean etat){
        this.connected=etat;
    }

    public void newEnvoie(PapotageListener concierge,String sujet,String corps){
        PapotageEvent pe1=new PapotageEvent(this,sujet,corps);
        concierge.newEnvoie(pe1);
    }

    public void addConcierge(Concierge concierge){
        //addPapotageListener anciennement
        this.concierges.add(concierge);
    }


    public void newEnvoie(PapotageEvent PE){
        System.out.println(PE.getSource()+"\n"+PE.getSujet()+"\n"+PE.getCorps()+"\n");
    }

    public ArrayList<Concierge> getConcierges(){
        return this.concierges;
    } 
    
    @Override
    public String toString() {
        return  getName();
    }

    public void removeConcierge(Concierge concierge) {
        this.concierges.remove(concierge);
    }


}
