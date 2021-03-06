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

	/**
	 * 
	 * @param celuiQuiEmbarque
	 *            Re�oit un objet de type client repr�sentant un client qui
	 *            d�sire prendre le taxi. Si le client est majeur et s�il a
	 *            assez d�argent pour payer, le taxi v�rifie s�il lui reste une
	 *            place disponible. Si la place1 est disponible, le nouveau
	 *            client y prend place (affectation de cet attribut au nouveau
	 *            client). Sinon si la seconde place est disponible, le nouveau
	 *            client y prend place. �videmment si aucune place n�est
	 *            disponible le client ne peut pas embarquer.
	 * 
	 * @return Retourne true si tout les conditions sont true et met le client a
	 *         sa place respective.
	 */
	public boolean embarque(Client celuiQuiEmbarque) {

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

	/**
	 * M�thode servant a payer les frais pour son exploitation. Elle prend la
	 * distance parcourue total par le taxi et l'additionne avec les constantes.
	 * Le montant obtenue est la d�pense pour la distance �ffectuer au total par
	 * le taxi. Puis la m�thode appelle la m�thode doisPayer en lui envoyant la
	 * distance en cours puis la soustrait au d�pense ce qui donne le montant
	 * gagn� par le taxi.
	 */
	public void appliqueDepense() {

		double depense;

		depense = distanceParcourueTotale / 100 * CONSOMMATION / 100
				* COUT_PAR_LITRE;
		montantGagne = montantGagne + doisPayer(distanceDepuisDepense)
				- depense;

	}

	public void changeDateCourante(int p_JourCourant, int p_MoisCourant,
			int p_AnneeCourante) {

		anneeCourante = p_AnneeCourante;
		moisCourant = p_MoisCourant;
		jourCourant = p_JourCourant;

	}

	/**
	 * 
	 * @param kilometre
	 *            Simule l'avancement d'un taxi. � chaque appel on re�oit un
	 *            nouveau kilom�trage qui a �t� parcouru par le taxi. Elle
	 *            averti chaque passager de l'avancement du taxi et les fait
	 *            descendre si la distance voulu du client est atteinte. Elle
	 *            prend �galement de l'argent au client � chaque fois que la
	 *            m�thode est appell�e.
	 */

	public void roule(int kilometre) {

		distanceParcourueTotale = distanceParcourueTotale + kilometre;
		distanceDepuisDepense = distanceDepuisDepense + kilometre;

		if (place1 != null) {

			if (place1.doitDebarquer(kilometre) == true) {
				place1.payeMontant((float) doisPayer(kilometre));
				appliqueDepense();
				place1 = null;

				distanceDepuisDepense = 0;
			} else {

				place1.payeMontant((float) doisPayer(kilometre));
				appliqueDepense();
			}
		}

		if (place2 != null) {

			if (place2.doitDebarquer(kilometre) == true) {
				place2.payeMontant((float) doisPayer(kilometre));
				appliqueDepense();
				place2 = null;
				distanceDepuisDepense = 0;
			} else {

				place2.payeMontant((float) doisPayer(kilometre));
				appliqueDepense();
			}
		}
	}

	private double doisPayer(double kilometre) {

		double montantPayer = 0;

		if (place1 != null) {

			if (place1.getClasseConfortSouhaitee() == classeConfortSouhaitee.AFFAIRE) {

				montantPayer = kilometre * REVENU_PAR_KILOMETRE_AFFAIRE;
			} else {
				if (place1.getClasseConfortSouhaitee() == classeConfortSouhaitee.LOCAL) {

					montantPayer = kilometre * REVENU_PAR_KILOMETRE_LOCAL;
				}

				else {
					if (place1.getClasseConfortSouhaitee() == classeConfortSouhaitee.TOURISTIQUE) {

						montantPayer = kilometre
								* REVENU_PAR_KILOMETRE_TOURISTIQUE;
					}

					else {
						if (place1.getClasseConfortSouhaitee() == classeConfortSouhaitee.PROMO) {

							montantPayer = kilometre
									* REVENU_PAR_KILOMETRE_PROMO;
						}

						else {
							if (place1.getClasseConfortSouhaitee() == classeConfortSouhaitee.LUXE) {

								montantPayer = kilometre
										* REVENU_PAR_KILOMETRE_LUXE;
							}
						}
					}
				}
			}
		} else {

			if (place2 != null) {

				if (place2.getClasseConfortSouhaitee() == classeConfortSouhaitee.AFFAIRE) {

					montantPayer = kilometre * REVENU_PAR_KILOMETRE_AFFAIRE;
				} else {
					if (place2.getClasseConfortSouhaitee() == classeConfortSouhaitee.LOCAL) {

						montantPayer = kilometre * REVENU_PAR_KILOMETRE_LOCAL;
					}

					else {
						if (place2.getClasseConfortSouhaitee() == classeConfortSouhaitee.TOURISTIQUE) {

							montantPayer = kilometre
									* REVENU_PAR_KILOMETRE_TOURISTIQUE;
						}

						else {
							if (place2.getClasseConfortSouhaitee() == classeConfortSouhaitee.PROMO) {

								montantPayer = kilometre
										* REVENU_PAR_KILOMETRE_PROMO;
							}

							else {
								if (place2.getClasseConfortSouhaitee() == classeConfortSouhaitee.LUXE) {

									montantPayer = kilometre
											* REVENU_PAR_KILOMETRE_LUXE;
								}
							}
						}
					}
				}
			}
		}

		return montantPayer;
	}

	// V�rifie si le client est majeur
	/**
	 * 
	 * @param celuiQuiEmbarque
	 *            Recois les valeurs du client pour v�rifier si le client est
	 *            majeur.
	 * @return true si l'age est supperieur a 18 et false sinon.
	 */
	public boolean estMajeur(Client celuiQuiEmbarque) {

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

	/**
	 * 
	 * @param celuiQuiEmbarque
	 *            V�rifie si le client qui d�sire embarquer a assez d'argent
	 *            pour faire la distance qu'il souhaite parcourir.
	 * @return Retourne true si le client a assez d'argent, false sinon.
	 */
	public boolean peutPayer(Client celuiQuiEmbarque) {

		boolean payer = false;

		if (celuiQuiEmbarque.getArgent() - calculClasse(celuiQuiEmbarque) < 0)
			payer = false;
		else {

			payer = true;

		}
		return payer;
	}

	/*
	 * 
	 * @param celuiQuiEmbarque
	 * 
	 * @return Retourne le montant total que coutera la distance souhaiter du
	 * client d�pendant de la classe choisi.
	 */
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

		return "Le taxi " + nom + " a gagn�: " + montantGagne
				+ " en parcourant: " + distanceParcourueTotale
				+ ". Sont � bord: " + place1 + " et " + place2;

	}

}