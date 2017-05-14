package dash;

import java.io.IOException;
import java.util.*;

public class Tableau {
	public char[][] Map = new char[8][7];
	public int x;
	public int y;
	public ArrayList depl;

	public Tableau() {
		/*
		 * for (int i=0; i<Map.length; i++){ for (int j=0; j<Map.length; j++){
		 * if (Map [i][j]=='P'){ this.x=i; this.y=j; } }
		 * 
		 * } this.depl=new ArrayList();
		 */
	}

	public Tableau(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void adddepl(String d) {
		// ajoute une direction dans la liste depl
		depl.add(d);
	}

	// les voisins où l'on peut se déplacer
	public static List<int[]> voisins(Niveau n, int[] pos) {
		List<int[]> vois = new ArrayList<int[]>();
		int x = pos[0];
		int y = pos[1];
		char[][] grille = n.getCarte();
		// voisin du bas
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

	// retourne le départ ou la case de Rockford si la partie a commencé sinon
	// tableau -1,-1
	public static int[] depart(Niveau n) {
		char[][] grille = n.getCarte();
		int[] tabv;
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille.length; j++) {
				if (grille[i][j] == 'P' || grille[i][j] == 'R') {
					tabv = new int[] { i, j };
					return tabv;
				}
			}
		}
		return new int[] { -1, -1 };
	}

	// retourne la sortie qui apparait après le bon compte de diamand, sinon
	// retourne tableau -1,-1
	public static int[] sortie(Niveau n) {
		char[][] grille = n.getCarte();
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

	public static void deplacer(Niveau n, ArrayList chemin) {
		char[][] grille = n.getCarte();
		int[] depart = depart(n);
		int[] sortie = sortie(n);
		List<int[]> lesVois = voisins(n, depart);
		String s = "";

		int rand = (int) (Math.random() * lesVois.size());
		System.out.println("RAND" + rand);
		for (int[] v : lesVois) {
			System.out.println(v[0] + " " + v[1] + " " + v[2]);
		}

		int suiv = -1;

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
	}

	public static void evolue(Niveau n) throws IOException {
		char[][] grille = n.getCarte();
		int[] depart = depart(n);
		int[] sortie = sortie(n);
		int hauteur = grille.length;
		int largeur = grille[0].length;
		List<int[]> lesVois = voisins(n, depart);
		ArrayList chemin = new ArrayList();
		for (int i = 0; i < 10; i++) {
			deplacer(n, chemin);
			for (int k = 0; k < grille.length; k++) {
				for (int j = 0; j < grille[0].length; j++) {
					System.out.print(grille[k][j]);
				}
				System.out.println();
			}
		}
		System.out.print(chemin);
		/*
		 * while(n.getDiamondsRequired()!=n.getRockford().getNbDiamiand()){
		 * deplacer(n,chemin);
		 * 
		 * }
		 */
		Fichier.enregistrer("test4", chemin);

	}
	public static char cible_al(char[][] map){
		//A modifier pour j
		int c=0;
		char a=' ';
		for (int i=0; i<map.length; i++){
		for (int j=0;j<map.length;j++){
			c=c+1;
			Random r= new Random();
			int elt=map.length*map.length;//ts les elt du tableau
			int de=r.nextInt(elt);
			if (c==elt){
				a=map[i][j];
			}
			
		}
		}
		return a;
	}
	public static void evolue2(Niveau n) throws IOException {
		char[][] grille = n.getCarte();
		int[] depart = depart(n);
		int[] sortie = sortie(n);
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
			System.out.println("->" + u.toString() + " " + chemin.toString());
			if(!atteint.contains(u)){
				atteint.add(u);
				//deplacer
				prevchemin=chemin;
				int i=u[0];
				int j=u[1];
				if (grille[i][j]==cible_al(grille)){
					break;
				}
				for (int[] v:voisins( n, u)){
					chemin.add(v);
					co=new Couple(v,chemin);
					pile.add(co);
				}
			}
		}
		List chem = new ArrayList();
		// Enumeration e = pile.elements();

		/*
		 * while(e.hasMoreElements()){ //u=e.nextElement().;
		 * 
		 * chem=(List) e.nextElement(); u=(int[]) chem.get(0); //chemin=(List)
		 * chem.get(1); System.out.print("u"+u+" "+"chem "+chem);
		 * 
		 * }
		 */

	}

	public static void simplet(Rockford rockford, Tableau Map) {
		// strategie du simplet
		String nom = "";
		Tableau depart = Map;
		Tableau chemin = depart;
		Tableau suiv = depart;
		// chemin doit memoriser tout le chemin
		while (rockford.time != 0) {
			chemin = depart;
			suiv = rockford.prochaindeplacementA(suiv, depart.x, depart.y);
			char contenusuiv = rockford.contenusuiv(suiv.x, suiv.y);

			/*
			 * if (contenusuiv=='w'||contenusuiv=='W'|| contenusuiv=='M'){
			 * //Rocfor ne se deplace pas si il rencontre un mur }
			 */

			if (contenusuiv == 'r') {
				// suv.x et non depart.x
				deplacerRoc(Map, depart.x, depart.y);
				// faire si il peux pas le déplacer
				Map.Map[depart.x][depart.y] = ' ';
				depart = suiv;
			}

			if (contenusuiv == 'd') {
				rockford.adddiamant();
				Map.Map[depart.x][depart.y] = ' ';
				Map.Map[suiv.x][suiv.y] = 'R';
				depart = suiv;
			}

			if (contenusuiv == ' ') {
				Map.Map[depart.x][depart.y] = ' ';
				Map.Map[suiv.x][suiv.y] = 'R';
			}

			if (contenusuiv == 'c' || contenusuiv == 'b' || contenusuiv == 'B'
					|| contenusuiv == 'C') {
				nom = "libellule";
				Map.Map[depart.x][depart.y] = ' ';
				Map.Map[suiv.x][suiv.y] = 'R';
				break;
			}

			if (contenusuiv == 'F' || contenusuiv == 'q' || contenusuiv == 'o'
					|| contenusuiv == 'O' || contenusuiv == 'Q') {
				nom = "luciole";
				Map.Map[depart.x][depart.y] = ' ';
				Map.Map[suiv.x][suiv.y] = 'R';
				break;
			}

			if (contenusuiv == 'a') {
				nom = "amibe";
				Map.Map[depart.x][depart.y] = ' ';
				Map.Map[suiv.x][suiv.y] = 'R';
				break;
			}

			if (contenusuiv == 'X') {
				nom = "fin";
				break;
			}

		}
		rockford.toString(nom);
	}

	public static boolean deplacerRoc(Tableau Map, int x, int y) {
		// déplacement de Roc par Rockford
		if (Map.Map[x][y + 1] == ' ') {
			Map.Map[x][y] = 'R';
			Map.Map[x][y + 1] = 'r';
			return true;
		} else if (Map.Map[x][y - 1] == ' ') {
			Map.Map[x][y] = 'R';
			Map.Map[x][y - 1] = 'r';
			return true;
		}
		return false;
	}

	public static void tomberRoc(Tableau Map) {
		// Quand Roc tombe
		for (int x = 0; x < Map.Map.length; x++) {
			for (int y = 0; y < Map.Map.length; y++) {
				if (Map.Map[x][y] == 'r') {
					while (Map.Map[x + 1][y] == ' ') {
						Map.Map[x][y] = ' ';
						Map.Map[x + 1][y] = 'r';
					}
				}
			}
		}

	}
}
