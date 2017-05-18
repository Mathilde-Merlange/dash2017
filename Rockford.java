package bdProjet;

import java.util.Random;

public class Rockford {	
/*public int nbdeplacement;
public int[] listediamant;;
public int nbdiamant;
public int time;
public Tableau tab1;*/
	private int nbdeplacement;
	private int[] listediamant;;
	private int nbdiamant;
	private int time;
	private Tableau tab1;
//public Tableau tab1;

public Rockford(){
	//constructeur Rockford
	nbdeplacement=0;
	nbdiamant=0;
	tab1=new Tableau();
	
}

public void setTime(int x){
	//modifier Time
	time=x;
}

public void adddiamant(){
	//ajouter diamant
	nbdiamant++;
}

public int getNbdiamant() {
	return nbdiamant;
}

public void setNbdiamant(int nbdiamant) {
	this.nbdiamant = nbdiamant;
}

public int getNbdeplacement() {
	return nbdeplacement;
}

public int getTime() {
	return time;
}

public Rockford(int a, char [] [] tab){
	nbdeplacement=a;
	
}

public void seDeplacer(){
	//augmenter deplacement
	/* méthode de déplacement */
nbdeplacement++;
}

public char contenusuiv(Tableau tab,int x,int y){
//contenu de la case suivante	
	return contenuTab(tab,x,y);
}

public char contenuTab(Tableau tab,int x, int y){
	//contenu d'une case
	return tab.Map [x][y];
	/*for (int i=0; i<Map.length; i++){
		for (int j=0; j<Map.length; j++){
			if (i==x && j==y){
				return Map [i] [j];
			}
		}
	}*/
}


public Tableau prochaindeplacementA(Tableau dep,int x,int y){
	int limitx=dep.Map.length-1;
	int limity=dep.Map[0].length-1;
	String nomdepl="";
	// prochain deplacement aleatoire
	
	do{
	Random r= new Random();
	int depl=r.nextInt(3);
	
	if (depl==0){
		
			
		
		if (dep.Map[x+1][y]=='w'||dep.Map[x+1][y]=='M'||dep.Map[x+1][y]=='W'||dep.Map[x+1][y]=='R'||dep.Map[x+1][y]=='r'){
		depl=r.nextInt(2);
		if (depl==0){
			depl=3;
		}
		
		}else{
	x=x+1;
	nomdepl="D";
		}
		
		}
	if (depl==1){
		if (dep.Map[x-1][y]=='w'||dep.Map[x-1][y]=='M'||dep.Map[x-1][y]=='W'||dep.Map[x-1][y]=='R'||dep.Map[x-1][y]=='r'){
			depl=r.nextInt(2);
			if (depl==1){
				depl=3;
			}
			}else{
	x=x-1;
	nomdepl="U";
			}
			}
		
	if (depl==2){
		
		if (dep.Map[x][y-1]=='w'||dep.Map[x][y-1]=='M'||dep.Map[x][y-1]=='W'||dep.Map[x][y-1]=='R'||(dep.Map[x][y-1]=='r'&&dep.Map[x][y-2]!=' ')){
			depl=r.nextInt(2);
			if (depl==2){
				depl=3;
			}
	}else{
	y=y-1;
	nomdepl="L";
	}}
	if (depl==3){
		if (dep.Map[x][y+1]=='w'||dep.Map[x][y+1]=='M'||dep.Map[x][y+1]=='W'||dep.Map[x][y+1]=='R'||(dep.Map[x][y+1]=='r'&&dep.Map[x][y+2]!=' ')){
			depl=r.nextInt(2);

	}else{
	y=y+1;
	nomdepl="R";
	}}
	}while (x>=limitx||x<=0||y>=limity||y<=0);
	dep.adddepl(nomdepl);
	dep.x=x;
	dep.y=y;
	
	return dep;
	//return super.contenuTab(x,y); 	
	
}

public int getNbDiamand() {
	//avoir nbdiamant
	return nbdiamant;
}

public void setNbDiamant(int nbDiamant) {
//modifier nbdiamant
	this.nbdiamant = nbDiamant;
}













public String toString(String nom,int nbdiamant){
System.out.println ("Fin de la partie");
if (nom!="fin"){
	System.out.println("Game over ("+nom+")");
}
return("Nombre de diamant:"+nbdiamant);

}



}
//2,4,6,8 les déplacements