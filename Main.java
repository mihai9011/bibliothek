
import java.util.*;

public class Main{
    public static void main(String[] args){
        Buch buch1 = new Buch("Schuld und Sühne", "Fjodor Dostojewski", 45.50, 600);
        Buch buch2 = new Buch("Der kleine Prinz", "Antoine de Saint-Exupéry", 25.00, 96);
        Buch buch3 = new Buch("Die Verwandlung", "Franz Kafka", 32.00, 128);
        Buch buch4 = new Buch("Im Westen nichts Neues", "Erich Maria Remarque", 29.99, 288);

        List<Buch> buecher = new ArrayList<>();

        buecher.add(buch1);
        buecher.add(buch2);
        buecher.add(buch3);
        buecher.add(buch4);

        Bibliothek b = new Bibliothek(buecher);

        System.out.println("Die Bucher fur die Anfragen:");

        List<String> buecher_namen = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String name = scanner.nextLine();
            
            if (name.equals("///")) {
                break;
            }
            
            buecher_namen.add(name);
        }


        // System.out.println(b.names_to_books(test));

        b.bucher_mit_autorname("Antoine de Saint-Exupéry");
        System.out.println();
        b.buecher_mit_mindestseitanzahl(288);
        System.out.println();
        System.out.println(b.durchschnittliche_Anzahl(b.names_to_books(buecher_namen)));
        System.out.println();
        b.teureste_buch(b.names_to_books(buecher_namen));
        System.out.println();
        b.innerhalb_preislimit(b.buecher, 30.0);
        System.out.println();

    
        scanner.close();
    }
}