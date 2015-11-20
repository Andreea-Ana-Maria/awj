package hello;

public class Angajat {

    private  int id;
    private  String nume;
    private String prenume;
    private int iddepartament;


    public Angajat(int id, String nume ,String prenume , int iddepartament) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.iddepartament = iddepartament;
    }

    public long getId() {
        return id;
    }

    public String getNume() {
        return nume;    
    }

    public String getPrenume() {
        return prenume;    
    }

    public long getIdDep() {
        return iddepartament;
    }

    public void setId(int id) {

            this.id = id;

        }

   public void setNume(String nume) {

       this.nume = nume;
   }
   public void setPrenume(String prenume) {

       this.prenume = prenume;
   }
   public void setIdDep(int iddepartament) {
       
        this.iddepartament = iddepartament;
    }
}
