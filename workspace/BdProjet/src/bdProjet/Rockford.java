package bdProjet;

import java.util.Random;

public class Rockford extends Tableau {	
public int nbdeplacement;
public int[] listediamant;;
public int nbdiamant;
public int time;
//public Tableau tab1;

public Rockford(){
	super();
	nbdeplacement=0;
	nbdiamant=0;
	
	
}

public void setTime(int x){
	time=x;
}

public void adddiamant(){
	nbdiamant++;
}

public Rockford(int a, char [] [] tab){
	nbdeplacement=a;
	
}

public void seDeplacer(){
	/* méthode de déplacement */
nbdeplacement++;
}

public char contenusuiv(int x,int y){
	
	return contenuTab(x,y);
}

public Tableau prochaindeplacementA(Tableau suiv,int x,int y){
	Random r= new Random();
	int depl=r.nextInt(3);
	
	if (depl==0){
	x=x+1;
	}
	if (depl==1){
	x=x-1;	
	}
	if (depl==2){
	y=y-1;
	}
	if (depl==3){
	y=y+1;
	}
	
	suiv.x=x;
	suiv.y=y;
	return suiv;
	//return super.contenuTab(x,y); 	
	
}

public int getNbDiamand() {
	return nbdiamant;
}

public void setNbDiamant(int nbDiamant) {
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