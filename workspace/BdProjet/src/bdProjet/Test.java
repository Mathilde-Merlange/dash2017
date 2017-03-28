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
	
private Diamant d;
private Mur m;
private Roc r;
private Strategie st;	
private static List <Niveau> listeniv=new ArrayList<Niveau>(); 	
public static Rockford rockford;
private char [][] map;






public static boolean deplacerRoc(Tableau Map,int x, int y){
//déplacement de Roc par Rockford		
	if (Map.Map[x][y+1]==' '){
		Map.Map[x][y]='R';
		Map.Map[x][y+1]='r';
	return true;
	}
	else if (Map.Map[x][y-1]==' '){
		Map.Map[x][y]='R';
		Map.Map[x][y-1]='r';
	return true;
	}
	return false;
}
	
public static void tomberRoc(Tableau Map){
// Quand Roc tombe
	for (int x=0;x<Map.Map.length; x ++){
	for (int y=0;y<Map.Map.length; y ++){	
		if (Map.Map [x] [y]=='r'){
		while (Map.Map[x+1][y]==' '){
			Map.Map[x][y]=' ';
			Map.Map[x+1][y]='r';
		}
		}
	}
}
	 
}

public static void simplet(Rockford rockford, Tableau Map){
//strategie du simplet	
	String nom="";
	Tableau depart=Map;
	Tableau chemin=depart;
	Tableau suiv=depart;
	//chemin doit memoriser tout le chemin
	while (rockford.time!=0){
	chemin=depart;
	suiv=rockford.prochaindeplacementA(suiv, depart.x, depart.y);
	char contenusuiv=rockford.contenusuiv(suiv.x,suiv.y);
	
	/*if (contenusuiv=='w'||contenusuiv=='W'|| contenusuiv=='M'){	
	//Rocfor ne se deplace pas si il rencontre un mur
	}*/	
	
	if (contenusuiv=='r'){
		//suv.x et non depart.x
	 deplacerRoc(Map,depart.x,depart.y);
	 //faire si il peux pas le déplacer
	 Map.Map[depart.x][depart.y]=' ';
	  depart=suiv;
	}
	
	if (contenusuiv=='d'){
		rockford.adddiamant();
		Map.Map[depart.x][depart.y]=' ';
		Map.Map[suiv.x][suiv.y]='R';
		depart=suiv;
	}
	
	if (contenusuiv==' '){
		Map.Map[depart.x][depart.y]=' ';
		Map.Map[suiv.x][suiv.y]='R';
	}
	
	if (contenusuiv=='c'||contenusuiv=='b'||contenusuiv=='B'||contenusuiv=='C'){
	nom="libellule";
	Map.Map[depart.x][depart.y]=' ';
	Map.Map[suiv.x][suiv.y]='R';
	break;
	}
	
	if(contenusuiv=='F'||contenusuiv=='q'||contenusuiv=='o'||contenusuiv=='O'||contenusuiv=='Q'){
		nom="luciole";
		Map.Map[depart.x][depart.y]=' ';
		Map.Map[suiv.x][suiv.y]='R';
		break;
	}
	
	if(contenusuiv=='a'){
		nom="amibe";
		Map.Map[depart.x][depart.y]=' ';
		Map.Map[suiv.x][suiv.y]='R';
		break;
	}
	
	if (contenusuiv=='X'){
		nom="fin";
		break;
	}
	

	
	}
	rockford.toString(nom);
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
							//System.out.println("ok");
							//System.out.println(ab);
						}
						/*if (mot.equals("CaveDelay")){
							//n.setCaveDelay(Integer.parseInt(st.nextToken()));
						}*/
						if (mot.equals("CaveTime")){
							//System.out.println("ok?");
							String d=de.next();
							int dep= Integer.parseInt(d);
							rockford.setTime(dep);
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
	
	
	
public static void main(String[]args) throws Exception{
	
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
	//Tableau Map= new Tableau ();
	int a=s.nextInt();
	switch(a){
	case 1:
		
		//simplet(rockford,Map);
		
		break;
	case 2:break;
	case 3:break;
	case 4:break;
	case 5:break;
	
	}
	
	
	
	
	
	
	String str=s.next();
	
}



}
