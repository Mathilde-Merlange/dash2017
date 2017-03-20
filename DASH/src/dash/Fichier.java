package dash;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Fichier {
	//UDLRI
	
	public static void enregistrer(String nomFichier,ArrayList moves) throws IOException{
			FileWriter fw=new FileWriter(nomFichier);
			PrintWriter out=new PrintWriter(fw);
			String s="";
			for(int i=0;i<moves.size();i++){
				int t= (Integer) moves.get(i);
			switch(t){
			case 2:
			s+='D';
			break;
			
			case 8:
				s+='U';
				break;
			case 4:
				s+='L';
				break;
			case 6:
				s+='R';
				break;
			default:s+="I";
			}
			}
			out.println(s);
			out.close();
	}
	
	//$ commence les lignes optionnelles
	public static char[][] lirecarte(Scanner sc,Scanner sc2) throws Exception{
		int cpl=0;
		int cph=0;
		String ligne2=sc2.nextLine();
		String ligne=sc.nextLine();
		
		
		
		/*while(sc2.hasNextLine()){
			ligne2=sc2.nextLine();
			System.out.println(ligne2+"tttttttt");
		}*/
		char[][]map;
		/*char[][] map=new char [5][40];
		for(int i=0;i<5;i++){
			//System.out.println("aaaa"+ligne+"bbbb");
			for(int j=0;j<ligne2.length();j++){
				map[i][j]=ligne2.charAt(j);
			}
			ligne2=sc2.nextLine();
			System.out.println(ligne);
			ligne=sc.nextLine();
			
		}*/
		//if(ligne.equals("[map]")){
			System.out.print("test");
			//ligne=sc.nextLine();
			cpl=ligne.length();
		while (!ligne.equals("[/map]")&& sc.hasNextLine()){
			
			//System.out.print(sc.nextLine());
			ligne=sc.nextLine();
			cph++;
		}
		System.out.println("cph"+cph+" cpl"+cpl);
		map= new char[cph][cpl];	
			
			ligne2=sc2.nextLine();
			
			//System.out.print("lllllllllll"+ligne2+"l2l2l2l2");
			for(int i=0;i<cph;i++){
				for(int j=0;j<cpl;j++){
					map[i][j]=ligne2.charAt(j);	
				}
				//System.out.println("ccc"+ligne2);
				ligne2=sc2.nextLine();
			}
				//System.out.println("ddd"+ligne);
				//Scanner sc1=new Scanner(ligne);
				/*if(sc2.hasNextLine()){
					//System.out.print("test2");
				//ligne=sc2.next();
				System.out.println(ligne+"bbbb");}*/
			
			//return map;
		//}
		return map;
	}
	
	/*public static Match lirematch(Scanner sc22,int nbj) throws Exception{
		Match m=null;
		//Scanner sc=new Scanner(li);
		//Scanner sc22=new Scanner(ligne);
		String ligne="";
		Equipe e1;
		Equipe e2;
		Arbitre a;
		Heure d;
		int sc1;
		int sc2;
		int i=0;
		//if(sc.hasNextLine()){
			//ligne=sc.nextLine();
			e1=lireequipe(sc22,nbj);
			if(sc22.hasNextLine()){
				ligne=sc22.nextLine();
				//System.out.print("\nSCORE1 "+sc22.next());
				Scanner sc=new Scanner(ligne);

				if(sc22.hasNextInt()){
					sc1=sc22.nextInt();
					//equipe 2
					if(sc22.hasNextLine()){
						ligne=sc22.nextLine();
						e2=lireequipe(sc22,nbj);
						if(sc22.hasNextLine()){
							ligne=sc22.nextLine();
							//sc=new Scanner(ligne);
							if(sc22.hasNextInt()){
								sc2=sc22.nextInt();

								//arbitre					
								if(sc22.hasNextLine()){
									ligne=sc22.nextLine();
									a=lirearbitre(sc22);
									//heure
									if(sc22.hasNextLine()){
										ligne=sc22.nextLine();
										sc=new Scanner(ligne);
										d=lireheure(sc22);
										
									}
									else  throw new Exception("ligne incomplete");
								}
								else  throw new Exception("ligne incomplete");
								
							}
							else  throw new Exception("ligne incomplete");
						}
						else  throw new Exception("ligne incomplete");
					}else  throw new Exception("ligne vide");
					
				}
				else  throw new Exception("ligne incomplete");
			}
			else  throw new Exception("ligne incomplete");
		//}else  throw new Exception("ligne vide");
		m= new Match (e1,e2,a,d,sc1,sc2);
		return m;
		
	}*/
	/*public static Tour liretour(Scanner sc, int nbm, int nbj) throws Exception{
	//Scanner sc=new Scanner(li);
	//Scanner sc2=new Scanner(ligne);
	Tour t=null;
	String ligne="";
	Match m=null;
	int num;
	List<Match> lm = new ArrayList<Match>();
	int i=0;

	if(sc.hasNextInt()){
		num=sc.nextInt();
		//System.out.print(li);
		sc.nextLine();
		while(sc.hasNextLine() && i<nbm){
			//ligne=sc.nextLine();
			//System.out.print("LL"+ligne);
					//System.out.print(sc.next());
			m=lirematch(sc,nbj);
			
			lm.add(m);*/
	/*for(int j=0;j<2*nbj+6;j++){
		sc.nextLine();
		System.out.print("LL"+ligne);
	}*/
		/*	i++;
			//System.out.print(num);
		}
	}
	else  throw new Exception("ligne vide");
	t=new Tour(num,lm);
	return t;
	}*/



	/**
	*
	*
	*lit un fichier de tournoi
	*
	*@return la liste des Tours du tournoi

	 

	*/
	/*public static List<Tour> lireFichierTournoi(String nomFi­chier) throws FileNotFoundException{
	List<Tour> lesTours=new ArrayList<Tour>();
	Tour t=null;
	int nbmauvlign=0;
	File f =new File(nomFi­chier);
	Scanner sc=new Scanner(f);
	String ligne="";
	int i=0;
	int nbm=sc.nextInt();
	//System.out.print(nbm);
	sc.nextLine();
	int nbj=sc.nextInt();
	//System.out.print(nbj);
	int c=nbm;
	while(sc.hasNextLine() && Math.pow(i,2)<=nbm){
		
		//ligne=
		sc.nextLine();
		try{
		t=liretour(sc,c,nbj);
		
		lesTours.add(t);
		}
		catch(Exception e){
			nbmauvlign++;
			e.getMessage();
		}
		c=c/2;
		i++;
	}
	return lesTours;
	}
*/


	/**
	 *
	 *
	 *sauvegarde le tournoi dans un fichier
	 *
	 *@param nomFichier nom du fichier
	 *@param lestours liste des tours
	 *@param nbm nombre de matchs du 1er tour
	 *@param nbj nombre de joueurs dans chaque équipe

	  

	 */
	/*public static void ecrireFichierTournoi(String nomFichier,List<Tour> lesTours,int nbm, int nbj) throws IOException{
		FileWriter fw=new FileWriter(nomFichier);
		PrintWriter out=new PrintWriter(fw);
		String s="\n"+nbm+"\n"+nbj+"\n";
		for(Tour tr : lesTours){
		s+=tr.toString();}
		out.println(s);
		out.close();
	}*/
}
