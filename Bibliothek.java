import java.util.*;

public class Bibliothek{
    public List<Buch> buecher = new ArrayList<>();

    public Bibliothek(List<Buch> buecher){
        this.buecher = buecher;
    }

    public void bucher_mit_autorname(String author_name){

        List<String> erg = new ArrayList<>();

        for(Buch buch : this.buecher){
            if(buch.autor == author_name){
                erg.add(buch.titel);
            }
        }

        if(erg.size() == 0){
            System.out.println("Keine Bucher von diesem Autor!");
        }
        else{
            for(String titel:erg){
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

    public void innerhalb_preislimit(List<Buch> buecher, Double max_preis){
        List<String> erg = new ArrayList<>();

        for(Buch buch: buecher){
            if(buch.preis <= max_preis){
                erg.add(buch.titel);
            }
        }

        if(erg.size() == 0){
            System.out.println("Keine Buecher unter den gegebenen Preis!");
        }
        else{
            for(String titel:erg){
                System.out.println(titel);
            }
        }
    }

    public void teureste_buch(List<Buch> buecher){
        Buch erg = buecher.get(0);

        for(Buch buch:buecher){
            if(buch.preis > erg.preis){
                erg = buch;
            }
        }

        System.out.println(erg.titel);
    }

    public void buecher_mit_mindestseitanzahl(Integer mindestanzahl){
        List<String> erg = new ArrayList<>();

        for(Buch buch: this.buecher){
            if(buch.anzahl_seiten >= mindestanzahl){
                erg.add(buch.titel);
            }
        }
        
        if(erg.size() == 0){
            System.out.println("Keine Buecher!");
        }
        else{
            for(String titel:erg){
                System.out.println(titel);
            }
        }

    }

    //to do 
    public void bucher_im_budget(List<Buch> buecher, Double budget){

  
    }

    public List<Buch> names_to_books(List<String> namen){
        List<Buch> erg = new ArrayList<>();

        for(String name:namen){
            for(Buch buch:this.buecher){
                if(buch.titel.equals(name)){
                    erg.add(buch);
                    break;
                }
            }
        }

        return erg;
    }
}