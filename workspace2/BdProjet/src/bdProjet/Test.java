package bdProjet;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
public class Test {
	
//private Diamant d;
//private Mur m;
//private Roc r;
private Strategie st;	
//private Tableau tab=new Tableau();
private static List <Niveau> listeniv=new ArrayList<Niveau>(); 	
//public static Rockford rockford;
private char [][] map;

//}
/*
public static char voisins(char [][] Map){
	Map voisin;
	List<Map> listevoisin= new ArrayList<Map>();
	
	int x;
	int y;
	for (x=0;x<Map.length;x++){
		for (y=0; y<Map.length;y++){
			
	if (Map[x+1][y]==' '|| Map[x+1][y]=='.' || Map[x+1][y]=='d' ){
		voisin= Map[x+1][y];
		listevoisin.add(voisin);
	}
	if (Map[x-1][y]==' '|| Map[x-1][y]=='.' || Map[x-1][y]=='d' ){
		voisin= Map[x-1][y];
	}
	if (Map[x][y+1]==' '|| Map[x][y+1]=='.' || Map[x][y+1]=='d' ){
	voisin= Map[x][y+1];
	}
	if (Map[x][y-1]==' '|| Map[x][y-1]=='.' || Map[x][y-1]=='d' ){
	voisin= Map[x][y-1];
	}
}
}
return voisin;
}*/


public static void main(String[]args) throws Exception{
	int z=0;
	Niveau niveau=new Niveau ();
	ArrayList <Niveau> niv= new ArrayList ();
	Rockford rockford = new Rockford();
	Scanner s=new Scanner (System.in);
	System.out.println("Entrer le nom du fichier à lire");
	String nom=s.next();
	File f= new File(nom);
	
	niv=Fichier.lirefichier(nom);

	
	
	//lit le fichier
	
	/*Scanner sc= new Scanner(f);
	Scanner sc2= new Scanner (f);
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
	*/
	
	
	System.out.println("Strategie:");
	System.out.println("Taper 1 pour strategie simplet");
	System.out.println("Taper 2 pour strategie evolué");
	System.out.println("Taper 3 pour strategie directif");
	System.out.println("Taper 4 pour strategie directif evolué");
	System.out.println("Taper 5 pour strategie parfait");
	Tableau tab= new Tableau ();
	Tableau tab2=new Tableau();
	int a=s.nextInt();
	switch(a){
	case 1:
		
		while (z!=niv.size()){
			niveau=niv.get(z);
			rockford.setTime (niveau.getCaveTime());
			tab.simplet(rockford,tab2,niveau);
		
		z=z+1;
		System.out.println("Continuer ? 0=Non 1=Oui");
		int b=s.nextInt();
		if(b==0){
			z=niv.size();
		}
		
		}
		
		
		break;
	case 2:break;
	case 3:break;
	case 4:break;
	case 5:break;
	//String str=s.next();
	}
	
}
}
	
	
	
	
	
	

/*System.out.println("Strategie:");
	System.out.println("Taper 1 pour strategie simplet");
	System.out.println("Taper 2 pour strategie evolué");
	System.out.println("Taper 3 pour strategie directif");
	System.out.println("Taper 4 pour strategie directif evolué");
	System.out.println("Taper 5 pour strategie parfait");
	
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
	System.out.println(Tableau.depart(niv)[0]+" "+Tableau.depart(niv)[1]);
	System.out.println(Tableau.sortie(niv)[0]+" "+Tableau.sortie(niv)[1]);
	ArrayList moves=new ArrayList();
	int[]c={2,5,3,6,4,8,2,4,6,6,8};
	for(int i=0;i<c.length;i++){
	moves.add(c[i]);
	}
	
	
	//Tableau.evolue(niv);
	//Fichier.enregistrer("test",moves);
*/
	
	
	



