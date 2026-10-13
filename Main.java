
import java.util.*;

public class Main{
    public static void main(String[] args){
        //create examples
        // Buch buch1 = Buch();
        
        List<Buch> buecher = new ArrayList<>();

        // buecher.add(buch1);
        // buecher.add(buch2);
        // buecher.add(buch3);
        // buecher.add(buch4);

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

        
        scanner.close();
    }
}