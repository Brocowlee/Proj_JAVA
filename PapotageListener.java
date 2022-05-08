public interface PapotageListener {
    public void newEnvoie(PapotageEvent PE);
    public void newEnvoie(PapotageListener concierge,String sujet,String corps);
}
