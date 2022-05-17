import java.util.ArrayList;

public class batiment {
    private ArrayList<Concierge> concierges;
    private ArrayList<Bavard> bavards;
    


    public batiment() {
        this.concierges = new ArrayList<Concierge>();
        this.bavards = new ArrayList<Bavard>();
    }

    public void newConcierges(String name){
        this.concierges.add(new Concierge(name));
    }


    public void newBavard(String name,String mdp){
        this.bavards.add(new Bavard(name,mdp));
    }

    public Concierge getConcierge(String name){
        for(int i = 0;i<this.concierges.size();i++){
            if(name.equals(concierges.get(i).getName())){
                return concierges.get(i);
            }
        }
        return null;
    }

    public Bavard getBavard(String name){
        for(int i = 0;i<this.bavards.size();i++){
            if(name.equals(this.bavards.get(i).getName())){
                return bavards.get(i);
            }
        }
        return null;
    }

    public void subscribe(String bavardName,String conciergeName){
        getConcierge(conciergeName).addBavard(getBavard(bavardName));
        getBavard(bavardName).addConcierge(getConcierge(conciergeName));
    }
}
