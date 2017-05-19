package dash;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Junit {

	@Test
	public void testvoisins() {
		Carte c = new Carte();
		int x = 1;
		int y = 9;
		char[][] map = {
				{ 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W',
						'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W' },
				{ 'W', '.', '.', 'd', '.', '.', '.', '.', '.', 'P', 'W', '.',
						'.', '.', '.', '.', '.', 'd', '.', 'W' },
				{ 'W', '.', '.', '.', 'd', '.', '.', '.', '.', '.', 'W', '.',
						'.', '.', '.', '.', 'd', '.', '.', 'W' },
				{ 'W', '.', '.', 'd', '.', '.', '.', '.', '.', '.', 'W', '.',
						'.', '.', '.', '.', '.', 'd', '.', 'W' },
				{ 'W', '.', '.', 'd', '.', '.', '.', '.', '.', '.', 'W', '.',
						'.', '.', '.', '.', '.', 'd', '.', 'W' },
				{ 'W', '.', '.', '.', 'd', '.', '.', '.', '.', '.', 'W', '.',
						'.', '.', '.', '.', 'd', '.', '.', 'W' },
				{ 'W', '.', '.', 'd', '.', '.', '.', '.', '.', '.', 'W', '.',
						'.', '.', '.', '.', '.', 'd', '.', 'W' },
				{ 'W', '.', '.', '.', 'd', '.', '.', '.', '.', '.', 'W', '.',
						'.', '.', '.', '.', 'd', '.', '.', 'W' },
				{ 'W', '.', '.', 'd', '.', '.', '.', '.', '.', '.', 'W', '.',
						'.', '.', '.', '.', '.', 'd', '.', 'W' },
				{ 'W', '.', '.', '.', 'd', '.', '.', '.', '.', '.', 'W', '.',
						'.', '.', '.', '.', 'd', '.', '.', 'W' },
				{ 'W', '.', '.', 'd', '.', '.', '.', '.', '.', '.', 'W', '.',
						'.', '.', '.', '.', '.', 'd', '.', 'W' },
				{ 'W', '.', '.', '.', 'd', '.', '.', '.', '.', '.', 'W', '.',
						'.', '.', '.', '.', 'd', '.', '.', 'W' },
				{ 'W', '.', '.', 'd', '.', '.', '.', '.', '.', '.', 'W', '.',
						'.', '.', '.', '.', '.', 'd', '.', 'W' },
				{ 'W', '.', '.', '.', 'd', '.', '.', '.', '.', '.', 'W', '.',
						'.', '.', '.', '.', 'd', '.', '.', 'W' },
				{ 'W', '.', '.', 'd', '.', '.', '.', '.', '.', '.', 'W', '.',
						'.', '.', '.', '.', '.', 'd', '.', 'W' },
				{ 'W', '.', '.', '.', 'd', '.', '.', '.', '.', '.', 'W', '.',
						'.', '.', '.', '.', 'd', '.', '.', 'W' },
				{ 'W', 'q', '.', '.', '.', '.', '.', '.', '.', '.', 'X', '.',
						'.', '.', '.', '.', '.', '.', '.', 'W' },
				{ 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W',
						'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W' } };
		int[] pos = { x, y };
		List<int[]> res = new ArrayList<int[]>();
		res.add(new int[] { x + 1, y, 2 });
		res.add(new int[] { x, y - 1, 4 });

		int i = 0;
		// on teste si la taille de la liste renvoyée == taille liste théorique
		assertEquals(res.size(), c.voisins(map, pos).size());

		// on parcourt la liste que renvoie la fonction et la liste du résultat
		// prévu
		while (i < c.voisins(map, pos).size() && i < res.size()) {
			int[] tab1 = c.voisins(map, pos).get(i);
			int[] tab2 = res.get(i);
			// un voisin est un tableau de 3 entier
			// on test si c'est la meme taille
			assertEquals(tab2.length, tab1.length);
			// on parcourt les tableaux pour les comparer
			for (int j = 0; j < tab1.length; j++) {
				if (tab1[j] != tab2[j]) {
					fail("mauvais voisins");
				}
			}

			i++;
		}

	}
}
