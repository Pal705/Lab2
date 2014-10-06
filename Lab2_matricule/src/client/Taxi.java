package client;

//Paul Champagne
//Jean-Luc Manseau

/**
 * 
 * @author Paul Champagne
 * @version 1.0.0
 */

public class Taxi {

	// D�claration des constantes

	double CONSOMMATION = 8.45;
	double COUT_PAR_LITRE = 2.37;
	double REVENU_PAR_KILOMETRE_AFFAIRE = 3;
	double REVENU_PAR_KILOMETRE_LOCAL = 3.5;
	double REVENU_PAR_KILOMETRE_TOURISTIQUE = 5;
	double REVENU_PAR_KILOMETRE_PROMO = 2;
	double REVENU_PAR_KILOMETRE_LUXE = 9.5;

	// D�claration des variables

	private String nom;
	private double montantGagne;
	private double distanceParcourueTotale;
	private double distanceDepuisDepense;
	private int anneeCourante;
	private int moisCourant;
	private int jourCourant;
	private Client place1;
	private Client place2;

	// Constructeur qui recois le nom en parametre

	/**
	 * 
	 * @param p_nom
	 *            : Recois le nom du Taxi et la transfert dans la variable nom.
	 *            Initialise les variables � leurs valeurs par defaut et
	 *            initialise les 2 places dans le taxi a null.
	 */

	public Taxi(String p_nom) {

		this.nom = p_nom;
		this.anneeCourante = 2014;
		this.moisCourant = 12;
		this.jourCourant = 24;
		this.distanceParcourueTotale = 0;
		this.distanceDepuisDepense = 0;
		this.montantGagne = 0;
		this.place1 = null;
		this.place2 = null;

	}

	public double getMontantGagne() {

		return montantGagne;
	}

	/*
	 * Re�oit un objet de type client repr�sentant un client qui d�sire prendre
	 * le taxi. Si le client est majeur et s�il a assez d�argent pour payer, le
	 * taxi v�rifie s�il lui reste une place disponible. Si la place1 est
	 * disponible, le nouveau client y prend place (affectation de cet attribut
	 * au nouveau client). Sinon si la seconde place est disponible, le nouveau
	 * client y prend place. �videmment si aucune place n�est disponible le
	 * client ne peut pas embarquer.
	 */

	boolean embarque(Client celuiQuiEmbarque) {

		boolean peutEmbarquer = false;

		if (this.place1 == null) {
			
			peutEmbarquer = true;
			this.place1 = celuiQuiEmbarque;
		} else if (this.place2 == null) {
			peutEmbarquer = true;
			this.place2 = celuiQuiEmbarque;

		}
		return peutEmbarquer;
	}

	
	
	
	
	void appliqueDepense() {

	}

	void changeDateCourante(int p_JourCourant, int p_MoisCourante,
			int p_AnneeCourante) {

	}

	void roule(int kilometre) {

	}

	boolean estMajeur(Client celuiQuiEmbarque) {

		return false;
	}

	boolean peutPayer(Client celuiQuiEmbarque) {

		return false;
	}

}
