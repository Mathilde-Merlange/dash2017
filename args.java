package bdProjet;
import java.util.ArrayList;
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
		                ArrayList moves = Move.depFichier(nomF);
		
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
		        System.out.println("Mathilde Merlange");
		        System.out.println("Adélie Calvo Fernandez");
		        System.out.println("Li-San Sultan");
		    }
		
		    private static void afficherOptions() {
		        System.out.println("-name affiche les noms des codeurs");
		    }
}