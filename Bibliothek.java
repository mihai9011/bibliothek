import java.util.*;

//link und rechts indizes, nummer seiten, summe_preis
record Quartet(int first, int second, int third, Double fourth) {}

public class Bibliothek{
    public List<Buch> buecher = new ArrayList<>();

    public Bibliothek(List<Buch> buecher){
        this.buecher = buecher;
    }

    public void bucher_mit_autorname(String author_name){

        List<String> erg = new ArrayList<>();

        for(Buch buch : this.buecher){
            if(buch.getAutor() == author_name){
                erg.add(buch.getTitel());
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
        if(buecher.size() == 0){
            return 0.0;
        }

        Double sum = 0.0;

        for(Buch buch: buecher){
            sum += buch.getSeiten();
        }
       
        return sum/buecher.size();
       
    }

    public void innerhalb_preislimit(List<Buch> buecher, Double max_preis){
        List<String> erg = new ArrayList<>();

        for(Buch buch: buecher){
            if(buch.getPreis() <= max_preis){
                erg.add(buch.getTitel());
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
        if(buecher.size() == 0){
            System.out.println("null");
            return;
        }

        Buch erg = buecher.get(0);

        for(Buch buch:buecher){
            if(buch.getPreis() > erg.getPreis()){
                erg = buch;
            }
        }
        
        System.out.println(erg.getTitel());
      
    }

    public void buecher_mit_mindestseitanzahl(List<Buch> buecher,Integer mindestanzahl){
        if(buecher.size() == 0){
            System.out.println("Keine Buecher gegeben!");
            return;
        }

        List<String> erg = new ArrayList<>();

        for(Buch buch:buecher){
            if(buch.getSeiten() >= mindestanzahl){
                erg.add(buch.getTitel());
            }
        }
        
        for(String titel:erg){
            System.out.println(titel);
        }
    }


    public void bucher_im_budget(List<Buch> buecher, Double budget){
        //kein gueltiges paar kann gemacht werden
        if(buecher.size() < 2){
            System.out.println("Die Liste enthalt nicht genug Buecher!");
            return;
        }

        //List mit ergebnisse
        List<Quartet> erg = new ArrayList<>();

        //sortieren nach preis, deep kopie nach buecher
        List<Buch> sortiert = new ArrayList<>(buecher);

        sortiert.sort(Comparator.comparingDouble(Buch::getPreis).thenComparingInt(Buch::getSeiten));

        int rechtes_index = sortiert.size() - 1;
        int linkes_index = 0;

        Double curr_sum = sortiert.get(linkes_index).getPreis() + sortiert.get(rechtes_index).getPreis();        
        int nr_seiten = sortiert.get(linkes_index).getSeiten() + sortiert.get(rechtes_index).getSeiten();


        while(linkes_index < rechtes_index){

            if(curr_sum <= budget){
                
                nr_seiten = sortiert.get(linkes_index).getSeiten() + sortiert.get(rechtes_index).getSeiten();

                //Indizes , nr_seiten und die summe in einen neuen Quartet speichern
                erg.add(new Quartet(linkes_index, rechtes_index, nr_seiten, curr_sum));

                linkes_index ++;
            }
            else{
                rechtes_index --;
            }
            curr_sum = sortiert.get(linkes_index).getPreis() + sortiert.get(rechtes_index).getPreis();
        }

        if(erg.size() == 0){
            System.out.println("Keine 2 Buecher unter den gegebenen Budget!");
            return;
        }

        erg.sort(Comparator.comparingDouble(Quartet::fourth).thenComparingInt(Quartet::third));

        linkes_index = erg.get(erg.size() - 1).first();
        rechtes_index = erg.get(erg.size() - 1).second();

        System.out.println(sortiert.get(linkes_index).getTitel() + " + " + sortiert.get(rechtes_index).getTitel());
        System.out.println("Gesamtpreis: " + erg.get(erg.size() - 1).fourth());
    }

    

    public List<Buch> names_to_books(List<String> namen){
        List<Buch> erg = new ArrayList<>();

        for(String name:namen){
            for(Buch buch:this.buecher){
                if(buch.getTitel().equals(name)){
                    erg.add(buch);
                    break;
                }
            }
        }

        return erg;
    }
}
