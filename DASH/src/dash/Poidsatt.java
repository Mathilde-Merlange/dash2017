package dash;

public class Poidsatt {

	private int poids;
	private boolean atteint;
	
	public Poidsatt(int poids, boolean atteint) {
		
		this.poids = poids;
		this.atteint = atteint;
	}

	public int getPoids() {
		return poids;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}

	public boolean isAtteint() {
		return atteint;
	}

	public void setAtteint(boolean atteint) {
		this.atteint = atteint;
	}
	
	
}
