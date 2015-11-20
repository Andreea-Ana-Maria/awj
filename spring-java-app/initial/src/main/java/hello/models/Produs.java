package hello;

public class Produs {

    private int id;
    private String denumire;
    private String tip;
    private int pret;


    public Produs(int id, String denumire, String tip, int pret) {
        this.id = id;
        this.denumire = denumire;
        this.tip = tip;
        this.pret = pret;
    }

    public long getId() {
        return id;
    }

    public String getDenumire() {
        return denumire;    
    }

     public String getTip() {
        return tip;    
    }

    public long getPret() {
        return pret;
    }

    public void setId(int id) {

            this.id = id;

        }

   public void setDenumire(String denumire) {

       this.denumire = denumire;
   }

    public void setTip(String tip) {

       this.tip = tip;
   }
   public void setPret(int pret) {
       
        this.pret = pret;
    }
}
