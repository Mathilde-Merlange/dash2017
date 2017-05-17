package bdProjet;
import java.util.ArrayList;
import java.util.Scanner;
import static bdProjet.ia.randompath;
public class Plateau {
	static Scanner in = new Scanner(System.in);
	
	   public static void main(String[] args) {
	        char[][] grille = new char[7][7];
	        int taille = grille.length;
	        for (int i = 1; i < taille - 1; i++) {
	            for (int j = 1; j < taille - 1; j++) grille[i][j] = '.';
	        }
	        int a = 0;
	        for (int b = 0; b < taille; b++) grille[a][b] = 'W';
	        int d = 0;
	        for (int c = 0; c < taille; c++) grille[c][d] = 'W';
	        int e = taille - 1;
	        for (int f = 0; f < taille; f++) grille[e][f] = 'W';
	        int h = taille - 1;
	        for (int g = 0; g < taille; g++) grille[g][h] = 'W';
	
	
	        int x = 3, y = 3;
	        grille[x][y] = '/'; //placement du personnage
	        grille[1][2] = 'c';
	        grille[4][4] = 'd';
	        // ↑ ↑ ↓ ↓ ← → ← → B A//
	        grille[5][5] = 'o';//sortie
	        afficher(grille, taille);
	
	        ArrayList moves = new ArrayList();//liste déplacements pour enregistrement
	        char[] shift = randompath(8);
	        int lg = shift.length - 1;
		
	        while (grille[x][y] != grille[5][5] && lg > 0) {
	            for (int i = 0; i < shift.length; i++) {
                char deplacement = shift[i];
	                moves.add(deplacement);
	
	
	                switch (deplacement) {  //2,4,5,6,8 : bas,gauche,immobile,droite,haut D,L,I,R,U
	                    case 'D':
	                        if (grille[x + 1][y] == 'W') {
	                            grille[x][y] = '/';
	                            System.out.println("mur bas");
	                            break;
	                        } else {
	                            grille[x + 1][y] = '/';
	                            grille[x][y] = '.';
	                            x++;
	                            break;
	                        }
	                    case 'L':
	                        if (grille[x][y - 1] == 'W') {
	                            grille[x][y] = '/';
	                            System.out.println("mur gauche");
	                            break;
	                        } else {
	                            grille[x][y - 1] = '/';
	                            grille[x][y] = '.';
	                            y--;
	                            break;
	                        }
	                    case 'I':
	
	                        grille[x][y] = '/';
	                        break;
	                    case 'R':
	                        if (grille[x][y + 1] == 'W') {
	                            grille[x][y] = '/';
	                            System.out.println("mur droite");
	                            break;
	                        } else {
	                            grille[x][y + 1] = '/';
	                            grille[x][y] = '.';
	                            y++;
	                           break;
	                        }
	                    case 'U':
	                        if (grille[x - 1][y] == 'W') {
	                            grille[x][y] = '/';
	                           System.out.println("mur haut");
	                            break;
	                        } else {
	                            grille[x - 1][y] = '/';
	                            grille[x][y] = '.';
	                            x--;
	                            break;
	                        }
	                    default:
	                        grille[x][y] = '/';
	                        break; // default pour autres touches
	                }
	
	                afficher(grille, taille);
	                lg--;
	           }
	
	
	            if (grille[x][y] == grille[5][5]) {
	               System.out.println("exit found");
	            }
	
	        }
	        for (int ct = 0; ct < moves.size(); ct++) {
	            System.out.print(moves.get(ct) + " ");
	        }
	
	    }//end main
	
	
	  public static void afficher(char[][] grille, int taille) {
	        int a = 0;
	        while (a < taille) {
	            int b = 0;
	           while (b < taille) {
	                System.out.print(grille[a][b] + " ");
	               b++;
	            }
	            System.out.println("");
	            a++;
	        }
	        System.out.println();
	    }//end afficher
	
}
