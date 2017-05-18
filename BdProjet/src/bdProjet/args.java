package bdProjet;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class args {
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList <Niveau> niv= new ArrayList ();
		Rockford rockford = new Rockford();
		Niveau niveau=new Niveau ();
		        String a1 = args[0];
		        switch (a1) {
		            case "-name":
		                afficherIdentite();
		                break;
		            case "-h":
		                afficherOptions();
		                break;
		                
		            case "-lis":
		                String nomF = args[1];
		                
		               Fichier.lirefichier(nomF);
		                //ArrayList moves = Move.depFichier(nomF);
		
		                break;
		            case "-joue":
		            	String nomF1 = args[1];
		            	niv=Fichier.lirefichier(nomF1);
		            	if(args.length==4){
		            	String a=args[3];
		            	int b=Integer.parseInt(a);
		            	
		            	Test.jouer(niv.get(b-1)); 
		            	}else{
		            		int lim=0;
		            		while(lim!=(niv.size()-1)){
		            			Test.jouer(niv.get(lim));
		            			lim++;		            			
		            		}
		            		
		            		
		            		
		            	}
		            	
		            	break;
		            	
		            case "-cal":
		            	Tableau tab= new Tableau ();
		            	String strategie=args[1];
		            	String nomF2 = args[2];
		            	  niv=Fichier.lirefichier(nomF2);
		            	switch(strategie){
		            	case "simplet":
		            		   			
		            			String num=args[3];
		            			int numniv=Integer.parseInt(num);
		            			niveau=niv.get(numniv);     					            			
		            			rockford.setTime (niveau.getCaveTime());
		            			Tableau tab2=new Tableau(niveau.getCarte());
		            			tab.simplet(rockford,tab2,niveau);
		            			break;
		            			
			            		
		            		
		            		
		            	
		            	case "evolue":/*Carte.evolue(niveau);
		            	    			Fichier.enregistrer("test", moves); break;*/ break;
		            		
		            	case "directif": break;
		            	default:
		        			System.out.println("mauvais nom");
		            	
		            		}
		            	
		        break;
		            	
		            	
		            	
		            	
		            	
		            case "-rejoue":
		                break;
		            case "-simul":
		                break;
		                
		            default:
		    			System.out.println("mauvaise entrée");
		        }
		    }
		
		    private static void afficherIdentite() {
		        System.out.println("Mathilde Merlange");
		        System.out.println("Adélie Calvo Fernandez");
		        System.out.println("Li-San Sultan");
		    }
		
		    private static void afficherOptions() {
		        System.out.println("-name affiche les noms des codeurs");
		        System.out.println("-h affiche la liste des options du programme");
		        System.out.println("-lis li et affiche les parametres d'un fichier BDCFF");
		        System.out.println("-joue joue de maniere interactive ");
		        System.out.println("-cal joue avecc une strategie");
		        System.out.println("-rejoue rejoue une partie avec des déplacements");
		        System.out.println("-simul evalue deux strategies en parametre ");
		       }
		    
		    private static void jouer(Niveau niv) {
		    	Scanner s = new Scanner(System.in);
		    	boolean gagne = false;
		    	boolean fini = false;
		    	char[][] grille = niv.getCarte();
		    	int[] dep = Carte.depart(grille);
		    	int[] sor = Carte.sortie(niv, grille);
		    	int x = dep[0];
		    	int y = dep[1];
		    	int[]tabv=new int[3];
		    	List<int[]> chemin = new ArrayList();
		    	System.out.println("cavetime"+niv.getCaveTime());
		    	while (niv.getCaveTime() > niv.getRockford().getNbdeplacement()
		    			&& !gagne && !fini) {
		    		dep = Carte.depart(grille);
		    		x = dep[0];
		    		y = dep[1];
		    		aff(grille, niv);
		    		System.out.println("jouer:");
		    		System.out.println("Taper 8 pour haut");
		    		System.out.println("Taper 2 pour bas");
		    		System.out.println("Taper 6 pour droite");
		    		System.out.println("Taper 4 pour gauche");
		    		int c = s.nextInt();
		    		switch (c) {
		    		case 5:
		    			tabv = new int[]{ x - 1, y, 5 };
		    		chemin.add(tabv);
		    		break;
		    		case 8:
		    			if (niv.getDiamondsRequired() <= niv.getRockford()
		    					.getNbdiamant()) {
		    				if (grille[x - 1][y] == 'X') {
		    					grille[x][y] = ' ';
		    					grille[x - 1][y] = 'R';
		    					tabv = new int[]{ x - 1, y, 8 };
		    					chemin.add(tabv);
		    					niv.getRockford().seDeplacer();
		    					fini = true;
		    					gagne = true;
		    				}
		    			}
		    			if (grille[x - 1][y] != 'W' && grille[x - 1][y] != 'w'
		    					&& grille[x - 1][y] != 'a' && grille[x + 1][y] != 'q') {

		    				if (grille[x - 1][y] == 'r') {
		    					Tableau tab = new Tableau();
		    					tab.Map = grille;
		    					if(Tableau.deplacerRoc(tab, x, y)){
		    						tabv = new int[]{ x - 1, y, 8 };
		    						chemin.add(tabv);
		    						niv.getRockford().seDeplacer();
		    					}
		    				} else {
		    					if (grille[x - 1][y] == 'd') {
		    						niv.getRockford().adddiamant();
		    					}
		    					grille[x][y] = ' ';
		    					grille[x - 1][y] = 'R';
		    				tabv = new int[]{ x - 1, y, 8 };
		    				chemin.add(tabv);
		    				niv.getRockford().seDeplacer();
		    				}

		    			} else {
		    				if (grille[x - 1][y] == 'a' || grille[x + 1][y] == 'q') {
		    					grille[x][y] = ' ';
		    					grille[x - 1][y] = 'R';
		    					tabv = new int[]{ x - 1, y, 8 };
		    					chemin.add(tabv);
		    					niv.getRockford().seDeplacer();
		    					fini = true;
		    				}
		    			}
		    			break;
		    		case 2:
		    			if (niv.getDiamondsRequired() <= niv.getRockford()
		    					.getNbdiamant()) {
		    				if (grille[x + 1][y] == 'X') {
		    					grille[x][y] = ' ';
		    					grille[x + 1][y] = 'R';
		    					 tabv =new int[] { x + 1, y, 2 };
		    					chemin.add(tabv);
		    					niv.getRockford().seDeplacer();
		    					fini = true;
		    					gagne = true;
		    				}
		    			}
		    			if (grille[x + 1][y] != 'W' && grille[x + 1][y] != 'w'
		    					&& grille[x + 1][y] != 'a' && grille[x + 1][y] != 'q') {

		    				if (grille[x + 1][y] == 'r') {
		    					Tableau tab = new Tableau();
		    					tab.Map = grille;
		    					if(Tableau.deplacerRoc(tab, x+1, y)){
		    						tabv = new int[]{ x + 1, y, 2 };
		    						chemin.add(tabv);
		    						niv.getRockford().seDeplacer();
		    					}
		    				} else {
		    					if (grille[x + 1][y] == 'd') {
		    						niv.getRockford().adddiamant();
		    					}
		    					grille[x][y] = ' ';
		    					grille[x + 1][y] = 'R';

		    				 tabv = new int[]{ x + 1, y, 2 };
		    				chemin.add(tabv);
		    				niv.getRockford().seDeplacer();
		    				}
		    			} else {
		    				if (grille[x + 1][y] == 'a' || grille[x + 1][y] == 'q') {
		    					grille[x][y] = ' ';
		    					grille[x + 1][y] = 'R';
		    					tabv = new int[]{ x + 1, y, 2 };
		    					chemin.add(tabv);
		    					niv.getRockford().seDeplacer();
		    					fini = true;
		    				}
		    			}
		    			break;
		    		case 6:
		    			if (niv.getDiamondsRequired() <= niv.getRockford()
		    					.getNbdiamant()) {
		    				if (grille[x][y + 1] == 'X') {
		    					grille[x][y] = ' ';
		    					grille[x][y + 1] = 'R';
		    					tabv =new int[] { x, y + 1, 6 };
		    					chemin.add(tabv);
		    					niv.getRockford().seDeplacer();
		    					fini = true;
		    					gagne = true;
		    				}
		    			}
		    			if (grille[x][y + 1] != 'W' && grille[x][y + 1] != 'w'
		    					&& grille[x][y + 1] != 'a' && grille[x][y + 1] != 'q') {

		    				if (grille[x][y + 1] == 'r') {
		    					Tableau tab = new Tableau();
		    					tab.Map = grille;
		    					if(Tableau.deplacerRoc(tab, x, y)){

		    						tabv = new int[]{ x, y + 1, 6 };
		    						chemin.add(tabv);
		    						niv.getRockford().seDeplacer();
		    					}
		    				} else {
		    					if (grille[x][y + 1] == 'd') {
		    						niv.getRockford().adddiamant();
		    					}
		    					grille[x][y] = ' ';
		    					grille[x][y + 1] = 'R';

		    				 tabv = new int[]{ x, y + 1, 6 };
		    				chemin.add(tabv);
		    				niv.getRockford().seDeplacer();
		    				}
		    			} else {
		    				if (grille[x][y + 1] == 'a' || grille[x][y + 1] == 'q') {
		    					grille[x][y] = ' ';
		    					grille[x][y + 1] = 'R';
		    					 tabv = new int[]{ x, y + 1, 6 };
		    					chemin.add(tabv);
		    					niv.getRockford().seDeplacer();
		    					fini = true;
		    				}
		    			}
		    			break;
		    		case 4:
		    			if (niv.getDiamondsRequired() <= niv.getRockford()
		    					.getNbdiamant()) {
		    				if (grille[x][y - 1] == 'X') {
		    					grille[x][y] = ' ';
		    					grille[x][y - 1] = 'R';
		    					 tabv = new int[]{ x, y - 1, 4 };
		    					chemin.add(tabv);
		    					niv.getRockford().seDeplacer();
		    					fini = true;
		    					gagne = true;
		    				}
		    			}
		    			if (grille[x][y - 1] != 'W' && grille[x][y - 1] != 'w'
		    					&& grille[x][y - 1] != 'a' && grille[x][y - 1] != 'q') {

		    				if (grille[x][y - 1] == 'r') {
		    					Tableau tab = new Tableau();
		    					tab.Map = grille;
		    					if(Tableau.deplacerRoc(tab, x, y)){

		    						tabv = new int[]{ x, y - 1, 4 };
		    						chemin.add(tabv);
		    						niv.getRockford().seDeplacer();
		    					}
		    				} else {
		    					if (grille[x][y - 1] == 'd') {
		    						niv.getRockford().adddiamant();
		    					}
		    					grille[x][y] = ' ';
		    					grille[x][y - 1] = 'R';
		    				 tabv = new int[]{ x, y - 1, 4 };
		    				chemin.add(tabv);
		    				niv.getRockford().seDeplacer();
		    				}

		    			} else {
		    				if (grille[x][y - 1] == 'a' || grille[x][y - 1] == 'q') {
		    					grille[x][y] = ' ';
		    					grille[x][y - 1] = 'R';
		    					tabv =new int[] { x, y - 1, 4 };
		    					chemin.add(tabv);
		    					niv.getRockford().seDeplacer();
		    					fini = true;
		    				}
		    			}
		    			break;
		    		default:
		    			System.out.println("mauvaise touche");
		    		}

		    	}
		    	aff(grille, niv);
		    	System.out.println("gagne"+gagne);
		    	System.out.println("fini"+fini);

		    }

		    public static void aff(char[][] map, Niveau n) {
		    	System.out.println("nombre de pas:" + n.getRockford().getNbdeplacement());
		    	System.out.println("diamants requis:" + n.getDiamondsRequired());
		    	System.out
		    			.println("diamants obtenus:" + n.getRockford().getNbdiamant());
		    	if (n.getDiamondsRequired() <= n.getRockford().getNbdiamant()) {
		    		for (int i = 0; i < map.length; i++) {
		    			for (int j = 0; j < map[0].length; j++) {
		    				System.out.print(map[i][j]);
		    			}
		    			System.out.println();
		    		}
		    	} else {

		    		for (int i = 0; i < map.length; i++) {
		    			for (int j = 0; j < map[0].length; j++) {
		    				if ((map[i][j]) == 'X') {
		    					System.out.print(' ');
		    				} else {
		    					System.out.print(map[i][j]);
		    				}
		    			}
		    			System.out.println();
		    		}
		    	}
		    }
}