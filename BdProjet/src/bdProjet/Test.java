package bdProjet;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.*;
public class Test {
	
private Diamant d;
private Mur m;
private Roc r;
private Strategie st;	
private static List <Niveau> listeniv=new ArrayList<Niveau>(); 	
private Rockford rockford;
private char [][] map;


public static void simplet(Rockford rockford,int [] P, char[][] Map, int [] chemin){
	//Random r= new Random();
	//int depl=r.nextInt(3);
	int[] depart=P;
	chemin=depart;
	rockford.deplacer(depart,chemin);
	depart=chemin;
	for (int x=0; x<Map.length; x++){
	for (int y=0; y<Map.length; y++){	
	
	if (Map [x] [y]=='r'){
		// deplacer roc
	}
	
	if (Map [x][y]== 'd'){
		rockford.adddiamant();
	}
	
	if (Map [x][y]=='X'){
	break;
	}
	
	}
	}
	rockford.toString();
	}
	
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


	
public static void lirefichier(String nomfichier) throws FileNotFoundException{
	
	File file=new File(nomfichier);
	BufferedReader br= new BufferedReader (new FileReader(file));
	Scanner sc=new Scanner(file);
	//FileReader a= new FileReader(file);
	String ligne="";
	String mot="";
	Niveau n= new Niveau();
	Rockford rockford= new Rockford();
	//StringTokenizer st = new StringTokenizer(ligne,"=",false);
	//Scanner sl=new Scanner(ligne);	
	ligne=sc.nextLine();
	
	//mot=de.next();
	
	try {
		while(sc.hasNextLine()){
		ligne=sc.nextLine();
		//System.out.println(ligne);
		//StringTokenizer st = new StringTokenizer(ligne,"=",false);
		/*while(!ligne.equals("[cave]")){
				ligne=sc.nextLine();
				System.out.println(ligne);
			}*/
			if (ligne.equals("[cave]")){
				//while (st.hasMoreTokens()){
				//mot=st.nextToken();
				//System.out.println(mot);
				
				while (!ligne.equals("[map]")){
					ligne=sc.nextLine();
					System.out.println(ligne);
					Scanner de= new Scanner (ligne).useDelimiter("=");
					while (de.hasNext()){
						mot=de.next();
						//mot=st.nextToken();
						//System.out.println(mot);
									
					//mot=st.nextToken();
						if (mot.equals("Name")){
						//System.out.println("ok");
							String ab=de.next();
							n.setname(ab);
							//test
							System.out.println("ok");
							System.out.println(ab);
						}
						if (mot.equals("CaveDelay")){
							//n.setCaveDelay(Integer.parseInt(st.nextToken()));
						}
						if (mot.equals("CaveTime")){
							System.out.println("ok?");
							String d=de.next();
							int dep= Integer.parseInt(d);
							//rockford.setnbdeplacement(dep);
							//n.setCaveTime(dep);
						}
						
						if (mot.equals("DiamondsRequired")){
							System.out.println("adelie");
							//n.setDiamondsRequired(Integer.parseInt(st.nextToken()));
						}
						
						if (mot.equals("DiamondValue")){
						System.out.println("aff");
						//a deux val min
							//de.next();
							//de.next();
							//Scanner st2= new Scanner (ligne).useDelimiter(" ");
							//StringTokenizer st2 = new StringTokenizer(ligne," ",false);
							//n.setDiamondValue(Integer.parseInt(st2.nextToken()));
							//n.ajouterDiamondValue(Integer.parseInt(st2.nextToken()));
							//test
							
							//n.toString();
						}
						
						if (mot.equals("AmoebaTime")){
							System.out.println("adelie");
							//n.setAmoebaTime(Integer.parseInt(st.nextToken()));
							}
						if (mot.equals("MagicWallTime")){
							System.out.println("adelie");
							//n.setMagicWallTime(Integer.parseInt(st.nextToken()));
							}
										
					}	
					//System.out.println(ligne+"aa");
					//mot=de.next();
					de.close();
				}	
				
			}
			
		}
			//ligne=ligne.trim();
			
			//}
		
		
		
		
		
				
	}catch(Exception ex){ 
		ex.getMessage();//catch
	}
	
	}

public static void ecrirefichier(String nomfichier){
	
}
	
	
	
public static void main(String[]args) throws FileNotFoundException{
	Scanner s=new Scanner (System.in);
	System.out.println("Entrer le nom du fichier à lire");
	String nom=s.next();
	lirefichier(nom);
	//lit le fichier
	System.out.println("Strategie:");
	System.out.println("Taper 1 pour strategie simplet");
	System.out.println("Taper 2 pour strategie evolué");
	System.out.println("Taper 3 pour strategie directif");
	System.out.println("Taper 4 pour strategie directif evolué");
	System.out.println("Taper 5 pour strategie parfait");
	int a=s.nextInt();
	switch(a){
	case 1: break;
	case 2:break;
	case 3:break;
	case 4:break;
	case 5:break;
	
	}
	
	
	
	
	
	
	String str=s.next();
	
}



}
