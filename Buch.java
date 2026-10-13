public class Buch{
    public String titel;
    public String autor;
    public Double preis;
    public Integer anzahl_seiten;

    public Buch(String titel, String autor, Double preis, Integer anzahl_seiten){
        this.titel = titel;
        this.autor = autor;
        this.preis = preis;
        this.anzahl_seiten = anzahl_seiten;
    }
}