package bdProjet;

import java.io.IOException;
import java.util.*;

//import dash1.Niveau1;

public class Carte {
	public static final int nbtab = 5;
	public static final int infini = 1000;

	

/**

*

* la liste des voisins, un voisin est un tableau à 3 cases avec coordonnées x, y et déplacement

* @param grille
* carte du niveau
* @param pos 
* position de Rockford
* 
* @return liste des voisins où l'on peut se déplacer

*/
	// les voisins où l'on peut se déplacer
	public static List<int[]> voisins(char[][] grille, int[] pos) {
		List<int[]> vois = new ArrayList<int[]>();
		int x = pos[0];
		int y = pos[1];
		
		
		// char[][]grille=n.getCarte();
		// voisin du bas
		if (grille[x + 1][y] != 'W' && grille[x + 1][y] != 'w'
				&& grille[x + 1][y] != 'a' && grille[x + 1][y] != 'q') {
			System.out.print("bas");
			int[] tabv = { x + 1, y, 2 };
			vois.add(tabv);
		}
		// voisin de droite
		if (grille[x][y + 1] != 'W' && grille[x][y + 1] != 'w'
				&& grille[x][y + 1] != 'a' && grille[x][y+1] != 'q') {
			System.out.print("droite");
			int[] tabv = { x, y + 1, 6 };
			vois.add(tabv);
		}
		// voisin du haut
		if (grille[x - 1][y] != 'W' && grille[x - 1][y] != 'w'
				&& grille[x - 1][y] != 'a' && grille[x - 1][y] != 'q') {
			System.out.print("haut");
			int[] tabv = { x - 1, y, 8 };
			vois.add(tabv);
		}
		// voisin de gauche
		if (grille[x][y - 1] != 'W' && grille[x][y - 1] != 'w'
				&& grille[x][y - 1] != 'a' && grille[x ][y-1] != 'q') {
			System.out.print("gauche");
			int[] tabv = { x, y - 1, 4 };
			vois.add(tabv);
		}
		// retourne la liste des voisins, un voisin est un tableau à 3 cases
		// avec coordonnées x, y et déplacement
		return vois.isEmpty() ? null : vois;

	}
	
	/**

	*

	* la sortie quand Rockford a ramassé assez de diamants

	* @param n 
	* niveau
	* 
	* @param grille
	* carte du niveau
	* 
	* @return position de la sortie sinon {-1,-1} si elle n'est pas apparue 

	*/

	// retourne la sortie qui apparait après le bon compte de diamand, sinon
	// retourne tableau -1,-1
	public static int[] sortie(Niveau n, char[][] grille) {
		// char[][]grille=n.getCarte();
		int[] tabv;
		if (n.getDiamondsRequired() == n.getRockford().getNbDiamand()) {
			for (int i = 0; i < grille.length; i++) {
				for (int j = 0; j < grille.length; j++) {
					if (grille[i][j] == 'X') {
						tabv = new int[] { i, j };
						return tabv;
					}
				}
			}
		}
		return new int[] { -1, -1 };
	}

	
	
	/**

	*

	* la position de Rockford
	*
	* @param grille
	* carte du niveau
	* 
	* @return position de Rockford sinon {-1,-1}

	*/

