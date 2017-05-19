package dash;

import java.util.*;

public class Couple {
	private int[] depart;
	private List chemin;

	public int[] getDepart() {
		return depart;
	}

	public void setDepart(int[] depart) {
		this.depart = depart;
	}

	public List getChemin() {
		return chemin;
	}

	public void setChemin(List chemin) {
		this.chemin = chemin;
	}
	/**
	 * 
	 * Constructeur de Couple pour évolué2 (parcours en profondeur)
	 * 
	 * @param depart
	 *            position actuelle
	 * @param prevchemin
	 *            chemin precedent
	 */
	public Couple(int[] depart, List prevchemin) {
		this.depart = depart;
		this.chemin = prevchemin;
	}
}
