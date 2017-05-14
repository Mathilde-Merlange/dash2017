package bdProjet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fichier {

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

	public static ArrayList lirefichier(String nomfichier) throws FileNotFoundException{
		int v1=0;
		int v2=0;
		ArrayList <Niveau> niv= new ArrayList ();
		File file=new File(nomfichier);
		Scanner sc1= new Scanner (file); 
		Scanner sc2= new Scanner (file); 
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
								rockford.setTime(dep);// A changer pour qu'il prenne le bon time
								n.setCaveTime(dep);
							}
							
							if (mot.equals("DiamondsRequired")){
								
								n.setDiamondsRequired(Integer.parseInt(de.next()));
							}
							
							if (mot.equals("DiamondValue")){
							System.out.println("aff");
							//a deux val min il faut les additionner et les ajouter
								//de.next();
								//de.next();
								Scanner st2= new Scanner (ligne).useDelimiter("=");
								//StringTokenizer st2 = new StringTokenizer(ligne," ",false);
								System.out.println(st2.next());
								ligne=st2.next();
								Scanner  st3= new Scanner (ligne).useDelimiter(" ");
								System.out.println(ligne);
								v1=Integer.parseInt(st3.next());
								v2=Integer.parseInt(st3.next());
							n.setDiamondValue(v1+v2);
							System.out.println(v1+v2);
								//n.ajouterDiamondValue(Integer.parseInt(st2.nextToken()));
								//test
								
								//n.toString();
							}
							
							if (mot.equals("AmoebaTime")){
								//System.out.println ("test");
								n.setAmoebaTime(Integer.parseInt(de.next()));
								}
							if (mot.equals("MagicWallTime")){
								
								n.setMagicWallTime(Integer.parseInt(de.next()));
								}
							
						 /*System.out.println(sc.nextLine());*/
							
						}	
						//System.out.println(ligne+"aa");
						//mot=de.next();
						de.close();
						
					}	
					
				if(ligne.equals("[map]")){
					String ligne1 = sc1.nextLine();
					String ligne2 = sc2.nextLine();
				
					while (!ligne1.equals(ligne) && !ligne2.equals(ligne)) {
							//System.out.println("testmmmm");
							if(!ligne1.equals(ligne)){
							 ligne1=sc1.nextLine();
							 //System.out.println("true");
							 }
							if(!ligne2.equals(ligne)){
								//System.out.println("true2");
								ligne2=sc2.nextLine();
							}
					
						}
				
						
				
									
						if(ligne1.equals(ligne) && ligne2.equals(ligne)){
							System.out.println("t b");
						char[][] map = Fichier.lirecarte(sc1, sc2);//l'erreur vient ici
						System.out.println("t b");
						
										
				
						for (int i = 0; i < map.length; i++) {
							for (int j = 0; j < map[0].length; j++) {
								System.out.print(map[i][j]);
							}
							System.out.println();
							}
						
				
						}else{
							System.out.println("ERROR");
						}
						
				}
								
					
					niv.add(n);
				//System.out.print("ok");
				}
				
				
			}
				
				
					
		}catch(Exception ex){ 
			ex.getMessage();//catch
		}
		return niv;
		
		}
	
	
	
	
	
	// $ commence les lignes optionnelles
		
	
	public static char[][] lirecarte(Scanner sc1, Scanner sc2) throws Exception {
			int cpl = 0;
			int cph = 0;
			String ligne2 = sc2.nextLine();
			String ligne1 = sc1.nextLine();
			char[] tab={'R',' ','.','r','d','w','W','P','X'};
	List lettre= new ArrayList();
	for(int i=0;i<tab.length;i++){
	lettre.add(tab[i]);
	}
		
			
		char[][] map;
		
	
			// if(ligne.equals("[map]")){
			
			// ligne=sc.nextLine();
			cpl = ligne1.length(); //colonne ok
			System.out.println(cpl);
						
			 while (!ligne1.equals("[/map]")) {
				ligne1 = sc1.nextLine();
				cph++;
			}
			 System.out.println(cph);//ligne ok
			
			System.out.println("1cph" + cph + " cpl" + cpl);
			map = new char[cph][cpl];

			//ligne2 = sc2.nextLine();
			// System.out.print("lllllllllll"+ligne2+"l2l2l2l2");
			//RAJOUTE LETTRE A LA CARTE ET D SI LETTRE INCONNUE.
			for (int i = 0; i < cph; i++) {
				for (int j = 0; j < cpl; j++) {
					if(lettre.contains(ligne2.charAt(j))){
					map[i][j] = ligne2.charAt(j);
					}
					else{
						map[i][j] ='d';
						
					}
				}
				// System.out.println("ccc"+ligne2);
				ligne2 = sc2.nextLine();
			
			}
			
			// Scanner sc1=new Scanner(ligne);
			

			// return map;
			// }
			System.out.println("cph" + cph + " cpl" + cpl);
			
			
			return map;
		}


	
	
	
	
	
}
