package dash;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by mathilde on 07/03/17.
 */
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
        grille[4][4] = 'd';
        // ↑ ↑ ↓ ↓ ← → ← → B A//
        grille[5][5] = 'o';//sortie
        afficher(grille, taille);

        ArrayList moves = new ArrayList();
        int[] shift = {6,2,6,2};
        int lg = shift.length - 1;


        while (grille[x][y] != grille[5][5] && lg > 0) {
            for (int i = 0; i < shift.length; i++) {
                int deplacement = shift[i];
                moves.add(deplacement);


                switch (deplacement) {  //2,4,5,6,8 : bas,gauche,immobile,droite,haut D,L,I,R,U
                    case 2:
                        if (grille[x + 1][y] == 'W') {
                            grille[x][y] = '/';
                            System.out.println("mur bas");
                            break;}
                        else {
                            grille[x + 1][y] = '/';
                            grille[x][y] = '.';
                            x++;
                            break;}
                    case 4:
                        if (grille[x][y - 1] == 'W') {
                            grille[x][y] = '/';
                            System.out.println("mur gauche");
                            break;}
                        else {
                            grille[x][y - 1] = '/';
                            grille[x][y] = '.';
                            y--;
                            break;}
                    case 5:

                        grille[x][y] = '/';
                        break;
                    case 6:
                        if (grille[x][y + 1] == 'W') {
                            grille[x][y] = '/';
                            System.out.println("mur droite");
                            break;}
                        else {
                            grille[x][y + 1] = '/';
                            grille[x][y] = '.';
                            y++;
                            break;}
                    case 8:
                        if (grille[x - 1][y] == 'W') {
                            grille[x][y] = '/';
                            System.out.println("mur haut");
                            break;}
                        else {
                            grille[x - 1][y] = '/';
                            grille[x][y] = '.';
                            x--;
                            break;}
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
            System.out.print(moves.get(ct) +" ");}

    }//end main



    public static void afficher (char [][]grille, int taille){
        int a=0;
        while(a<taille){
            int b=0;
            while(b<taille){
                System.out.print(grille[a][b]+" ");
                b++;
            }
            System.out.println("");
            a++;
        }
        System.out.println();
    }//end afficher

}




// not to do :
//diamants
//enregistrement positions
//conv chiffres lettres