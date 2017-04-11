package bdProjet;

import java.util.Random;

public class Rockford {	
public int nbdeplacement;
public int[] listediamant;;
public int nbdiamant;
public int time;
public Tableau tab1;
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

public Rockford(int a, char [] [] tab){
	nbdeplacement=a;
	
}

public void seDeplacer(){
	//augmenter deplacement
	/* méthode de déplacement */
nbdeplacement++;
}

public char contenusuiv(int x,int y){
//contenu de la case suivante	
	return contenuTab(x,y);
}

public char contenuTab(int x, int y){
	//contenu d'une case
	return tab1.Map [x][y];
	/*for (int i=0; i<Map.length; i++){
		for (int j=0; j<Map.length; j++){
			if (i==x && j==y){
				return Map [i] [j];
			}
		}
	}*/
}

public Tableau prochaindeplacementA(Tableau suiv,int x,int y){
	// prochain deplacement aleatoire
	Random r= new Random();
	int depl=r.nextInt(3);
	String nomdepl="";
	if (depl==0){
	x=x+1;
	nomdepl="D";
	}
	if (depl==1){
	x=x-1;
	nomdepl="U";
	}
	if (depl==2){
	y=y-1;
	nomdepl="L";
	}
	if (depl==3){
	y=y+1;
	nomdepl="R";
	}
	
	suiv.adddepl(nomdepl);
	suiv.x=x;
	suiv.y=y;
	
	return suiv;
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

public String toString(String nom){
System.out.println ("Fin de la partie");
if (nom!="fin"){
	System.out.println("Game over");
}
return("Nombre de diamant:"+nbdiamant+"Nombre de deplacement restant:"+nbdeplacement);

}
}
//2,4,6,8 les déplacements