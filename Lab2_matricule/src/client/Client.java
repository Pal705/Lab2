package client;

//Paul Champagne
//Jean-Luc Manseau

//declaration variable

/**
 * 
 * @author Jean-Luc Manseau
 * @version 1.0.0
 */
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

	public void setDistanceSouhaitee(double p_distanceSouhaitee) {
		distanceSouhaitee = p_distanceSouhaitee;
	}

	public double getJourNaissance() {
		return jourNaissance;

	}

	public double getMoisNaissance() {
		return moisNaissance;
	}

	// constructeur
	public Client(int p_montantInitial, double p_distanceSouhaitee,
			String p_nom, classeConfortSouhaitee p_ClasseConfort) {
		argent = p_montantInitial;
		distanceSouhaitee = p_distanceSouhaitee;
		nom = p_nom;
		ClasseConfort = p_ClasseConfort;
		jourNaissance = 24;
		moisNaissance = 12;
		anneeNaissance = 1996;

	}

	// change la date d'anniversaire des clients
	public void changeAnniversaire(int annee, int jour, int mois) {
		anneeNaissance = annee;
		jourNaissance = jour;
		moisNaissance = mois;
	}

	/**
	 * 
	 * @param distance
	 * @return Le moment ou le client a parcourue la distance qu'il souhaitait
	 *         parcourir.
	 */

	public boolean doitDebarquer(float distance) {

		boolean reponse = false;
		distanceParcourue = (float) (distance + distanceParcourue);

		if (getDistanceParcourue() >= getDistanceSouhaitee()) {
			reponse = true;

		}

		return reponse;
	}

	/*
	 * le client paye le taxi donc doit retourner l'argent qu'il paye que la
	 * classe Taxi pourra venir chercher l'argent ne peut pas dépasser ce que le
	 * client possède si le montant a payer est plus grand que ce que le client
	 * a le client paye tout ce qu'il a mais pas plus (retire l'argent payer)
	 */
	
	/**
	 * 
	 * @param Montant
	 * @return le montant que le client a payer et soustrait celui-ci a son
	 *         total d'argent
	 */

	public float payeMontant(float Montant) {

		float montantPayer = Montant;

		if (Montant <= argent) {

			argent = argent - Montant;
		} else {
			if (Montant > argent) {
				montantPayer = (float) argent;
				argent = 0;
			}
		}
		return montantPayer;
	}

	public String toString() {
		return nom + " possede " + getArgent() + " et a parcouru "
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
