package dash;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dash {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File f =new File("BD01plus.bd");
		Scanner sc=new Scanner(f);
		Scanner sc2=new Scanner(f);
		while(!sc.nextLine().equals("[map]")&&!sc2.nextLine().equals("[map]")){
			sc.nextLine();
			sc2.nextLine();
		}
		char [][] map =Fichier.lirecarte(sc,sc2);
		for(int i=0;i<map.length;i++){
			for(int j=0;j<map[0].length;j++){
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		Niveau niv=new Niveau();
		niv.setCarte(map);
		System.out.println(Carte.depart(niv)[0]+" "+Carte.depart(niv)[1]);
		System.out.println(Carte.sortie(niv)[0]+" "+Carte.sortie(niv)[1]);
		ArrayList moves=new ArrayList();
		int[]c={2,5,3,6,4,8,2,4,6,6,8};
		for(int i=0;i<c.length;i++){
		moves.add(c[i]);
		}
		Carte.evolue(niv);
		Fichier.enregistrer("test",moves);
	}

}
