package dash;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class args {
	public static List lirechemin(String nomfichier)
			throws FileNotFoundException {

		List che = new ArrayList();
		File file = new File(nomfichier);
		Scanner sc = new Scanner(file);

		try {
			if (sc.hasNext()) {
				String ligne = sc.next();
				System.out.print(ligne);

				for (int i = 0; i < ligne.length(); i++) {
					switch (ligne.charAt(i)) {
					case 'D':
						che.add(2);
						break;
					case 'L':
						che.add(4);
						break;
					case 'I':
						che.add(5);
						break;
					case 'R':
						che.add(6);
						break;
					case 'U':
						che.add(8);
						break;
					default:

					}
				}
			}
		} catch (Exception ex) {
			ex.getMessage();// catch
		}
		return che;
	}

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Niveau> niv = new ArrayList();
		Rockford rockford = new Rockford();
		Niveau niveau = new Niveau();
		List che = new ArrayList();
		String a1 = args[0];
		String num = "";
		int numniv = 0;
		Tableau tab2 = null;
		Scanner s = new Scanner(System.in);
		switch (a1) {
		case "-name":
			afficherIdentite();
			break;
		case "-h":
			afficherOptions();
			break;

		case "-lis":
			String nomF = args[1];
			Fichier.lirefichier(nomF);
			// ArrayList moves = Move.depFichier(nomF);

			break;
		case "-joue":
			String nomF1 = args[1];
			niv = Fichier.lirefichier(nomF1);
			if (args.length == 4) {
				String a = args[3];
				int b = Integer.parseInt(a);

				Dash.jouer(niv.get(b - 1));
			} else {
				int lim = 0;
				while (lim != (niv.size() - 1)) {
					Dash.jouer(niv.get(lim));
					lim++;
				}

			}

			break;

		case "-cal":
			Tableau tab = new Tableau();
			String strategie = args[1];
			String nomF2 = args[2];
			niv = Fichier.lirefichier(nomF2);
			switch (strategie) {

			case "-simplet":
				num = args[4];
				numniv = Integer.parseInt(num);
				niveau = niv.get(numniv - 1);
				rockford.setTime(niveau.getCaveTime());
				tab2 = new Tableau(niveau.getCarte());
				tab.simplet(rockford, tab2, niveau);

				System.out.println("enregistrer: nom du fichier");
				String fic1 = s.next();
				try {
					Fichier.enregistrer2(fic1 + ".dash", tab2.depl);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case "-evolue":
				num = args[4];
				numniv = Integer.parseInt(num);
				niveau = niv.get(numniv - 1);
				rockford.setTime(niveau.getCaveTime());
				try {

					che = Carte.evolue(niveau);
					niveau.getRockford().setNbDiamant(0);
					Carte.evaluer(che, niveau);
					System.out.println("enregistrer: nom du fichier");
					String fic = s.next();
					try {
						Fichier.enregistrer(fic + ".dash", che);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case "-directif":
				num = args[4];
				numniv = Integer.parseInt(num);
				niveau = niv.get(numniv - 1);
				rockford.setTime(niveau.getCaveTime());
				try {
					dash.Carte.directif(niveau);
				} catch (Exception e) {
					e.getMessage();
				}
				break;
			default:
				System.out.println("mauvais nom");

			}

			break;

		case "-rejoue":
			num = args[4];
			numniv = Integer.parseInt(num);
			System.out.println("num" + numniv);
			String nomF3 = args[2];
			niv = Fichier.lirefichier(nomF3);
			niveau = niv.get(numniv - 1);
			String nomF4 = args[1];
			che = lirechemin(nomF4);
			Carte.evaluer(che, niveau);
			break;
		case "-simul":
			break;

		default:
			System.out.println("mauvaise entrée");
		}
	}

	/**
	 * 
	 * 
	 * 
	 * Affiche nos prénoms et noms
	 * 
	 * 
	 */
	private static void afficherIdentite() {
		System.out.println("Mathilde Merlange");
		System.out.println("Adélie Calvo Fernandez");
		System.out.println("Li-San Sultan");
	}

	/**
	 * 
	 * 
	 * Affiche les options du programme
	 */
	private static void afficherOptions() {
		System.out.println("-name affiche les noms des codeurs");
		System.out.println("-h affiche la liste des options du programme");
		System.out
				.println("-lis lit et affiche les parametres d'un fichier BDCFF");
		System.out.println("-joue joue de maniere interactive ");
		System.out.println("-cal joue avec une strategie");
		System.out.println("-rejoue rejoue une partie avec des déplacements");
		System.out.println("-simul evalue deux strategies en parametre ");
	}

}