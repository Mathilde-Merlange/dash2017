package dash1;

import java.io.IOException;
import java.util.*;

import dash.Couple;
import dash.Niveau;

public class Carte {

	// les voisins où l'on peut se déplacer
	public static List<int[]> voisins(char[][] grille, int[] pos) {
		List<int[]> vois = new ArrayList<int[]>();
		int x = pos[0];
		int y = pos[1];
		// char[][] grille = niv.getCarte();
		// voisin du bas
		System.out.println("x" + x);
		System.out.println("y" + y);
		if (grille[x + 1][y] != 'W' && grille[x + 1][y] != 'w'
				&& grille[x + 1][y] != 'a' && grille[x + 1][y] != 'q') {
			int[] tabv = { x + 1, y, 2 };
			vois.add(tabv);
		}
		// voisin de droite
		if (grille[x][y + 1] != 'W' && grille[x][y + 1] != 'w'
				&& grille[x][y + 1] != 'a' && grille[x + 1][y] != 'q') {
			int[] tabv = { x, y + 1, 6 };
			vois.add(tabv);
		}
		// voisin du haut
		if (grille[x - 1][y] != 'W' && grille[x - 1][y] != 'w'
				&& grille[x - 1][y] != 'a' && grille[x + 1][y] != 'q') {
			int[] tabv = { x - 1, y, 8 };
			vois.add(tabv);
		}
		// voisin de gauche
		if (grille[x][y - 1] != 'W' && grille[x][y - 1] != 'w'
				&& grille[x][y - 1] != 'a' && grille[x + 1][y] != 'q') {
			int[] tabv = { x, y - 1, 4 };
			vois.add(tabv);
		}
		// retourne la liste des voisins, un voisin est un tableau à 3 cases
		// avec coordonnées x, y et déplacement
		return vois;

	}

