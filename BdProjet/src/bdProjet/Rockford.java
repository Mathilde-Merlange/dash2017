package bdProjet;

public class Rockford {	
public int nbdeplacement;
public int[] listediamant;;
public int nbdiamant;

public Rockford(){
	nbdeplacement=0;
	nbdiamant=0;
}

public void adddiamant(){
	nbdiamant++;
}

public Rockford(int a, int[] tab){
	nbdeplacement=a;
	
}

public void seDeplacer(){
	/* méthode de déplacement */
nbdeplacement++;
}

public void deplacer(int [] depart,int [] chemin){
	
}


public String toString(){
String s="";
System.out.println ("Fin de la partie");
System.out.println ("Nombre de diamant:");
s=s+nbdiamant;
System.out.println ("Nombre de deplacement restant:");	
return s;
}

}
//2,4,6,8 les déplacements