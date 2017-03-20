package dash;

import java.util.*;

public class Carte {

	public static List<int[]> voisins(Niveau n,int[]pos){
		List<int[]> vois =new ArrayList<int[]>();
		int x=pos[0];
		int y=pos[1];
		char[][]grille=n.getCarte();
		if (grille[x+1][y]!='W' && grille[x+1][y]!='w' && grille[x+1][y]!='a'&& grille[x+1][y]!='q'){
			int[]tabv={x+1,y,2};
			vois.add(tabv);
		}
		if (grille[x][y+1]!='W' && grille[x][y+1]!='w' && grille[x][y+1]!='a'&& grille[x+1][y]!='q'){
			int[]tabv={x,y+1,6};
			vois.add(tabv);
		}
		if (grille[x-1][y]!='W' && grille[x-1][y]!='w' && grille[x-1][y]!='a'&& grille[x+1][y]!='q'){
			int[]tabv={x-1,y,8};
			vois.add(tabv);
		}
		if (grille[x][y-1]!='W' && grille[x][y-1]!='w' && grille[x][y-1]!='a'&& grille[x+1][y]!='q'){
			int[]tabv={x,y-1,4};
			vois.add(tabv);
		}
		return vois;
		
		
	}
	
	public static int[] sortie(Niveau n){
		char[][]grille=n.getCarte();
		int[]tabv;
		if(n.getDiamondsRequired()==n.getRockford().getNbDiamiand()){
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
			
		
		
		int[]vois=lesVois.get(rand);
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
		}}}
		//if(sortie)
	}
	
	public static void evolue(Niveau n){
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
		}
		/*while(n.getDiamondsRequired()!=n.getRockford().getNbDiamiand()){
			deplacer(n,chemin);
			
		}*/
		
		
	}
	
}
