package bdProjet;


import java.io.IOException;
import java.util.*;

public  class Tableau {
public char[][] Map= new char [8][7];	
public int x;
public int y;
public ArrayList<String> depl= new ArrayList();

public Tableau(){
}

public Tableau (char [] [] map){
	this.Map=map;
	for (int i = 0; i < map.length; i++) {
		for (int j = 0; j < map[0].length; j++) {
			if(map[i][j]=='P'){
				this.x=i;
				this.y=j;
			}
		}
	
		}
	
	
	
}

public Tableau(int x,int y){
	this.x=x;
	this.y=y;
}

public void adddepl(String d){
	// ajoute une direction dans la liste depl
	depl.add(d);
}

//les voisins où l'on peut se déplacer
	public static List<int[]> voisins(Niveau n,int[]pos){
		List<int[]> vois =new ArrayList<int[]>();
		int x=pos[0];
		int y=pos[1];
		char[][]grille=n.getCarte();
		//voisin du bas
		if (grille[x+1][y]!='W' && grille[x+1][y]!='w' && grille[x+1][y]!='a'&& grille[x+1][y]!='q'){
			int[]tabv={x+1,y,2};
			vois.add(tabv);
		}
		//voisin de droite
		if (grille[x][y+1]!='W' && grille[x][y+1]!='w' && grille[x][y+1]!='a'&& grille[x+1][y]!='q'){
			int[]tabv={x,y+1,6};
			vois.add(tabv);
		}
		//voisin du haut
		if (grille[x-1][y]!='W' && grille[x-1][y]!='w' && grille[x-1][y]!='a'&& grille[x+1][y]!='q'){
			int[]tabv={x-1,y,8};
			vois.add(tabv);
		}
		//voisin de gauche
		if (grille[x][y-1]!='W' && grille[x][y-1]!='w' && grille[x][y-1]!='a'&& grille[x+1][y]!='q'){
			int[]tabv={x,y-1,4};
			vois.add(tabv);
		}
		//retourne la liste des voisins, un voisin est un tableau à 3 cases avec coordonnées x, y et déplacement
		return vois;
		
		
	}
	
	




// retourne le départ ou la case de Rockford si la partie a commencé sinon tableau -1,-1
public static int[] depart(Niveau n){
	char[][]grille=n.getCarte();
	int[]tabv;
	for(int i=0;i<grille.length;i++){
		for(int j=0;j<grille.length;j++){
			if(grille[i][j]=='P'||grille[i][j]=='R'){
				tabv=new int[]{i,j};
				return tabv;
			}
		}
	}
	return new int[]{-1,-1};
}


// retourne la sortie qui apparait après le bon compte de diamand, sinon retourne tableau -1,-1
public static int[] sortie(Niveau n){
	char[][]grille=n.getCarte();
	int[]tabv;
	if(n.getDiamondsRequired()==n.getRockford().getNbDiamand()){
	for(int i=0;i<grille.length;i++){
		for(int j=0;j<grille.length;j++){
			if(grille[i][j]=='X'){
				tabv=new int[]{i,j};
				return tabv;
			}
		}
	}
}
	return new int[]{-1,-1};
}



public static void deplacer(Niveau n,ArrayList chemin){
	char[][]grille=n.getCarte();
	int[]depart=depart(n);
	int[]sortie=sortie(n);
	List<int[]> lesVois= voisins(n,depart);
	String s="";
	
	int rand = (int) (Math.random()*lesVois.size());
	System.out.println("RAND"+rand);
	for (int[]v :lesVois){
		System.out.println(v[0]+" "+v[1]+" "+v[2]);
	}
		
	int suiv=-1;
	
	int[]vois=lesVois.get(rand);
	//on regarde s'il y a un diamand dans les voisins
	for(int[]v:lesVois){
		if(grille[v[0]][v[1]]=='d'){
			suiv=lesVois.indexOf(v);
		}
	}
	//s'il y a un diamand dans les voisins on va sur cette case
	if(suiv>=0){
		vois=lesVois.get(suiv);
		chemin.add(vois[2]);
		grille[depart[0]][depart[1]]=' ';
		grille[vois[0]][vois[1]]='R';
		//ajout diamand
		System.out.println("suiv "+suiv);
	}
	else{
	if(grille[vois[0]][vois[1]]=='.'){
		chemin.add(vois[2]);
		grille[depart[0]][depart[1]]=' ';
		grille[vois[0]][vois[1]]='R';
	}else{
	if(grille[vois[0]][vois[1]]=='d'){
		chemin.add(vois[2]);
		grille[depart[0]][depart[1]]=' ';
		grille[vois[0]][vois[1]]='R';
		//ajouter diamant
	}else{
	if(grille[vois[0]][vois[1]]=='r'){
		chemin.add(vois[2]);
		grille[depart[0]][depart[1]]=' ';
		grille[vois[0]][vois[1]]='R';
	}else{
		chemin.add(vois[2]);
		grille[depart[0]][depart[1]]=' ';
		grille[vois[0]][vois[1]]='R';
	}}}}
	//if(sortie)
}

public static void evolue(Niveau n) throws IOException{
	char[][]grille=n.getCarte();
	int[]depart=depart(n);
	int[]sortie=sortie(n);
	int hauteur=grille.length;
	int largeur=grille[0].length;
	List<int[]> lesVois= voisins(n,depart);
	ArrayList chemin=new ArrayList();
	for(int i=0;i<10;i++){
		deplacer(n,chemin);
		for(int k=0;k<grille.length;k++){
			for(int j=0;j<grille[0].length;j++){
				System.out.print(grille[k][j]);
			}
			System.out.println();
		}
	}System.out.print(chemin);
	/*while(n.getDiamondsRequired()!=n.getRockford().getNbDiamiand()){
		deplacer(n,chemin);
		
	}*/
	Fichier.enregistrer("test4", chemin);
	
}

public static char cible_al(Tableau Map){
		//A modifier pour j
		int c=0;
		char a=' ';
		for (int i=0; i<Map.Map.length; i++){
		for (int j=0;j<Map.Map.length;j++){
			c=c+1;
			Random r= new Random();
			int elt=Map.Map.length*Map.Map.length;//ts les elt du tableau
			int de=r.nextInt(elt);
			if (c==elt){
				a=Map.Map[i][j];
 			}
			
		}
 		}
 		return a;
 	}

public static void directif(Rockford rockford, Tableau Map){
		Tableau depart= Map;
		ArrayList chemin=new ArrayList();
		Tableau suiv=depart;
		while (rockford.getTime()!=0){
			chemin.add(depart.depl);;
		    char cible=cible_al(Map);
		   // suiv=rockford.pluscourtchemin(cible,Map,suiv);
		    char contenusuiv=rockford.contenusuiv(suiv,suiv.x,suiv.y);
		    while (contenusuiv!=cible){
		    	
		    }
		    
		    
		    
		    
		}
			
			
			
		}

public static Tableau debuttab(Tableau tab){
	
	tab.Map[tab.x][tab.y]='R';
	
	return tab;
}

public static Tableau suitetab(Tableau tab){
	for (int i = 0; i < tab.Map.length; i++) {
		for (int j = 0; j < tab.Map[0].length; j++) {
			if(tab.Map[i][j]=='R'){
				tab.Map[i][j]=' ';
				
			}
		}
		
		}
	tab.Map[tab.x][tab.y]='R';
	
	return tab;
}

public static void simplet(Rockford rockford, Tableau Map,Niveau niv){
	//strategie du simplet	
		int dp=0;
		String nom="time";
		Tableau depart=Map;//tableau de depart
		ArrayList chemin=new ArrayList();
		Tableau suiv=depart;//suite tableau
		//chemin doit memoriser tout le chemin
		debuttab(depart);//remplace lepoint de départ par R
		
		for (int i = 0; i < depart.Map.length; i++) {
			for (int j = 0; j < depart.Map[0].length; j++) {
				System.out.print(depart.Map[i][j]);
			}
			System.out.println();
			}
		
		
		
		while (rockford.getTime()!=0){
		dp=0;
		suiv=rockford.prochaindeplacementA(depart, depart.x, depart.y);//renvoi tableau du prochain deplacement
		char contenusuiv=rockford.contenusuiv(suiv,suiv.x,suiv.y);
		
		
		
		
		//contenu du prochain deplacement
		//System.out.println("depl:"+contenusuiv);
		
		if(contenusuiv=='R'){
			
			dp=1;
			rockford.setTime((rockford.getTime())+1);
		}
		
		
		if (contenusuiv=='r'){
			System.out.println("depl:"+contenusuiv);			
		deplacerRoc(Map,suiv.x,suiv.y);
		//nom=tomberRoc(suiv);
		if (nom.equals("G")){
			break;
		}
					// depart=suiv;
			  
			 //Map.Map[depart.x][depart.y]='R';
			 //Map.Map[suiv.x][suiv.y]='r';//
			
			 //faire si il peux pas le déplacer
		// Map.Map[depart.x][depart.y]=' ';//
		  
		}
		
		if (contenusuiv=='d'){
			System.out.println("depl:"+contenusuiv);
			rockford.adddiamant();
			suitetab(suiv);
			nom=tomberRoc(suiv);
			if (nom.equals("G")){
				break;
			}
			
			//Map.Map[depart.x][depart.y]=' ';//
			//Map.Map[suiv.x][suiv.y]='R';//
			//depart=suiv;
		}
		
		if (contenusuiv==' '||contenusuiv=='.'){
			System.out.println("depl:"+contenusuiv);
			suitetab(suiv);
			nom=tomberRoc(suiv);
			if (nom.equals("G")){
				break;
			}
			
			//Map.Map[depart.x][depart.y]=' ';
			//Map.Map[suiv.x][suiv.y]='R';
			//depart=suiv;
		}
		
		if (contenusuiv=='c'||contenusuiv=='b'||contenusuiv=='B'||contenusuiv=='C'){
			System.out.println("depl:"+contenusuiv);
		nom="libellule";
		suitetab(suiv);
		//Map.Map[depart.x][depart.y]=' ';
		//Map.Map[suiv.x][suiv.y]='R';
		break;
		}
		
		if(contenusuiv=='F'||contenusuiv=='q'||contenusuiv=='o'||contenusuiv=='O'||contenusuiv=='Q'){
			System.out.println("depl:"+contenusuiv);
			nom="luciole";
			//Map.Map[depart.x][depart.y]=' ';
			//Map.Map[suiv.x][suiv.y]='R';
			suitetab(suiv);
			break;
		}
		
		if(contenusuiv=='a'){
			System.out.println("depl:"+contenusuiv);
			nom="amibe";
			//Map.Map[depart.x][depart.y]=' ';
			//Map.Map[suiv.x][suiv.y]='R';
			suitetab(suiv);
			break;
		}
		
		if (contenusuiv=='X'){
			nom="fin";
			break;
		}
		
		
		//suitetab(depart);
		if(dp!=1){
		for (int i = 0; i < depart.Map.length; i++) {
			for (int j = 0; j < depart.Map[0].length; j++) {
				System.out.print(depart.Map[i][j]);
			}
			System.out.println();
			}
		
		chemin.add(depart.depl);; //prend tous les déplacements
		}
		
		rockford.setTime((rockford.getTime())-1);
		}
		System.out.println(rockford.toString(nom,rockford.getNbdiamant(), chemin));
		
		}




public static boolean deplacerRoc(Tableau Map,int x, int y){
//déplacement de Roc par Rockford	
	//x, y là ou il y a r
	if (Map.Map[x][y+1]==' '&& Map.Map[x][y-1]=='R'){
		Map.Map[x][y]='R';
		Map.Map[x][y+1]='r';
	return true;
	}else if (Map.Map[x][y-1]==' '&&Map.Map[x][y+1]=='R'){
		Map.Map[x][y]='R';
		Map.Map[x][y-1]='r';
	return true;
	}
	
			return false;
	

}
	
public static String tomberRoc(Tableau Map){
// Quand Roc tombe
	String a="time";
	for (int x=0;x<Map.Map.length; x ++){
	for (int y=0;y<Map.Map[0].length; y ++){	
		if (Map.Map [x] [y]=='r'){
		
		if(Map.Map[x][y+1]==' '&&Map.Map[x+1][y+1]==' '){
			Map.Map[x][y]=' ';
			Map.Map[x+1][y+1]='r';
			if(Map.Map[x+2][y+1]=='R'){
				a="G";
			}
		}
		
		if(Map.Map[x][y-1]==' '&&Map.Map[x+1][y-1]==' '){
			Map.Map[x][y]=' ';
			Map.Map[x+1][y-1]='r';
			if(Map.Map[x+2][y-1]=='R'){
				a="G";
			}
		}
		while (Map.Map[x+1][y]==' '){
			Map.Map[x+1][y]='r';
			x=x+1;
			if(Map.Map[x][y+1]=='R'){
				a="G";
			}
		}
		
		}
	}
}
	return a; 
}

//creer une methode qui permt d'afficher depl de Rockford avec chemin

}
