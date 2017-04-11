package dash;

import java.util.ArrayList;

/**
 * Created by mathilde on 11/04/17.
 */
public class Moves {

    public static void afficherM(ArrayList<Character> moves) {//Affichage déplacements
        for (char m : moves) {
            switch (m) {
                case 'D':
                    System.out.println("bas");
                    break;
                case 'L':
                    System.out.println("gauche");
                    break;
                case 'I':
                    System.out.println("immobile");
                    break;
                case 'R':
                    System.out.println("droite");
                    break;
                case 'U':
                    System.out.println("haut");
                    break;
                default:
                    System.out.println("\n");
            }
            //System.out.print(moves.get(ct) + " ");
        }
    }

    public static void main(String[] args) {
        ArrayList<Character> moves = new ArrayList();
        moves.add('U');
        moves.add('L');
        moves.add('D');
        moves.add('I');
        moves.add('R');
        afficherM(moves);

    }

}
