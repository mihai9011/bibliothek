import java.util.*;

public class Bibliothek{
    public List<Buch> buecher = new ArrayList<>();

    public void get_books(String author_name){

        List<String> result = new ArrayList<>();

        for(Buch buch : this.buecher){
            if(buch.autor == author_name){
                result.add(buch.titel);
            }
        }

        if(result.size() == 0){
            System.out.println("No books by this author.");
        }
        else{
            for(String titel:result){
                System.out.println(titel);
            }
        }
    }

    public Double durchschnittliche_Anzahl(List<Buch> buecher){
        Double sum = 0.0;

        for(Buch buch: buecher){
            sum += buch.anzahl_seiten;
        }

        return sum/buecher.size();
    }

}