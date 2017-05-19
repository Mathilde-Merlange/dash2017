package dash;

import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/*import dash1.Carte;
 import dash1.Fichier;
 import dash1.Niveau1;*/
/**
 * Cette classe contient des fonctions pour le mode interactif.
 */
public class Dash {
	//faire réapparaitre la sortie
public static void sortie(char[][] grille2, char[][] grille) {
			// char[][]grille=n.getCarte();
			int[] tabv=new int[]{0,0};
				for (int i = 0; i < grille2.length; i++) {
					for (int j = 0; j < grille2[0].length; j++) {
						if (grille2[i][j] == 'X') {
							grille[i][j]= 'X';
							
						}
					}
				}
			
		}
	/**
	 * 
	 * 
	 * 
	 * Mode interactif qui affiche le score et demande d'enregistrer le chemin à
	 * la fin de la partie au format .dash
	 * 
	 * 
	 * @param niv
	 *            niveau
	 * 
	 * 
	 * 
	 * @return le chemin parcouru par Rockford
	 */
	public static List<int[]> jouer(Niveau niv) {
		
		
		Scanner s = new Scanner(System.in);
		boolean gagne = false;
		boolean fini = false;
		char[][] grille = niv.getCarte();
		char[][] grille2 = niv.getCarte();
		int[] dep = Carte.depart(grille);
		int[] sor = Carte.sortie(niv, grille);
		int x = dep[0];
		int y = dep[1];
		int[] tabv = new int[3];
		List chemin = new ArrayList();
		System.out.println("cavetime" + niv.getCaveTime());
		while (niv.getCaveTime() > niv.getRockford().getNbdeplacement()
				&& !gagne && !fini) {
			dep = Carte.depart(grille);
			x = dep[0];
			y = dep[1];
			aff(grille, niv);
			System.out.println("jouer:");
			System.out.println("Taper 8 pour haut");
			System.out.println("Taper 2 pour bas");
			System.out.println("Taper 6 pour droite");
			System.out.println("Taper 4 pour gauche");
			int c = s.nextInt();
			switch (c) {
			case 5:
				chemin.add(5);
				break;
			case 8:
				if (niv.getDiamondsRequired() <= niv.getRockford()
						.getNbdiamant()) {
					if (grille[x - 1][y] == 'X') {
						grille[x][y] = ' ';
						grille[x - 1][y] = 'R';
						chemin.add(8);
						niv.getRockford().seDeplacer();
						fini = true;
						gagne = true;
					}
				}
				
				if (grille[x - 1][y] != 'W' && grille[x - 1][y] != 'w'
						&& grille[x - 1][y] != 'a' && grille[x - 1][y] != 'q') {

					if (grille[x - 1][y] == 'r') {
						Tableau tab = new Tableau();
						tab.Map = grille;
						if (Tableau.deplacerRoc(tab, x - 1, y)) {
							chemin.add(8);
							niv.getRockford().seDeplacer();
						}
					} else {
						if (grille[x - 1][y] == 'd') {
							niv.getRockford().adddiamant();
						}
						grille[x][y] = ' ';
						grille[x - 1][y] = 'R';
						chemin.add(8);
						niv.getRockford().seDeplacer();
					}

				} else {
					if (grille[x - 1][y] == 'a' || grille[x - 1][y] == 'q') {
						grille[x][y] = ' ';
						grille[x - 1][y] = 'R';
						chemin.add(8);
						niv.getRockford().seDeplacer();
						fini = true;
					}
				}
				if (niv.getDiamondsRequired() <= niv.getRockford()
						.getNbdiamant()) {
					sortie(grille2, grille);}
				break;
			case 2:
				if (niv.getDiamondsRequired() <= niv.getRockford()
						.getNbdiamant()) {
					if (grille[x + 1][y] == 'X') {
						grille[x][y] = ' ';
						grille[x + 1][y] = 'R';
						chemin.add(2);
						niv.getRockford().seDeplacer();
						fini = true;
						gagne = true;
					}
				}
				if (grille[x + 1][y] != 'W' && grille[x + 1][y] != 'w'
						&& grille[x + 1][y] != 'a' && grille[x + 1][y] != 'q') {

					if (grille[x + 1][y] == 'r') {
						Tableau tab = new Tableau();
						tab.Map = grille;
						if (Tableau.deplacerRoc(tab, x + 1, y)) {
							chemin.add(2);
							niv.getRockford().seDeplacer();
						}
					} else {
						if (grille[x + 1][y] == 'd') {
							niv.getRockford().adddiamant();
						}
						grille[x][y] = ' ';
						grille[x + 1][y] = 'R';

						chemin.add(2);
						niv.getRockford().seDeplacer();
					}
				} else {
					if (grille[x + 1][y] == 'a' || grille[x + 1][y] == 'q') {
						grille[x][y] = ' ';
						grille[x + 1][y] = 'R';
						chemin.add(2);
						niv.getRockford().seDeplacer();
						fini = true;
					}
				}
				if (niv.getDiamondsRequired() <= niv.getRockford()
						.getNbdiamant()) {
					sortie(grille2, grille);}
				break;
			case 6:
				if (niv.getDiamondsRequired() <= niv.getRockford()
						.getNbdiamant()) {
					if (grille[x][y + 1] == 'X') {
						grille[x][y] = ' ';
						grille[x][y + 1] = 'R';
						chemin.add(6);
						niv.getRockford().seDeplacer();
						fini = true;
						gagne = true;
					}
				}
				if (grille[x][y + 1] != 'W' && grille[x][y + 1] != 'w'
						&& grille[x][y + 1] != 'a' && grille[x][y + 1] != 'q') {

					if (grille[x][y + 1] == 'r') {
						Tableau tab = new Tableau();
						tab.Map = grille;
						if (Tableau.deplacerRoc(tab, x, y + 1)) {

							chemin.add(6);
							niv.getRockford().seDeplacer();
						}
					} else {
						if (grille[x][y + 1] == 'd') {
							niv.getRockford().adddiamant();
						}
						grille[x][y] = ' ';
						grille[x][y + 1] = 'R';

						chemin.add(6);
						niv.getRockford().seDeplacer();
					}
				} else {
					if (grille[x][y + 1] == 'a' || grille[x][y + 1] == 'q') {
						grille[x][y] = ' ';
						grille[x][y + 1] = 'R';
						chemin.add(6);
						niv.getRockford().seDeplacer();
						fini = true;
					}
				}
				if (niv.getDiamondsRequired() <= niv.getRockford()
						.getNbdiamant()) {
					sortie(grille2, grille);}
				break;
			case 4:
				if (niv.getDiamondsRequired() <= niv.getRockford()
						.getNbdiamant()) {
					if (grille[x][y - 1] == 'X') {
						grille[x][y] = ' ';
						grille[x][y - 1] = 'R';
						chemin.add(4);
						niv.getRockford().seDeplacer();
						fini = true;
						gagne = true;
					}
				}
				if (grille[x][y - 1] != 'W' && grille[x][y - 1] != 'w'
						&& grille[x][y - 1] != 'a' && grille[x][y - 1] != 'q') {

					if (grille[x][y - 1] == 'r') {
						Tableau tab = new Tableau();
						tab.Map = grille;
						if (Tableau.deplacerRoc(tab, x, y - 1)) {

							chemin.add(4);
							niv.getRockford().seDeplacer();
						}
					} else {
						if (grille[x][y - 1] == 'd') {
							niv.getRockford().adddiamant();
						}
						grille[x][y] = ' ';
						grille[x][y - 1] = 'R';
						chemin.add(4);
						niv.getRockford().seDeplacer();
					}

				} else {
					if (grille[x][y - 1] == 'a' || grille[x][y - 1] == 'q') {
						grille[x][y] = ' ';
						grille[x][y - 1] = 'R';
						chemin.add(4);
						niv.getRockford().seDeplacer();
						fini = true;
					}
				}
				if (niv.getDiamondsRequired() <= niv.getRockford()
						.getNbdiamant()) {
					sortie(grille2, grille);}
				break;
			default:
				System.out.println("mauvaise touche");
			}

		}
		aff(grille, niv);
		System.out.println("SCORE:" + niv.getRockford().getNbdiamant()
				* niv.getDiamondValue()[0]);
		if (gagne) {
			System.out.println("GAGNE");
		} else {
			System.out.println("GAME OVER");
		}
		System.out.println("enregistrer: nom du fichier");
		String fic = s.next();
		try {
			Fichier.enregistrer(fic + ".dash", chemin);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return chemin;
	}

	/**
	 * 
	 * 
	 * 
	 * Affiche la carte du niveau
	 * 
	 * @param map
	 *            carte du niveau
	 * 
	 * @param n
	 *            niveau
	 * 
	 */
	public static void aff(char[][] map, Niveau n) {
		System.out.println("nombre de déplacements maximum:" + n.getCaveTime());
		System.out.println("nombre de déplacements de Rockford:"
				+ n.getRockford().getNbdeplacement());
		System.out.println("diamants requis:" + n.getDiamondsRequired());
		System.out
				.println("diamants obtenus:" + n.getRockford().getNbdiamant());
		if (n.getDiamondsRequired() <= n.getRockford().getNbdiamant()) {
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		} else {

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					if ((map[i][j]) == 'X') {
						System.out.print(' ');
					} else {
						System.out.print(map[i][j]);
					}
				}
				System.out.println();
			}
		}
	}

	
}
