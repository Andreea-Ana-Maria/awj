package hello;

public class Persoana {

    private final int varsta ;
    private final String nume;
    private final String prenume;

    public Persoana( int varsta, String nume, String prenume) {
        this.varsta = varsta;
        this.nume = nume;
        this.prenume = prenume;
    }

    public int getVarsta() {
        return varsta;
    }

    public String getNume() {
        return nume;
    }
    public String getPrenume() {
        return prenume;
    }
}