	// retourne le départ ou la case de Rockford si la partie a commencé sinon
	// tableau -1,-1
	public static int[] depart(char[][] grille) {
		// char[][]grille=n.getCarte();
		int[] tabv;
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[0].length; j++) {
				if (grille[i][j] == 'P' || grille[i][j] == 'R') {
					tabv = new int[] { i, j };
					return tabv;
				}
			}
		}
		return new int[] { -1, -1 };
	}

	/**

	*

	* Déplace Rockford sur un voisin

	* @param n 
	* niveau
	* 
	* @param grille
	* carte du niveau
	* 
	* @param chemin
	* chemin parcouru
	* 
	* @return true si Rockford a atteint la sortie sinon false

	*/

	public static boolean deplacer(Niveau n, char[][] grille, List chemin) {
		// char[][]grille=n.getCarte();
		int[] depart = depart(grille);
		int[] sortie = sortie(n, grille);
		List<int[]> lesVois = voisins(grille, depart);
		String s = "";

		int rand = (int) (Math.random() * lesVois.size());
		System.out.println("RAND" + rand);
		for (int[] v : lesVois) {
			System.out.println(v[0] + " " + v[1] + " " + v[2]);
		}

		int suiv = -1;
		if (lesVois.size() > 0) {
			int[] vois = lesVois.get(rand);
			// on regarde s'il y a un diamand dans les voisins ou la sortie
			for (int[] v : lesVois) {
				if (grille[v[0]][v[1]] == 'd') {
					suiv = lesVois.indexOf(v);
				}
				if ((grille[v[0]][v[1]] == 'x' || grille[v[0]][v[1]] == 'X')
						&& sortie != new int[] { -1, -1 }) {
					suiv = lesVois.indexOf(v);
					break;
				}
			}
			// s'il y a un diamand ou la sortie dans les voisins on va sur cette
			// case
			if (suiv >= 0) {
				vois = lesVois.get(suiv);
				chemin.add(vois[2]);
				if (grille[vois[0]][vois[1]] == 'x'
						|| grille[vois[0]][vois[1]] == 'X') {
					grille[depart[0]][depart[1]] = ' ';
					grille[vois[0]][vois[1]] = 'R';
					return true;
				} else {
					grille[depart[0]][depart[1]] = ' ';
					grille[vois[0]][vois[1]] = 'R';
					// ajout diamand
					n.getRockford().adddiamant();
					System.out.println("suiv " + suiv);
				}
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
						n.getRockford().adddiamant();
					} else {
						if (grille[vois[0]][vois[1]] == 'r') {
							chemin.add(vois[2]);
							Tableau map=new Tableau();
							map.Map=grille;
							Tableau.deplacerRoc(map, vois[0], vois[1]);
							/*grille[depart[0]][depart[1]] = ' ';
							grille[vois[0]][vois[1]] = 'R';*/
						} else {
							chemin.add(vois[2]);
							grille[depart[0]][depart[1]] = ' ';
							grille[vois[0]][vois[1]] = 'R';
						}
					}
				}
			}
		}
		return false;
		//
	}

	// PAS FINI
	public static void croisement(List<List> lestab, Niveau n) {
		int croi = lestab.size() / 2;
		int nb = 0;
		int rand = 0;
		List tab = new ArrayList();

		// croisement
		for (int i = 0; i < croi; i += 2) {
			lestab.get(i);

			lestab.get(i + 1);
		}

		for (int i = 0; i < lestab.size(); i++) {
			if (tab.size() < croi && lestab.get(i).size() <= n.CaveTime) {
				tab.add(lestab.remove(i));
			}
		}
		while (tab.size() < croi) {
			rand = (int) (Math.random() * lestab.size());
			tab.add(lestab.remove(rand));
		}
		// mutation
		if (nbtab % 2 != 0) {
			nb = nbtab - 1;
		} else {
			nb = nbtab;
		}
		for (int i = croi; i < nb; i += 2) {
			lestab.get(i);
		}
	}

	
	/**

	*

	* Sélectionne les meilleurs chemins

	* @param lestab
	* liste des chemins
	* 
	* @param n
	*  niveau
	* 
	* 
	* @return la liste des meilleurs chemins

	*/
	public static List selection(List<List> lestab, Niveau n) {
		int croi = lestab.size() / 2;
		int nb = 0;
		int rand = 0;
		List tab = new ArrayList();
		// croisement
		for (int i = 0; i < lestab.size(); i++) {
			if (tab.size() < croi && lestab.get(i).size() <= n.CaveTime) {
				tab.add(lestab.remove(i));
			}
		}
		while (tab.size() < croi) {
			rand = (int) (Math.random() * lestab.size());
			tab.add(lestab.remove(rand));
		}
		return tab;
	}


	/**

	*

	* Joueur évolué

	* @param n 
	* niveau
	* 
	* @param grille
	* carte du niveau
	* 
	* @param chemin
	* chemin parcouru
	* 
	* @return true si Rockford a atteint la sortie sinon false

	*/
	public static void evolue(Niveau n) throws IOException {
		char[][] grille = n.getCarte();
		int[] depart = depart(grille);
		int[] sortie = sortie(n, grille);
		int hauteur = grille.length;
		int largeur = grille[0].length;
		List<List> lestab = new ArrayList();
		List<int[]> lesVois = voisins(grille, depart);
		ArrayList chemin = new ArrayList();
		// nb chemin
		for (int l = 0; l < nbtab; l++) {

			chemin = new ArrayList();
			grille = n.getCarte();
			// nombre de déplacement par chemin
			for (int i = 0; i < 2 * n.getCaveTime(); i++) {
				// si c la sortie deplacer renvoie true
				if (deplacer(n, grille, chemin)) {
					break;
				}
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
		 * while(lestab.size()>1){ lestab=selection(lestab,n);
		 * lestab=croisement(lestab,n); }
		 */
	}

	public static char cible_al(char[][] map) {
		// A modifier pour j
		int c = 0;
		char a = ' ';
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				c = c + 1;
				Random r = new Random();
				int elt = map.length * map[0].length;// ts les elt du tableau
				int de = r.nextInt(elt);
				if (c == elt) {
					a = map[i][j];
				}

			}
		}
		return a;
	}

	public static void evolue2(Niveau niv) throws IOException {
		char[][] grille = niv.getCarte();
		int[] depart = depart(grille);
		int[] sortie = sortie(niv, grille);
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
				deplacer(niv, grille, chemin);
				niv.getRockford().seDeplacer();
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

	public static void init(char[][] grille, int[] depart) {
		Poidsatt[][] map1 = null;
		Coupleint[][] pere = null;
		for (int k = 0; k < grille.length; k++) {
			for (int j = 0; j < grille[0].length; j++) {
				map1[k][j] = new Poidsatt(-1, false);
				pere[k][j] = new Coupleint(-1, -1);
			}
		}
		map1[depart[0]][depart[1]] = new Poidsatt(0, false);
	}

	// return case non atteinte de plus petit poids passe à atteint
	public static int[] extrairemin(List<int[]> f, Poidsatt[][] map1) {
		int[] min = f.get(0);
		for (int[] a : f) {

			if ((!map1[a[0]][a[1]].isAtteint())
					&& (map1[a[0]][a[1]].getPoids()) < (map1[min[0]][min[1]]
							.getPoids())) {
				min = a;
			}
		}
		map1[min[0]][min[1]].setAtteint(true);

		System.out.print("MIN"+min[0]+" "+min[1]+"mAP"+map1[min[0]][min[1]].isAtteint()+" "+map1[min[0]][min[1]].getPoids());
		return min;
	}

	// plus court chemin
	public static List<int[]> dijkstra(char[][] grille, int[] depart) {
		// init
		Poidsatt[][] map1 = new Poidsatt[grille.length][grille[0].length];
		Coupleint[][] pere = new Coupleint[grille.length][grille[0].length];
		for (int k = 0; k < grille.length; k++) {
			for (int j = 0; j < grille[0].length; j++) {
				map1[k][j] = new Poidsatt(10000, false);
				pere[k][j] = new Coupleint(-1, -1);
			}
		}
		map1[depart[0]][depart[1]] = new Poidsatt(0, false);
		// fin init
		// f liste des cases

		List<int[]> x = new ArrayList();
		List<int[]> f = new ArrayList();
		for (int k = 0; k < grille.length; k++) {
			for (int j = 0; j < grille[0].length; j++) {
				f.add(new int[] { k, j });
			}
		}
		//
		while (!f.isEmpty()) {
			int[] u = extrairemin(f, map1);
			f.remove(u);
			x.add(u);
//ICIIIIIIIIII
			//ICIIIIIIIIII	
			//ICIIIIIIIIII
			for (int[] v : voisins(grille, u)) {
				// relacher, si le voisin pas atteint et poids fils > poids pere +1
				if ((!map1[v[0]][v[1]].isAtteint())
						&& (map1[v[0]][v[1]].getPoids() > map1[u[0]][u[1]]
								.getPoids() + 1)) {
					map1[v[0]][v[1]].setPoids(map1[u[0]][u[1]].getPoids() + 1);
					pere[v[0]][v[1]] = new Coupleint(u[0], u[1]);
				}//
			}
		}
		return x;
	}

	public static void directif(Niveau niv) {
		char[][] grille = niv.getCarte();
		int[] depart = depart(grille);
		int[] sortie = sortie(niv, grille);
		System.out.print(depart[0]+" "+depart[1]);
		List<int[]> x = dijkstra(grille, depart);
		for (int[] a : x) {
			System.out.print(a.toString());
		}
	}

	/*
	 * public static void evolue2(Niveau n) throws IOException{
	 * char[][]grille=n.getCarte(); int[]depart=depart(n);
	 * int[]sortie=sortie(n); List atteint=new ArrayList(); List prevchemin=new
	 * ArrayList(); prevchemin.add(depart); List pile = new ArrayList(); Couple
	 * co=new Couple(depart,prevchemin); pile.add(co); int[]u=new int[1]; List
	 * chemin=new ArrayList(); List chem=new ArrayList();
	 * 
	 * }
	 */

}