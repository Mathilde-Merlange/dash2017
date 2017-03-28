package bdProjet;


import java.io.IOException;
import java.util.*;

public abstract class Tableau {
public char[][] Map;	
public int x;
public int y;
	
public Tableau (){
	for (int x=0; x<Map.length; x++){
		for (int y=0; y<Map.length; y++){
			if (Map [x][y]=='P'){
				this.x=x;
				this.y=y;
			}
		}
		
	}
}

public Tableau(int x,int y){
	this.x=x;
	this.y=y;
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

public char contenuTab(int x, int y){
	return Map [x][y];
	/*for (int i=0; i<Map.length; i++){
		for (int j=0; j<Map.length; j++){
			if (i==x && j==y){
				return Map [i] [j];
			}
		}
	}*/
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


}
