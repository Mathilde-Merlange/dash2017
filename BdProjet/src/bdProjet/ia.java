package bdProjet;
import java.util.Random;

public class ia {
	 public static char[] randompath(int nb) {//déplacements aléatoires
		         char[] valeurs = {'D', 'L', 'I', 'R', 'L'};
		         char[] moves = new char[nb];
		         Random rand = new Random();
		         // ↑ ↑ ↓ ↓ ← → ← → B A//
		         for (int i = 0; i < nb; i++) {
		             char choix = valeurs[rand.nextInt(valeurs.length)];
		             moves[i] = choix;
		         }
		         return moves;
		     }
		 
		     public static void main(String[] args) {
		         char[] dep = randompath(10);
		         for (int i = 0; i < 10; i++) {
		             System.out.print(dep[i] + " ");
		         }
		 
		     }
}
