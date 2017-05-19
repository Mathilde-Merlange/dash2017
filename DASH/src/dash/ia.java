package dash;

import java.util.Random;

/**
 * Classe pour des déplacements aléatoires.
 */
public class ia {

	/**
	 * 
	 * 
	 * 
	 * Génère des déplacements aléatoires
	 * 
	 * 
	 * @param nb
	 *            nombre de déplacements que l'on veut générer
	 * 
	 * 
	 * 
	 * 
	 * @return un chemin aléatoire
	 * 
	 * 
	 */
	public static char[] randompath(int nb) {// déplacements aléatoires
		char[] valeurs = { 'D', 'L', 'I', 'R', 'L' };
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
