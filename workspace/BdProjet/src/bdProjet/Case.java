package bdProjet;

public class Case {
public Diamant d;
public Roc r;
public Rockford R;
public Poussiere p;
public Mur w;
/* à compléter	*/

public Case(char c){
	if(c=='d'){
		d=new Diamant();
	}else if(c=='r'){
		r=new Roc();
	}else if(c=='R'){
		R=new Rockford();
	}else if(c=='.'){
		p=new Poussiere();
	}else if(c=='w'){
		w=new Mur();
	}
	/* à compléter */
}





}
