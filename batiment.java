import java.util.ArrayList;

public class batiment {
    private ArrayList<Concierge> concierges;
    private ArrayList<Bavard> bavards;
    


    public batiment() {
        this.concierges = new ArrayList<Concierge>();
        this.bavards = new ArrayList<Bavard>();
    }

    public void addConcierges(Concierge concierge){
        this.concierges.add(concierge);
    }


    public void newBavard(String name){
        this.bavards.add(new Bavard(name));
    }

}
