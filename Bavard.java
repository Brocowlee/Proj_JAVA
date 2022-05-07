public class Bavard implements PapotageListener{
    PapotageListener ConciergeListener;

    public Bavard() {
    }

    public void addPapotageListener(PapotageListener ConciergeListener){
        this.ConciergeListener=ConciergeListener;
    }

    public void envoyerUnMessage(Concierge concierge,String sujet,String corps){
        PapotageEvent pe1=new PapotageEvent(concierge.getBavard(0),sujet,corps);
        concierge.newEnvoie(pe1);
    }

    public void newEnvoie(PapotageEvent PE){
        System.out.println(PE.getSujet());
        System.out.println(PE.getCorps());
    }

}
