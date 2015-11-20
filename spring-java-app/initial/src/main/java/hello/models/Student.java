package hello;

public class Student {

    private int id;
    private String nume;
    private String prenume;
    private int anstudiu;

    public Student(int id, String nume, String prenume, int anstudiu) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.anstudiu = anstudiu;
    }

    public long getId() {
        return id;
    }

    public String getNume() {
        return nume;    }

    public String getPrenume() {
        return prenume;    }

    public long getAn() {
        return anstudiu;
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
   public void setAn(int anstudiu) {
       
        this.anstudiu = anstudiu;
    }
}
