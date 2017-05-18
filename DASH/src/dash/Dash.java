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

public class Dash {

	// private Diamant d;
	// private Mur m;
	// private Roc r;
	private Strategie st;
	// private Tableau tab=new Tableau();
	private static List<Niveau> listeniv = new ArrayList<Niveau>();
	// public static Rockford rockford;
	private char[][] map;

	// }
	/*
	 * public static char voisins(char [][] Map){ Map voisin; List<Map>
	 * listevoisin= new ArrayList<Map>();
	 * 
	 * int x; int y; for (x=0;x<Map.length;x++){ for (y=0; y<Map.length;y++){
	 * 
	 * if (Map[x+1][y]==' '|| Map[x+1][y]=='.' || Map[x+1][y]=='d' ){ voisin=
	 * Map[x+1][y]; listevoisin.add(voisin); } if (Map[x-1][y]==' '||
	 * Map[x-1][y]=='.' || Map[x-1][y]=='d' ){ voisin= Map[x-1][y]; } if
	 * (Map[x][y+1]==' '|| Map[x][y+1]=='.' || Map[x][y+1]=='d' ){ voisin=
	 * Map[x][y+1]; } if (Map[x][y-1]==' '|| Map[x][y-1]=='.' ||
	 * Map[x][y-1]=='d' ){ voisin= Map[x][y-1]; } } } return voisin; }
	 */
	public static List<int[]> jouer(Niveau niv) {
		Scanner s = new Scanner(System.in);
		boolean gagne = false;
		boolean fini = false;
		char[][] grille = niv.getCarte();
		int[] dep = Carte.depart(grille);
		int[] sor = Carte.sortie(niv, grille);
		int x = dep[0];
		int y = dep[1];
		int[]tabv=new int[3];
		List chemin = new ArrayList();
		System.out.println("cavetime"+niv.getCaveTime());
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
						&& grille[x - 1][y] != 'a' && grille[x + 1][y] != 'q') {

					if (grille[x - 1][y] == 'r') {
						Tableau tab = new Tableau();
						tab.Map = grille;
						if(Tableau.deplacerRoc(tab, x-1, y)){
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
					if (grille[x - 1][y] == 'a' || grille[x + 1][y] == 'q') {
						grille[x][y] = ' ';
						grille[x - 1][y] = 'R';
						chemin.add(8);
						niv.getRockford().seDeplacer();
						fini = true;
					}
				}
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
						if(Tableau.deplacerRoc(tab, x+1, y)){
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
						if(Tableau.deplacerRoc(tab, x, y+1)){

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
						if(Tableau.deplacerRoc(tab, x, y-1)){

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
				break;
			default:
				System.out.println("mauvaise touche");
			}

		}
		aff(grille, niv);
		System.out.println("SCORE:"+niv.getRockford().getNbdiamant()*niv.getDiamondValue()[0]);
		if(gagne){
		System.out.println("GAGNE");}
		else{
			System.out.println("GAME OVER");
		}
		System.out.println("enregistrer: nom du fichier");
		String fic=s.next();
		try {
			Fichier.enregistrer(fic+".dash",chemin);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
return chemin;
	}

	public static void aff(char[][] map, Niveau n) {
		System.out.println("nombre de déplacements maximum:" + n.getCaveTime());
		System.out.println("nombre de déplacements de Rockford:" + n.getRockford().getNbdeplacement());
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

	public static void main(String[] args) throws Exception {
		
		int z = 0;
		Niveau niveau = new Niveau();
		ArrayList<Niveau> niv = new ArrayList();
		Rockford rockford = new Rockford();
		Scanner s = new Scanner(System.in);
		System.out.println("Entrer le nom du fichier à lire");
		String nom = s.next();
		File f = new File(nom);
		char[][] map = null;
		niv = dash.Fichier.lirefichier("BD01plus.bd");

		System.out.println("Strategie:");
		System.out.println("Taper 1 pour strategie simplet");
		System.out.println("Taper 2 pour strategie evolué");
		System.out.println("Taper 3 pour strategie directif");
		System.out.println("Taper 4 pour strategie directif evolué");
		System.out.println("Taper 5 pour strategie parfait");
		Tableau tab = new Tableau();
		int a = s.nextInt();
		switch (a) {
		case 1:
			int ch=1;
			while(ch==1){
			System.out.println("Choisir le numéro du niveau:");
			z=s.nextInt();
			while (z>niv.size()||z==0){
				System.out.println("Choisir le numéro du niveau:");
				z=s.nextInt();
			}
				
				
			
				//niv2=trierniv(niv);
				niveau=niv.get(z-1);
					System.out.println(niv.get(z-1).getName());
				
				rockford.setTime (niveau.getCaveTime());
				Tableau tab2=new Tableau(niveau.getCarte());
				
				
				
				
				
				
				tab.simplet(rockford,tab2,niveau);
			System.out.println("Continuer ? 0=Non 1=Oui");
			ch=s.nextInt();
	}

			break;
		case 2:

			niveau = niv.get(z);

			map = niveau.getCarte();
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}

			// niveau.setCarte(map);
			// char[][] grille = niveau.getCarte();
			System.out.println(Carte.depart(map)[0] + " "
					+ Carte.depart(map)[1]);
			System.out.println(Carte.sortie(niveau, map)[0] + " "
					+ Carte.sortie(niveau, map)[1]);
			List moves = new ArrayList();
			int[] c = { 2, 5, 3, 6, 4, 8, 2, 4, 6, 6, 8 };
			for (int i = 0; i < c.length; i++) {
				moves.add(c[i]);
			}
			// Carte.evolue(niv);
			dash.Carte.evolue(niveau);
			Fichier.enregistrer("test", moves);
			break;
		case 3:
			niveau = niv.get(3);

			map = niveau.getCarte();
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}

			dash.Carte.directif(niveau);

			break;
		case 4:
			jouer(niv.get(19));
			
			
			break;
		case 5:
			break;
		default:
			System.out.println("mauvaise touche");

		}
	}
}
