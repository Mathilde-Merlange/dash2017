package dash1;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import dash.Niveau;

public class Fichier {
	// UDLRI

	public static void enregistrer(String nomFichier, ArrayList moves)
			throws IOException {
		FileWriter fw = new FileWriter(nomFichier);
		PrintWriter out = new PrintWriter(fw);
		String s = "";
		for (int i = 0; i < moves.size(); i++) {
			int t = (Integer) moves.get(i);
			switch (t) {
			case 2:
				s += 'D';
				break;

			case 8:
				s += 'U';
				break;
			case 4:
				s += 'L';
				break;
			case 6:
				s += 'R';
				break;
			default:
				s += "I";
			}
		}
		out.println(s);
		out.close();
	}

	public static void enregistrer2(String nomFichier, ArrayList moves)
			throws IOException {
		FileWriter fw = new FileWriter(nomFichier);
		PrintWriter out = new PrintWriter(fw);
		String s = "";
		for (int i = 0; i < moves.size(); i++) {
			s += moves.get(i);

		}
		out.println(s);
		out.close();
	}

	// $ commence les lignes optionnelles
	public static char[][] lirecarte(Scanner sc, Scanner sc2) throws Exception {
		int cpl = 0;
		int cph = 0;
		String ligne2 = sc2.nextLine();
		String ligne = sc.nextLine();

		/*
		 * while(sc2.hasNextLine()){ ligne2=sc2.nextLine();
		 * System.out.println(ligne2+"tttttttt"); }
		 */
		char[][] map;
		/*
		 * char[][] map=new char [5][40]; for(int i=0;i<5;i++){
		 * //System.out.println("aaaa"+ligne+"bbbb"); for(int
		 * j=0;j<ligne2.length();j++){ map[i][j]=ligne2.charAt(j); }
		 * ligne2=sc2.nextLine(); System.out.println(ligne);
		 * ligne=sc.nextLine();
		 * 
		 * }
		 */
		// if(ligne.equals("[map]")){
		System.out.print("test");
		// ligne=sc.nextLine();
		cpl = ligne.length();
		while (!ligne.equals("[/map]") && sc.hasNextLine()) {

			// System.out.print(sc.nextLine());
			ligne = sc.nextLine();
			cph++;
		}
		System.out.println("cph" + cph + " cpl" + cpl);
		map = new char[cph][cpl];

		ligne2 = sc2.nextLine();

		// System.out.print("lllllllllll"+ligne2+"l2l2l2l2");
		for (int i = 0; i < cph; i++) {
			for (int j = 0; j < cpl; j++) {
				map[i][j] = ligne2.charAt(j);
			}
			// System.out.println("ccc"+ligne2);
			ligne2 = sc2.nextLine();
		}
		// System.out.println("ddd"+ligne);
		// Scanner sc1=new Scanner(ligne);
		/*
		 * if(sc2.hasNextLine()){ //System.out.print("test2");
		 * //ligne=sc2.next(); System.out.println(ligne+"bbbb");}
		 */

		// return map;
		// }
		return map;
	}

}
