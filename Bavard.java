public class Bavard implements PapotageListener{
    PapotageListener ConciergeListener;
    String name;

    public Bavard(String name) {
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

    public void newEnvoie(PapotageListener concierge,String sujet,String corps){
        PapotageEvent pe1=new PapotageEvent(this,sujet,corps);
        concierge.newEnvoie(pe1);
    }

    public void addPapotageListener(PapotageListener ConciergeListener){
        this.ConciergeListener=ConciergeListener;
    }


    public void newEnvoie(PapotageEvent PE){
        System.out.println(PE.getSource()+"\n"+PE.getSujet()+"\n"+PE.getCorps()+"\n");
    }

}
