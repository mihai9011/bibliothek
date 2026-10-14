public class Buch{
    private String titel;
    private String autor;
    private Double preis;
    private Integer anzahl_seiten;

    public  Buch(String titel, String autor, Double preis, Integer anzahl_seiten){
        this.titel = titel;
        this.autor = autor;
        this.preis = preis;
        this.anzahl_seiten = anzahl_seiten;
    }
    public String getTitel(){
        return this.titel;
    }

    public String getAutor(){
        return this.autor;
    }
    
    public Integer getSeiten(){
        return this.anzahl_seiten;
    }

    public Double getPreis(){
        return this.preis;
    }
}