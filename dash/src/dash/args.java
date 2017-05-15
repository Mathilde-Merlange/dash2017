package dash;

import java.util.ArrayList;

/**
 * Created by mathilde.
 */
public class args {

    public static void main(String[] args) {
        String a1 = args[0];
        switch (a1) {
            case "name":
                afficherIdentite();
                break;
            case "h":
                afficherOptions();
                break;
            case "lis":
                String nomF = args[1];
                ArrayList moves = Moves.depFichier(nomF);

                break;
            case "joue":
                break;
            case "rejoue":
                break;
            case "simul":
                break;
        }
    }

    private static void afficherIdentite() {
        System.out.println("M");
        System.out.println("A");
        System.out.println("L");
    }

    private static void afficherOptions() {
        System.out.println("-name affiche les noms des codeurs");
    }


}
