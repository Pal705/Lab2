package client;

//Jean-Luc Manseau et Paul Champagne

public class Client {
	private double argent;
	private String nom;
	private double distanceSouhaitee;
	private double distanceParcourue;
	private int jourNaissance;
	private int moisNaissance;
	private int anneeNaissance;

	enum classeConfortSouhaitee {
		TOURISTIQUE, AFFAIRE, LOCAL, PROMO, LUXE
	};

	classeConfortSouhaitee ClasseConfort;

	public double getArgent() {
		return argent;
	}

	public double getAnneeNaissance() {

		return anneeNaissance;
	}

	public classeConfortSouhaitee getClasseConfortSouhaitee() {
		return ClasseConfort;
	}

	public double getDistanceParcourue() {
		return distanceParcourue;
	}

	public double getDistanceSouhaitee() {
		return distanceSouhaitee;
	}

	public void setDistancesouhaitee(double p_distanceSouhaitee) {
		distanceSouhaitee = p_distanceSouhaitee;
	}

	public double getJourNaissance() {
		return jourNaissance;

	}

	public double getMoisNaissance() {
		return moisNaissance;
	}

	public Client(int p_montantInitial, double p_distanceSouhaitee,
			String p_nom, classeConfortSouhaitee p_ClasseConfort) {
		argent = p_montantInitial;
		distanceSouhaitee = p_distanceSouhaitee;
		nom = p_nom;
		p_ClasseConfort = ClasseConfort;
		jourNaissance = 24;
		moisNaissance = 12;
		anneeNaissance = 1996;
		
		
	}

	public void changeAnniversaire(int annee, int jour, int mois) {
		;
	}

	public boolean doitDebarquer(float distance) {
		boolean reponse = false;
		if (getDistanceParcourue() == getDistanceSouhaitee()) {
			reponse = true;
		}
		return reponse;
	}

	public float payeMontant(float Montant) {

	}

	public String toString() {
		return nom + "possede" + getArgent() + "a parcouru"
				+ getDistanceParcourue();
	}

	private boolean verificationJourNaissance() {
		boolean reponse = false;
		if (jourNaissance > 0 || jourNaissance <= 31) {
			reponse = true;
		}
		return reponse;
	}

	private boolean verificationMoisNaissance() {
		boolean reponse = false;
		if (moisNaissance > 0 || moisNaissance <= 12) {
			reponse = true;
		}
		return reponse;
	}
	
	private boolean verificationAnneeNaissance() {
		boolean reponse = false;
		if (anneeNaissance > 0) {
			reponse = true;
		}
		return reponse;
	}
}
