package dash;

import java.util.ArrayList;

/**
 * Utilisé pour le déplacement interactif.
 */
public class Move {

	/**
	 * 
	 * 
	 * 
	 * Affiche les déplacements
	 * 
	 * 
	 * @param moves
	 *            chemin représenté par une liste de lettres
	 * 
	 * 
	 * 
	 * 
	 */
	public static void afficherM(ArrayList moves) {// ArrayList char MAJUSCULES
		for (int ct = 0; ct < moves.size(); ct++) {
			char e1 = (char) moves.get(ct);
			switch (e1) {
			case 'D':
				System.out.println("bas");
				break;
			case 'L':
				System.out.println("gauche");
				break;
			case 'I':
				System.out.println("immobile");
				break;
			case 'R':
				System.out.println("droite");
				break;
			case 'U':
				System.out.println("haut");
				break;
			default:
				System.out.println("\n");
			}
			// System.out.print(moves.get(ct) + " ");
		}
	}

	public static void main(String[] args) {
		ArrayList moves = new ArrayList();
		moves.add('U');
		moves.add('L');
		moves.add('D');
		moves.add('I');
		moves.add('R');
		afficherM(moves);

	}

}
