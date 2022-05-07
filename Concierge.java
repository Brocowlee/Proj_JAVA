import java.util.ArrayList;

public class Concierge implements PapotageListener{
    private ArrayList<Bavard> bavardsON;
    private ArrayList<Bavard> bavardsOFF;
    

    public Concierge() {
        this.bavardsON = new ArrayList<Bavard>();
        this.bavardsOFF = new ArrayList<Bavard>();
    }

    public void newBavard(){
        Bavard b = new Bavard();
        b.addPapotageListener(this);
        bavardsON.add(b);
    }

    public void turnON(Bavard b){
        for(Bavard bavard : this.bavardsOFF){
            if(bavard==b){
                bavardsOFF.remove(b);
                bavardsON.add(b);
            }
        }
    }

    public void turnOFF(Bavard b){
        for(Bavard bavard : this.bavardsON){
            if(bavard==b){
                bavardsON.remove(b);
                bavardsOFF.add(b);
            }
        }
    }

    public void newRecu(PapotageEvent PE){
        this.newEnvoie(PE);
    }

    public void newEnvoie(PapotageEvent PE){
        for(Bavard bavard : this.bavardsON){
            if(bavard!=PE.getSource()){
                bavard.newEnvoie(PE);
            }
        }
    }

    public Bavard getBavard(int i){
        return this.bavardsON.get(i);
    }
}
