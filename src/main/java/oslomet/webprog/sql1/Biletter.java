package oslomet.webprog.sql1;


public class Biletter implements Comparable<Biletter> { //implementerer en klasse
    private int id;
    private String velgfilm;
    private int antall;
    private String fornavn;
    private String etternavn;
    private String telefonnr;
    private String epost;

    public Biletter(int id, String velgfilm, int antall, String fornavn, String etternavn, String telefonnr, String epost) {
        this.id=id;
        this.velgfilm = velgfilm;
        this.antall = antall;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.telefonnr = telefonnr;
        this.epost = epost;
    }
    public Biletter(){
    }

    public int getId(){
        return id;
    }

    public void setId(){
        this.id=id;
    }
    public String getVelgfilm() {
        return velgfilm;
    }

    public void setVelgfilm(String velgfilm) {
        this.velgfilm = velgfilm;
    }

    public int getAntall() {
        return antall;
    }

    public void setAntall(int antall) {
        this.antall = antall;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getTelefonnr() {
        return telefonnr;
    }

    public void setTelefonnr(String telefonnr) {
        this.telefonnr = telefonnr;
    }

    public String getEpost() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }

    @Override
    public int compareTo(Biletter o) {
        return this.getEtternavn().compareTo(o.getEtternavn()); //this er en bilett, denne billetten sammenlignes med en bilett som v isender inn som parameter
    }
}
