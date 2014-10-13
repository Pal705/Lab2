package client;

import client.Client.classeConfortSouhaitee;

//Paul Champagne
//Jean-Luc Manseau

/**
 * 
 * @author Paul Champagne
 * @version 1.0.0
 */

public class Taxi {

	// Déclaration des constantes

	double CONSOMMATION = 8.45;
	double COUT_PAR_LITRE = 2.37;
	double REVENU_PAR_KILOMETRE_AFFAIRE = 3;
	double REVENU_PAR_KILOMETRE_LOCAL = 3.5;
	double REVENU_PAR_KILOMETRE_TOURISTIQUE = 5;
	double REVENU_PAR_KILOMETRE_PROMO = 2;
	double REVENU_PAR_KILOMETRE_LUXE = 9.5;

	// Déclaration des variables

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
	 *            Initialise les variables à leurs valeurs par defaut et
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
	 * Reçoit un objet de type client représentant un client qui désire prendre
	 * le taxi. Si le client est majeur et s’il a assez d’argent pour payer, le
	 * taxi vérifie s’il lui reste une place disponible. Si la place1 est
	 * disponible, le nouveau client y prend place (affectation de cet attribut
	 * au nouveau client). Sinon si la seconde place est disponible, le nouveau
	 * client y prend place. Évidemment si aucune place n’est disponible le
	 * client ne peut pas embarquer.
	 */

	boolean embarque(Client celuiQuiEmbarque) {

		boolean peutEmbarquer = false;

		if (this.place1 == null) {
			if (estMajeur(celuiQuiEmbarque) == true) {
				if (peutPayer(celuiQuiEmbarque) == true) {
					peutEmbarquer = true;
					this.place1 = celuiQuiEmbarque;
				}
			}
		}

		else {

			if (this.place2 == null) {
				if (estMajeur(celuiQuiEmbarque) == true) {
					if (peutPayer(celuiQuiEmbarque) == true) {
						peutEmbarquer = true;
						this.place2 = celuiQuiEmbarque;
					}
				}
			}
		}
		return peutEmbarquer;
	}

	void appliqueDepense() {

	}

	void changeDateCourante(int p_JourCourant, int p_MoisCourant,
			int p_AnneeCourante) {

		anneeCourante = p_AnneeCourante;
		moisCourant = p_MoisCourant;
		jourCourant = p_JourCourant;

	}

	void roule(int kilometre) {

	}

	// Vérifie si le client est majeur
	/**
	 * 
	 * @param celuiQuiEmbarque
	 *            : Recois les valeurs du client.
	 * @return: true si l'age est supperieur a 18 et false sinon.
	 */
	boolean estMajeur(Client celuiQuiEmbarque) {

		boolean majeur = false;

		if (this.anneeCourante - celuiQuiEmbarque.getAnneeNaissance() > 18) {
			majeur = true;
		} else {
			if (this.anneeCourante - celuiQuiEmbarque.getAnneeNaissance() < 18) {
				majeur = false;
			} else {
				if (this.anneeCourante - celuiQuiEmbarque.getAnneeNaissance() == 18) {
					if (this.moisCourant < celuiQuiEmbarque.getMoisNaissance()) {
						majeur = false;
					} else {
						if (this.moisCourant > celuiQuiEmbarque
								.getMoisNaissance()) {
							majeur = true;
						} else {
							if (this.moisCourant == celuiQuiEmbarque
									.getMoisNaissance()) {
								if (this.jourCourant < celuiQuiEmbarque
										.getJourNaissance()) {
									majeur = false;
								} else {
									majeur = true;
								}

							}
						}
					}
				}

			}
		}

		return majeur;
	}

	boolean peutPayer(Client celuiQuiEmbarque) {

		boolean payer = false;

		if (celuiQuiEmbarque.getArgent() - calculClasse(celuiQuiEmbarque) < 0)
			payer = false;
		else {

			payer = true;

		}
		return payer;
	}

	private double calculClasse(Client celuiQuiEmbarque) {

		double montant = 0;
		double distance = celuiQuiEmbarque.getDistanceSouhaitee();

		if (celuiQuiEmbarque.getClasseConfortSouhaitee() == classeConfortSouhaitee.AFFAIRE) {

			montant = distance * REVENU_PAR_KILOMETRE_AFFAIRE;
		} else {
			if (celuiQuiEmbarque.getClasseConfortSouhaitee() == classeConfortSouhaitee.LOCAL) {

				montant = distance * REVENU_PAR_KILOMETRE_LOCAL;
			}

			else {
				if (celuiQuiEmbarque.getClasseConfortSouhaitee() == classeConfortSouhaitee.TOURISTIQUE) {

					montant = distance * REVENU_PAR_KILOMETRE_TOURISTIQUE;
				}

				else {
					if (celuiQuiEmbarque.getClasseConfortSouhaitee() == classeConfortSouhaitee.PROMO) {

						montant = distance * REVENU_PAR_KILOMETRE_PROMO;
					}

					else {
						if (celuiQuiEmbarque.getClasseConfortSouhaitee() == classeConfortSouhaitee.LUXE) {

							montant = distance * REVENU_PAR_KILOMETRE_LUXE;
						}
					}
				}
			}
		}

		return montant;
	}

	public String toString() {

		return "Le taxi " + nom + " a gagné: " + montantGagne
				+ " en parcourant: " + distanceParcourueTotale
				+ ". Sont à bord: " + place1 + " et " + place2;

	}

}