	// retourne la sortie qui apparait après le bon compte de diamand, sinon
	// retourne tableau -1,-1
	public static int[] sortie(char[][] grille) {
		// char[][] grille = niv.getCarte();
		int[] tabv;
		// if(n.getDiamondsRequired()==n.getRockford().getNbDiamond()){
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille.length; j++) {
				if (grille[i][j] == 'X') {
					tabv = new int[] { i, j };
					return tabv;
				}
				// }
			}
		}
		return new int[] { -1, -1 };
	}

	// retourne le départ ou la case de Rockford si la partie a commencé sinon
	// tableau -1,-1
	public static int[] depart(char[][] grille) {
		// char[][] grille = n.getCarte();
		int[] tabv;

		System.out.println("DEPART");
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[0].length; j++) {
				if (grille[i][j] == 'P' || grille[i][j] == 'R') {
					tabv = new int[] { i, j };

					System.out.println(grille[i][j] + " " + i + " " + j);
					return tabv;
				}
			}
		}
		return new int[] { -1, -1 };
	}

	public static void deplacer(char[][] grille, List chemin) {
		// char[][] grille = n.getCarte();
		int[] depart = depart(grille);
		int[] sortie = sortie(grille);
		List<int[]> lesVois = voisins(grille, depart);
		String s = "";

		int rand = (int) (Math.random() * lesVois.size());
		System.out.println("nbvois" + lesVois.size());
		System.out.println("RAND" + rand);
		for (int[] v : lesVois) {
			System.out.println(v[0] + " " + v[1] + " " + v[2]);
		}

		int suiv = -1;
		if (lesVois.size() > 0) {
			int[] vois = lesVois.get(rand);
			// on regarde s'il y a un diamand dans les voisins
			for (int[] v : lesVois) {
				if (grille[v[0]][v[1]] == 'd') {
					suiv = lesVois.indexOf(v);
				}
			}
			// s'il y a un diamand dans les voisins on va sur cette case
			if (suiv >= 0) {
				vois = lesVois.get(suiv);
				chemin.add(vois[2]);
				grille[depart[0]][depart[1]] = ' ';
				grille[vois[0]][vois[1]] = 'R';
				// ajout diamand
				System.out.println("suiv " + suiv);
			} else {
				if (grille[vois[0]][vois[1]] == '.') {
					chemin.add(vois[2]);
					grille[depart[0]][depart[1]] = ' ';
					grille[vois[0]][vois[1]] = 'R';
				} else {
					if (grille[vois[0]][vois[1]] == 'd') {
						chemin.add(vois[2]);
						grille[depart[0]][depart[1]] = ' ';
						grille[vois[0]][vois[1]] = 'R';
						// ajouter diamant
					} else {
						if (grille[vois[0]][vois[1]] == 'r') {
							chemin.add(vois[2]);
							grille[depart[0]][depart[1]] = ' ';
							grille[vois[0]][vois[1]] = 'R';
						} else {
							chemin.add(vois[2]);
							grille[depart[0]][depart[1]] = ' ';
							grille[vois[0]][vois[1]] = 'R';
						}
					}
				}
			}
			// if(sortie)
		}// else s'il n'y a pas de voisins
	}

	public static void evolue(Niveau1 n) throws IOException {
		char[][] grille = n.getCarte();
		int[] depart = depart(grille);
		int[] sortie = sortie(grille);
		int hauteur = grille.length;
		int largeur = grille[0].length;
		List<List> lestab = new ArrayList();
		List<int[]> lesVois = voisins(grille, depart);
		ArrayList chemin;
		// 100 chemins
		for (int l = 0; l < 100; l++) {
			chemin = new ArrayList();
			grille = n.getCarte();
			// nombre de déplacement par chemin
			for (int i = 0; i < 2 * n.getCaveTime(); i++) {
				deplacer(grille, chemin);
				for (int k = 0; k < grille.length; k++) {
					for (int j = 0; j < grille[0].length; j++) {
						System.out.print(grille[k][j]);
					}
					System.out.println();
				}
			}
			// on stocke les chemins
			lestab.add(chemin);
			System.out.print(chemin);
		}
		/*
		 * while(n.getDiamondsRequired()!=n.getRockford().getNbDiamiand()){
		 * deplacer(n,chemin);
		 * 
		 * }
		 */
		// Fichier.enregistrer("test4", chemin);

	}

	/*
	 * public static void evolue2(Niveau n) throws IOException{
	 * char[][]grille=n.getCarte(); int[]depart=depart(n);
	 * int[]sortie=sortie(n); List atteint=new ArrayList(); List prevchemin=new
	 * ArrayList(); prevchemin.add(depart); List pile = new ArrayList(); Couple
	 * co=new Couple(depart,prevchemin); pile.add(co); int[]u=new int[1]; List
	 * chemin=new ArrayList(); List chem=new ArrayList();
	 */
	// Enumeration e = pile.elements();

	/*
	 * while(e.hasMoreElements()){ //u=e.nextElement().;
	 * 
	 * chem=(List) e.nextElement(); u=(int[]) chem.get(0); //chemin=(List)
	 * chem.get(1); System.out.print("u"+u+" "+"chem "+chem);
	 * 
	 * }
	 * 
	 * }
	 */
	public static char cible_al(char[][] map) {
		// A modifier pour j
		int c = 0;
		char a = ' ';
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				c = c + 1;
				Random r = new Random();
				int elt = map.length * map.length;// ts les elt du tableau
				int de = r.nextInt(elt);
				if (c == elt) {
					a = map[i][j];
				}

			}
		}
		return a;
	}

	public static void evolue2(Niveau1 niv) throws IOException {
		char[][] grille = niv.getCarte();
		int[] depart = depart(grille);
		int[] sortie = sortie(grille);
		List atteint = new ArrayList();
		List prevchemin = new ArrayList();
		prevchemin.add(depart);
		List<Couple> pile = new ArrayList();
		Couple co = new Couple(depart, prevchemin);
		pile.add(co);
		int[] u = new int[2];
		List chemin = new ArrayList();
		while (!pile.isEmpty()) {
			u = pile.get(0).getDepart();
			chemin = pile.get(0).getChemin();
			pile.remove(0);
			System.out.println("->" + u.toString() + " " + chemin.toString());
			if (!atteint.contains(u)) {
				atteint.add(u);
				deplacer(grille, chemin);
				prevchemin = chemin;
				int i = u[0];
				int j = u[1];
				if (grille[i][j] == cible_al(grille)) {
					break;
				}
				for (int[] v : voisins(grille, u)) {
					chemin.add(v);
					co = new Couple(v, chemin);
					pile.add(co);
				}
			}
			for (int k = 0; k < grille.length; k++) {
				for (int j = 0; j < grille[0].length; j++) {
					System.out.print(grille[k][j]);
				}
				System.out.println();
			}
		}
	}
}
